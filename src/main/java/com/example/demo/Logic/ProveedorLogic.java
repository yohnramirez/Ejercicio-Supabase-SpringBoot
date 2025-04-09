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

        }

        return null;
    }

    public List<Proveedor> getAll() {
        return this.proveedorRepository.findAll();
    }

    public Proveedor getById(Long id) {
        Optional<Proveedor> proveedor = this.proveedorRepository.findById(id);
        return proveedor.orElse(null);
    }

    public void delete(Long id) {
        Optional<Proveedor> proveedor = this.proveedorRepository.findById(id);

        if (proveedor.isEmpty()) return;

        this.proveedorRepository.deleteById(id);
    }

    public Proveedor update(Long id, Proveedor data) {
        Optional<Proveedor> proveedor = this.proveedorRepository.findById(id);

        if (proveedor.isPresent()) {
            proveedor.get().setNombre(data.getNombre());
            proveedor.get().setTelefono(data.getTelefono());
            proveedor.get().setCorreo(data.getCorreo());
            proveedor.get().setDireccion(data.getDireccion());
            proveedor.get().setProductos(data.getProductos());

            return this.proveedorRepository.save(proveedor.get());
        }

        return null;
    }
}
