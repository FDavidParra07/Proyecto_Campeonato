package com.proyecto.torneo.dto;

import lombok.Data;

@Data
public class EstadioDTO {
    private Long id;
    private String nombre;
    private int capacidad;
    private String ubicacion;
}
