package com.t1lean.runlife_api.service.ServiceImpl;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.model.Asistencia;
import com.t1lean.runlife_api.model.Evento;
import com.t1lean.runlife_api.repository.IAsistenciaRepository;
import com.t1lean.runlife_api.repository.IEventoRepository;
import com.t1lean.runlife_api.service.AsistenciaService;
import com.t1lean.runlife_api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    private final IAsistenciaRepository asistenciaRepository;

    private final IEventoRepository eventoRepository;
    private final EventoService eventoService;

    @Autowired
    public AsistenciaServiceImpl(IAsistenciaRepository asistenciaRepository, IEventoRepository eventoRepository, EventoService eventoService) {
        this.asistenciaRepository = asistenciaRepository;
        this.eventoRepository = eventoRepository;
        this.eventoService = eventoService;
    }

    @Override
    public Asistencia generarAsistencia(Long eventoId) {
        Evento evento = eventoService.buscarEventoPorId(eventoId);
        if (evento == null) {
            throw new ResourceNotFoundException("Evento no encontrado con el ID: " + eventoId);
        }

        Asistencia asistencia = new Asistencia();
        asistencia.setEvento(evento);

        LocalDateTime fechaAsistencia = LocalDateTime.now();
        asistencia.setFechaAsistencia(fechaAsistencia);

        evento.setParticipantes(evento.getParticipantes() + 1);

        eventoRepository.save(evento);
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public void eliminarAsistencia(Long asistenciaId) {
        Asistencia asistencia = asistenciaRepository.findById(asistenciaId)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con el ID: " + asistenciaId));

        Evento evento = asistencia.getEvento();

        evento.setParticipantes(evento.getParticipantes() - 1);

        asistenciaRepository.deleteById(asistenciaId);
        eventoRepository.save(evento);
    }

}