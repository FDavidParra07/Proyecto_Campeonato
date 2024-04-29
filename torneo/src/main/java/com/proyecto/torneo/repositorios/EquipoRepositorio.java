package com.proyecto.torneo.repositorios;

import com.proyecto.torneo.entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipoRepositorio extends JpaRepository <Equipo, Long>, JpaSpecificationExecutor<Equipo> {

}
