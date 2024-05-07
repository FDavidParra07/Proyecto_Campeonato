package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.GolDto;
import com.proyecto.torneo.servicios.GolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goles")
public class GolControlador {

    private final GolServicio golServicio;

    @Autowired
    public GolControlador(GolServicio golServicio) {
        this.golServicio = golServicio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarGol(@RequestBody GolDto golDto) {
        try {
            golServicio.registrarGol(golDto);
            return ResponseEntity.ok("Gol registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el gol: " + e.getMessage());
        }
    }
}
