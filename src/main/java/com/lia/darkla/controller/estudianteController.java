package com.lia.darkla.controller;

import com.lia.darkla.model.estudiante;
import com.lia.darkla.service.estudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/estudiantes")
public class estudianteController {

    private final estudianteService estudianteService;
    private static final Logger logger = LoggerFactory.getLogger(estudianteController.class);

    @Autowired
    public estudianteController(estudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.findAll());
        return "estudiantes";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute estudiante estudiante, 
                                    @RequestParam String nombreCurso, 
                                    @RequestParam String numeroAula) {
        logger.info("Recibida solicitud POST para guardar estudiante: {}", estudiante);
        estudianteService.saveWithCursoAndAula(estudiante, nombreCurso, numeroAula);
        return "redirect:/estudiantes";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarEstudiante(@PathVariable Long id, 
                                       @ModelAttribute estudiante estudiante,
                                       @RequestParam String nombreCurso, 
                                       @RequestParam String numeroAula) {
        logger.info("Recibida solicitud POST para actualizar estudiante con ID: {}", id);
        estudianteService.updateWithCursoAndAula(id, estudiante, nombreCurso, numeroAula);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        logger.info("Recibida solicitud GET para eliminar estudiante con ID: {}", id);
        estudianteService.deleteById(id);
        return "redirect:/estudiantes";
    }
}