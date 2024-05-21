package com.proyecto.torneo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDto {
    private Long id;
    private int golesLocal;
    private int golesVisitante;
    private List<Long> listaGoles;
}
