package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResultadoRepositorio extends JpaRepository<Resultado, Long>, JpaSpecificationExecutor<Resultado> {
}
