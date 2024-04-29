package com.proyecto.torneo.controladores;

import com.proyecto.torneo.dto.EquipoDto;
import com.proyecto.torneo.servicios.EquipoServicio;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Log4j2
public class EquipoControl {
    private static final Logger logger = LogManager.getLogger(EquipoControl.class);

    @Autowired
    EquipoServicio equipoServicio;

    public void registrarEquipo(EquipoDto equipo) {
        equipoServicio.registrarEquipo(equipo);
    }

    public List<EquipoDto> obtenerEquipos(){
        logger.info("Verificando ");
        return equipoServicio.obtenerEquipos();
    }
}

