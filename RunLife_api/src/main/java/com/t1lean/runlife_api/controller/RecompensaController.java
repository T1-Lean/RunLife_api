package com.t1lean.runlife_api.controller;
import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.exception.ValidationException;
import com.t1lean.runlife_api.model.Recompensa;
import com.t1lean.runlife_api.repository.IRecompensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/recompensas")
public class RecompensaController {
    private final IRecompensaRepository recompensaRepository;
    @GetMapping
    public ResponseEntity<List<Recompensa>> listarRecompensas() {
        List<Recompensa> recompensas = recompensaRepository.findAll();
        return ResponseEntity.ok(recompensas);
    }

    @Autowired
    public RecompensaController(IRecompensaRepository recompensaRepository) {
        this.recompensaRepository = recompensaRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Recompensa> crearRecompensa(@RequestBody Recompensa recompensa) {
        Recompensa nuevaRecompensa = recompensaRepository.save(recompensa);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRecompensa);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Recompensa> editarRecompensa(@PathVariable Long id, @RequestBody Recompensa recompensaActualizada) {
        Recompensa recompensaExistente = recompensaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa no encontrada con el ID: " + id));

        recompensaExistente.setNombre(recompensaActualizada.getNombre());
        recompensaExistente.setDescripcion(recompensaActualizada.getDescripcion());
        recompensaExistente.setKmRequeridos(recompensaActualizada.getKmRequeridos());

        Recompensa recompensaActualizadaResult = recompensaRepository.save(recompensaExistente);
        return ResponseEntity.status(HttpStatus.OK).body(recompensaActualizadaResult);
    }
}


