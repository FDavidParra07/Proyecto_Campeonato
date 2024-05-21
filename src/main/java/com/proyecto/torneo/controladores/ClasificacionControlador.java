package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ClasificacionDto;
import com.proyecto.torneo.servicios.ClasificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClasificacionControlador {

    @Autowired
    private ClasificacionServicio clasificacionServicio;

    @GetMapping("/clasificaciones")
    public String listarClasificaciones(Model model) {
        List<ClasificacionDto> clasificaciones = clasificacionServicio.obtenerClasificaciones();
        model.addAttribute("clasificaciones", clasificaciones);
        return "clasificaciones";
    }

    @GetMapping("/clasificaciones/nuevo")
    public String mostrarFormulario(Model model) {
        ClasificacionDto clasificacionDto = new ClasificacionDto();
        model.addAttribute("clasificacion", clasificacionDto);
        return "crear_clasificacion";
    }

    @PostMapping("/clasificaciones/nuevo")
    public String registrarClasificacion(@ModelAttribute("clasificacion") ClasificacionDto clasificacionDto, Model model) {
        try {
            clasificacionServicio.registrarClasificacion(clasificacionDto);
            model.addAttribute("mensaje", "Clasificación registrada exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar la clasificación: " + e.getMessage());
        }
        return "redirect:/clasificaciones";
    }

    @GetMapping("/clasificaciones/eliminar/{id}")
    public String eliminarClasificacion(@PathVariable long id, Model model) {
        clasificacionServicio.eliminarClasificacion(id);
        return "redirect:/clasificaciones";
    }
}
