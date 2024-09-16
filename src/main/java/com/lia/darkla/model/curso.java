package com.lia.darkla.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")

public class curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private docentes docente;

    @ManyToMany(mappedBy = "cursos")
    private List<estudiante> estudiantes;

    @OneToOne
    @JoinColumn(name = "aula_id")
    private aulas aula;

    // Constructores
    public curso() {}

    public curso(String nombre, String descripcion, Integer creditos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public docentes getDocente() {
        return docente;
    }

    public void setDocente(docentes docente) {
        this.docente = docente;
    }

    public List<estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public aulas getAula() {
        return aula;
    }

    public void setAula(aulas aula) {
        this.aula = aula;
    }
}