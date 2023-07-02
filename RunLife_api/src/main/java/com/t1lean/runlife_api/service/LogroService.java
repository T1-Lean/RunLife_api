package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Logro;
import java.util.List;

public interface LogroService {
    Logro actualizarLogro(Long id, Logro logroActualizado);
    Logro getLogroById(Long id);
    List<Logro> getLogroByNombre(String nombre);
    List<Logro> getAllLogros();
    Logro crearLogro(Logro logro);
    void eliminarLogro(Long id);
    Logro asignarRecompensaALogro(Long logroId, Long recompensaId);
}
