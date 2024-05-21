package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepositorio extends JpaRepository<Estadio, Long> {
    boolean existsByNombre(String nombre);
    boolean existsByNombreIgnoreCase(String nombre);
}
