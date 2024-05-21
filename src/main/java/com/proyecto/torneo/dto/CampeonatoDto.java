package com.proyecto.torneo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampeonatoDto {
    private Long id;
    private List<Long> equipos;
    private List<Long> partidos;
    private List<Long> clasificaciones;
}
