package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.CampeonatoDto;
import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.repositorios.CampeonatoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CampeonatoServicio {

    @Autowired
    private CampeonatoRepositorio campeonatoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public CampeonatoDto registrarCampeonato(CampeonatoDto campeonatoDto) {
        Campeonato campeonato = modelMapper.map(campeonatoDto, Campeonato.class);
        campeonato = campeonatoRepositorio.save(campeonato);
        return modelMapper.map(campeonato, CampeonatoDto.class);
    }

    public List<CampeonatoDto> obtenerCampeonatos() {
        List<Campeonato> campeonatos = campeonatoRepositorio.findAll();
        return campeonatos.stream()
                .map(campeonato -> modelMapper.map(campeonato, CampeonatoDto.class))
                .collect(Collectors.toList());
    }

    public CampeonatoDto obtenerCampeonatoPorId(long id) {
        Optional<Campeonato> campeonatoOptional = campeonatoRepositorio.findById(id);
        return campeonatoOptional.map(campeonato -> modelMapper.map(campeonato, CampeonatoDto.class)).orElse(null);
    }

    public void eliminarCampeonato(long id) {
        campeonatoRepositorio.deleteById(id);
    }
}
