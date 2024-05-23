package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepositorio extends JpaRepository<Jugador, Long> {
}
