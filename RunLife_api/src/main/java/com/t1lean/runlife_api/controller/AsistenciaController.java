package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.model.Asistencia;
import com.t1lean.runlife_api.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runlife")
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    @Autowired
    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @PostMapping("/asistencias/{eventoId}/generarasistencia")
    public ResponseEntity<Asistencia> generarAsistencia(@PathVariable Long eventoId) {
        Asistencia nuevaAsistencia = asistenciaService.generarAsistencia(eventoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAsistencia);
    }

    @DeleteMapping("/asistencias/eliminarasistencia/{asistenciaId}")
    public ResponseEntity<String> eliminarAsistencia(@PathVariable Long asistenciaId) {
        asistenciaService.eliminarAsistencia(asistenciaId);
        return ResponseEntity.ok("Asistencia eliminada correctamente");
    }
}
