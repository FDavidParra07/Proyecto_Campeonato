package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepositorio extends JpaRepository<Campeonato, Long> {
}
