package com.t1lean.runlife_api.exception;

public class EjercicioExistenteException extends RuntimeException {
    public EjercicioExistenteException(String mensaje) {
        super(mensaje);
    }
}