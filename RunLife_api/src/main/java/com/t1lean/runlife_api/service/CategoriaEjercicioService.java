package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Categoria;

import java.util.List;

public interface CategoriaEjercicioService {
    Categoria crearCategoriaEjercicio(Categoria categoria);
    Categoria actualizarCategoriaEjercicio(Long id, Categoria categoria);
    Categoria searchCategoriaEjercicioById(Long id);
    List<Categoria> searchCategoriaEjercicioByNombre(String nombre);
    List<Categoria> listarCategoriaEjercicios();


}
