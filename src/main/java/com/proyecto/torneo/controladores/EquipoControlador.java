package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDto;
import com.proyecto.torneo.servicios.EquipoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EquipoControlador {

    @Autowired
    private EquipoServicio equipoServicio;

    @GetMapping("/equipos")
    public String listarEquipos(Model model) {
        List<EquipoDto> equipos = equipoServicio.obtenerEquipos();
        model.addAttribute("equipos", equipos);
        return "equipos";
    }

    @GetMapping("/equipos/nuevo")
    public String mostrarFormulario(Model model) {
        EquipoDto equipoDto = new EquipoDto();
        model.addAttribute("equipo", equipoDto);
        return "crear_equipo";
    }

    @PostMapping("/equipos/nuevo")
    public String registrarEquipo(@ModelAttribute("equipo") EquipoDto equipoDto, Model model) {
        try {
            equipoServicio.registrarEquipo(equipoDto);
            model.addAttribute("mensaje", "Equipo registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el equipo: " + e.getMessage());
        }
        return "redirect:/equipos";
    }

    @GetMapping("/equipos/eliminar/{id}")
    public String eliminarEquipo(@PathVariable long id, Model model) {
        equipoServicio.eliminarEquipo(id);
        return "redirect:/equipos";
    }
}
