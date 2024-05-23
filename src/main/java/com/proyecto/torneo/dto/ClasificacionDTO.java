package com.proyecto.torneo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClasificacionDTO {
    private Long id;
    private EquipoDTO equipo;
    private int puntos;
    private int golesAFavor;
    private int golesEnContra;
    private int diferenciaDeGoles;
    private int partidosJugados;
    private int partidosPerdidos;
    private int partidosEmpatados;
    private int partidosGanados;
}