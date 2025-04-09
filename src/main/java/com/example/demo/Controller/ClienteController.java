package com.example.demo.Controller;

import com.example.demo.Logic.ClienteLogic;
import com.example.demo.Model.Cliente;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente/")
public class ClienteController {

    @Autowired
    private ClienteLogic clienteLogic;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Cliente data) {

        if (data == null) return new ResponseEntity<>("Parametros inválidos.", HttpStatus.BAD_REQUEST);

        var result = this.clienteLogic.create(data);

        if (result == null) return new ResponseEntity<>("Error al crear el cliente.", HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>("Cliente creado correctamente!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>>  getAll() {

        var result = this.clienteLogic.getAll();

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.clienteLogic.getById(id);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable Long id) {

        if (id < 1) return new ResponseEntity<>("Parámetros inválidos", HttpStatus.BAD_REQUEST);

        this.clienteLogic.delete(id);

        return new ResponseEntity<>("Cliente con id " + id + " eliminado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateOne(@PathVariable Long id, @RequestBody Cliente data) {

        if (id < 1 || data == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        var result = this.clienteLogic.update(id, data);

        if (result == null) return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
