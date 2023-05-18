package com.t1lean.runlife_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ejercicioId;
    private String nombre;
    private String descripcion;

    // Constructor vacío
    public Ejercicio() {
    }

    // Constructor con todos los campos excepto ejercicioId
    public Ejercicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters de todos los campos

    public int getEjercicioId() {
        return ejercicioId;
    }

    public void setEjercicioId(int ejercicioId) {
        this.ejercicioId = ejercicioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
