package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String cargo;

    @Column
    @NonNull
    private String telefono;

    @OneToMany(mappedBy = "empleado")
    @JsonBackReference(value = "empleado-ventas")
    private List<Venta> ventas;
}
