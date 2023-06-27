package com.t1lean.runlife_api.service;

import com.t1lean.runlife_api.model.Usuario;
import java.util.*;

public interface UsuarioService {
    Usuario actualizarUsuario(Long id, Usuario usuarioActualizado);
    Usuario getUserById(Long id);
    List<Usuario> getAllUsers();
    List<Usuario> searchUsersByName(String nombre);
    Usuario crearUsuario(Usuario usuario);
    Usuario cambiarEstadoReportado(Long id);
}
