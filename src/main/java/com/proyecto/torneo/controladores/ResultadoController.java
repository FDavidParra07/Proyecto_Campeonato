package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.ResultadoDTO;
import com.proyecto.torneo.entidades.Resultado;
import com.proyecto.torneo.servicios.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping
    public List<ResultadoDTO> findAll() {
        return resultadoService.findAll().stream()
                .map(resultado -> {
                    ResultadoDTO dto = new ResultadoDTO();
                    return dto;
                })
                .collect(Collectors.toList());
    }

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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        resultadoService.deleteById(id);
    }
}
