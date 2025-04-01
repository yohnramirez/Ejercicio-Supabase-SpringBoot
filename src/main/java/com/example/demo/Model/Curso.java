package com.example.demo.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @ManyToMany(mappedBy = "cursos")
    private Set<Estudiante> estudiantes;

    @Column
    private boolean estado;

    @Column
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    public Curso() {
    }

    public Curso(Long id, String nombre, String descripcion, Set<Estudiante> estudiantes, boolean estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estudiantes = estudiantes;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

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

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
