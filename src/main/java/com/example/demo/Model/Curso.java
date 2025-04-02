package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String descripcion;

    @NonNull
    @ManyToMany(mappedBy = "cursos")
    private Set<Estudiante> estudiantes;

    @Column
    @NonNull
    private boolean estado;

    @Column
    @NonNull
    @CreationTimestamp
    private LocalDateTime fechaCreacion;
}
