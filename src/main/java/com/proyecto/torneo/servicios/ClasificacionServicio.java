package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ClasificacionDto;
import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.repositorios.ClasificacionRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ClasificacionServicio implements Serializable {

    private final ModelMapper modelMapper;

    @Autowired
    public ClasificacionServicio(ModelMapper modelMapper, ClasificacionRepositorio clasificacionRepositorio) {
        this.modelMapper = modelMapper;
        this.clasificacionRepositorio = clasificacionRepositorio;
    }

    private final ClasificacionRepositorio clasificacionRepositorio;

    public void registrarClasificacion(ClasificacionDto clasificacionDto) {
        clasificacionRepositorio.save(modelMapper.map(clasificacionDto, Clasificacion.class));
    }
}
