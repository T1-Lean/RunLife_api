package com.t1lean.runlife_api.service.serviceImpl;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.exception.ValidationException;
import com.t1lean.runlife_api.model.Logro;
import com.t1lean.runlife_api.model.Recompensa;
import com.t1lean.runlife_api.repository.IRecompensaRepository;
import com.t1lean.runlife_api.repository.ILogroRepository;
import com.t1lean.runlife_api.service.LogroService; // Importa la interfaz correcta
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogroServiceImpl implements LogroService { // Implementa la interfaz correcta
    private final IRecompensaRepository recompensaRepository;
    private final ILogroRepository logroRepository;

    @Autowired
    public LogroServiceImpl(IRecompensaRepository recompensaRepository, ILogroRepository logroRepository) {
        this.recompensaRepository = recompensaRepository;
        this.logroRepository = logroRepository;
    }

    @Override
    public List<Logro> getAllLogros() {
        return logroRepository.findAll();
    }

    @Override
    public Logro getLogroById(Long id) {
        return logroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Logro no encontrado con el ID: " + id));
    }
    @Override
    public List<Logro> getLogroByNombre(String nombre) {
        List<Logro> logros = logroRepository.findByNombreContainingIgnoreCase(nombre);

        if (logros.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron logros con el nombre proporcionado: " + nombre);
        }

        return logros;
    }

    @Override
    @Transactional
    public Logro crearLogro(Logro logro) {
        validateLogro(logro);

        // Verificar si ya existe un logro con el mismo valor en km_requeridos
        if (logroRepository.existsByKmRequeridos(logro.getKmRequeridos())) {
            throw new ValidationException("Ya existe un logro con el mismo valor en km_requeridos");
        }

        return logroRepository.save(logro);
    }


    @Override
    public void eliminarLogro(Long id) {
        logroRepository.deleteById(id);
    }

    @Override
    public Logro actualizarLogro(Long id, Logro logroActualizado) {
        Logro logroExistente = logroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Logro no encontrado con el ID: " + id));

        logroExistente.setNombre(logroActualizado.getNombre());
        logroExistente.setDescripcion(logroActualizado.getDescripcion());
        logroExistente.setKmRequeridos(logroActualizado.getKmRequeridos());

        return logroRepository.save(logroExistente);
    }

    @Override
    public Logro asignarRecompensaALogro(Long logroId, Long recompensaId) {
        Logro logroExistente = logroRepository.findById(logroId)
                .orElseThrow(() -> new ResourceNotFoundException("Logro no encontrado con el ID: " + logroId));

        Recompensa recompensa = recompensaRepository.findById(recompensaId)
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa no encontrada con el ID: " + recompensaId));

        logroExistente.setRecompensa(recompensa);

        return logroRepository.save(logroExistente);
    }
    private void validateLogro(Logro logro) {
        if (logro.getNombre() == null || logro.getNombre().isEmpty()) {
            throw new ValidationException("El nombre del logro es obligatorio");
        }

        if (logro.getDescripcion() == null || logro.getDescripcion().length() < 20) {
            throw new ValidationException("La descripción del logro debe tener al menos 20 caracteres");
        }

        if (logro.getKmRequeridos() <= 0) {
            throw new ValidationException("Los kilómetros requeridos deben ser mayores que cero");
        }
    }

}


