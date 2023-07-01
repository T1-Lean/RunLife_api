package com.t1lean.runlife_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Ejercicio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ejercicioId;
    private String nombre;
    private String descripcion;
    private String grupoMuscular;
    @ManyToOne
    @JoinColumn(name = "categoria_ejercicio_id")
    private CategoriaEjercicio categoriaEjercicio;


    public Ejercicio(String nombre, String descripcion, String grupoMuscular) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descripcion = grupoMuscular;
    }

    public Ejercicio() {

    }

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

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public CategoriaEjercicio getCategoriaEjercicio() {
        return categoriaEjercicio;
    }

    public void setCategoriaEjercicio(CategoriaEjercicio categoriaEjercicio) {
        this.categoriaEjercicio = categoriaEjercicio;
    }
}
