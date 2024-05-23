package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "clasificaciones")
public class Clasificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipo_id", nullable = true)
    private Equipo equipo;

    @Column(name = "puntos", nullable = true)
    private int puntos;

    @Column(name = "goles_a_favor", nullable = true)
    private int golesAFavor;

    @Column(name = "goles_en_contra", nullable = true)
    private int golesEnContra;

    @Column(name = "diferencia_de_goles", nullable = true)
    private int diferenciaDeGoles;

    @Column(name = "partidos_jugados", nullable = true)
    private int partidosJugados;

    @Column(name = "partidos_perdidos", nullable = true)
    private int partidosPerdidos;

    @Column(name = "partidos_empatados", nullable = true)
    private int partidosEmpatados;

    @Column(name = "partidos_ganados", nullable = true)
    private int partidosGanados;

    @ManyToOne
    @JoinColumn(name = "campeonato_id", nullable = true)
    private Campeonato campeonato;
}
