package com.lia.darkla.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "aulas")
public class aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroAula;

    private Integer capacidad;

    @OneToOne(mappedBy = "aula")
    private curso curso;

    @OneToMany(mappedBy = "aula")
    private List<estudiante> estudiantes;

    // Constructores
    public aulas() {}

    public aulas(String numeroAula, Integer capacidad) {
        this.numeroAula = numeroAula;
        this.capacidad = capacidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(String numeroAula) {
        this.numeroAula = numeroAula;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public curso getCurso() {
        return curso;
    }

    public void setCurso(curso curso) {
        this.curso = curso;
    }

    
}