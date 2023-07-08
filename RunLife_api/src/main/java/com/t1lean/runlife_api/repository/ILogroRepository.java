package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Logro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILogroRepository extends JpaRepository<Logro, Long> {
    List<Logro> findByNombreContainingIgnoreCase(String nombre);
    boolean existsByKmRequeridos(double kmRequeridos);
    // Puedes agregar métodos de consulta personalizados si los necesitas
}
