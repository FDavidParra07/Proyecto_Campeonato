package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.CampeonatoDto;
import com.proyecto.torneo.servicios.CampeonatoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoControlador {

    private final CampeonatoServicio campeonatoServicio;

    @Autowired
    public CampeonatoControlador(CampeonatoServicio campeonatoServicio) {
        this.campeonatoServicio = campeonatoServicio;
    }

    @PostMapping
    public void crearCampeonato(@RequestBody CampeonatoDto campeonatoDto) {
        campeonatoServicio.registrarCampeonato(campeonatoDto);
    }
}
