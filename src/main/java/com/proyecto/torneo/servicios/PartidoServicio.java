package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.PartidoDTO;
import com.proyecto.torneo.entidades.Partido;
import com.proyecto.torneo.repositorios.PartidoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidoServicio {

    @Autowired
    private PartidoRepositorio partidoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public PartidoDTO registrarPartido(PartidoDTO partidoDTO) {
        Partido partido = modelMapper.map(partidoDTO, Partido.class);
        partido = partidoRepositorio.save(partido);
        return modelMapper.map(partido, PartidoDTO.class);
    }

    public List<PartidoDTO> obtenerPartidos() {
        List<Partido> partidos = partidoRepositorio.findAll();
        return partidos.stream()
                .map(partido -> modelMapper.map(partido, PartidoDTO.class))
                .collect(Collectors.toList());
    }

    public PartidoDTO obtenerPartidoPorId(long id) {
        Optional<Partido> partidoOptional = partidoRepositorio.findById(id);
        return partidoOptional.map(partido -> modelMapper.map(partido, PartidoDTO.class)).orElse(null);
    }

    public void eliminarPartido(long id) {
        partidoRepositorio.deleteById(id);
    }
}
