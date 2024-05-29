package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.FiltroForm;
import com.proyecto.torneo.dto.GolDTO;
import com.proyecto.torneo.dto.PartidoDTO;
import com.proyecto.torneo.entidades.*;
import com.proyecto.torneo.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private CampeonatoService campeonatoService;

    @Autowired
    private EstadioService estadioService;

    @Autowired
    private ResultadoService resultadoService;

    @Autowired
    private ClasificacionService clasificacionService;

    @GetMapping("/{id}")
    public PartidoDTO findById(@PathVariable Long id) {
        return partidoService.findById(id).map(partido -> {
            PartidoDTO dto = new PartidoDTO();
            return dto;
        }).orElse(null);
    }

    @GetMapping("/create")
    public String crearPartidoForm(Model model) {
        List<Equipo> equipos = equipoService.findAll();
        List<Estadio> estadios = estadioService.findAll();
        List<Campeonato> campeonatos = campeonatoService.findAll();
        model.addAttribute("campeonatos", campeonatos);
        model.addAttribute("estadios", estadios);
        model.addAttribute("partido", new PartidoDTO());
        model.addAttribute("equipos", equipos);

        return "crear_partido";
    }

    @PostMapping("/create")
    public String create(PartidoDTO partidoDTO) {
        Partido partido = new Partido();
        Equipo local = equipoService.findById(partidoDTO.getLocalId()).orElse(null);
        Equipo visitante = equipoService.findById(partidoDTO.getVisitanteId()).orElse(null);
        Estadio estadio = estadioService.findById(partidoDTO.getEstadioId()).orElse(null);
        Campeonato campeonato = campeonatoService.findById(partidoDTO.getCampeonatoId()).orElse(null);

        partido.setLocal(local);
        partido.setVisitante(visitante);
        partido.setEstadio(estadio);
        partido.setFecha(partidoDTO.getFecha());
        partido.setCampeonato(campeonato);

        partido = partidoService.save(partido);

        Resultado resultado = new Resultado();
        resultado.setPartido(partido);
        resultado.setGolesLocal(partidoDTO.getResultado().getGolesLocal());
        resultado.setGolesVisitante(partidoDTO.getResultado().getGolesVisitante());

        resultado = resultadoService.save(resultado);

        List<GolDTO> listaGolesDTO = partidoDTO.getResultado().getListaGoles();
        List<Gol> listaGoles = new ArrayList<>();

        resultado.setListaGoles(listaGoles);
        resultadoService.save(resultado);

        actualizarClasificacion(local, visitante, partidoDTO.getResultado().getGolesLocal(), partidoDTO.getResultado().getGolesVisitante(), partido);

        return "redirect:/partidos";
    }

    private void actualizarClasificacion(Equipo local, Equipo visitante, int golesLocal, int golesVisitante, Partido partido) {
        actualizarClasificacionEquipo(local, golesLocal, golesVisitante, partido);
        actualizarClasificacionEquipo(visitante, golesVisitante, golesLocal, partido);
    }

    private void actualizarClasificacionEquipo(Equipo equipo, int golesAFavor, int golesEnContra, Partido partido) {
        Clasificacion clasificacion = clasificacionService.findByEquipoIdAndCampeonatoId(equipo.getId(), partido.getCampeonato().getId());

        if (clasificacion != null) {
            clasificacion.setGolesAFavor(clasificacion.getGolesAFavor() + golesAFavor);
            clasificacion.setGolesEnContra(clasificacion.getGolesEnContra() + golesEnContra);
            clasificacion.setDiferenciaDeGoles(clasificacion.getGolesAFavor() - clasificacion.getGolesEnContra());
            clasificacion.setPartidosJugados(clasificacion.getPartidosJugados() + 1);

            if (golesAFavor > golesEnContra) {
                clasificacion.setPartidosGanados(clasificacion.getPartidosGanados() + 1);
                clasificacion.setPuntos(clasificacion.getPuntos() + 3);
            } else if (golesAFavor == golesEnContra) {
                clasificacion.setPartidosEmpatados(clasificacion.getPartidosEmpatados() + 1);
                clasificacion.setPuntos(clasificacion.getPuntos() + 1);
            } else {
                clasificacion.setPartidosPerdidos(clasificacion.getPartidosPerdidos() + 1);
            }

            clasificacionService.save(clasificacion);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        partidoService.deleteById(id);
    }

    @PostMapping("/filtrar")
    public String filtrarPartidos(@ModelAttribute("filtroForm") FiltroForm filtroForm, Model model) {
        Long campeonatoId = filtroForm.getCampeonatoId();
        List<Partido> partidosFiltrados = partidoService.findByCampeonatoId(campeonatoId);
        model.addAttribute("partidos", partidosFiltrados);
        model.addAttribute("campeonatos", campeonatoService.findAll());
        return "partidos";
    }
}
