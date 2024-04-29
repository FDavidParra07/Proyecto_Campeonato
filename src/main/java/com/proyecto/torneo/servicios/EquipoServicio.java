package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.EquipoDto;
import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.repositorios.EquipoRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class EquipoServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    EquipoRepositorio equipoRepositorio;

    public void registrarEquipo(EquipoDto equipoDto) {
        equipoRepositorio.save(modelMapper.map(equipoDto, Equipo.class));
    }
    public List<EquipoDto> obtenerEquipos() {
        TypeToken<List<EquipoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(equipoRepositorio.findAll(), typeToken.getType());

    }
}