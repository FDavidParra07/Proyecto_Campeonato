package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.PartidoDto;
import com.proyecto.torneo.entidades.Partido;
import com.proyecto.torneo.repositorios.PartidoRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class PartidoServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    PartidoRepositorio partidoRepositorio;

    public void registrarPartido(PartidoDto partidoDto) {
        partidoRepositorio.save(modelMapper.map(partidoDto, Partido.class));
    }

    public List<PartidoDto> obtenerPartidos() {
        TypeToken<List<PartidoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(partidoRepositorio.findAll(), typeToken.getType());
    }
}
