package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.CategoriaEjercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaEjercicioRepository extends JpaRepository<CategoriaEjercicio, Integer> {

}
