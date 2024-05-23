package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {
}
