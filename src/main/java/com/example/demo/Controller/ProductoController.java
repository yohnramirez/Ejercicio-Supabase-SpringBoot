package com.example.demo.Controller;

import com.example.demo.Logic.ProductoLogic;
import com.example.demo.Model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto/")
public class ProductoController {

    @Autowired
    private ProductoLogic productoLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Producto data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.productoLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el producto.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Producto creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {

        var result = this.productoLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.productoLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.productoLogic.delete(id);

        return new ResponseEntity<>("Producto con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateOne(@PathVariable Long id, @RequestBody Producto data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.productoLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getBySupplier")
    public ResponseEntity<List<Producto>> getBySupplier(@RequestParam Long idSupplier) {

        if (idSupplier < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.productoLogic.getBySupplierId(idSupplier);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
