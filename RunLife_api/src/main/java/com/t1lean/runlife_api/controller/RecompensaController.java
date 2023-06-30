package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.model.Recompensa;
import com.t1lean.runlife_api.service.RecompensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runlife")
public class RecompensaController {
    private final RecompensaService recompensaService;

    @Autowired
    public RecompensaController(RecompensaService recompensaService) {
        this.recompensaService = recompensaService;
    }

    @GetMapping("/recompensas")
    public ResponseEntity<List<Recompensa>> getAllRecompensas() {
        List<Recompensa> recompensas = recompensaService.getAllRecompensas();
        return ResponseEntity.ok(recompensas);
    }

    @PostMapping("/recompensas/crearrecompensa")
    public ResponseEntity<Recompensa> crearRecompensa(@RequestBody Recompensa recompensa) {
        Recompensa nuevaRecompensa = recompensaService.crearRecompensa(recompensa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRecompensa);
    }

    @GetMapping("/recompensas/buscarrecompensa/{id}")
    public ResponseEntity<Recompensa> getRecompensaById(@PathVariable Long id) {
        Recompensa recompensa = recompensaService.getRecompensaById(id);
        if (recompensa != null) {
            return ResponseEntity.ok(recompensa);
        } else {
            throw new ResourceNotFoundException("Recompensa no encontrada con el ID: " + id);
        }
    }
    @GetMapping("/recompensas/buscarrecompensa/nombre")
    public ResponseEntity<List<Recompensa>> getRecompensaByNombre(@RequestParam("nombre") String nombre) {
        List<Recompensa> recompensas = recompensaService.getRecompensaByNombre(nombre);
        if (!recompensas.isEmpty()) {
            return ResponseEntity.ok(recompensas);
        } else {
            throw new ResourceNotFoundException("No se encontraron recompensas con el nombre: " + nombre);
        }
    }


    @PutMapping("/recompensas/actualizarrecompensa/{id}")
    public ResponseEntity<Recompensa> actualizarRecompensa(@PathVariable Long id, @RequestBody Recompensa recompensaActualizada) {
        Recompensa recompensaActualizadaResult = recompensaService.actualizarRecompensa(id, recompensaActualizada);
        return ResponseEntity.ok(recompensaActualizadaResult);
    }

    @DeleteMapping("/recompensas/eliminarrecompensa/{id}")
    public ResponseEntity<Void> eliminarRecompensa(@PathVariable Long id) {
        recompensaService.eliminarRecompensa(id);
        return ResponseEntity.noContent().build();
    }
}

