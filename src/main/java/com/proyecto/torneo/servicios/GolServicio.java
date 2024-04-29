package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.GolDto;
import com.proyecto.torneo.entidades.Gol;
import com.proyecto.torneo.repositorios.GolRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class GolServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    GolRepositorio golRepositorio;

    public void registrarGol(GolDto golDto) {
        golRepositorio.save(modelMapper.map(golDto, Gol.class));
    }
}
