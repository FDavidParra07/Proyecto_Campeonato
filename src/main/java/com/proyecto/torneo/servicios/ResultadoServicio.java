package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ResultadoDto;
import com.proyecto.torneo.entidades.Resultado;
import com.proyecto.torneo.repositorios.ResultadoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ResultadoServicio implements Serializable {

    private final ResultadoRepositorio resultadoRepositorio;
    private final ModelMapper modelMapper;

    @Autowired
    public ResultadoServicio(ResultadoRepositorio resultadoRepositorio, ModelMapper modelMapper) {
        this.resultadoRepositorio = resultadoRepositorio;
        this.modelMapper = modelMapper;
    }

    public void registrarResultado(ResultadoDto resultadoDto) {
        Resultado resultado = modelMapper.map(resultadoDto, Resultado.class);
        resultadoRepositorio.save(resultado);
    }
}
