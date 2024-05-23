package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.JugadorDTO;
import com.proyecto.torneo.servicios.JugadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JugadorControlador {

    @Autowired
    private JugadorServicio jugadorServicio;

    @GetMapping("/jugadores")
    public String listarJugadores(Model model) {
        List<JugadorDTO> jugadores = jugadorServicio.obtenerJugadores();
        model.addAttribute("jugadores", jugadores);
        return "jugadores";
    }

    @GetMapping("/jugadores/nuevo")
    public String mostrarFormulario(Model model) {
        JugadorDTO jugadorDto = new JugadorDTO();
        model.addAttribute("jugador", jugadorDto);
        return "crear_jugador";
    }

    @PostMapping("/jugadores/nuevo")
    public String registrarJugador(@ModelAttribute("jugador") JugadorDTO jugadorDto, Model model) {
        try {
            jugadorServicio.registrarJugador(jugadorDto);
            model.addAttribute("mensaje", "Jugador registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el jugador: " + e.getMessage());
        }
        return "redirect:/jugadores";
    }

    @GetMapping("/jugadores/eliminar/{id}")
    public String eliminarJugador(@PathVariable long id, Model model) {
        jugadorServicio.eliminarJugador(id);
        return "redirect:/jugadores";
    }
}
