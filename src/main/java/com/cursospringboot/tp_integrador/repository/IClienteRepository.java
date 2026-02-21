package com.cursospringboot.tp_integrador.repository;

import com.cursospringboot.tp_integrador.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
