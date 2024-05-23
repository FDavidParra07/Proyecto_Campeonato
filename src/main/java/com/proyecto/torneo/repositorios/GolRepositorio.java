package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Gol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolRepositorio extends JpaRepository<Gol, Long> {
}
