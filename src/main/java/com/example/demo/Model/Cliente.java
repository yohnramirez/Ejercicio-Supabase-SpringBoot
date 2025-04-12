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
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String cedula;

    @Column
    @NonNull
    private String telefono;

    @Column
    @NonNull
    private String correo;

    @OneToMany(mappedBy = "cliente")
    @JsonBackReference(value = "cliente-ventas")
    private List<Venta> ventas;
}
