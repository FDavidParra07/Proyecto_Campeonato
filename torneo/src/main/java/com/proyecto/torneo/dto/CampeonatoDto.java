package com.proyecto.torneo.dto;

import com.proyecto.torneo.entidades.Equipo;
import com.proyecto.torneo.entidades.Partido;
import com.proyecto.torneo.entidades.Clasificacion;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CampeonatoDto implements Serializable {
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private List<Clasificacion> clasificaciones;
}