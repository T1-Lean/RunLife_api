package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEjercicioRepository extends JpaRepository<Ejercicio, Long> {
    List<Ejercicio> findByNombreContainingIgnoreCase(String nombre);
    boolean existsByNombreIgnoreCase(String nombre);
    boolean existsByDescripcionIgnoreCase(String descripcion);
}
