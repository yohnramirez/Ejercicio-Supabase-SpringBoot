package com.example.demo.Controller;

import com.example.demo.Logic.VentaLogic;
import com.example.demo.Model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta/")
public class VentaController {

    @Autowired
    private VentaLogic ventaLogic;

    @PostMapping
    public Venta create(Venta data) {
        return this.ventaLogic.create(data);
    }

    @GetMapping
    public List<Venta> getAll() {
        return this.ventaLogic.getAll();
    }

    @GetMapping("/{id}")
    public Venta getOne(@PathVariable Long id) {
        return this.ventaLogic.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        this.ventaLogic.delete(id);
    }
}
