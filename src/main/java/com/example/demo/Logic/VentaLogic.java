package com.example.demo.Logic;

import com.example.demo.Model.Empleado;
import com.example.demo.Model.Venta;
import com.example.demo.Repository.IEmpleadoRepository;
import com.example.demo.Repository.IVentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaLogic {

    private IVentaRepository ventaRepository;

    public Venta create(Venta data) {
        return this.ventaRepository.save(data);
    }

    public List<Venta> getAll() {
        return this.ventaRepository.findAll();
    }

    public Venta getById(Long id) {
        Optional<Venta> venta = this.ventaRepository.findById(id);
        return venta.orElse(null);
    }

    public void delete(Long id) {
        Optional<Venta> venta = this.ventaRepository.findById(id);

        if (venta.isEmpty()) return;

        this.ventaRepository.deleteById(id);
    }
}
