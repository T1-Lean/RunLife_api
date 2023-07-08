package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DiaDieta")
public class DiaDieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DiaDietaId;

    @Column(name = "diaDeSemana", length = 30, nullable = false)
    private String diaDeSemana;;

    @ManyToOne
    @JoinColumn(name = "plan_dietetico_predeterminado_id")
    private PlanDieteticoPredeterminado planDieteticoPredeterminado;

    @ManyToOne
    @JoinColumn(name = "plan_dietetico_id")
    private PlanDietetico planDietetico;
}
