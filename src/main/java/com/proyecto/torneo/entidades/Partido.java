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

    @Column(name = "local", nullable = false)
    private Long local;

    @Column(name = "visitante", nullable = false)
    private Long visitante;

    @Column(name = "estadio", nullable = false)
    private Long estadio;

    @Column(name = "resultado", nullable = false)
    private Long resultado;
}