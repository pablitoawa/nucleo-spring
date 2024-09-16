package com.lia.darkla.controller;

import com.lia.darkla.model.docentes;
import com.lia.darkla.service.docentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocentesController {

    @Autowired
    private docentesService docentesService;

    @GetMapping
    public List<docentes> getAllDocentes() {
        return docentesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<docentes> getDocenteById(@PathVariable Long id) {
        return docentesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public docentes createDocente(@RequestBody docentes docente) {
        return docentesService.save(docente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<docentes> updateDocente(@PathVariable Long id, @RequestBody docentes docenteDetails) {
        docentes updatedDocente = docentesService.update(id, docenteDetails);
        return updatedDocente != null ? ResponseEntity.ok(updatedDocente) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable Long id) {
        docentesService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}