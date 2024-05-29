package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ClasificacionDTO;
import com.proyecto.torneo.dto.FiltroForm;
import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.servicios.CampeonatoService;
import com.proyecto.torneo.servicios.ClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/clasificaciones")
public class ClasificacionController {

    @Autowired
    private ClasificacionService clasificacionService;

    @Autowired
    private CampeonatoService campeonatoService;

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

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        clasificacionService.deleteById(id);
    }

    @PostMapping("/filtrar")
    public String filtrarClasificaciones(@ModelAttribute("filtroForm") FiltroForm filtroForm, Model model) {
        Long campeonatoId = filtroForm.getCampeonatoId();
        List<Clasificacion> clasificacionesFiltradas = clasificacionService.findByCampeonatoId(campeonatoId);
        clasificacionesFiltradas.sort(Comparator
                .comparingInt(Clasificacion::getPuntos)
                .thenComparingInt(Clasificacion::getGolesAFavor)
                .thenComparingInt(Clasificacion::getPartidosGanados)
                .reversed());
        model.addAttribute("clasificaciones", clasificacionesFiltradas);
        model.addAttribute("campeonatos", campeonatoService.findAll()); // Agregar campeonatos nuevamente
        return "clasificaciones";
    }
}
