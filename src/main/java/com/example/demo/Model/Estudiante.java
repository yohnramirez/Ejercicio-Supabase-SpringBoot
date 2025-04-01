package com.example.demo.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column
    private String nombre;

    @Column
    private String telefono;

    @OneToMany(
            mappedBy = "estudiante",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Calificacion> calificaciones;

    @ManyToMany()
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    public Estudiante() {
    }

    public Estudiante(long codigo, String nombre, String telefono, List<Calificacion> calificaciones, Set<Curso> cursos, Direccion direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.calificaciones = calificaciones;
        this.cursos = cursos;
        this.direccion = direccion;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
