package com.cursospringboot.tp_integrador.repository;

import com.cursospringboot.tp_integrador.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
