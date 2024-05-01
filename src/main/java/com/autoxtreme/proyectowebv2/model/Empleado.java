package com.autoxtreme.proyectowebv2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleado")
    private int idEmpleado;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombres")
    private String nom;

    @Column(name = "apellidos")
    private String ape;

    @Column(name = "telefono")
    private String tel;

    @Column(name = "userempleado")
    private String user;

    @Column(name = "clave")
    private String clave;

    @Column(name = "imgempleado")
    private String img;

    @ManyToOne()
    @JoinColumn(name = "idtipo")
    TipoEmpleado objTipo;
 
}


