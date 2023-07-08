package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.CategoriaEjercicio;
import com.t1lean.runlife_api.model.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
    boolean existsByNombre(String nombre);
}