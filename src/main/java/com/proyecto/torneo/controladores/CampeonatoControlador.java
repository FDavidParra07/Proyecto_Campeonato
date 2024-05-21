package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.CampeonatoDto;
import com.proyecto.torneo.servicios.CampeonatoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CampeonatoControlador {

    @Autowired
    private CampeonatoServicio campeonatoServicio;

    @GetMapping("/campeonatos")
    public String listarCampeonatos(Model model) {
        List<CampeonatoDto> campeonatos = campeonatoServicio.obtenerCampeonatos();
        model.addAttribute("campeonatos", campeonatos);
        return "campeonatos/campeonatos";
    }

    @GetMapping("/campeonatos/nuevo")
    public String mostrarFormulario(Model model) {
        CampeonatoDto campeonatoDto = new CampeonatoDto();
        model.addAttribute("campeonato", campeonatoDto);
        return "campeonatos/crear_campeonato";
    }

    @PostMapping("/campeonatos/nuevo")
    public String registrarCampeonato(@ModelAttribute("campeonato") CampeonatoDto campeonatoDto, Model model) {
        try {
            campeonatoServicio.registrarCampeonato(campeonatoDto);
            model.addAttribute("mensaje", "Campeonato registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el campeonato: " + e.getMessage());
        }
        return "redirect:/campeonatos";
    }

    @GetMapping("/campeonatos/eliminar/{id}")
    public String eliminarCampeonato(@PathVariable long id, Model model) {
        campeonatoServicio.eliminarCampeonato(id);
        return "redirect:/campeonatos";
    }
}
