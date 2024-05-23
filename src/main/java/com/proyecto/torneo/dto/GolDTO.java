package com.proyecto.torneo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GolDTO {
    private Long id;
    private ResultadoDTO resultado;
    private JugadorDTO jugador;
    private int minuto;
    private boolean autogol;
    private boolean golLocal;
    private boolean golVisitante;
}