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

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "correo", length = 30, nullable = false)
    private String correo;

    @Column(name = "contraseña", length = 30, nullable = false)
    private String contraseña;

    @Column(name = "altura", nullable = false)
    private float altura;

    @Column(name = "peso", nullable = false)
    private float peso;

    @Column(name = "duracionTotal", nullable = false)
    private float duracionTotal;

    @Column(name = "distanciaTotal", nullable = false)
    private float distanciaTotal;

}