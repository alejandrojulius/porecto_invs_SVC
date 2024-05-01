package com.autoxtreme.proyectowebv2.repository;

import com.autoxtreme.proyectowebv2.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarroRepository extends JpaRepository<Carro, Integer> {
}
