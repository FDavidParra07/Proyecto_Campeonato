package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ResultadoDto;
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

    public ResultadoDto registrarResultado(ResultadoDto resultadoDto) {
        Resultado resultado = modelMapper.map(resultadoDto, Resultado.class);
        resultado = resultadoRepositorio.save(resultado);
        return modelMapper.map(resultado, ResultadoDto.class);
    }

    public List<ResultadoDto> obtenerResultados() {
        List<Resultado> resultados = resultadoRepositorio.findAll();
        return resultados.stream()
                .map(resultado -> modelMapper.map(resultado, ResultadoDto.class))
                .collect(Collectors.toList());
    }

    public ResultadoDto obtenerResultadoPorId(long id) {
        Optional<Resultado> resultadoOptional = resultadoRepositorio.findById(id);
        return resultadoOptional.map(resultado -> modelMapper.map(resultado, ResultadoDto.class)).orElse(null);
    }

    public void eliminarResultado(long id) {
        resultadoRepositorio.deleteById(id);
    }
}
