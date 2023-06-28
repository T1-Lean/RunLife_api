package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.model.Ejercicio;
import com.t1lean.runlife_api.service.EjercicioService;
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
    public ResponseEntity<Ejercicio> crearEjercicio(@RequestBody Ejercicio ejercicio) {
        Ejercicio nuevoEjercicio = ejercicioService.crearEjercicio(ejercicio);
        return ResponseEntity.ok(nuevoEjercicio);
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
    public ResponseEntity<Ejercicio> actualizarEjercicio(@PathVariable int id, @RequestBody Ejercicio ejercicio) {
        Ejercicio ejercicioExistente = ejercicioService.obtenerEjercicioPorId(id);
        if (ejercicioExistente != null) {
            ejercicioExistente.setNombre(ejercicio.getNombre());
            ejercicioExistente.setDescripcion(ejercicio.getDescripcion());
            Ejercicio ejercicioActualizado = ejercicioService.actualizarEjercicio(ejercicioExistente);
            return ResponseEntity.ok(ejercicioActualizado);
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