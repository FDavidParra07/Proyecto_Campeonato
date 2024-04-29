package com.proyecto.torneo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EstadioDto implements Serializable {
    private String nombre;
    private int capacidad;
    private String ubicacion;
}
