package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Asistencia;
import org.springframework.stereotype.Service;

@Service
public interface AsistenciaService {
    Asistencia generarAsistencia(Long eventoId);
    void eliminarAsistencia(Long asistenciaId);
}
