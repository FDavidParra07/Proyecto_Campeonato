package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartidoRepositorio extends JpaRepository<Partido, Long>, JpaSpecificationExecutor<Partido> {
}
