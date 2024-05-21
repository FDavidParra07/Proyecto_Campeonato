package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ResultadoDto;
import com.proyecto.torneo.servicios.ResultadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ResultadoControlador {

    @Autowired
    private ResultadoServicio resultadoServicio;

    @GetMapping("/resultados")
    public String listarResultados(Model model) {
        List<ResultadoDto> resultados = resultadoServicio.obtenerResultados();
        model.addAttribute("resultados", resultados);
        return "resultados";
    }

    @GetMapping("/resultados/nuevo")
    public String mostrarFormulario(Model model) {
        ResultadoDto resultadoDto = new ResultadoDto();
        model.addAttribute("resultado", resultadoDto);
        return "crear_resultado";
    }

    @PostMapping("/resultados/nuevo")
    public String registrarResultado(@ModelAttribute("resultado") ResultadoDto resultadoDto, Model model) {
        try {
            resultadoServicio.registrarResultado(resultadoDto);
            model.addAttribute("mensaje", "Resultado registrado exitosamente.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar el resultado: " + e.getMessage());
        }
        return "redirect:/resultados";
    }

    @GetMapping("/resultados/eliminar/{id}")
    public String eliminarResultado(@PathVariable long id, Model model) {
        resultadoServicio.eliminarResultado(id);
        return "redirect:/resultados";
    }
}
