package com.example.demo.Logic;

import com.example.demo.Model.Cliente;
import com.example.demo.Repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteLogic {

    @Autowired
    private IClienteRepository clienteRepository;

    public Cliente create(Cliente data) {
        try {
            return this.clienteRepository.save(data);
        } catch (Exception ex) {
            System.out.println("Ocurrió un error creando el cliente: " + ex.getMessage());
        }

        return null;
    }

    public List<Cliente> getAll() {
        try {
            return this.clienteRepository.findAll();
        } catch (Exception ex){
            System.out.println("Ocurrió un error obteniendo los clientes: " + ex.getMessage());
        }

        return null;
    }

    public Cliente getById(Long id) {
        try {
            Optional<Cliente> cliente = this.clienteRepository.findById(id);

            if (cliente.isPresent())
                return cliente.get();

        } catch (Exception ex) {
            System.out.println("Ocurrió un error obteniendo el cliente con id " + id + ": " + ex.getMessage());
        }

        return null;
    }

    public void delete(Long id) {
        try {
            Optional<Cliente> cliente = this.clienteRepository.findById(id);

            if (cliente.isPresent())
                this.clienteRepository.deleteById(id);

        } catch (Exception ex) {
            System.out.println("Ocurrió un error eliminando el cliente con id " + id + ": " + ex.getMessage());
        }
    }

    public Cliente update(Long id, Cliente data) {

        try {
            Optional<Cliente> cliente = this.clienteRepository.findById(id);

            if (cliente.isPresent()) {
                cliente.get().setCedula(data.getCedula());
                cliente.get().setCorreo(data.getCorreo());
                cliente.get().setNombre(data.getNombre());
                cliente.get().setTelefono(data.getTelefono());

                return this.clienteRepository.save(cliente.get());
            }

        } catch (Exception ex) {
            System.out.println("Ocurrió un error actualizando el cliente con id " + id + ": " + ex.getMessage());
        }

        return null;
    }
}
