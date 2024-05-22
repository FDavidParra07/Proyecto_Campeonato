package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.EquipoDto;
import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.repositorios.EquipoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoServicio {

    @Autowired
    private EquipoRepositorio equipoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public EquipoDto registrarEquipo(EquipoDto equipoDto) {
        Equipo equipo = modelMapper.map(equipoDto, Equipo.class);
        equipo = equipoRepositorio.save(equipo);
        return modelMapper.map(equipo, EquipoDto.class);
    }

    public List<EquipoDto> obtenerEquipos() {
        List<Equipo> equipos = equipoRepositorio.findAll();
        return equipos.stream()
                .map(equipo -> modelMapper.map(equipo, EquipoDto.class))
                .collect(Collectors.toList());
    }

    public EquipoDto obtenerEquipoPorId(long id) {
        Optional<Equipo> equipoOptional = equipoRepositorio.findById(id);
        return equipoOptional.map(equipo -> modelMapper.map(equipo, EquipoDto.class)).orElse(null);
    }

    public void eliminarEquipo(long id) {
        equipoRepositorio.deleteById(id);
    }

    public boolean existeEquipoPorNombre(String nombre){
        return equipoRepositorio.existsByNombreIgnoreCase(nombre);
    }

    public boolean existeEquipoPorId(long id){
        return equipoRepositorio.existsById(id);
    }
}
