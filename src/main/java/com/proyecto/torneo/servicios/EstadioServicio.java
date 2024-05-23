package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.EstadioDTO;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.repositorios.EstadioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadioServicio {

    @Autowired
    private EstadioRepositorio estadioRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public EstadioDTO registrarEstadio(EstadioDTO estadioDTO) {
        Estadio estadio = modelMapper.map(estadioDTO, Estadio.class);
        estadio = estadioRepositorio.save(estadio);
        return modelMapper.map(estadio, EstadioDTO.class);
    }

    public List<EstadioDTO> obtenerEstadios() {
        List<Estadio> estadios = estadioRepositorio.findAll();
        return estadios.stream()
                .map(estadio -> modelMapper.map(estadio, EstadioDTO.class))
                .collect(Collectors.toList());
    }

    public EstadioDTO obtenerEstadioPorId(long id) {
        Optional<Estadio> estadioOptional = estadioRepositorio.findById(id);
        return estadioOptional.map(estadio -> modelMapper.map(estadio, EstadioDTO.class)).orElse(null);
    }

    public void eliminarEstadio(long id) {
        estadioRepositorio.deleteById(id);
    }
}
