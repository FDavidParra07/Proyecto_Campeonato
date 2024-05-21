package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "gol")
@Table(name = "goles")
public class Gol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_goles")
    @SequenceGenerator(name = "seq_goles", sequenceName = "seq_goles", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "resultado", nullable = false)
    private Long resultado;

    @Column(name = "jugador", nullable = false)
    private Long jugador;

    @Column(name = "minuto", nullable = false)
    private int minuto;

    @Column(name = "autogol", nullable = false)
    private boolean autogol;

    @Column(name = "gol_local", nullable = false)
    private boolean golLocal;

    @Column(name = "gol_visitante", nullable = false)
    private boolean golVisitante;
}
