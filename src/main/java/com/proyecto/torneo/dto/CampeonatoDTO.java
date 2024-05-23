package com.proyecto.torneo.dto;

import lombok.Data;
import java.util.List;

@Data
public class CampeonatoDTO {
    private Long id;
    private String nombre;
    private List<EquipoDTO> equipos;
    private List<PartidoDTO> partidos;
    private List<ClasificacionDTO> clasificaciones;
}
