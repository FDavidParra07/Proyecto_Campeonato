package com.proyecto.torneo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoDto {
    private Long id;
    private String nombre;
    private String tecnico;
    private String uniforme;
    private String direccion;
    private EstadioDto estadio;
}
