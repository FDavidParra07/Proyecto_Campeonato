package com.proyecto.torneo.dto;

import com.proyecto.torneo.entidades.Equipo;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClasificacionDto implements Serializable {
    private Equipo equipo;
    private int puntos;
    private int golesAFavor;
    private int golesEnContra;
    private int diferenciaDeGoles;
    private int partidosJugados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private int partidosGanados;
}
