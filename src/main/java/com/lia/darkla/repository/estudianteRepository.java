package com.lia.darkla.repository;

import com.lia.darkla.model.estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface estudianteRepository extends JpaRepository<estudiante, Long> {
    List<estudiante> findByApellidoContaining(String apellido);
    Optional<estudiante> findByEmail(String email);
    List<estudiante> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFin);
    List<estudiante> findByNombreContainingIgnoreCase(String nombre);
}