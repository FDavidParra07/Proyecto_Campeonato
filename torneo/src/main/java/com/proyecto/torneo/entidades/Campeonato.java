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

    @OneToMany
    private List<Equipo> equipos;

    @OneToMany
    private List<Partido> partidos;

    @OneToMany
    private List<Clasificacion> clasificaciones;
}