package com.example.demo.Controller;

import com.example.demo.Logic.ProveedorLogic;
import com.example.demo.Model.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedor/")
public class ProveedorController {

    @Autowired
    private ProveedorLogic proveedorLogic;

    @PostMapping
    public Proveedor create(Proveedor data) {
        return this.proveedorLogic.create(data);
    }

    @GetMapping
    public List<Proveedor> getAll() {
        return this.proveedorLogic.getAll();
    }

    @GetMapping("/{id}")
    public Proveedor getOne(@PathVariable Long id) {
        return this.proveedorLogic.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id) {
        this.proveedorLogic.delete(id);
    }

    @PutMapping("/{id}")
    public Proveedor updateOne(@PathVariable Long id, @RequestBody Proveedor data) {
        return this.proveedorLogic.update(id, data);
    }
}
