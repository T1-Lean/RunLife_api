package com.t1lean.runlife_api.exception;

public class CamposInvalidosException extends RuntimeException {
    public CamposInvalidosException(String mensaje) {
        super(mensaje);
    }
}