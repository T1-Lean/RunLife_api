/*package com.t1lean.runlife_api.model;

import jakarta.persistence.*;

@Entity
public class DetalleDieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = "dieta_id")
    private Dieta dieta;

    private int detalleDietaId;
    private String nombre;
    private String tipo;
    private int calorias;

    // Constructor vacío
    public DetalleDieta() {
    }

    // Constructor con todos los campos excepto detalleDietaId
    public DetalleDieta(String nombre, String tipo, int calorias) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.calorias = calorias;
    }

    // Getters y setters de todos los campos

    public int getDetalleDietaId() {
        return detalleDietaId;
    }

    public void setDetalleDietaId(int detalleDietaId) {
        this.detalleDietaId = detalleDietaId;
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

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
*/