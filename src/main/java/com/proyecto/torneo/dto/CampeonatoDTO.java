package com.proyecto.torneo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampeonatoDTO {
    private Long id;
    private List<EquipoDTO> equipos;
    private List<PartidoDTO> partidos;
    private List<ClasificacionDTO> clasificaciones;
}