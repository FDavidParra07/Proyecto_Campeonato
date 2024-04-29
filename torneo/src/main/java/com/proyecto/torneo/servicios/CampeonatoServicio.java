package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.CampeonatoDto;
import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.repositorios.CampeonatoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class CampeonatoServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    CampeonatoRepositorio campeonatoRepositorio;

    public void registrarCampeonato(CampeonatoDto campeonatoDto) {
        campeonatoRepositorio.save(modelMapper.map(campeonatoDto, Campeonato.class));
    }
}
