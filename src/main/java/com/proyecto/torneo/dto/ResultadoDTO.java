package com.proyecto.torneo.dto;

import lombok.Data;
import java.util.List;

@Data
public class ResultadoDTO {
    private Long id;
    private int golesLocal;
    private int golesVisitante;
    private List<GolDTO> listaGoles;
}
