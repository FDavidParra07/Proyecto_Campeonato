package com.proyecto.torneo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClasificacionDto {
    private Long id;
    private Long equipo;
    private int puntos;
    private int golesAFavor;
    private int golesEnContra;
    private int diferenciaDeGoles;
    private int partidosJugados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private int partidosGanados;
}
