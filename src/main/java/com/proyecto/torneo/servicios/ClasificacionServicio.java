package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ClasificacionDto;
import com.proyecto.torneo.entidades.Clasificacion;
import com.proyecto.torneo.repositorios.ClasificacionRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClasificacionServicio {

    @Autowired
    private ClasificacionRepositorio clasificacionRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public ClasificacionDto registrarClasificacion(ClasificacionDto clasificacionDto) {
        Clasificacion clasificacion = modelMapper.map(clasificacionDto, Clasificacion.class);
        clasificacion = clasificacionRepositorio.save(clasificacion);
        return modelMapper.map(clasificacion, ClasificacionDto.class);
    }

    public List<ClasificacionDto> obtenerClasificaciones() {
        List<Clasificacion> clasificaciones = clasificacionRepositorio.findAll();
        return clasificaciones.stream()
                .map(clasificacion -> modelMapper.map(clasificacion, ClasificacionDto.class))
                .collect(Collectors.toList());
    }

    public ClasificacionDto obtenerClasificacionPorId(long id) {
        Optional<Clasificacion> clasificacionOptional = clasificacionRepositorio.findById(id);
        return clasificacionOptional.map(clasificacion -> modelMapper.map(clasificacion, ClasificacionDto.class)).orElse(null);
    }

    public void eliminarClasificacion(long id) {
        clasificacionRepositorio.deleteById(id);
    }
}
