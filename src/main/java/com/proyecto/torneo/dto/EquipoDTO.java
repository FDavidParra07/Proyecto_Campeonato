package com.proyecto.torneo.dto;

import lombok.Data;

@Data
public class EquipoDTO {
    private Long id;
    private String nombre;
    private String tecnico;
    private String uniforme;
    private String direccion;
    private Long estadioId;
    private Long campeonatoId;
}
