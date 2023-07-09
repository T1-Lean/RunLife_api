package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PlanEntrenamientoPredeterminado")
public class PlanEntrenamientoPredeterminado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlanEntrenamientoPredeterminadoId;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "dificultad", nullable = false)
    private int dificultad;

    @ManyToOne
    @JoinColumn(name = "plan_entrenamiento_id")
    private PlanEntrenamiento planEntrenamiento;
}
