package com.t1lean.runlife_api.exception;

public class CategoriaEjercicioNotFoundException extends RuntimeException {
    public CategoriaEjercicioNotFoundException(String mensaje) {
        super(mensaje);
    }
}