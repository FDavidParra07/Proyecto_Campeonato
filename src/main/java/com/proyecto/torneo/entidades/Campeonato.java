package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "campeonatos")
public class Campeonato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Equipo> equipos;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Partido> partidos;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Clasificacion> clasificaciones;
}
