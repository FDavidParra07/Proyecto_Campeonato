package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDTO;
import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.servicios.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<EquipoDTO> findAll() {
        return equipoService.findAll().stream()
                .map(equipo -> {
                    EquipoDTO dto = new EquipoDTO();
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EquipoDTO findById(@PathVariable Long id) {
        return equipoService.findById(id).map(equipo -> {
            EquipoDTO dto = new EquipoDTO();
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public EquipoDTO create(@RequestBody EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo = equipoService.save(equipo);
        EquipoDTO dto = new EquipoDTO();
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        equipoService.deleteById(id);
    }
}
