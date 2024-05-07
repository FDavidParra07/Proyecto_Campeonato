package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.JugadorDto;
import com.proyecto.torneo.servicios.JugadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; // Importa esta anotación
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jugadores")
public class JugadorControlador {

    private final JugadorServicio jugadorServicio;

    @Autowired
    public JugadorControlador(JugadorServicio jugadorServicio) {
        this.jugadorServicio = jugadorServicio;
    }

    @GetMapping("/")
    public String obtenerJugadores(Model model) {
        List<JugadorDto> jugadores = jugadorServicio.obtenerJugadores();
        model.addAttribute("jugadores", jugadores);
        return "jugadores";
    }
}