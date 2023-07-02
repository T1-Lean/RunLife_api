package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Recompensa;

import java.util.List;

public interface RecompensaService {
    List<Recompensa> getAllRecompensas();
    Recompensa getRecompensaById(Long id);
    List<Recompensa> getRecompensaByNombre(String nombre);
    Recompensa crearRecompensa(Recompensa recompensa);
    Recompensa actualizarRecompensa(Long id, Recompensa recompensaActualizada);
    void eliminarRecompensa(Long id);
}

