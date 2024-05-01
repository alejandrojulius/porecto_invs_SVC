package com.autoxtreme.proyectowebv2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "ventas")
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Empleado empleado;

    @Column(name = "numeroserie")
    private String Numserie;

    @Column(name = "fechaventas")
    private Date fecha;
    @Column(name = "monto")
    private double monto;

	
	

	
	

}
