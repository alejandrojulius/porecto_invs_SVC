package com.autoxtreme.proyectowebv2.controller;

import com.autoxtreme.proyectowebv2.carrito.Carrito;
import com.autoxtreme.proyectowebv2.model.Empleado;
import com.autoxtreme.proyectowebv2.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(path = "/login")
@SessionAttributes({"carrito"})
public class LoginController {
    @Autowired
    private IEmpleadoRepository emRep;

    // Crear un controlador para cargar la página index
    @GetMapping("/cargar")
    public String cargarPag(Model model) {
        Empleado empleadoPorDefecto = new Empleado();
        empleadoPorDefecto.setUser("usuarioPorDefecto");
        empleadoPorDefecto.setClave("clavePorDefecto");

        model.addAttribute("empleado", empleadoPorDefecto);
        return "menu-principal";
    }
    // Método para cargar datos de un empleado específico
    @GetMapping("/cargaEmpleado")
    public String cargaEmpleado(@ModelAttribute Empleado empleado, Model model) {
        Optional<Empleado> empleadoOptional = emRep.findById(empleado.getIdEmpleado());
        if (empleadoOptional.isPresent()) {
            model.addAttribute("empleado", empleadoOptional.get());
        } else {
            model.addAttribute("empleado", new Empleado());
            // Puedes añadir un mensaje para informar que el empleado no se encontró
            model.addAttribute("mensaje", "Empleado no encontrado");
        }
        model.addAttribute("lstEmpleado", emRep.findAll());
        return "menu-principal";
    }

    // Método para validar el inicio de sesión de un empleado  grabarPag
    @PostMapping("/validar")
    public String procesarFormularioLogin(@ModelAttribute Empleado empleado, Model model) {
        // Lógica para procesar el formulario de inicio de sesión
        return "menu-principal";
    }
}
