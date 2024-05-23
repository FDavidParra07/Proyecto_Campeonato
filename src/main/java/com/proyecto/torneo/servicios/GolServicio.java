package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.GolDTO;
import com.proyecto.torneo.entidades.Gol;
import com.proyecto.torneo.repositorios.GolRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GolServicio {

    @Autowired
    private GolRepositorio golRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public GolDTO registrarGol(GolDTO golDTO) {
        Gol gol = modelMapper.map(golDTO, Gol.class);
        gol = golRepositorio.save(gol);
        return modelMapper.map(gol, GolDTO.class);
    }

    public List<GolDTO> obtenerGoles() {
        List<Gol> goles = golRepositorio.findAll();
        return goles.stream()
                .map(gol -> modelMapper.map(gol, GolDTO.class))
                .collect(Collectors.toList());
    }

    public GolDTO obtenerGolPorId(long id) {
        Optional<Gol> golOptional = golRepositorio.findById(id);
        return golOptional.map(gol -> modelMapper.map(gol, GolDTO.class)).orElse(null);
    }

    public void eliminarGol(long id) {
        golRepositorio.deleteById(id);
    }
}
