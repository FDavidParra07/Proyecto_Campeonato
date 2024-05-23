package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.EquipoDTO;
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

    public EquipoDTO registrarEquipo(EquipoDTO equipoDTO) {
        Equipo equipo = modelMapper.map(equipoDTO, Equipo.class);
        equipo = equipoRepositorio.save(equipo);
        return modelMapper.map(equipo, EquipoDTO.class);
    }

    public List<EquipoDTO> obtenerEquipos() {
        List<Equipo> equipos = equipoRepositorio.findAll();
        return equipos.stream()
                .map(equipo -> modelMapper.map(equipo, EquipoDTO.class))
                .collect(Collectors.toList());
    }

    public EquipoDTO obtenerEquipoPorId(long id) {
        Optional<Equipo> equipoOptional = equipoRepositorio.findById(id);
        return equipoOptional.map(equipo -> modelMapper.map(equipo, EquipoDTO.class)).orElse(null);
    }

    public void eliminarEquipo(long id) {
        equipoRepositorio.deleteById(id);
    }
}
