package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ResultadoDto;
import com.proyecto.torneo.entidades.Resultado;
import com.proyecto.torneo.repositorios.ResultadoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ResultadoServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    ResultadoRepositorio resultadoRepositorio;

    public void registrarResultado(ResultadoDto resultadoDto) {
        resultadoRepositorio.save(modelMapper.map(resultadoDto, Resultado.class));
    }
}
