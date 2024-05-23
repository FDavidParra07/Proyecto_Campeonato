package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EstadioDTO;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.servicios.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estadios")
public class EstadioController {

    @Autowired
    private EstadioService estadioService;

    @GetMapping
    public List<EstadioDTO> findAll() {
        return estadioService.findAll().stream()
                .map(estadio -> {
                    EstadioDTO dto = new EstadioDTO();
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EstadioDTO findById(@PathVariable Long id) {
        return estadioService.findById(id).map(estadio -> {
            EstadioDTO dto = new EstadioDTO();
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public EstadioDTO create(@RequestBody EstadioDTO estadioDTO) {
        Estadio estadio = new Estadio();
        estadio = estadioService.save(estadio);
        EstadioDTO dto = new EstadioDTO();
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        estadioService.deleteById(id);
    }
}
