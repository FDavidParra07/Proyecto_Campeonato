package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EstadioDto;
import com.proyecto.torneo.servicios.EstadioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EstadioControlador {

    @Autowired
    private EstadioServicio estadioServicio;

    @GetMapping("/estadios")
    public String listarEstadios(Model model) {
        List<EstadioDto> estadios = estadioServicio.obtenerEstadios();
        model.addAttribute("estadios", estadios);
        return "estadios";
    }

    @GetMapping("/estadios/nuevo")
    public String mostrarFormulario(Model model) {
        EstadioDto estadioDto = new EstadioDto();
        model.addAttribute("estadio", estadioDto);
        return "crear_estadio";
    }

    @PostMapping("/estadios/nuevo")
    public String registrarEstadio(@ModelAttribute("estadio") EstadioDto estadioDto, Model model) {
        try {
            estadioServicio.registrarEstadio(estadioDto);
            model.addAttribute("mensaje", "Estadio registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el estadio: " + e.getMessage());
        }
        return "redirect:/estadios";
    }

    @GetMapping("/estadios/eliminar/{id}")
    public String eliminarEstadio(@PathVariable long id, Model model) {
        estadioServicio.eliminarEstadio(id);
        return "redirect:/estadios";
    }
}
