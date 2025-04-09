package com.example.demo.Controller;

import com.example.demo.Logic.ProveedorLogic;
import com.example.demo.Model.Proveedor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedor/")
public class ProveedorController {

    @Autowired
    private ProveedorLogic proveedorLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Proveedor data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.proveedorLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el proveedor.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Proveedor creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> getAll() {

        var result = this.proveedorLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.proveedorLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.proveedorLogic.delete(id);

        return new ResponseEntity<>("Proveedor con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateOne(@PathVariable Long id, @RequestBody Proveedor data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.proveedorLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
