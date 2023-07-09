package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.DiaEntrenamiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaEntrenamientoRepository extends CrudRepository<DiaEntrenamiento, Long> {
}
