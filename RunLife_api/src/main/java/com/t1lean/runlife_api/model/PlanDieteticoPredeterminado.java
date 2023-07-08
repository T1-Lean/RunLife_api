package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PlanDieteticoPredeterminado")
public class PlanDieteticoPredeterminado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlanDieteticoPredeterminadoId;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "tipo", length = 20, nullable = false)
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "plan_dietetico_id")
    private PlanDietetico planDietetico;
}
