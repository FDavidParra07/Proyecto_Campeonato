package com.proyecto.torneo.dto;

import lombok.Data;

@Data
public class GolDTO {
    private Long id;
    private Long resultadoId;
    private Long jugadorId;
    private int minuto;
    private boolean autogol;
    private boolean golLocal;
    private boolean golVisitante;
}
