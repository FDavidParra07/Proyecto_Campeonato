package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.JugadorDTO;
import com.proyecto.torneo.entidades.Jugador;
import com.proyecto.torneo.servicios.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<JugadorDTO> findAll() {
        return jugadorService.findAll().stream()
                .map(jugador -> {
                    JugadorDTO dto = new JugadorDTO();
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public JugadorDTO findById(@PathVariable Long id) {
        return jugadorService.findById(id).map(jugador -> {
            JugadorDTO dto = new JugadorDTO();
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public JugadorDTO create(@RequestBody JugadorDTO jugadorDTO) {
        Jugador jugador = new Jugador();
        jugador = jugadorService.save(jugador);
        JugadorDTO dto = new JugadorDTO();
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        jugadorService.deleteById(id);
    }
}
