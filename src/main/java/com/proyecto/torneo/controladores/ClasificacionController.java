package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ClasificacionDTO;
import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.servicios.ClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clasificaciones")
public class ClasificacionController {

    @Autowired
    private ClasificacionService clasificacionService;

    @GetMapping
    public List<ClasificacionDTO> findAll() {
        return clasificacionService.findAll().stream()
                .map(clasificacion -> {
                    ClasificacionDTO dto = new ClasificacionDTO();
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClasificacionDTO findById(@PathVariable Long id) {
        return clasificacionService.findById(id).map(clasificacion -> {
            ClasificacionDTO dto = new ClasificacionDTO();
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public ClasificacionDTO create(@RequestBody ClasificacionDTO clasificacionDTO) {
        Clasificacion clasificacion = new Clasificacion();
        clasificacion = clasificacionService.save(clasificacion);
        ClasificacionDTO dto = new ClasificacionDTO();
        return dto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clasificacionService.deleteById(id);
    }
}
