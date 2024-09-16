package com.lia.darkla.controller;

import com.lia.darkla.model.curso;
import com.lia.darkla.service.cursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class cursoController {

    @Autowired
    private cursoService cursoService;

    @GetMapping
    public List<curso> getAllCursos() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<curso> getCursoById(@PathVariable Long id) {
        return cursoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public curso createCurso(@RequestBody curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<curso> updateCurso(@PathVariable Long id, @RequestBody curso cursoDetails) {
        curso updatedCurso = cursoService.update(id, cursoDetails);
        return updatedCurso != null ? ResponseEntity.ok(updatedCurso) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id) {
        cursoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}