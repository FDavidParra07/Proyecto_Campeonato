package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ClasificacionDto;
import com.proyecto.torneo.servicios.ClasificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clasificaciones")
public class ClasificacionControlador {

    private final ClasificacionServicio clasificacionServicio;

    @Autowired
    public ClasificacionControlador(ClasificacionServicio clasificacionServicio) {
        this.clasificacionServicio = clasificacionServicio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarClasificacion(@RequestBody ClasificacionDto clasificacionDto) {
        try {
            clasificacionServicio.registrarClasificacion(clasificacionDto);
            return ResponseEntity.ok("Clasificación registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar la clasificación: " + e.getMessage());
        }
    }
}
