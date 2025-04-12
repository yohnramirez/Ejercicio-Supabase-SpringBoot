package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String nombre;

    @Column
    @NonNull
    private String telefono;

    @Column
    @NonNull
    private String correo;

    @Column
    @NonNull
    private String direccion;

    @JsonManagedReference
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
}
