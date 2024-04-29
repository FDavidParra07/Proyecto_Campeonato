package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JugadorRepositorio extends JpaRepository<Jugador, Long>, JpaSpecificationExecutor<Jugador> {
}
