package com.t1lean.runlife_api.service.ServiceImpl;

        import com.t1lean.runlife_api.exception.CamposInvalidosException;
        import com.t1lean.runlife_api.exception.ResourceNotFoundException;
        import com.t1lean.runlife_api.exception.UsuarioNotFoundException;
        import com.t1lean.runlife_api.model.Categoria;
        import com.t1lean.runlife_api.model.Ejercicio;
        import com.t1lean.runlife_api.repository.IEjercicioRepository;
        import com.t1lean.runlife_api.service.CategoriaEjercicioService;
        import com.t1lean.runlife_api.service.EjercicioService;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class EjercicioServiceImpl implements EjercicioService {
    private final IEjercicioRepository ejercicioRepository;
    private final CategoriaEjercicioService categoriaEjercicioService;

    public EjercicioServiceImpl(IEjercicioRepository ejercicioRepository, CategoriaEjercicioService categoriaEjercicioService) {
        this.ejercicioRepository = ejercicioRepository;
        this.categoriaEjercicioService = categoriaEjercicioService;
    }

    @Override
    public Ejercicio crearEjercicio(Ejercicio ejercicio) {
        validateEjercicio(ejercicio);
        return ejercicioRepository.save(ejercicio);
    }

    @Override
    public List<Ejercicio> listarEjercicios() {
        return ejercicioRepository.findAll();
    }

    public Ejercicio searchEjercicioById(Long id) {
        return ejercicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria de Ejercicio no encontrado con el ID: " + id));
    }

    @Override
    public List<Ejercicio> searchEjercicioByNombre(String nombre) {
        List<Ejercicio> ejercicios = ejercicioRepository.findByNombreContainingIgnoreCase(nombre);

        if (ejercicios.isEmpty()) {
            throw new UsuarioNotFoundException("No se encontraron ejercicios con el nombre proporcionado: " + nombre);
        }

        return ejercicios;
    }
    @Override
    public Ejercicio actualizarEjercicio(Long id, Ejercicio ejercicioActualizado) {
        Ejercicio ejercicioExistente = ejercicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ejercicio no encontrado con el ID: " + id));

        if (ejercicioActualizado.getNombre() != null) {
            ejercicioExistente.setNombre(ejercicioActualizado.getNombre());
        }
        if (ejercicioActualizado.getDescripcion() != null) {
            ejercicioExistente.setDescripcion(ejercicioActualizado.getDescripcion());
        }
        if (ejercicioActualizado.getGrupoMuscular() != null) {
            ejercicioExistente.setGrupoMuscular(ejercicioActualizado.getGrupoMuscular());
        }
        if (ejercicioActualizado.getCategoriaEjercicioId() != null) {
            Long categoriaId = ejercicioActualizado.getCategoriaEjercicioId();
            Categoria categoria = categoriaEjercicioService.searchCategoriaEjercicioById(categoriaId);
            if (categoria == null) {
                throw new UsuarioNotFoundException("La categoría de ejercicio proporcionada no existe");
            }
            ejercicioExistente.setCategoria(categoria);
        }

        validateUpdate(ejercicioExistente);

        return ejercicioRepository.save(ejercicioExistente);
    }
    @Override
    public void eliminarEjercicio(Long id) {
        ejercicioRepository.deleteById(id);
    }

    public void validateEjercicio(Ejercicio ejercicio) {
        if (ejercicio.getNombre() == null || ejercicio.getNombre().isEmpty()) {
            throw new CamposInvalidosException("El nombre del evento no puede estar vacío");
        }

        if (ejercicio.getDescripcion() == null || ejercicio.getDescripcion().isEmpty()) {
            throw new CamposInvalidosException("La descripción del evento no puede estar vacía");
        }

        if (ejercicio.getGrupoMuscular() == null || ejercicio.getGrupoMuscular().isEmpty()) {
            throw new CamposInvalidosException("El Grupo Muscular no puede estar vacío");
        }
    }
    @Override
    public void validateUpdate(Ejercicio ejercicio) {
        if (ejercicio.getNombre() != null && ejercicio.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del ejercicio no puede estar vacío");
        }
        if (ejercicio.getDescripcion() != null && ejercicio.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del ejercicio no puede estar vacía");
        }
        if (ejercicio.getGrupoMuscular() != null && ejercicio.getGrupoMuscular().isEmpty()) {
            throw new IllegalArgumentException("El Grupo Muscular del ejercicio no puede estar vacío");
        }
    }


}

