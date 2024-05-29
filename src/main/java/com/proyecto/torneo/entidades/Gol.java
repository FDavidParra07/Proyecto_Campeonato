package com.proyecto.torneo.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "gol")
@Table(name = "goles")
public class Gol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resultado_id", nullable = false)
    private Resultado resultado;

    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = true)
    private Jugador jugador;

    @Column(name = "minuto", nullable = true)
    private int minuto;

    @Column(name = "autogol", nullable = true)
    private boolean autogol;

    @Column(name = "gol_local", nullable = true)
    private boolean golLocal;

    @Column(name = "gol_visitante", nullable = true)
    private boolean golVisitante;
}
