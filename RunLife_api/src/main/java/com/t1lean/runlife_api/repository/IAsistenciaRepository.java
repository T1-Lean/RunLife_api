package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsistenciaRepository extends JpaRepository<Asistencia, Long> {
}
