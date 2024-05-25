package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.CampeonatoDTO;
import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.servicios.CampeonatoService;
import com.proyecto.torneo.servicios.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    CampeonatoService campeonatoService;

    @Autowired
    EstadioService estadioService;

    @GetMapping("/create")
    public String crearEquipoForm(Model model) {
        CampeonatoDTO campeonatoDTO = new CampeonatoDTO();
        model.addAttribute("campeonato", campeonatoDTO);
        List<Estadio> estadios = estadioService.findAll();
        model.addAttribute("estadios", estadios);
        return "crear_campeonato";
    }

    @PostMapping("/create")
    public String crearCampeonatoSubmit(@ModelAttribute CampeonatoDTO campeonatoDTO) {
        Campeonato campeonato = new Campeonato();
        campeonato.setNombre(campeonatoDTO.getNombre());
        campeonato.setEquipos(new ArrayList<>());
        campeonato.setPartidos(new ArrayList<>());
        campeonato.setClasificaciones(new ArrayList<>());

        campeonatoService.save(campeonato);

        return "redirect:/campeonatos";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        campeonatoService.deleteById(id);
        return ResponseEntity.ok().body("Campeonato eliminado correctamente");
    }
}