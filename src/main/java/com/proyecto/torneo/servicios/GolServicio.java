package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.GolDto;
import com.proyecto.torneo.entidades.Gol;
import com.proyecto.torneo.repositorios.GolRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class GolServicio implements Serializable {

    private final ModelMapper modelMapper;
    private final GolRepositorio golRepositorio;

    @Autowired
    public GolServicio(ModelMapper modelMapper, GolRepositorio golRepositorio) {
        this.modelMapper = modelMapper;
        this.golRepositorio = golRepositorio;
    }

    public void registrarGol(GolDto golDto) {
        Gol gol = modelMapper.map(golDto, Gol.class);
        golRepositorio.save(gol);
    }
}
