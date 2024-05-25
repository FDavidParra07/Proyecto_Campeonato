package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.PartidoDTO;
import com.proyecto.torneo.entidades.Partido;
import com.proyecto.torneo.servicios.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping("/{id}")
    public PartidoDTO findById(@PathVariable Long id) {
        return partidoService.findById(id).map(partido -> {
            PartidoDTO dto = new PartidoDTO();
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public PartidoDTO create(@RequestBody PartidoDTO partidoDTO) {
        Partido partido = new Partido();
        partido = partidoService.save(partido);
        PartidoDTO dto = new PartidoDTO();
        return dto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        partidoService.deleteById(id);
    }
}
