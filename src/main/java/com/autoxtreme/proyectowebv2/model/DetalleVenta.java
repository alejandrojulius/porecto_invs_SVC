package com.autoxtreme.proyectowebv2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "detalleventa")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double precio;
    private int cantidad;
    private String descripcionC;
    private double subtotal;
    @ManyToOne
    @JoinColumn(name = "idventa")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idcarro")
    private Carro carro;

	
    

}
