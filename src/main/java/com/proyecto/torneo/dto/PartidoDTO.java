package com.proyecto.torneo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidoDTO {
    private Long id;
    private EquipoDTO local;
    private EquipoDTO visitante;
    private EstadioDTO estadio;
    private ResultadoDTO resultado;
}