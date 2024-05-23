package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.ClasificacionDTO;
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

    public List<ClasificacionDTO> obtenerClasificacionesPorCampeonato(long campeonatoId) {
        List<Clasificacion> clasificaciones = clasificacionRepositorio.findByCampeonatoId(campeonatoId);
        return clasificaciones.stream()
                .map(clasificacion -> modelMapper.map(clasificacion, ClasificacionDTO.class))
                .collect(Collectors.toList());
    }

    public ClasificacionDTO registrarClasificacion(ClasificacionDTO clasificacionDTO) {
        Clasificacion clasificacion = modelMapper.map(clasificacionDTO, Clasificacion.class);
        clasificacion = clasificacionRepositorio.save(clasificacion);
        return modelMapper.map(clasificacion, ClasificacionDTO.class);
    }

    public ClasificacionDTO actualizarClasificacion(ClasificacionDTO clasificacionDTO) {
        Clasificacion clasificacion = modelMapper.map(clasificacionDTO, Clasificacion.class);
        clasificacion = clasificacionRepositorio.save(clasificacion);
        return modelMapper.map(clasificacion, ClasificacionDTO.class);
    }

    public void eliminarClasificacion(long id) {
        clasificacionRepositorio.deleteById(id);
    }
}
