package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String materia;

    @Column
    @NonNull
    private double nota;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
}
