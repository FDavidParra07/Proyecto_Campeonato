package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
