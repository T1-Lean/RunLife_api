package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Alimento")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AlimentoId;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "calorias", nullable = false)
    private double calorias;

    @Column(name = "proteina", nullable = false)
    private double proteina;

    @Column(name = "carbohidratos", nullable = false)
    private double carbohidratos;

    @Column(name = "grasa", nullable = false)
    private double grasa;

    @Column(name = "azucar", nullable = false)
    private double azucar;

    @Column(name = "sodio", nullable = false)
    private double sodio;
}
