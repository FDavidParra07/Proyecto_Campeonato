package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "equipo")
@Table(name = "equipos")
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tecnico", nullable = true)
    private String tecnico;

    @Column(name = "uniforme", nullable = true)
    private String uniforme;

    @Column(name = "direccion", nullable = true)
    private String direccion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clasificacion> clasificaciones;

    @ManyToOne
    @JoinColumn(name = "estadio_id", nullable = true)
    private Estadio estadio;

    @ManyToOne
    @JoinColumn(name = "campeonato_id", nullable = false)
    private Campeonato campeonato;
}
