package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DiaEntrenamiento")
public class DiaEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DiaEntrenamientoId;

    @Column(name = "diaDeSemana", length = 30, nullable = false)
    private String diaDeSemana;;

    @ManyToOne
    @JoinColumn(name = "plan_entrenamiento_predeterminado_id")
    private PlanEntrenamientoPredeterminado planEntrenamientoPredeterminado;

    @ManyToOne
    @JoinColumn(name = "plan_entrenamiento_id")
    private PlanEntrenamiento planEntrenamiento;
}
