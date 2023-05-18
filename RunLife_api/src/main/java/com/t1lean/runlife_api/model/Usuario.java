package com.t1lean.runlife_api.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;
    private int usuarioId;
    private String nombre;
    private int edad;
    private String correo;
    private String contraseña;
    private float altura;
    private float peso;
    private float duracionTotal;
    private float distanciaTotal;

    // Constructores, getters y setters

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los campos excepto usuario Id
    public Usuario(String nombre, int edad, String correo, String contraseña, float altura, float peso, float duracionTotal, float distanciaTotal) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.contraseña = contraseña;
        this.altura = altura;
        this.peso = peso;
        this.duracionTotal = duracionTotal;
        this.distanciaTotal = distanciaTotal;
    }

    // Getters y setters de todos los campos

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(float duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    public float getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(float distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }
}
