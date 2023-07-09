package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PlanEntrenamiento")
public class PlanEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PlanEntrenamientoId;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
