package com.t1lean.runlife_api.repository;
import com.t1lean.runlife_api.model.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRecompensaRepository extends JpaRepository<Recompensa, Long> {
    // Otros métodos personalizados si los necesitas
}