package com.example.demo.Logic;

import com.example.demo.Model.DetalleVenta;
import com.example.demo.Repository.IDetalleVentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleVentaLogic {

    private IDetalleVentaRepository detalleVentaRepository;

    public DetalleVenta create(DetalleVenta data) {
        try {
            return this.detalleVentaRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el detalle de venta: " + ex.getMessage());
        }

        return null;
    }

    public List<DetalleVenta> getAll() {
        try {
            return this.detalleVentaRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo los detalles de ventas: " + ex.getMessage());
        }

        return null;
    }

    public DetalleVenta getById(Long id) {
        try {
            Optional<DetalleVenta> detalleVenta = this.detalleVentaRepository.findById(id);

            if (detalleVenta.isPresent())
                return detalleVenta.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el detalle de venta con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<DetalleVenta> detalleVenta = this.detalleVentaRepository.findById(id);

            if (detalleVenta.isPresent())
                this.detalleVentaRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el detalle de venta con id " + id + ": " + ex.getMessage());
        }
    }

    public DetalleVenta update(Long id, DetalleVenta data) {
        try {
            Optional<DetalleVenta> detalleVenta = this.detalleVentaRepository.findById(id);

            if (detalleVenta.isPresent()) {
                detalleVenta.get().setCantidad(data.getCantidad());
                detalleVenta.get().setPrecioUnitario(data.getPrecioUnitario());
                detalleVenta.get().setVenta(data.getVenta());

                return this.detalleVentaRepository.save(detalleVenta.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el detalle de venta con id " + id + ": " + ex.getMessage());
        }

        return null;
    }
}
