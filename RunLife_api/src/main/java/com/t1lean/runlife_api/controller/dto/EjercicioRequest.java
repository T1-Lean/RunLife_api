package com.t1lean.runlife_api.controller.dto;
import jakarta.validation.constraints.NotBlank;

public class EjercicioRequest {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    private String grupoMuscular;
    private int categoriaEjercicioID;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGrupoMuscular(){
        return grupoMuscular;
    }

    public int getCategoriaEjercicioID(){
        return categoriaEjercicioID;
    }
}
