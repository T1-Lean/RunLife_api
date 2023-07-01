package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.controller.dto.EjercicioRequest;
import com.t1lean.runlife_api.exception.CamposInvalidosException;
import com.t1lean.runlife_api.exception.EjercicioExistenteException;
import com.t1lean.runlife_api.model.Ejercicio;
import com.t1lean.runlife_api.service.EjercicioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/runlife")
public class EjercicioController {
    private final EjercicioService ejercicioService;

    public EjercicioController(EjercicioService ejercicioService) {
        this.ejercicioService = ejercicioService;
    }

    @PostMapping("/crearejercicio")
    public ResponseEntity<String> crearEjercicio(@Valid @RequestBody EjercicioRequest ejercicioRequest) {
        try {
            Ejercicio ejercicio = ejercicioService.agregarEjercicio(ejercicioRequest);
            return ResponseEntity.ok("Ejercicio agregado correctamente");
        } catch (EjercicioExistenteException e) {
            return ResponseEntity.badRequest().body("El ejercicio ya existe en el sistema");
        } catch (CamposInvalidosException e) {
            return ResponseEntity.badRequest().body("Todos los campos obligatorios deben ser completados");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al agregar el ejercicio");
        }
    }

    @GetMapping("/listarejercicios")
    public ResponseEntity<List<Ejercicio>> obtenerTodosLosEjercicios() {
        List<Ejercicio> ejercicios = ejercicioService.obtenerTodosLosEjercicios();
        return ResponseEntity.ok(ejercicios);
    }

    @GetMapping("/buscarejercicio/{id}")
    public ResponseEntity<Ejercicio> obtenerEjercicioPorId(@PathVariable int id) {
        Ejercicio ejercicio = ejercicioService.obtenerEjercicioPorId(id);
        if (ejercicio != null) {
            return ResponseEntity.ok(ejercicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/actualizarejercicio/{id}")
    public ResponseEntity<String> actualizarEjercicio(@PathVariable int id, @RequestBody Ejercicio ejercicio) {
        Ejercicio ejercicioExistente = ejercicioService.obtenerEjercicioPorId(id);
        if (ejercicioExistente != null) {
            ejercicioExistente.setNombre(ejercicio.getNombre());
            ejercicioExistente.setDescripcion(ejercicio.getDescripcion());
            ejercicioExistente.setGrupoMuscular(ejercicio.getGrupoMuscular());
            ejercicioExistente.setCategoriaEjercicio(ejercicio.getCategoriaEjercicio());
            Ejercicio ejercicioActualizado = ejercicioService.actualizarEjercicio(ejercicioExistente);
            if (ejercicioActualizado != null) {
                return ResponseEntity.ok("Ejercicio actualizado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error al actualizar el ejercicio");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminarejercicio/{id}")
    public ResponseEntity<Void> eliminarEjercicio(@PathVariable int id) {
        Ejercicio ejercicioExistente = ejercicioService.obtenerEjercicioPorId(id);
        if (ejercicioExistente != null) {
            ejercicioService.eliminarEjercicio(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}