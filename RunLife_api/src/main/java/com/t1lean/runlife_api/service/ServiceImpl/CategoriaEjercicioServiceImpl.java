package com.t1lean.runlife_api.service.ServiceImpl;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.exception.UsuarioNotFoundException;
import com.t1lean.runlife_api.model.Categoria;
import com.t1lean.runlife_api.repository.ICategoriaEjercicioRepository;
import com.t1lean.runlife_api.service.CategoriaEjercicioService;
import jakarta.transaction.Transactional;
import com.t1lean.runlife_api.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaEjercicioServiceImpl implements CategoriaEjercicioService {
    private final ICategoriaEjercicioRepository categoriaEjercicioRepository;

    @Autowired
    public CategoriaEjercicioServiceImpl(ICategoriaEjercicioRepository categoriaEjercicioRepository) {
        this.categoriaEjercicioRepository = categoriaEjercicioRepository;

    }
    @Override
    @Transactional
    public Categoria crearCategoriaEjercicio(Categoria categoria) {
        boolean existingCategoriaEjercicio = categoriaEjercicioRepository.existsByNombreIgnoreCase(categoria.getNombre());
        if (existingCategoriaEjercicio) {
            throw new ValidationException("El nombre de categoría ya está en uso");
        } else {
            validateCategoriaEjercicio(categoria);
        }

        return categoriaEjercicioRepository.save(categoria);
    }
    @Override
    public Categoria actualizarCategoriaEjercicio(Long id, Categoria categoriaActualizada) {
        Categoria categoriaExistente = categoriaEjercicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría de Ejercicio no encontrado con el ID: " + id));

        if (categoriaActualizada.getNombre() != null) {
            categoriaExistente.setNombre(categoriaActualizada.getNombre());
        }

        validateUpdate(categoriaExistente);

        return categoriaEjercicioRepository.save(categoriaExistente);
    }
    @Override
    public Categoria searchCategoriaEjercicioById(Long id) {
        return categoriaEjercicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria de Ejercicio no encontrado con el ID: " + id));
    }

    @Override
    public List<Categoria> searchCategoriaEjercicioByNombre(String nombre) {
        List<Categoria> categorias = categoriaEjercicioRepository.findByNombreContainingIgnoreCase(nombre);

        if (categorias.isEmpty()) {
            throw new UsuarioNotFoundException("No se encontró Categoria de Ejercicios con el nombre proporcionado: " + nombre);
        }
        return categorias;
    }

    @Override
    public List<Categoria> listarCategoriaEjercicios() {
        return categoriaEjercicioRepository.findAll();
    }

    private void validateUpdate(Categoria categoriaActualizado) {
        if (categoriaActualizado.getNombre() == null || categoriaActualizado.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la Categoria de ejercicio no puede estar vacío");
        }
    }

    public void validateCategoriaEjercicio(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento no puede estar vacío");
        }
    }

}
