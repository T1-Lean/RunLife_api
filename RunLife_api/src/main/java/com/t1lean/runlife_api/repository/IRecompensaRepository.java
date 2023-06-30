package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface IRecompensaRepository extends JpaRepository<Recompensa, Long> {
    List<Recompensa> findByNombreContainingIgnoreCase(String nombre);
    boolean existsByDescripcion(String descripcion);
    // Puedes agregar métodos de consulta personalizados si los necesitas
}
