package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.GolDto;
import com.proyecto.torneo.servicios.GolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GolControlador {

    @Autowired
    private GolServicio golServicio;

    @GetMapping("/goles")
    public String listarGoles(Model model) {
        List<GolDto> goles = golServicio.obtenerGoles();
        model.addAttribute("goles", goles);
        return "goles";
    }

    @GetMapping("/goles/nuevo")
    public String mostrarFormulario(Model model) {
        GolDto golDto = new GolDto();
        model.addAttribute("gol", golDto);
        return "crear_gol";
    }

    @PostMapping("/goles/nuevo")
    public String registrarGol(@ModelAttribute("gol") GolDto golDto, Model model) {
        try {
            golServicio.registrarGol(golDto);
            model.addAttribute("mensaje", "Gol registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el gol: " + e.getMessage());
        }
        return "redirect:/goles";
    }

    @GetMapping("/goles/eliminar/{id}")
    public String eliminarGol(@PathVariable long id, Model model) {
        golServicio.eliminarGol(id);
        return "redirect:/goles";
    }
}
