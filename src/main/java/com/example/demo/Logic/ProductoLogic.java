package com.example.demo.Logic;

import com.example.demo.Model.Empleado;
import com.example.demo.Model.Producto;
import com.example.demo.Repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoLogic {

    @Autowired
    private IProductoRepository productoRepository;

    public Producto create(Producto data) {
        try {
            return this.productoRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el producto: " + ex.getMessage());
        }

        return null;
    }

    public List<Producto> getAll() {
        try {
            return this.productoRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los productos: " + ex.getMessage());
        }

        return null;
    }

    public Producto getById(Long id) {
        try {
            Optional<Producto> producto = this.productoRepository.findById(id);

            if (producto.isPresent())
                return producto.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el producto con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Producto> producto = this.productoRepository.findById(id);

            if (producto.isPresent())
                this.productoRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el producto con id " + id + ": " + ex.getMessage());
        }
    }

    public Producto update(Long id, Producto data) {
        try {
            Optional<Producto> producto = this.productoRepository.findById(id);

            if (producto.isPresent()) {
                producto.get().setNombre(data.getNombre());
                producto.get().setDescripcion(data.getDescripcion());
                producto.get().setStock(data.getStock());
                producto.get().setPrecio(data.getPrecio());
                producto.get().setProveedor(data.getProveedor());

                return this.productoRepository.save(producto.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el producto con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public List<Producto> getBySupplierId(Long idSupplier) {
        try {
            return this.productoRepository.findByProveedorId(idSupplier);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error los productos por proveedor: " + ex.getMessage());
        }

        return null;
    }
}
