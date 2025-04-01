package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String calle;

    @Column(nullable = true)
    private String carrera;

    @Column
    private String ciudad;

    @OneToOne(mappedBy = "direccion")
    private Estudiante estudiante;

    public Direccion() {
    }

    public Direccion(Long id, String calle, String carrera, String ciudad, Estudiante estudiante) {
        this.id = id;
        this.calle = calle;
        this.carrera = carrera;
        this.ciudad = ciudad;
        this.estudiante = estudiante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
