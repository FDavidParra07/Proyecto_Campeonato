package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.JugadorDTO;
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

    public JugadorDTO registrarJugador(JugadorDTO jugadorDTO) {
        Jugador jugador = modelMapper.map(jugadorDTO, Jugador.class);
        jugador = jugadorRepositorio.save(jugador);
        return modelMapper.map(jugador, JugadorDTO.class);
    }

    public List<JugadorDTO> obtenerJugadores() {
        List<Jugador> jugadores = jugadorRepositorio.findAll();
        return jugadores.stream()
                .map(jugador -> modelMapper.map(jugador, JugadorDTO.class))
                .collect(Collectors.toList());
    }

    public JugadorDTO obtenerJugadorPorId(long id) {
        Optional<Jugador> jugadorOptional = jugadorRepositorio.findById(id);
        return jugadorOptional.map(jugador -> modelMapper.map(jugador, JugadorDTO.class)).orElse(null);
    }

    public void eliminarJugador(long id) {
        jugadorRepositorio.deleteById(id);
    }
}
