package com.lia.darkla.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "docentes")
public class docentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true)
    private String email;

    private String especializacion;

    @OneToMany(mappedBy = "docente")
    private List<curso> cursos;

    // Constructores
    public docentes() {}

    public docentes(String nombre, String apellido, String email, String especializacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.especializacion = especializacion;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public List<curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<curso> cursos) {
        this.cursos = cursos;
    }
}