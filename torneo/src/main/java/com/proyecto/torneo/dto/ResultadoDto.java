package com.proyecto.torneo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultadoDto implements Serializable {
    private int golesLocal;
    private int golesVisitante;
}
