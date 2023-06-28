package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aquí puedes agregar métodos de consulta personalizados si los necesitas
        List<Usuario> findByNombreContainingIgnoreCase(String nombre);
        Optional<Usuario> findByUsername(String username);
}
