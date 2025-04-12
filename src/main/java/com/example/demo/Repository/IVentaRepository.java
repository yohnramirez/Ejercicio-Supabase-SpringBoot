package com.example.demo.Repository;

import com.example.demo.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    List<Venta> findByEmpleadoId(Long idEmployee);

    List<Venta> findByClienteId(Long idCustomer);
}
