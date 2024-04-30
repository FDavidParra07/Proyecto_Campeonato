package com.proyecto.torneo.dto;

import com.proyecto.torneo.entidades.Estadio;
import lombok.Data;

import java.io.Serializable;

@Data
public class EquipoDto implements Serializable {
    private Long id;
    private String nombre;
    private String tecnico;
    private String uniforme;
    private String direccion;
    private Estadio estadio;
}
