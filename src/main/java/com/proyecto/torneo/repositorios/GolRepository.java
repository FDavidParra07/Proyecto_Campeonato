package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Gol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolRepository extends JpaRepository<Gol, Long> {
}
