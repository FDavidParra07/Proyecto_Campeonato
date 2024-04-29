package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ClasificacionDto;
import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.repositorios.ClasificacionRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ClasificacionServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    ClasificacionRepositorio clasificacionRepositorio;

    public void registrarClasificacion(ClasificacionDto clasificacionDto) {
        clasificacionRepositorio.save(modelMapper.map(clasificacionDto, Clasificacion.class));
    }
}
