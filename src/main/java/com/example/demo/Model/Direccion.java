package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String calle;

    @Column(nullable = true)
    private String carrera;

    @Column
    @NonNull
    private String ciudad;

    @NonNull
    @OneToOne(mappedBy = "direccion")
    private Estudiante estudiante;
}
