package com.lia.darkla.service;

import com.lia.darkla.model.estudiante;
import com.lia.darkla.model.aulas;
import com.lia.darkla.model.curso;
import com.lia.darkla.repository.estudianteRepository;
import com.lia.darkla.repository.aulasRepository;
import com.lia.darkla.repository.cursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class estudianteService {

    private final estudianteRepository estudianteRepository;
    private final cursoRepository cursoRepository;
    private final aulasRepository aulaRepository;

    @Autowired
    public estudianteService(estudianteRepository estudianteRepository, aulasRepository aulasRepository, cursoRepository cursoRepository) {
        this.estudianteRepository = estudianteRepository;
        this.aulaRepository = aulasRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional(readOnly = true)
    public List<estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    @Transactional
    public estudiante saveWithCursoAndAula(estudiante estudiante, String nombreCurso, String numeroAula) {
        curso curso = obtenerOCrearCurso(nombreCurso);
        aulas aula = obtenerOCrearAula(numeroAula);

        if (estudiante.getCursos() == null) {
            estudiante.setCursos(new ArrayList<>());
        }
        estudiante.getCursos().add(curso);
        estudiante.setAula(aula);
        return estudianteRepository.save(estudiante);
    }

    @Transactional
    public estudiante updateWithCursoAndAula(Long id, estudiante estudianteActualizado, String nombreCurso, String numeroAula) {
        return estudianteRepository.findById(id)
            .map(estudiante -> {
                estudiante.setNombre(estudianteActualizado.getNombre());
                estudiante.setApellido(estudianteActualizado.getApellido());
                estudiante.setEmail(estudianteActualizado.getEmail());
                estudiante.setFechaNacimiento(estudianteActualizado.getFechaNacimiento());

                curso curso = obtenerOCrearCurso(nombreCurso);
                aulas aula = obtenerOCrearAula(numeroAula);

                estudiante.getCursos().clear();
                estudiante.getCursos().add(curso);
                estudiante.setAula(aula);

                return estudianteRepository.save(estudiante);
            })
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    @Transactional
    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }

    private curso obtenerOCrearCurso(String nombreCurso) {
        return cursoRepository.findByNombreContaining(nombreCurso)
                .stream().findFirst()
                .orElseGet(() -> {
                    curso nuevoCurso = new curso(nombreCurso, "", 0);
                    return cursoRepository.save(nuevoCurso);
                });
    }

    private aulas obtenerOCrearAula(String numeroAula) {
        return aulaRepository.findByNumeroAula(numeroAula)
                .orElseGet(() -> {
                    aulas nuevaAula = new aulas(numeroAula, 0);
                    return aulaRepository.save(nuevaAula);
                });
    }
}