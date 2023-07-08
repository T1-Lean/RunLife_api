package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.model.CategoriaEjercicio;
import com.t1lean.runlife_api.service.CategoriaEjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runlife")
public class CategoriaController {
    private final CategoriaEjercicioService categoriaEjercicioService;

    @Autowired
    public CategoriaController(CategoriaEjercicioService categoriaEjercicioService) {
        this.categoriaEjercicioService = categoriaEjercicioService;
    }

    @PostMapping("crearcategoria")
    public ResponseEntity<CategoriaEjercicio> crearCategoria(@RequestBody CategoriaEjercicio categoria) {
        CategoriaEjercicio nuevaCategoria = categoriaEjercicioService.crearCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    @PutMapping("editarCategoria/{id}")
    public ResponseEntity<CategoriaEjercicio> editarCategoria(@PathVariable("id") int id, @RequestBody CategoriaEjercicio categoria) {
        CategoriaEjercicio categoriaExistente = categoriaEjercicioService.buscarCategoria(id);
        if (categoriaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        categoriaExistente.setNombre(categoria.getNombre());
        CategoriaEjercicio categoriaActualizada = categoriaEjercicioService.editarCategoria(categoriaExistente);
        return ResponseEntity.ok(categoriaActualizada);
    }
}
