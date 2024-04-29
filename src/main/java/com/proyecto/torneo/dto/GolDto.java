package com.proyecto.torneo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GolDto implements Serializable {
    private JugadorDto jugador;
    private int minuto;
    private boolean autogol;
    private boolean golLocal;
    private boolean golVisitante;
}
