package com.proyecto.torneo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoDTO {
    private Long id;
    private String nombre;
    private String tecnico;
    private String uniforme;
    private String direccion;
    private EstadioDTO estadio;
}