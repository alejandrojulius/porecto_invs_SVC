package com.autoxtreme.proyectowebv2.repository;

import com.autoxtreme.proyectowebv2.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
    List<DetalleVenta> findByVentaId(int id);
   // List<DetalleVenta> findByVentaId(int id);
}
