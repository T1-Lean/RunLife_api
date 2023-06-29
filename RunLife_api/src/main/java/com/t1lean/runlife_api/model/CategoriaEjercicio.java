package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria_ejercicio")
public class CategoriaEjercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_ejercicio_id")
    private int categoriaEjercicioID;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "categoriaEjercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejercicio> ejercicios;

    public CategoriaEjercicio() {
        ejercicios = new ArrayList<>();
    }

    public int getCategoriaEjercicioID() {
        return categoriaEjercicioID;
    }

    public void setCategoriaEjercicioID(int categoriaEjercicioID) {
        this.categoriaEjercicioID = categoriaEjercicioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void addEjercicio(Ejercicio ejercicio) {
        ejercicios.add(ejercicio);
        ejercicio.setCategoriaEjercicio(this);
    }

    public void removeEjercicio(Ejercicio ejercicio) {
        ejercicios.remove(ejercicio);
        ejercicio.setCategoriaEjercicio(null);
    }
}