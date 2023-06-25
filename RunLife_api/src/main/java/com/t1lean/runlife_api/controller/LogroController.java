package com.t1lean.runlife_api.controller;
import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.exception.ValidationException;
import com.t1lean.runlife_api.model.Logro;
import com.t1lean.runlife_api.model.Recompensa;
import com.t1lean.runlife_api.repository.ILogroRepository;
import com.t1lean.runlife_api.repository.IRecompensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/logros")
public class LogroController {
    private final ILogroRepository logroRepository;
    private final IRecompensaRepository recompensaRepository;

    @Autowired
    public LogroController(ILogroRepository logroRepository, IRecompensaRepository recompensaRepository) {
        this.logroRepository = logroRepository;
        this.recompensaRepository = recompensaRepository;
    }


    @GetMapping
    public ResponseEntity<List<Logro>> getAllLogros() {
        List<Logro> logros = logroRepository.findAll();
        return ResponseEntity.ok(logros);
    }

    @PostMapping
    public ResponseEntity<Logro> createLogro(@RequestBody Logro logro) {
        Logro nuevoLogro = logroRepository.save(logro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLogro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Logro> getLogroById(@PathVariable Long id) {
        Optional<Logro> optionalLogro = logroRepository.findById(id);

        if (optionalLogro.isPresent()) {
            Logro logro = optionalLogro.get();
            return ResponseEntity.ok(logro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Logro> updateLogro(@PathVariable Long id, @RequestBody Logro logroActualizado) {
        Logro logroExistente = logroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Logro no encontrado con el ID: " + id));

        logroExistente.setNombre(logroActualizado.getNombre());
        logroExistente.setDescripcion(logroActualizado.getDescripcion());

        Logro logroActualizadoResult = logroRepository.save(logroExistente);
        return ResponseEntity.status(HttpStatus.OK).body(logroActualizadoResult);
    }
    @PutMapping("/{logroId}/asignar-recompensa/{recompensaId}")
    public ResponseEntity<Logro> asignarRecompensaALogro(
            @PathVariable Long logroId, @PathVariable Long recompensaId) {
        Logro logroExistente = logroRepository.findById(logroId)
                .orElseThrow(() -> new ResourceNotFoundException("Logro no encontrado con el ID: " + logroId));

        Recompensa recompensa = recompensaRepository.findById(recompensaId)
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa no encontrada con el ID: " + recompensaId));

        logroExistente.setRecompensa(recompensa);

        Logro logroActualizado = logroRepository.save(logroExistente);
        return ResponseEntity.status(HttpStatus.OK).body(logroActualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogro(@PathVariable Long id) {
        logroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

