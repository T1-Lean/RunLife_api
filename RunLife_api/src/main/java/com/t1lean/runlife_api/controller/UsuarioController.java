package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.controller.dto.SimpleUserDTO;
import com.t1lean.runlife_api.exception.InvalidPasswordException;
import com.t1lean.runlife_api.exception.UsuarioNotFoundException;
import com.t1lean.runlife_api.model.Usuario;
import com.t1lean.runlife_api.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.t1lean.runlife_api.controller.dto.LoginRequest;

import java.util.List;

@RestController
@RequestMapping("/runlife")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Transactional
    @PutMapping("/actualizarusuario/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuario = usuarioService.actualizarUsuario(id, usuarioActualizado);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping("/usuarios/buscarusuario/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/usuarios/buscarusuario/nombre")
    public ResponseEntity<List<Usuario>> searchUsersByName(@RequestParam("nombre") String nombre) {
        List<Usuario> usuarios = usuarioService.searchUsersByName(nombre);
        return ResponseEntity.ok(usuarios);
    }

    @Transactional
    @PostMapping("/usuarios/crearusuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PutMapping("/uruarios/reportarusuario/{id}")
    public ResponseEntity<Usuario> cambiarEstadoReportado(@PathVariable Long id) {
        Usuario usuario = usuarioService.cambiarEstadoReportado(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<SimpleUserDTO> login(@RequestBody LoginRequest loginRequest) throws InvalidPasswordException, UsuarioNotFoundException {
        Usuario usuario = usuarioService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (usuario == null) {
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }
        SimpleUserDTO simpleUserDTO = new SimpleUserDTO(usuario.getNombre(), usuario.getUsername());
        return ResponseEntity.ok(simpleUserDTO);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<String> handleUsuarioNotFoundException(UsuarioNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<String> handleInvalidPasswordException(InvalidPasswordException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}