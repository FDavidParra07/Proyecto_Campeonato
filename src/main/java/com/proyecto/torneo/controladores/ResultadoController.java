package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ResultadoDTO;
import com.proyecto.torneo.entidades.Resultado;
import com.proyecto.torneo.servicios.CampeonatoService;
import com.proyecto.torneo.servicios.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping("/{id}")
    public ResultadoDTO findById(@PathVariable Long id) {
        return resultadoService.findById(id).map(resultado -> {
            ResultadoDTO dto = new ResultadoDTO();
            return dto;
        }).orElse(null);
    }

    @PostMapping
    public ResultadoDTO create(@RequestBody ResultadoDTO resultadoDTO) {
        Resultado resultado = new Resultado();
        resultado = resultadoService.save(resultado);
        ResultadoDTO dto = new ResultadoDTO();
        return dto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        resultadoService.deleteById(id);
    }
}
