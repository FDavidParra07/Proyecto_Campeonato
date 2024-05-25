package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDTO;
import com.proyecto.torneo.dto.FiltroForm;
import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.servicios.CampeonatoService;
import com.proyecto.torneo.servicios.ClasificacionService;
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

    @Autowired
    private ClasificacionService clasificacionService;

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

        Clasificacion clasificacion = new Clasificacion();
        clasificacion.setEquipo(equipo);
        clasificacion.setPuntos(0);
        clasificacion.setGolesAFavor(0);
        clasificacion.setGolesEnContra(0);
        clasificacion.setDiferenciaDeGoles(0);
        clasificacion.setPartidosJugados(0);
        clasificacion.setPartidosEmpatados(0);
        clasificacion.setPartidosPerdidos(0);
        clasificacion.setPartidosGanados(0);
        clasificacion.setCampeonato(campeonato);

        clasificacionService.save(clasificacion);
        return "redirect:/equipos";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        equipoService.deleteById(id);
        return ResponseEntity.ok().body("Equipo eliminado correctamente");
    }

    @PostMapping("/filtrar")
    public String filtrarEquipos(@ModelAttribute("filtroForm") FiltroForm filtroForm, Model model) {
        Long campeonatoId = filtroForm.getCampeonatoId();
        List<Equipo> equiposFiltrados = equipoService.findByCampeonatoId(campeonatoId);
        model.addAttribute("equipos", equiposFiltrados);
        model.addAttribute("campeonatos", campeonatoService.findAll());
        return "equipos";
    }

}
