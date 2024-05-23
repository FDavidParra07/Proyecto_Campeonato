package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
