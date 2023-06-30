package com.t1lean.runlife_api.service.serviceImpl;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.exception.ValidationException;
import com.t1lean.runlife_api.model.Recompensa;
import com.t1lean.runlife_api.repository.IRecompensaRepository;
import com.t1lean.runlife_api.service.RecompensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecompensaServiceImpl implements RecompensaService {
    private final IRecompensaRepository recompensaRepository;

    @Autowired
    public RecompensaServiceImpl(IRecompensaRepository recompensaRepository) {
        this.recompensaRepository = recompensaRepository;
    }

    @Override
    public List<Recompensa> getAllRecompensas() {
        return recompensaRepository.findAll();
    }

    @Override
    public Recompensa getRecompensaById(Long id) {
        Optional<Recompensa> optionalRecompensa = recompensaRepository.findById(id);
        return optionalRecompensa.orElse(null);
    }
    @Override
    public List<Recompensa> getRecompensaByNombre(String nombre) {
        List<Recompensa> recompensas = recompensaRepository.findByNombreContainingIgnoreCase(nombre);

        if (recompensas.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron usuarios con el nombre proporcionado: " + nombre);
        }

        return recompensas;
    }

    @Override
    public Recompensa crearRecompensa(Recompensa recompensa) {
        validateRecompensa(recompensa);
        if (recompensaRepository.existsByDescripcion(recompensa.getDescripcion())) {
            throw new ValidationException("Ya existe una recompensa con esta descripcion");
        }
        return recompensaRepository.save(recompensa);
    }

    @Override
    public Recompensa actualizarRecompensa(Long id, Recompensa recompensaActualizada) {
        Recompensa recompensaExistente = recompensaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa no encontrada con el ID: " + id));

        recompensaExistente.setNombre(recompensaActualizada.getNombre());
        recompensaExistente.setDescripcion(recompensaActualizada.getDescripcion());

        return recompensaRepository.save(recompensaExistente);
    }

    @Override
    public void eliminarRecompensa(Long id) {
        recompensaRepository.deleteById(id);
    }
    private void validateRecompensa(Recompensa recompensa) {
        if (recompensa.getNombre() == null || recompensa.getNombre().isEmpty()) {
            throw new ValidationException("El nombre de la recompensa es obligatorio");
        }

        if (recompensa.getDescripcion() == null || recompensa.getDescripcion().length() < 5) {
            throw new ValidationException("La descripción del logro debe tener al menos 5 caracteres");
        }
    }
}
