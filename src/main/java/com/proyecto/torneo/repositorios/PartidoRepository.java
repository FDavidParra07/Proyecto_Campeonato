package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Campeonato;
import com.proyecto.torneo.entidades.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findByCampeonatoId(Long campeonatoId);
}
