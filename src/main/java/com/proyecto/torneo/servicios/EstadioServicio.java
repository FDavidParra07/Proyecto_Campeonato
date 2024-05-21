package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.EstadioDto;
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

    public EstadioDto registrarEstadio(EstadioDto estadioDto) {
        Estadio estadio = modelMapper.map(estadioDto, Estadio.class);
        estadio = estadioRepositorio.save(estadio);
        return modelMapper.map(estadio, EstadioDto.class);
    }

    public List<EstadioDto> obtenerEstadios() {
        List<Estadio> estadios = estadioRepositorio.findAll();
        return estadios.stream()
                .map(estadio -> modelMapper.map(estadio, EstadioDto.class))
                .collect(Collectors.toList());
    }

    public EstadioDto obtenerEstadioPorId(long id) {
        Optional<Estadio> estadioOptional = estadioRepositorio.findById(id);
        return estadioOptional.map(estadio -> modelMapper.map(estadio, EstadioDto.class)).orElse(null);
    }

    public void eliminarEstadio(long id) {
        estadioRepositorio.deleteById(id);
    }

    public boolean existeEstadioPorNombre(String nombre){
        return estadioRepositorio.existsByNombreIgnoreCase(nombre);
    }
}
