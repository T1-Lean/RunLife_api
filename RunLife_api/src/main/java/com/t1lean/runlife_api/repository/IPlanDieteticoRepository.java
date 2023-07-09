package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.PlanDietetico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanDieteticoRepository extends CrudRepository<PlanDietetico, Long> {
}
