package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.PartidoDto;
import com.proyecto.torneo.servicios.PartidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PartidoControlador {

    @Autowired
    private PartidoServicio partidoServicio;

    @GetMapping("/partidos")
    public String listarPartidos(Model model) {
        List<PartidoDto> partidos = partidoServicio.obtenerPartidos();
        model.addAttribute("partidos", partidos);
        return "partidos";
    }

    @GetMapping("/partidos/nuevo")
    public String mostrarFormulario(Model model) {
        PartidoDto partidoDto = new PartidoDto();
        model.addAttribute("partido", partidoDto);
        return "crear_partido";
    }

    @PostMapping("/partidos/nuevo")
    public String registrarPartido(@ModelAttribute("partido") PartidoDto partidoDto, Model model) {
        try {
            partidoServicio.registrarPartido(partidoDto);
            model.addAttribute("mensaje", "Partido registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el partido: " + e.getMessage());
        }
        return "redirect:/partidos";
    }

    @GetMapping("/partidos/eliminar/{id}")
    public String eliminarPartido(@PathVariable long id, Model model) {
        partidoServicio.eliminarPartido(id);
        return "redirect:/partidos";
    }
}
