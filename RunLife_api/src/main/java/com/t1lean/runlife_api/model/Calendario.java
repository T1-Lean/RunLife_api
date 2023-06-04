/*package com.t1lean.runlife_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int calendarioId;

    @OneToOne
    private Usuario usuario;

    private String evento;

    // Constructor vacío
    public Calendario() {
    }

    // Constructor con todos los campos excepto calendarioId
    public Calendario(Usuario usuario, String evento) {
        this.usuario = usuario;
        this.evento = evento;
    }

    // Getters y setters de todos los campos

    public int getCalendarioId() {
        return calendarioId;
    }

    public void setCalendarioId(int calendarioId) {
        this.calendarioId = calendarioId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
}
*/