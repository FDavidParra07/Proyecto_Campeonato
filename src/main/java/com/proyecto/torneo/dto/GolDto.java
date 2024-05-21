package com.proyecto.torneo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GolDto {
    private Long id;
    private Long resultado;
    private Long jugador;
    private int minuto;
    private boolean autogol;
    private boolean golLocal;
    private boolean golVisitante;
}
