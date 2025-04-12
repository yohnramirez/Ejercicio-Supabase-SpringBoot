package com.example.demo.Repository;

import com.example.demo.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    @Query("SELECT dv FROM DetalleVenta dv " +
            "WHERE dv.venta.empleado.id = :id_empleado AND dv.venta.cliente.id = :id_cliente")
    List<DetalleVenta> findDetallesByEmpleadoAndCliente(@Param("id_empleado") Long empleadoId,
                                                        @Param("id_cliente") Long clienteId);
}
