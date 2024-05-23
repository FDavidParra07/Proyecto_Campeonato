package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "resultados")
public class Resultado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "goles_local", nullable = true)
    private int golesLocal;

    @Column(name = "goles_visitante", nullable = true)
    private int golesVisitante;

    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL)
    private List<Gol> listaGoles;

    @OneToOne
    @JoinColumn(name = "partido_id", nullable = true)
    private Partido partido;
}
