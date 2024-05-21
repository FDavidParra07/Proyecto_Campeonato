package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "campeonato")
@Table(name = "campeonatos")
public class Campeonato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_campeonatos")
    @SequenceGenerator(name = "seq_campeonatos", sequenceName = "seq_campeonatos", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "equipos", nullable = false)
    private List<Long> equipos;

    @Column(name = "partidos", nullable = false)
    private List<Long> partidos;

    @Column(name = "clasificaciones", nullable = false)
    private List<Long> clasificaciones;
}