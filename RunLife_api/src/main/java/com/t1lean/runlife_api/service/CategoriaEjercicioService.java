package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.CategoriaEjercicio;
import com.t1lean.runlife_api.repository.CategoriaEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaEjercicioService {
    private final CategoriaEjercicioRepository categoriaEjercicioRepository;

    @Autowired
    public CategoriaEjercicioService(CategoriaEjercicioRepository categoriaEjercicioRepository) {
        this.categoriaEjercicioRepository = categoriaEjercicioRepository;
    }

    public CategoriaEjercicio crearCategoria(CategoriaEjercicio categoria) {
        return categoriaEjercicioRepository.save(categoria);
    }

    public CategoriaEjercicio editarCategoria(CategoriaEjercicio categoria) {
        return categoriaEjercicioRepository.save(categoria);
    }

    public CategoriaEjercicio buscarCategoria(int id) {
        return categoriaEjercicioRepository.findById(id).orElse(null);
    }
}
