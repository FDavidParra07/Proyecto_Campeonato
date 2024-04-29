package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstadioRepositorio extends JpaRepository<Estadio, Long>, JpaSpecificationExecutor<Estadio> {
}
