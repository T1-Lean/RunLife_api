package com.t1lean.runlife_api.service.ServiceImpl;

        import com.t1lean.runlife_api.exception.InvalidPasswordException;
        import com.t1lean.runlife_api.exception.ResourceNotFoundException;
        import com.t1lean.runlife_api.exception.UsuarioNotFoundException;
        import com.t1lean.runlife_api.exception.ValidationException;
        import com.t1lean.runlife_api.model.Usuario;
        import com.t1lean.runlife_api.repository.IUsuarioRepository;
        import com.t1lean.runlife_api.service.UsuarioService;

        import jakarta.transaction.Transactional;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.*;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(IUsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + id));

        validateUpdate(usuarioActualizado, id);

        if (usuarioActualizado.getNombre() != null) {
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
        }

        if (usuarioActualizado.getEdad() != 0) {
            usuarioExistente.setEdad(usuarioActualizado.getEdad());
        }

        if (usuarioActualizado.getCorreo() != null) {
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        }

        if (usuarioActualizado.getAltura() != 0) {
            usuarioExistente.setAltura(usuarioActualizado.getAltura());
        }

        if (usuarioActualizado.getPeso() != 0) {
            usuarioExistente.setPeso(usuarioActualizado.getPeso());
        }

        if (usuarioActualizado.getPassword() != null) {
            usuarioExistente.setPassword(usuarioActualizado.getPassword());
        }

        if (usuarioActualizado.getUsername() != null) {
            usuarioExistente.setUsername(usuarioActualizado.getUsername());
        }

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public Usuario authenticate(String username, String password) throws InvalidPasswordException {
        Optional<Usuario> result = usuarioRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new UsuarioNotFoundException("El usuario no se ha encontrado");
        }

        Usuario usuario = result.get();
        if (Objects.equals(usuario.getPassword(), password)) {
            return usuario;
        }
        throw new InvalidPasswordException("La contraseña es incorrecta");
    }

    @Override
    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID proporcionado: " + id));
    }

    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> searchUsersByName(String nombre) {
        List<Usuario> usuarios = usuarioRepository.findByNombreContainingIgnoreCase(nombre);

        if (usuarios.isEmpty()) {
            throw new UsuarioNotFoundException("No se encontraron usuarios con el nombre proporcionado: " + nombre);
        }

        return usuarios;
    }

    @Override
    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        Optional<Usuario> existingUser = usuarioRepository.findByUsername(usuario.getUsername());
        if (existingUser.isPresent()) {
            throw new ValidationException("El nombre de usuario ya está en uso");
        } else {
            validateUsuario(usuario);

            usuario.setEstado("Activo");
            usuario.setDuracionTotal(0);
            usuario.setDistanciaTotal(0);
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario cambiarEstadoReportado(Long id) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("No se encontró un usuario con el ID proporcionado: " + id));

        usuarioExistente.setEstado("Reportado");

        return usuarioRepository.save(usuarioExistente);
    }

    private void validateUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new ValidationException("El nombre del usuario es obligatorio");
        }

        if (usuario.getNombre().length() > 30) {
            throw new ValidationException("El nombre del usuario no debe exceder los 30 caracteres");
        }
    }

    private void validateUpdate(Usuario usuarioActualizado, Long id) {

        if (usuarioActualizado.getUsername() != null) {
            Optional<Usuario> usuarioExistenteByUsername = usuarioRepository.findByUsername(usuarioActualizado.getUsername());
            if (usuarioExistenteByUsername.isPresent() && !usuarioExistenteByUsername.get().getId().equals(id)) {
                throw new ValidationException("El nombre de usuario ya está en uso");
            }
        }
    }
}
