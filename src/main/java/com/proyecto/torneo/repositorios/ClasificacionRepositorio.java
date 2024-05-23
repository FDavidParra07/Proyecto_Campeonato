package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClasificacionRepositorio extends JpaRepository<Clasificacion, Long> {
    List<Clasificacion> findByCampeonatoId(Long campeonatoId);
}
