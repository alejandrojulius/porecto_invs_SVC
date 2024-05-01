package com.autoxtreme.proyectowebv2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "carro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarro")
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

	@Column(name = "origen")
    private String origen;

    @Column(name = "combustible")
    private String Combustible;

    @Column(name = "precio")
    private double precio;

    @Column(name = "stock")
    private int stock;
    @ManyToOne
    @JoinColumn(name = "idmarca")
    Marca objMarca;

    
    
	

    


}
