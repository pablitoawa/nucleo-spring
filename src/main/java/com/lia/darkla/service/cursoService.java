package com.lia.darkla.service;

import com.lia.darkla.model.curso;
import com.lia.darkla.repository.cursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class cursoService {

    @Autowired
    private cursoRepository cursoRepository;

    public List<curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public curso save(curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    public curso update(Long id, curso cursoDetails) {
        Optional<curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            curso existingCurso = curso.get();
            existingCurso.setNombre(cursoDetails.getNombre());
            existingCurso.setDescripcion(cursoDetails.getDescripcion());
            existingCurso.setCreditos(cursoDetails.getCreditos());
            return cursoRepository.save(existingCurso);
        }
        return null;
    }
}