package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Asistencia;

public interface AsistenciaService {
    Asistencia generarAsistencia(Long eventoId);
    void eliminarAsistencia(Long asistenciaId);
}
