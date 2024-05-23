package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EstadioDTO;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.servicios.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estadios")
public class EstadioController {

    @Autowired
    private EstadioService estadioService;

    @GetMapping("/create")
    public String crearEstadioForm(Model model) {
        model.addAttribute("estadio", new EstadioDTO());
        return "crear_estadio";
    }

    @PostMapping("/create")
    public String crearEstadioSubmit(@ModelAttribute EstadioDTO estadioDTO) {
        Estadio estadio = new Estadio();
        estadio.setNombre(estadioDTO.getNombre());
        estadio.setCapacidad(estadioDTO.getCapacidad());
        estadio.setUbicacion(estadioDTO.getUbicacion());
        estadioService.save(estadio);
        return "redirect:/estadios";
    }
}
