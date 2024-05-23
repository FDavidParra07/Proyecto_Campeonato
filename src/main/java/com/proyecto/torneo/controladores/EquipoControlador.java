package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDTO;
import com.proyecto.torneo.dto.EstadioDTO;
import com.proyecto.torneo.servicios.EquipoServicio;
import com.proyecto.torneo.servicios.EstadioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EquipoControlador {

    @Autowired
    private EquipoServicio equipoServicio;

    @Autowired
    private EstadioServicio estadioServicio;

    @GetMapping("/equipos")
    public String listarEquipos(Model model) {
        List<EquipoDTO> equipos = equipoServicio.obtenerEquipos();
        model.addAttribute("equipos", equipos);
        return "equipos/equipos";
    }

    @GetMapping("/equipos/nuevo")
    public String mostrarFormulario(Model model) {
        EquipoDTO equipoDto = new EquipoDTO();
        model.addAttribute("equipo", equipoDto);

        List<EstadioDTO> estadios = estadioServicio.obtenerEstadios();
        model.addAttribute("estadios", estadios);

        return "equipos/crear_equipo";
    }

    @PostMapping("/equipos/nuevo")
    public String registrarEquipo(@ModelAttribute("equipo") EquipoDTO equipoDto, Model model) {
        try {
            String nombreEquipo = equipoDto.getNombre().toLowerCase();
            if (equipoServicio.existeEquipoPorNombre(nombreEquipo)) {
                throw new IllegalArgumentException("El nombre del equipo ya está registrado.");
            }

            equipoServicio.registrarEquipo(equipoDto);
            model.addAttribute("mensaje", "Equipo registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Error al registrar el equipo: " + e.getMessage());
            model.addAttribute("alertScript", "<script>alert('" + e.getMessage() + "');</script>");
            List<EstadioDTO> estadios = estadioServicio.obtenerEstadios();
            model.addAttribute("estadios", estadios);
            return "equipos/crear_equipo";
        }
        return "redirect:/equipos";
    }

    @GetMapping("/equipos/eliminar/{id}")
    public String eliminarEquipo(@PathVariable long id) {
        equipoServicio.eliminarEquipo(id);
        return "redirect:/equipos";
    }
}
