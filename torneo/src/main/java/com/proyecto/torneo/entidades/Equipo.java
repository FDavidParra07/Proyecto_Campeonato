package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "equipo")
@Table(name = "equipos")
public class Equipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipos")
    @SequenceGenerator(name = "seq_equipos", sequenceName = "seq_equipos", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tecnico", nullable = false)
    private String tecnico;

    @Column(name = "uniforme", nullable = false)
    private String uniforme;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToOne
    private Estadio estadio;
}