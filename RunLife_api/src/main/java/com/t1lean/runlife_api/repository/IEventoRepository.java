package com.t1lean.runlife_api.repository;

import com.t1lean.runlife_api.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Long> {
    Optional<Evento> findById(Long id);
    List<Evento> findByNombreContainingIgnoreCase(String nombre);

}
