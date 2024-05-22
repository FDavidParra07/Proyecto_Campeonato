package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDto;
import com.proyecto.torneo.dto.EstadioDto;
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
        List<EquipoDto> equipos = equipoServicio.obtenerEquipos();
        model.addAttribute("equipos", equipos);
        model.addAttribute("estadios", estadioServicio.obtenerEstadios());
        return "equipos/equipos";
    }

    @GetMapping("/equipos/nuevo")
    public String mostrarFormulario(Model model) {
        EquipoDto equipoDto = new EquipoDto();
        model.addAttribute("equipo", equipoDto);

        List<EstadioDto> estadios = estadioServicio.obtenerEstadios();
        model.addAttribute("estadios", estadios);

        return "equipos/crear_equipo";
    }

    @PostMapping("/equipos/nuevo")
    public String registrarEquipo(@ModelAttribute("equipo") EquipoDto equipoDto, Model model) {
        try {
            String nombreEquipo = equipoDto.getNombre().toLowerCase();
            if (equipoServicio.existeEquipoPorNombre(nombreEquipo)) {
                throw new IllegalArgumentException("El nombre del equipo ya está registrado.");
            }

            Long idEstadio = equipoDto.getEstadio();
            if (equipoServicio.existeEquipoPorId(idEstadio)) {
                throw new IllegalArgumentException("El estadio seleccionado ya está asociado a otro equipo.");
            }

            equipoServicio.registrarEquipo(equipoDto);
            model.addAttribute("mensaje", "Equipo registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Error al registrar el equipo: " + e.getMessage());
            model.addAttribute("alertScript", "<script>alert('" + e.getMessage() + "');</script>");
            List<EstadioDto> estadios = estadioServicio.obtenerEstadios();
            model.addAttribute("estadios", estadios);
            return "equipos/crear_equipo";
        }
        return "redirect:/equipos";
    }

    @GetMapping("/equipos/eliminar/{id}")
    public String eliminarEquipo(@PathVariable long id, Model model) {
        equipoServicio.eliminarEquipo(id);
        return "redirect:/equipos";
    }
}