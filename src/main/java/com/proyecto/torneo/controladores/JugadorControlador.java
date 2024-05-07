package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.JugadorDto;
import com.proyecto.torneo.servicios.JugadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jugadores")
public class JugadorControlador {

    private final JugadorServicio jugadorServicio;

    @Autowired
    public JugadorControlador(JugadorServicio jugadorServicio) {
        this.jugadorServicio = jugadorServicio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarJugador(@RequestBody JugadorDto jugadorDto) {
        try {
            jugadorServicio.registrarJugador(jugadorDto);
            return ResponseEntity.ok("Jugador registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el jugador: " + e.getMessage());
        }
    }
}
