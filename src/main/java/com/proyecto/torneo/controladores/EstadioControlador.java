package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EstadioDTO;
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
        List<EstadioDTO> estadios = estadioServicio.obtenerEstadios();
        model.addAttribute("estadios", estadios);
        return "estadios/estadios";
    }

    @GetMapping("/estadios/nuevo")
    public String mostrarFormulario(Model model) {
        EstadioDTO estadioDto = new EstadioDTO();
        model.addAttribute("estadio", estadioDto);
        return "estadios/crear_estadio";
    }

    @PostMapping("/estadios/nuevo")
    public String registrarEstadio(@ModelAttribute("estadio") EstadioDTO estadioDto, Model model) {
        try {
            String nombreEstadio = estadioDto.getNombre().toLowerCase();
            if (estadioServicio.existeEstadioPorNombre(nombreEstadio)) {
                throw new IllegalArgumentException("El nombre del estadio ya está registrado.");
            }
            estadioServicio.registrarEstadio(estadioDto);
            model.addAttribute("mensaje", "Estadio registrado exitosamente.");
            model.addAttribute("alertScript", "<script>alert('Estadio registrado exitosamente.');</script>");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Error al registrar el estadio: " + e.getMessage());
            model.addAttribute("alertScript", "<script>alert('El nombre del estadio ya esta en uso en la base de datos.');</script>");
            return "estadios/crear_estadio";
        }
        return "redirect:/estadios";
    }

    @GetMapping("/estadios/eliminar/{id}")
    public String eliminarEstadio(@PathVariable long id, Model model) {
        estadioServicio.eliminarEstadio(id);
        return "redirect:/estadios";
    }
}
