package com.lia.darkla.repository;

import com.lia.darkla.model.aulas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface aulasRepository extends JpaRepository<aulas, Long> {
    Optional<aulas> findByNumeroAula(String numeroAula);
    List<aulas> findByCapacidadGreaterThanEqual(Integer capacidad);
}