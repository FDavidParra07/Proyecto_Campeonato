package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Gol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GolRepositorio extends JpaRepository<Gol, Long>, JpaSpecificationExecutor<Gol> {
}
