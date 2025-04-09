package com.example.demo.Logic;

import com.example.demo.Model.Empleado;
import com.example.demo.Repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoLogic {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    public Empleado create(Empleado data) {
        try {
            return this.empleadoRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el empleado: " + ex.getMessage());
        }

        return null;
    }

    public List<Empleado> getAll() {
        try {
            return this.empleadoRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los empleados: " + ex.getMessage());
        }

        return null;
    }

    public Empleado getById(Long id) {
        try {
            Optional<Empleado> empleado = this.empleadoRepository.findById(id);

            if (empleado.isPresent())
                return empleado.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el empleado con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Empleado> empleado = this.empleadoRepository.findById(id);

            if (empleado.isPresent())
                this.empleadoRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el empleado con id " + id + ": " + ex.getMessage());
        }
    }

    public Empleado update(Long id, Empleado data) {
        try {
            Optional<Empleado> empleado = this.empleadoRepository.findById(id);

            if (empleado.isPresent()) {
                empleado.get().setCargo(data.getCargo());
                empleado.get().setNombre(data.getNombre());
                empleado.get().setTelefono(data.getTelefono());

                return this.empleadoRepository.save(empleado.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el empleado con id " + id + ": " + ex.getMessage());
        }

        return null;
    }
}
