package com.lia.darkla.controller;

import com.lia.darkla.model.aulas;
import com.lia.darkla.service.aulasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class aulasController {

    @Autowired
    private aulasService aulasService;

    @GetMapping
    public List<aulas> getAllAulas() {
        return aulasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<aulas> getAulaById(@PathVariable Long id) {
        return aulasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public aulas createAula(@RequestBody aulas aula) {
        return aulasService.save(aula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<aulas> updateAula(@PathVariable Long id, @RequestBody aulas aulaDetails) {
        aulas updatedAula = aulasService.update(id, aulaDetails);
        return updatedAula != null ? ResponseEntity.ok(updatedAula) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Long id) {
        aulasService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}