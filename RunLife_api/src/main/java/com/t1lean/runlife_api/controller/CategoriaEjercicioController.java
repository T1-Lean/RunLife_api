package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.model.Categoria;
import com.t1lean.runlife_api.service.CategoriaEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/runlife")
public class CategoriaEjercicioController {
    private final CategoriaEjercicioService categoriaEjercicioService;

    @Autowired
    public CategoriaEjercicioController(CategoriaEjercicioService categoriaEjercicioService) {
        this.categoriaEjercicioService = categoriaEjercicioService;
    }

    @PostMapping("categoriaejercicios/crearcategoriaejercicio")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = categoriaEjercicioService.crearCategoriaEjercicio(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("categoriaejercicios/actualizarcategoria/{id}")
    public ResponseEntity<Categoria> actualizarCategoriaEjercicio(@PathVariable("id") Long id, @RequestBody Categoria categoria) {
        Categoria categoriaActualizada = categoriaEjercicioService.actualizarCategoriaEjercicio(id, categoria);
        return ResponseEntity.ok(categoriaActualizada);
    }

    @GetMapping("/categoriaejercicios/buscarcategoria/{id}")
    public ResponseEntity<Categoria> searchCategoriaEjercicioById(@PathVariable Long id) {
        Categoria categoria = categoriaEjercicioService.searchCategoriaEjercicioById(id);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/categoriaejercicios/buscarcategoria")
    public ResponseEntity<List<Categoria>> searchCategoriaEjercicioByNombre(@RequestParam("nombre") String nombre) {
        List<Categoria> categorias = categoriaEjercicioService.searchCategoriaEjercicioByNombre(nombre);
        if (categorias.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categorias);
    }
    @GetMapping("/categoriaejercicios")
    public ResponseEntity<List<Categoria>> listarCategoriaEjercicios() {
        List<Categoria> categorias = categoriaEjercicioService.listarCategoriaEjercicios();
        return ResponseEntity.ok(categorias);
    }

}