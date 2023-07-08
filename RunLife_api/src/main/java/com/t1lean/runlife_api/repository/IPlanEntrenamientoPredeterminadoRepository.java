package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.PlanEntrenamientoPredeterminado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanEntrenamientoPredeterminadoRepository extends CrudRepository<PlanEntrenamientoPredeterminado, Long> {
}
