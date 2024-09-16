package com.lia.darkla.repository;

import com.lia.darkla.model.docentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface docentesRepository extends JpaRepository<docentes, Long> {
    List<docentes> findByApellidoContaining(String apellido);
    Optional<docentes> findByEmail(String email);
    List<docentes> findByEspecializacion(String especializacion);
}