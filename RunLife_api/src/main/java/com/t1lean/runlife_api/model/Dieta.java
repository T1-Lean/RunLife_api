/*package com.t1lean.runlife_api.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Dieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "plan_de_entrenamiento_id")
    private PlanDeEntrenamiento planDeEntrenamiento;

    private int dietaId;
    private String nombre;
    private String tipo;
    private int caloriasTotales;

    @OneToMany(mappedBy = "dieta")
    private List<DetalleDieta> detallesDieta;

    // Constructor vacío
    public Dieta() {
    }

    // Constructor con todos los campos excepto dietaId
    public Dieta(String nombre, String tipo, int caloriasTotales, List<DetalleDieta> detallesDieta) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.caloriasTotales = caloriasTotales;
        this.detallesDieta = detallesDieta;
    }

    // Getters y setters de todos los campos

    public int getDietaId() {
        return dietaId;
    }

    public void setDietaId(int dietaId) {
        this.dietaId = dietaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCaloriasTotales() {
        return caloriasTotales;
    }

    public void setCaloriasTotales(int caloriasTotales) {
        this.caloriasTotales = caloriasTotales;
    }

    public List<DetalleDieta> getDetallesDieta() {
        return detallesDieta;
    }

    public void setDetallesDieta(List<DetalleDieta> detallesDieta) {
        this.detallesDieta = detallesDieta;
    }
}
*/