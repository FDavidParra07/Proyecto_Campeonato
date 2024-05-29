package com.proyecto.torneo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PartidoDTO {
    private Long id;
    private Long localId;
    private Long visitanteId;
    private Long estadioId;
    private LocalDateTime fecha;
    private ResultadoDTO resultado;
    private Long campeonatoId;
}
