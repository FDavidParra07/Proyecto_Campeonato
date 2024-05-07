package com.proyecto.torneo.servicios;

import com.proyecto.torneo.dto.JugadorDto;
import com.proyecto.torneo.entidades.Jugador;
import com.proyecto.torneo.repositorios.JugadorRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class JugadorServicio implements Serializable {

    private ModelMapper modelMapper;

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    public void registrarJugador(JugadorDto jugadorDto) {
        jugadorRepositorio.save(modelMapper.map(jugadorDto, Jugador.class));
    }
}
