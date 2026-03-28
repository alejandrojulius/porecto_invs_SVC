package com.autoxtreme.proyectowebv2.repository;

import com.autoxtreme.proyectowebv2.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
    Empleado findByUserAndClave(String user, String clave);
    @Query(value = "SELECT e.idempleado FROM svc.empleado e WHERE e.userempleado= :user;", nativeQuery = true)
    String findIdByUser(@Param("user") String user);

}
