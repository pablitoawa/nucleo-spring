package com.lia.darkla.service;

import com.lia.darkla.model.aulas;
import com.lia.darkla.repository.aulasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class aulasService {

    @Autowired
    private aulasRepository aulasRepository;

    public List<aulas> findAll() {
        return aulasRepository.findAll();
    }

    public Optional<aulas> findById(Long id) {
        return aulasRepository.findById(id);
    }

    public aulas save(aulas aula) {
        return aulasRepository.save(aula);
    }

    public void deleteById(Long id) {
        aulasRepository.deleteById(id);
    }

    public aulas update(Long id, aulas aulaDetails) {
        Optional<aulas> aula = aulasRepository.findById(id);
        if (aula.isPresent()) {
            aulas existingAula = aula.get();
            existingAula.setNumeroAula(aulaDetails.getNumeroAula());
            existingAula.setCapacidad(aulaDetails.getCapacidad());
            return aulasRepository.save(existingAula);
        }
        return null;
    }
}