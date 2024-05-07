package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.PartidoDto;
import org.springframework.ui.Model;
import com.proyecto.torneo.servicios.PartidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/partidos")
public class PartidoControlador {

    private final PartidoServicio partidoServicio;

    @Autowired
    public PartidoControlador(PartidoServicio partidoServicio) {
        this.partidoServicio = partidoServicio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPartido(@RequestBody PartidoDto partidoDto) {
        try {
            partidoServicio.registrarPartido(partidoDto);
            return ResponseEntity.ok("Partido registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el partido: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public String obtenerPartidos(Model model) {
        List<PartidoDto> partidos = partidoServicio.obtenerPartidos();
        model.addAttribute("partidos", partidos);
        return "partidos";
    }
}
