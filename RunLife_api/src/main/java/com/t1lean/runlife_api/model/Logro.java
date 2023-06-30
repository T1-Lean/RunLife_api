package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Logro {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recompensa_id")
    private Recompensa recompensa;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "km_requeridos", nullable = false)
    private double kmRequeridos;
}

