package com.autoxtreme.proyectowebv2.repository;

import com.autoxtreme.proyectowebv2.model.TipoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoRepository extends JpaRepository<TipoEmpleado, Integer> {
}
