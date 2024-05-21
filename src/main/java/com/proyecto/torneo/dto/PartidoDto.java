package com.proyecto.torneo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PartidoDto implements Serializable {
    private Long idLocal;
    private Long idVisitante;
    private Long estadio;
    private Long resultado;
}
