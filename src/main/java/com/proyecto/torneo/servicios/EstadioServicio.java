package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.EstadioDto;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.repositorios.EstadioRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class EstadioServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    EstadioRepositorio estadioRepositorio;

    public void registrarEstadio(EstadioDto estadioDto) {
        estadioRepositorio.save(modelMapper.map(estadioDto, Estadio.class));
    }

    public List<EstadioDto> obtenerEstadios() {
        TypeToken<List<EstadioDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(estadioRepositorio.findAll(), typeToken.getType());
    }
}
