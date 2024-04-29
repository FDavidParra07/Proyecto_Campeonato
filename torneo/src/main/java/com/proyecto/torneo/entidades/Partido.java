package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "partido")
@Table(name = "partidos")
public class Partido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_partidos")
    @SequenceGenerator(name = "seq_partidos", sequenceName = "seq_partidos", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Equipo local;

    @ManyToOne
    private Equipo visitante;

    @ManyToOne
    private Estadio estadio;

    @OneToOne
    private Resultado resultado;
}