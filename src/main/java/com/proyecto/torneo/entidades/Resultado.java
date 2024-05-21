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
@Entity(name = "resultado")
@Table(name = "resultados")
public class Resultado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_resultados")
    @SequenceGenerator(name = "seq_resultados", sequenceName = "seq_resultados", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "goles_local", nullable = false)
    private int golesLocal;

    @Column(name = "goles_visitante", nullable = false)
    private int golesVisitante;

    @Column(name = "lista_goles", nullable = false)
    private List<Long> listaGoles;
}