package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDto;
import com.proyecto.torneo.dto.EstadioDto;
import com.proyecto.torneo.servicios.EquipoServicio;
import com.proyecto.torneo.servicios.EstadioServicio;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class EquipoControlador {
    private static final Logger logger = LogManager.getLogger(EquipoControlador.class);

    @Autowired
    EquipoServicio servicioEquipos;

    @Autowired
    EstadioServicio estadioServicio;

    @RequestMapping("/prueba")
    public  String prueba(){
        return "prueba";
    }

    @GetMapping("/equipos")
    public String listarEquipos(Model model) {
        logger.info("Obteniendo lista de equipos");
        List<EquipoDto> equipos = servicioEquipos.obtenerEquipos();
        if (equipos.isEmpty()) {
            model.addAttribute("mensaje", "No hay equipos registrados.");
        }
        model.addAttribute("equipos", equipos);
        return "equipos";
    }

    @GetMapping("/equipos/nuevo")
    public String mostrarFormulario(Model model) {
        EquipoDto equipoDto = new EquipoDto();
        List<EstadioDto> estadios = estadioServicio.obtenerEstadios();
        if (estadios.isEmpty()) {
            model.addAttribute("error", "No hay estadios disponibles. Registre un estadio antes de crear un equipo.");
        }
        model.addAttribute("equipo", equipoDto);
        model.addAttribute("estadios", estadios);
        return "crear_equipo";
    }

    @PostMapping("/equipos/nuevo")
    public String crearEquipo(@ModelAttribute("equipo") EquipoDto equipoDto, Model model) {
        try {
            servicioEquipos.registrarEquipo(equipoDto);
            model.addAttribute("mensaje", "Equipo creado exitosamente.");
            return "redirect:/equipos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al crear el equipo: " + e.getMessage());
            return "crear_equipo";
        }
    }

    @GetMapping("/equipos/modificar/{id}")
    public String mostrarFormularioEditar(@PathVariable long id, Model model) {
        EquipoDto equipoDto = servicioEquipos.obtenerEquipoPorId(id);
        if (equipoDto == null) {
            model.addAttribute("error", "No se encontró el equipo con ID: " + id);
            return "redirect:/equipos";
        }
        List<EstadioDto> estadios = estadioServicio.obtenerEstadios();
        model.addAttribute("equipo", equipoDto);
        model.addAttribute("estadios", estadios);
        return "editar_equipo";
    }

    @PostMapping("/equipos/modificar/{id}")
    public String modificarEquipo(@PathVariable long id, @ModelAttribute("equipo") EquipoDto equipoDto, Model model) {
        try {
            servicioEquipos.actualizarEquipo(equipoDto);
            model.addAttribute("mensaje", "Equipo actualizado exitosamente.");
            return "redirect:/equipos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el equipo: " + e.getMessage());
            return "editar_equipo";
        }
    }

    @GetMapping("/equipos/eliminar/{id}")
    public String eliminarEquipo(@PathVariable long id, Model model) {
        try {
            servicioEquipos.eliminarEquipo(id);
            model.addAttribute("mensaje", "Equipo eliminado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el equipo: " + e.getMessage());
        }
        return "redirect:/equipos";
    }
}