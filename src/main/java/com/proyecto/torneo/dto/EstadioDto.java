package com.proyecto.torneo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadioDto {
    private Long id;
    private String nombre;
    private int capacidad;
    private String ubicacion;
}
