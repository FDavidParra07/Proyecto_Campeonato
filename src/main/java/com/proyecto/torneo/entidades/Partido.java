package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "partidos")
public class Partido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "local_id", nullable = false)
    private Equipo local;

    @ManyToOne
    @JoinColumn(name = "visitante_id", nullable = true)
    private Equipo visitante;

    @ManyToOne
    @JoinColumn(name = "estadio_id", nullable = true)
    private Estadio estadio;

    @OneToOne(mappedBy = "partido")
    private Resultado resultado;

    @ManyToOne
    @JoinColumn(name = "campeonato_id", nullable = true)
    private Campeonato campeonato;
}
