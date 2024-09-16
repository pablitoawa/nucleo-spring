package com.lia.darkla.service;

import com.lia.darkla.model.docentes;
import com.lia.darkla.repository.docentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class docentesService {

    @Autowired
    private docentesRepository docentesRepository;

    public List<docentes> findAll() {
        return docentesRepository.findAll();
    }

    public Optional<docentes> findById(Long id) {
        return docentesRepository.findById(id);
    }

    public docentes save(docentes docente) {
        return docentesRepository.save(docente);
    }

    public void deleteById(Long id) {
        docentesRepository.deleteById(id);
    }

    public docentes update(Long id, docentes docenteDetails) {
        Optional<docentes> docente = docentesRepository.findById(id);
        if (docente.isPresent()) {
            docentes existingDocente = docente.get();
            existingDocente.setNombre(docenteDetails.getNombre());
            existingDocente.setApellido(docenteDetails.getApellido());
            existingDocente.setEmail(docenteDetails.getEmail());
            existingDocente.setEspecializacion(docenteDetails.getEspecializacion());
            return docentesRepository.save(existingDocente);
        }
        return null;
    }
}