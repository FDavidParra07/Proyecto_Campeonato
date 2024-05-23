package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ResultadoDTO;
import com.proyecto.torneo.entidades.Resultado;
import com.proyecto.torneo.repositorios.ResultadoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultadoServicio {

    @Autowired
    private ResultadoRepositorio resultadoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public ResultadoDTO registrarResultado(ResultadoDTO resultadoDTO) {
        Resultado resultado = modelMapper.map(resultadoDTO, Resultado.class);
        resultado = resultadoRepositorio.save(resultado);
        return modelMapper.map(resultado, ResultadoDTO.class);
    }

    public List<ResultadoDTO> obtenerResultados() {
        List<Resultado> resultados = resultadoRepositorio.findAll();
        return resultados.stream()
                .map(resultado -> modelMapper.map(resultado, ResultadoDTO.class))
                .collect(Collectors.toList());
    }

    public ResultadoDTO obtenerResultadoPorId(long id) {
        Optional<Resultado> resultadoOptional = resultadoRepositorio.findById(id);
        return resultadoOptional.map(resultado -> modelMapper.map(resultado, ResultadoDTO.class)).orElse(null);
    }

    public void eliminarResultado(long id) {
        resultadoRepositorio.deleteById(id);
    }
}
