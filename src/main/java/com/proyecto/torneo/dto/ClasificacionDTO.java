package com.proyecto.torneo.dto;

import lombok.Data;

@Data
public class ClasificacionDTO {
    private Long id;
    private Long equipoId;
    private int puntos;
    private int golesAFavor;
    private int golesEnContra;
    private int diferenciaDeGoles;
    private int partidosJugados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private int partidosGanados;
    private Long campeonatoId;
}
