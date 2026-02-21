package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {

    public List<ClienteDTO> getClientes();

    public ClienteDTO saveCliente(ClienteDTO clienteDTO);

    public ClienteDTO findCliente(Long idCliente);

    public ClienteDTO updateCliente(Long idCliente, ClienteDTO clienteDTO);

    public void deleteCliente(Long idCliente);
}
