package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {

    List<ClienteDTO> getClientes();

    ClienteDTO saveCliente(ClienteDTO clienteDTO);

    ClienteDTO findCliente(Long id);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    void deleteCliente(Long id);
}
