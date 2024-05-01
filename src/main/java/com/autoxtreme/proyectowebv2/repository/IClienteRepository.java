package com.autoxtreme.proyectowebv2.repository;

import com.autoxtreme.proyectowebv2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByDni(String dni);
}
