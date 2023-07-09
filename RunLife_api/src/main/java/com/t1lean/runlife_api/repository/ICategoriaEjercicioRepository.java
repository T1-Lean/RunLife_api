package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriaEjercicioRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNombreContainingIgnoreCase(String nombre);
    boolean existsByNombreIgnoreCase(String nombre);


}
