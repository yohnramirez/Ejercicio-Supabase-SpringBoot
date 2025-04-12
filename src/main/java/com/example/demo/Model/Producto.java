package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String descripcion;

    @Column
    @NonNull
    private double precio;

    @Column
    @NonNull
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    @JsonBackReference
    private Proveedor proveedor;
}
