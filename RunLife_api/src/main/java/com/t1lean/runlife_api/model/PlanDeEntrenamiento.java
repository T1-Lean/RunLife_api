package com.t1lean.runlife_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class PlanDeEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planEntrenamientoId;
    private String nombre;
    private float duracion;

    @OneToMany(mappedBy = "planDeEntrenamiento")
    private List<Ejercicio> ejercicios;

    @OneToMany(mappedBy = "planDeEntrenamiento")
    private List<Dieta> dietas;

    // Constructor vacío
    public PlanDeEntrenamiento() {
    }

    // Constructor con todos los campos excepto planEntrenamientoId
    public PlanDeEntrenamiento(String nombre, float duracion, List<Ejercicio> ejercicios, List<Dieta> dietas) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.ejercicios = ejercicios;
        this.dietas = dietas;
    }

    // Getters y setters de todos los campos

    public int getPlanEntrenamientoId() {
        return planEntrenamientoId;
    }

    public void setPlanEntrenamientoId(int planEntrenamientoId) {
        this.planEntrenamientoId = planEntrenamientoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public List<Dieta> getDietas() {
        return dietas;
    }

    public void setDietas(List<Dieta> dietas) {
        this.dietas = dietas;
    }
}

