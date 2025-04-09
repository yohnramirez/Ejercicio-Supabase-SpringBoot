package com.example.demo.Controller;

import com.example.demo.Logic.VentaLogic;
import com.example.demo.Model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta/")
public class VentaController {

    @Autowired
    private VentaLogic ventaLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Venta data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.ventaLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear la venta.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Venta creada correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Venta>> getAll() {

        var result = this.ventaLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.ventaLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.ventaLogic.delete(id);

        return new ResponseEntity<>("Venta con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }
}
