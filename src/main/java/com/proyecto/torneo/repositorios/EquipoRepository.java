package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByCampeonatoId(Long campeonatoId);
}
