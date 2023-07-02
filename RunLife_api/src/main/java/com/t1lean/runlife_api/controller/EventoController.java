package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.model.Evento;
import com.t1lean.runlife_api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runlife")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping("/eventos/crearevento")
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        Evento nuevoEvento = eventoService.crearEvento(evento);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }

    @PutMapping("/eventos/actualizarevento/{id}")
    public ResponseEntity<Evento> actualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Evento eventoActualizado = eventoService.actualizarEvento(id, evento);
        return ResponseEntity.ok(eventoActualizado);
    }

    @GetMapping("/eventos/buscarevento/{id}")
    public ResponseEntity<Evento> buscarEventoPorId(@PathVariable Long id) {
        Evento evento = eventoService.buscarEventoPorId(id);
        return ResponseEntity.ok(evento);
    }

    @GetMapping("/eventos/buscarevento/nombre")
    public ResponseEntity<List<Evento>> searchEventosByNombre(@RequestParam("nombre") String nombre) {
        List<Evento> eventos = eventoService.searchEventosByNombre(nombre);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<Evento>> listarEventos() {
        List<Evento> eventos = eventoService.listarEventos();
        return ResponseEntity.ok(eventos);
    }
}
