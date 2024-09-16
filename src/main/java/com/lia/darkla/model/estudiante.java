package com.lia.darkla.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
        name = "matriculas",
        joinColumns = @JoinColumn(name = "estudiante_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<curso> cursos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private aulas aula;

    // Constructores
    public estudiante() {}

    public estudiante(String nombre, String apellido, Date fechaNacimiento, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<curso> cursos) {
        this.cursos = cursos;
    }

    public aulas getAula() {
        return aula;
    }

    public void setAula(aulas aula) {
        this.aula = aula;
    }
}