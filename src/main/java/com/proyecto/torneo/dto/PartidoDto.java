package com.proyecto.torneo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidoDto {
    private Long id;
    private Long local;
    private Long visitante;
    private Long estadio;
    private Long resultado;
}
