package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.controller.dto.EjercicioRequest;
import com.t1lean.runlife_api.model.Ejercicio;
import com.t1lean.runlife_api.repository.EjercicioRepository;
import com.t1lean.runlife_api.exception.CamposInvalidosException;
import com.t1lean.runlife_api.exception.EjercicioExistenteException;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjercicioService {
    private final EjercicioRepository ejercicioRepository;

    public EjercicioService(EjercicioRepository ejercicioRepository) {
        this.ejercicioRepository = ejercicioRepository;
    }

    public Ejercicio agregarEjercicio(EjercicioRequest ejercicioRequest) {
        validarCamposObligatorios(ejercicioRequest);
        verificarEjercicioExistente(ejercicioRequest.getNombre());

        Ejercicio ejercicio = convertirDtoAEjercicio(ejercicioRequest);
        return ejercicioRepository.save(ejercicio);
    }

    private void validarCamposObligatorios(EjercicioRequest ejercicioRequest) {
        if (StringUtils.isBlank(ejercicioRequest.getNombre()) ||
                StringUtils.isBlank(ejercicioRequest.getDescripcion())) {
            throw new CamposInvalidosException("Todos los campos obligatorios deben ser completados");
        }
    }

    private void verificarEjercicioExistente(String nombre) {
        if (ejercicioRepository.existsByNombre(nombre)) {
            throw new EjercicioExistenteException("El ejercicio ya existe en el sistema");
        }
    }

    private Ejercicio convertirDtoAEjercicio(EjercicioRequest ejercicioRequest) {
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombre(ejercicioRequest.getNombre());
        ejercicio.setDescripcion(ejercicioRequest.getDescripcion());
        ejercicio.setGrupoMuscular(ejercicioRequest.getGrupoMuscular());
        return ejercicio;
    }
    public List<Ejercicio> obtenerTodosLosEjercicios() {
        return ejercicioRepository.findAll();
    }

    public Ejercicio obtenerEjercicioPorId(int id) {
        Optional<Ejercicio> ejercicioOptional = ejercicioRepository.findById((long) id);
        return ejercicioOptional.orElse(null);
    }

    public Ejercicio actualizarEjercicio(Ejercicio ejercicio) {
        return ejercicioRepository.save(ejercicio);
    }

    public void eliminarEjercicio(int id) {
        ejercicioRepository.deleteById((long) id);
    }
}
