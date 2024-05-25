package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EstadioDTO;
import com.proyecto.torneo.dto.FiltroForm;
import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CampeonatoService campeonatoService;
    @Autowired
    private EquipoService equipoService;
    @Autowired
    private PartidoService partidoService;
    @Autowired
    private ResultadoService resultadoService;
    @Autowired
    private ClasificacionService clasificacionService;
    @Autowired
    private EstadioService estadioService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/campeonatos")
    public String campeonatos(Model model) {
        model.addAttribute("campeonatos", campeonatoService.findAll());
        return "campeonatos";
    }

    @GetMapping("/equipos")
    public String equipos(Model model) {
        model.addAttribute("equipos", equipoService.findAll());
        model.addAttribute("campeonatos", campeonatoService.findAll());
        model.addAttribute("filtroForm", new FiltroForm());
        return "equipos";
    }

    @GetMapping("/partidos")
    public String partidos(Model model) {
        model.addAttribute("partidos", partidoService.findAll());
        return "partidos";
    }

    @GetMapping("/resultados")
    public String resultados(Model model) {
        model.addAttribute("resultados", resultadoService.findAll());
        return "resultados";
    }

    @GetMapping("/clasificaciones")
    public String clasificaciones(Model model) {
        model.addAttribute("clasificaciones", clasificacionService.findAll());
        model.addAttribute("campeonatos", campeonatoService.findAll());
        model.addAttribute("filtroForm", new FiltroForm());
        return "clasificaciones";
    }

    @PostMapping("/clasificaciones/filtrar")
    public String filtrarClasificaciones(@ModelAttribute("filtroForm") FiltroForm filtroForm, Model model) {
        Long campeonatoId = filtroForm.getCampeonatoId();
        List<Clasificacion> clasificacionesFiltradas = clasificacionService.findByCampeonatoId(campeonatoId);
        model.addAttribute("clasificaciones", clasificacionesFiltradas);
        model.addAttribute("campeonatos", campeonatoService.findAll()); // Agregar campeonatos nuevamente
        return "clasificaciones";
    }


    @GetMapping("/estadios")
    public String estadios(Model model) {
        model.addAttribute("estadios", estadioService.findAll());
        model.addAttribute("estadio", new EstadioDTO());
        return "estadios";
    }
}
