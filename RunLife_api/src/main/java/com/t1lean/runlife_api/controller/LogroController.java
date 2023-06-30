package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.model.Logro;
import com.t1lean.runlife_api.service.LogroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;
@RestController
@RequestMapping("/runlife")
public class LogroController {
    private final LogroService logroService;

    @Autowired
    public LogroController(LogroService logroService) {
        this.logroService = logroService;
    }

    @GetMapping("/logros")
    public ResponseEntity<List<Logro>> getAllLogros() {
        List<Logro> logros = logroService.getAllLogros();
        return ResponseEntity.ok(logros);
    }

    @PostMapping("/logros/crearlogro")
    public ResponseEntity<Logro> crearLogro(@RequestBody Logro logro) {
        Logro nuevoLogro = logroService.crearLogro(logro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLogro);
    }

    @GetMapping("/logros/buscarlogro/{id}")
    public ResponseEntity<Logro> getLogroById(@PathVariable Long id) {
        Logro logro = logroService.getLogroById(id);
        if (logro != null) {
            return ResponseEntity.ok(logro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/logros/buscarlogro/nombre")
    public ResponseEntity<List<Logro>> getLogroByNombre(@RequestParam("nombre") String nombre) {
        List<Logro> logros = logroService.getLogroByNombre(nombre);
        if (!logros.isEmpty()) {
            return ResponseEntity.ok(logros);
        } else {
            throw new ResourceNotFoundException("No se encontraron logros con el nombre: " + nombre);
        }
    }

    @PutMapping("/logros/actualizarlogro/{id}")
    public ResponseEntity<Logro> actualizarLogro(@PathVariable Long id, @RequestBody Logro logroActualizado) {
        Logro logroActualizadoResult = logroService.actualizarLogro(id, logroActualizado);
        return ResponseEntity.status(HttpStatus.OK).body(logroActualizadoResult);
    }

    @PutMapping("/logros/{logroId}/asignarrecompensa/{recompensaId}")
    public ResponseEntity<Logro> asignarRecompensaALogro(
            @PathVariable Long logroId, @PathVariable Long recompensaId) {
        Logro logroActualizado = logroService.asignarRecompensaALogro(logroId, recompensaId);
        return ResponseEntity.status(HttpStatus.OK).body(logroActualizado);
    }

    @DeleteMapping("/logros/eliminarlogro/{id}")
    public ResponseEntity<Void> eliminarLogro(@PathVariable Long id) {
        logroService.eliminarLogro(id);
        return ResponseEntity.noContent().build();
    }
}


