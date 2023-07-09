package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.controller.dto.EjercicioRequest;
import com.t1lean.runlife_api.exception.EjercicioExistenteException;
import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.model.Categoria;
import com.t1lean.runlife_api.model.Ejercicio;
import com.t1lean.runlife_api.repository.IEjercicioRepository;
import com.t1lean.runlife_api.service.CategoriaEjercicioService;
import com.t1lean.runlife_api.service.EjercicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runlife")
public class EjercicioController {

    private final EjercicioService ejercicioService;
    private final IEjercicioRepository ejercicioRepository;
    private final CategoriaEjercicioService categoriaEjercicioService;

    public EjercicioController(EjercicioService ejercicioService, IEjercicioRepository ejercicioRepository, CategoriaEjercicioService categoriaEjercicioService) {
        this.ejercicioService = ejercicioService;
        this.ejercicioRepository = ejercicioRepository;
        this.categoriaEjercicioService = categoriaEjercicioService;
    }
    @PostMapping("/ejercicios/crearejercicio")
    public ResponseEntity<Ejercicio> crearEjercicio(@RequestBody EjercicioRequest ejercicioRequest) {
        String nombre = ejercicioRequest.getNombre();
        String descripcion = ejercicioRequest.getDescripcion();

        if (ejercicioRepository.existsByNombreIgnoreCase(nombre) || ejercicioRepository.existsByDescripcionIgnoreCase(descripcion)) {
            throw new EjercicioExistenteException("Ya existe un ejercicio con el mismo nombre o descripción");
        }

        Ejercicio nuevoEjercicio = new Ejercicio();
        nuevoEjercicio.setNombre(nombre);
        nuevoEjercicio.setDescripcion(descripcion);
        nuevoEjercicio.setGrupoMuscular(ejercicioRequest.getGrupoMuscular());

        Long categoriaId = ejercicioRequest.getCategoriaEjercicioId();
        if (categoriaId != null) {
            Categoria categoria = categoriaEjercicioService.searchCategoriaEjercicioById(categoriaId);
            if (categoria == null) {
                throw new ResourceNotFoundException("La categoría de ejercicio proporcionada no existe");
            }
            nuevoEjercicio.setCategoria(categoria);
        }

        Ejercicio ejercicioCreado = ejercicioService.crearEjercicio(nuevoEjercicio);
        return new ResponseEntity<>(ejercicioCreado, HttpStatus.CREATED);
    }

    @PutMapping("/ejercicios/actualizarejercicio/{id}")
    public ResponseEntity<Ejercicio> actualizarEjercicio(@PathVariable Long id, @RequestBody Ejercicio ejercicio) {
        Ejercicio ejercicioActualizado = ejercicioService.actualizarEjercicio(id, ejercicio);
        return ResponseEntity.ok(ejercicioActualizado);
    }
    @GetMapping("/ejercicios")
    public ResponseEntity<List<Ejercicio>> listarEjercicios() {
        List<Ejercicio> ejercicios = ejercicioService.listarEjercicios();
        return ResponseEntity.ok(ejercicios);
    }
    @GetMapping("/ejercicios/buscarejercicio/{id}")
    public ResponseEntity<Ejercicio> searchEjercicioById(@PathVariable Long id) {
        Ejercicio ejercicio = ejercicioService.searchEjercicioById(id);
        if (ejercicio != null) {
            return ResponseEntity.ok(ejercicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/eventos/buscarejercicio/nombre")
    public ResponseEntity<List<Ejercicio>> searchEjercicioByNombre(@RequestParam("nombre") String nombre) {
        List<Ejercicio> ejercicios = ejercicioService.searchEjercicioByNombre(nombre);
        return ResponseEntity.ok(ejercicios);
    }
    @DeleteMapping("/ejercicios/eliminarejercicio/{id}")
    public ResponseEntity<Void> eliminarEjercicio(@PathVariable Long id) {
        Ejercicio ejercicioExistente = ejercicioService.searchEjercicioById(id);
        if (ejercicioExistente != null) {
            ejercicioService.eliminarEjercicio(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
