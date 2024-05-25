package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.GolDTO;
import com.proyecto.torneo.entidades.Gol;
import com.proyecto.torneo.servicios.GolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/goles")
public class GolController {

    @Autowired
    private GolService golService;

    @GetMapping
    public List<GolDTO> findAll() {
        return golService.findAll().stream()
                .map(gol -> {
                    GolDTO dto = new GolDTO();
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GolDTO findById(@PathVariable Long id) {
        return golService.findById(id).map(gol -> {
            GolDTO dto = new GolDTO();
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public GolDTO create(@RequestBody GolDTO golDTO) {
        Gol gol = new Gol();
        gol = golService.save(gol);
        GolDTO dto = new GolDTO();
        return dto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        golService.deleteById(id);
    }
}
