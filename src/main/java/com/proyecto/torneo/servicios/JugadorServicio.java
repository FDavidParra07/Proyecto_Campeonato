package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.JugadorDto;
import com.proyecto.torneo.entidades.Jugador;
import com.proyecto.torneo.repositorios.JugadorRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JugadorServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    public void registrarJugador(JugadorDto jugadorDto) {
        jugadorRepositorio.save(modelMapper.map(jugadorDto, Jugador.class));
    }

    public List<JugadorDto> obtenerJugadores() {
        List<Jugador> jugadores = jugadorRepositorio.findAll();
        return jugadores.stream()
                .map(jugador -> modelMapper.map(jugador, JugadorDto.class))
                .collect(Collectors.toList());
    }
}
