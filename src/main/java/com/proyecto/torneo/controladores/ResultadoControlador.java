package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ResultadoDto;
import com.proyecto.torneo.servicios.ResultadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resultados")
public class ResultadoControlador {

    private final ResultadoServicio resultadoServicio;

    @Autowired
    public ResultadoControlador(ResultadoServicio resultadoServicio) {
        this.resultadoServicio = resultadoServicio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarResultado(@RequestBody ResultadoDto resultadoDto) {
        try {
            resultadoServicio.registrarResultado(resultadoDto);
            return ResponseEntity.ok("Resultado registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el resultado: " + e.getMessage());
        }
    }
}
