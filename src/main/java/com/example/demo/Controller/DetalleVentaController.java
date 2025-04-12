package com.example.demo.Controller;

import com.example.demo.Logic.DetalleVentaLogic;
import com.example.demo.Model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle/")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaLogic detalleVentaLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody DetalleVenta data) {

        var result = this.detalleVentaLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el detalle de venta.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Detalle de venta creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> getAll() {

        var result = this.detalleVentaLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.detalleVentaLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.detalleVentaLogic.delete(id);

        return new ResponseEntity<>("Detalle de venta con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> updateOne(@PathVariable Long id, @RequestBody DetalleVenta data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.detalleVentaLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/byEmployeeAndCustomer")
    public ResponseEntity<List<DetalleVenta>> findByEmployeeAndCustomer(@RequestParam Long idEmployee, @RequestParam Long idCustomer) {

        if (idEmployee < 1 || idCustomer < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.detalleVentaLogic.findByEmployeeAndCustomer(idEmployee, idCustomer);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
