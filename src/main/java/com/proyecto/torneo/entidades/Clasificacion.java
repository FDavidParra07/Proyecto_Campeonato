package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clasificacion")
@Table(name = "clasificaciones")
public class Clasificacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clasificaciones")
    @SequenceGenerator(name = "seq_clasificaciones", sequenceName = "seq_clasificaciones", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Equipo equipo;

    @Column(name = "puntos", nullable = false)
    private int puntos;

    @Column(name = "goles_a_favor", nullable = false)
    private int golesAFavor;

    @Column(name = "goles_en_contra", nullable = false)
    private int golesEnContra;

    @Column(name = "diferencia_de_goles", nullable = false)
    private int diferenciaDeGoles;

    @Column(name = "partidos_jugados", nullable = false)
    private int partidosJugados;

    @Column(name = "partidos_perdidos", nullable = false)
    private int partidosPerdidos;

    @Column(name = "partidos_empatados", nullable = false)
    private int partidosEmpatados;

    @Column(name = "partidos_ganados", nullable = false)
    private int partidosGanados;
}