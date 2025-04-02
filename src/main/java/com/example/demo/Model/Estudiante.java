package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String telefono;

    @NonNull
    @OneToMany(
            mappedBy = "estudiante",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Calificacion> calificaciones;

    @NonNull
    @ManyToMany()
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;
}
