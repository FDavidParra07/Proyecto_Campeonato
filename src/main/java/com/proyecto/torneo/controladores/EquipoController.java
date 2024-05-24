package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDTO;
import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.servicios.CampeonatoService;
import com.proyecto.torneo.servicios.EquipoService;
import com.proyecto.torneo.servicios.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private EstadioService estadioService;

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping("/create")
    public String crearEquipoForm(Model model) {
        List<Estadio> estadios = estadioService.findAll();
        List<Campeonato> campeonatos = campeonatoService.findAll();

        model.addAttribute("equipo", new EquipoDTO());
        model.addAttribute("estadios", estadios);
        model.addAttribute("campeonatos", campeonatos);

        return "crear_equipo";
    }

    @PostMapping("/create")
    public String crearEquipoSubmit(@ModelAttribute EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setTecnico(equipoDTO.getTecnico());
        equipo.setUniforme(equipoDTO.getUniforme());
        equipo.setDireccion(equipoDTO.getDireccion());
        Estadio estadio = estadioService.findById(equipoDTO.getEstadioId()).orElse(null);
        equipo.setEstadio(estadio);
        Campeonato campeonato = campeonatoService.findById(equipoDTO.getCampeonatoId()).orElse(null);
        equipo.setCampeonato(campeonato);
        equipoService.save(equipo);
        return "redirect:/equipos";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        equipoService.deleteById(id);
        return ResponseEntity.ok().body("Equipo eliminado correctamente");
    }
}
