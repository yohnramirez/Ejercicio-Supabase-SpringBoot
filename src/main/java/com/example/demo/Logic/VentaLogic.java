package com.example.demo.Logic;

import com.example.demo.Model.Empleado;
import com.example.demo.Model.Venta;
import com.example.demo.Repository.IEmpleadoRepository;
import com.example.demo.Repository.IVentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaLogic {

    @Autowired
    private IVentaRepository ventaRepository;

    public Venta create(Venta data) {
        try {
            return this.ventaRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando la venta: " + ex.getMessage());
        }

        return null;
    }

    public List<Venta> getAll() {
        try {
            return this.ventaRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo las ventas: " + ex.getMessage());
        }

        return null;
    }

    public Venta getById(Long id) {
        try {
            Optional<Venta> venta = this.ventaRepository.findById(id);

            if (venta.isPresent())
                return venta.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo la venta con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Venta> venta = this.ventaRepository.findById(id);

            if (venta.isPresent())
                this.ventaRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando la venta con id " + id + ": " + ex.getMessage());
        }
    }

    public List<Venta> getByCustomerId(Long idCustomer) {
        try {
            return this.ventaRepository.findByClienteId(idCustomer);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo las ventas por cliente: " + ex.getMessage());
        }

        return null;
    }

    public List<Venta> getByEmployeeId(Long idEmployee) {
        try {
            return this.ventaRepository.findByEmpleadoId(idEmployee);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo las ventas por empleado: " + ex.getMessage());
        }

        return null;
    }
}
