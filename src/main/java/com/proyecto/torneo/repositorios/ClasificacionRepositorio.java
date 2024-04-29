package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClasificacionRepositorio extends JpaRepository<Clasificacion, Long>, JpaSpecificationExecutor<Clasificacion> {
}
