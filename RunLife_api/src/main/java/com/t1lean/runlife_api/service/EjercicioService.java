package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Ejercicio;

import java.util.List;

public interface EjercicioService {
    Ejercicio crearEjercicio(Ejercicio ejercicio);
    List<Ejercicio> listarEjercicios();
    Ejercicio searchEjercicioById(Long id);
    List<Ejercicio> searchEjercicioByNombre(String nombre);
    Ejercicio actualizarEjercicio(Long id, Ejercicio ejercicio);
    void eliminarEjercicio(Long id);
    void validateUpdate(Ejercicio ejercicio);
}
