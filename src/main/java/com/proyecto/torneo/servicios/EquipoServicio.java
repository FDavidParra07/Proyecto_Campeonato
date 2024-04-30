package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.EquipoDto;
import com.proyecto.torneo.dto.EstadioDto;
import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.entidades.Estadio;
import com.proyecto.torneo.repositorios.EquipoRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoServicio {

    private final ModelMapper modelMapper;
    private final EquipoRepositorio equipoRepositorio;
    private final EstadioServicio estadioServicio;

    @Autowired
    public EquipoServicio(ModelMapper modelMapper, EquipoRepositorio equipoRepositorio, EstadioServicio estadioServicio) {
        this.modelMapper = modelMapper;
        this.equipoRepositorio = equipoRepositorio;
        this.estadioServicio = estadioServicio;
    }

    public void registrarEquipo(EquipoDto equipoDto) {
        System.out.println("En pruebas");
    }

    public List<EquipoDto> obtenerEquipos() {
        List<Equipo> equipos = equipoRepositorio.findAll();
        return modelMapper.map(equipos, new TypeToken<List<EquipoDto>>() {}.getType());
    }

    public EquipoDto obtenerEquipoPorId(long id) {
        Optional<Equipo> optionalEquipo = equipoRepositorio.findById(id);
        return optionalEquipo.map(equipo -> modelMapper.map(equipo, EquipoDto.class)).orElse(null);
    }

    public void actualizarEquipo(EquipoDto equipoDto) {
        Equipo equipo = modelMapper.map(equipoDto, Equipo.class);
        equipoRepositorio.save(equipo);
    }

    public void eliminarEquipo(long id) {
        equipoRepositorio.deleteById(id);
    }

}
