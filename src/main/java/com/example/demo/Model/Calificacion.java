package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String materia;

    @Column
    private double nota;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    public Calificacion() {
    }

    public Calificacion(Long id, String materia, double nota, Estudiante estudiante) {
        this.id = id;
        this.materia = materia;
        this.nota = nota;
        this.estudiante = estudiante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
