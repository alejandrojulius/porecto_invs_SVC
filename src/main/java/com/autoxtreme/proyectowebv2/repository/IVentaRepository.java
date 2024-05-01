package com.autoxtreme.proyectowebv2.repository;

import com.autoxtreme.proyectowebv2.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

    Optional<Venta> findFirstByOrderByIdDesc();
    
    List<Venta> findVentaByFechaBetween(Date fechaInicio, Date fechaFin);
    //List<Venta> findVentaByFechaBetween(String fechaInicio, String fechaFin);

}
