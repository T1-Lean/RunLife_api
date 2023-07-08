package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CategoriaEjercicio")
public class CategoriaEjercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoriaEjercicioId;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;;
}
