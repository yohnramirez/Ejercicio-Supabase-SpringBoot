package com.example.demo.Logic;

import com.example.demo.Model.Proveedor;
import com.example.demo.Repository.IProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProveedorLogic {

    private IProveedorRepository proveedorRepository;

    public Proveedor create(Proveedor data) {
        try {
            return this.proveedorRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el proveedor: " + ex.getMessage());
        }

        return null;
    }

    public List<Proveedor> getAll() {
        try {
            return this.proveedorRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los proveedores: " + ex.getMessage());
        }

        return null;
    }

    public Proveedor getById(Long id) {
        try {
            Optional<Proveedor> proveedor = this.proveedorRepository.findById(id);

            if (proveedor.isPresent())
                return proveedor.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el proveedor con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Proveedor> proveedor = this.proveedorRepository.findById(id);

            if (proveedor.isPresent())
                this.proveedorRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el proveedor con id " + id + ": " + ex.getMessage());
        }
    }

    public Proveedor update(Long id, Proveedor data) {
        try {
            Optional<Proveedor> proveedor = this.proveedorRepository.findById(id);

            if (proveedor.isPresent()) {
                proveedor.get().setNombre(data.getNombre());
                proveedor.get().setTelefono(data.getTelefono());
                proveedor.get().setCorreo(data.getCorreo());
                proveedor.get().setDireccion(data.getDireccion());
                proveedor.get().setProductos(data.getProductos());

                return this.proveedorRepository.save(proveedor.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el proveedor con id " + id + ": " + ex.getMessage());
        }

        return null;
    }
}
