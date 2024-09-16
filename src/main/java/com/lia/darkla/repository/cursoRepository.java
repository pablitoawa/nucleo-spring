package com.lia.darkla.repository;

import com.lia.darkla.model.curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface cursoRepository extends JpaRepository<curso, Long> {
    List<curso> findByNombreContaining(String nombre);
    List<curso> findByCreditos(Integer creditos);
}