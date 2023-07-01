package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Evento;

import java.util.List;

public interface EventoService {
    Evento crearEvento(Evento evento);
    Evento actualizarEvento(Long id, Evento evento);
    Evento buscarEventoPorId(Long id);
    List<Evento> searchEventosByNombre(String nombre);
    List<Evento> listarEventos();
}
