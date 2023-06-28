package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "correo", length = 30, nullable = false)
    private String correo;

    @Column(name = "altura", nullable = false)
    private float altura;

    @Column(name = "peso", nullable = false)
    private float peso;

    @Column(name = "duracionTotal", nullable = false)
    private float duracionTotal;

    @Column(name = "distanciaTotal", nullable = false)
    private float distanciaTotal;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

}