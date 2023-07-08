package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PlanDietetico")
public class PlanDietetico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlanDieteticoId;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
