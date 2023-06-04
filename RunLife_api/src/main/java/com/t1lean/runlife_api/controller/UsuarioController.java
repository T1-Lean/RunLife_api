package com.t1lean.runlife_api.controller;

import com.t1lean.runlife_api.exception.ResourceNotFoundException;
import com.t1lean.runlife_api.exception.ValidationException;
import com.t1lean.runlife_api.model.Usuario;
import com.t1lean.runlife_api.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(IUsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + id));

        if (usuarioActualizado.getNombre() != null){
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
        }

        if (usuarioActualizado.getEdad() != 0){
            usuarioExistente.setEdad(usuarioActualizado.getEdad());
        }

        if (usuarioActualizado.getCorreo() != null){
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        }

        if (usuarioActualizado.getContraseña() != null){
            usuarioExistente.setContraseña(usuarioActualizado.getContraseña());
        }

        if (usuarioActualizado.getAltura() != 0){
            usuarioExistente.setAltura(usuarioActualizado.getAltura());
        }

        if (usuarioActualizado.getPeso() != 0){
            usuarioExistente.setPeso(usuarioActualizado.getPeso());
        }

        usuarioActualizado = usuarioRepository.save(usuarioExistente);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioActualizado);
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if(optionalUsuario.isPresent()){
            Usuario usuario = optionalUsuario.get();
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }
    private void validateEmployee(Usuario usuario){
        if(usuario.getNombre()==null || usuario.getNombre().trim().isEmpty()){
            throw new ValidationException("El nombre del empleado es obligatorio");
        }
        if(usuario.getNombre().length()>30){
            throw new ValidationException("El nombre del empleado no debe exceder los 30 caracteres");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
