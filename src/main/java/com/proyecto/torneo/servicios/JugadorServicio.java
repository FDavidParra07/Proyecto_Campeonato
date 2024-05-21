package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.JugadorDto;
import com.proyecto.torneo.entidades.Jugador;
import com.proyecto.torneo.repositorios.JugadorRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorServicio {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public JugadorDto registrarJugador(JugadorDto jugadorDto) {
        Jugador jugador = modelMapper.map(jugadorDto, Jugador.class);
        jugador = jugadorRepositorio.save(jugador);
        return modelMapper.map(jugador, JugadorDto.class);
    }

    public List<JugadorDto> obtenerJugadores() {
        List<Jugador> jugadores = jugadorRepositorio.findAll();
        return jugadores.stream()
                .map(jugador -> modelMapper.map(jugador, JugadorDto.class))
                .collect(Collectors.toList());
    }

    public JugadorDto obtenerJugadorPorId(long id) {
        Optional<Jugador> jugadorOptional = jugadorRepositorio.findById(id);
        return jugadorOptional.map(jugador -> modelMapper.map(jugador, JugadorDto.class)).orElse(null);
    }

    public void eliminarJugador(long id) {
        jugadorRepositorio.deleteById(id);
    }
}
