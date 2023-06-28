package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Ejercicio;
import com.t1lean.runlife_api.repository.EjercicioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EjercicioService {
    private final EjercicioRepository ejercicioRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public Ejercicio crearEjercicio(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public List<Ejercicio> obtenerTodosLosEjercicios() {
        return ejercicioRepository.findAll();
    }

    public Ejercicio obtenerEjercicioPorId(int id) {
        Optional<Ejercicio> ejercicioOptional = ejercicioRepository.findById(id);
        return ejercicioOptional.orElse(null);
    }

    public Ejercicio actualizarEjercicio(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public void eliminarEjercicio(int id) {
        ejercicioRepository.deleteById(id);
    }
}