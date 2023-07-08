package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlimentoRepository extends JpaRepository<Alimento, Long> {
}
