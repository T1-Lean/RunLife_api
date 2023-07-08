package com.t1lean.runlife_api.service.ServiceImpl;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.exception.UsuarioNotFoundException;
import com.t1lean.runlife_api.model.Evento;
import com.t1lean.runlife_api.repository.IEventoRepository;
import com.t1lean.runlife_api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    private final IEventoRepository eventoRepository;

    @Autowired
    public EventoServiceImpl(IEventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento crearEvento(Evento evento) {
        evento.setParticipantes(0);
        validateEvento(evento);
        return eventoRepository.save(evento);
    }

    @Override
    public Evento actualizarEvento(Long id, Evento eventoActualizado) {
        Evento eventoExistente = eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con el ID: " + id));

        if (eventoActualizado.getNombre() != null) {
            eventoExistente.setNombre(eventoActualizado.getNombre());
        }

        if (eventoActualizado.getDescripcion() != null) {
            eventoExistente.setDescripcion(eventoActualizado.getDescripcion());
        }

        if (eventoActualizado.getFecha() != null) {
            eventoExistente.setFecha(eventoActualizado.getFecha());
        }

        validateUpdate(eventoExistente);

        return eventoRepository.save(eventoExistente);
    }

    @Override
    public Evento buscarEventoPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con el ID: " + id));
    }

    @Override
    public List<Evento> searchEventosByNombre(String nombre) {
        List<Evento> eventos = eventoRepository.findByNombreContainingIgnoreCase(nombre);

        if (eventos.isEmpty()) {
            throw new UsuarioNotFoundException("No se encontraron eventos con el nombre proporcionado: " + nombre);
        }

        return eventos;
    }

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    private void validateEvento(Evento evento) {
        if (evento.getNombre() == null || evento.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento no puede estar vacío");
        }

        if (evento.getDescripcion() == null || evento.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción del evento no puede estar vacía");
        }

        if (evento.getFecha() == null) {
            throw new IllegalArgumentException("La fecha del evento no puede ser nula");
        }
    }
    private void validateUpdate(Evento eventoActualizado) {
        if (eventoActualizado.getNombre() == null || eventoActualizado.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento no puede estar vacío");
        }

        if (eventoActualizado.getDescripcion() == null || eventoActualizado.getDescripcion().isEmpty()) {
            throw new IllegalArgumentException("La descripción del evento no puede estar vacía");
        }
    }

}
