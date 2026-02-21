package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.ClienteDTO;
import com.cursospringboot.tp_integrador.exception.NotFoundException;
import com.cursospringboot.tp_integrador.mapper.Mapper;
import com.cursospringboot.tp_integrador.model.Cliente;
import com.cursospringboot.tp_integrador.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> getClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        List<ClienteDTO> listaClienteDTO = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            ClienteDTO clienteDTO = Mapper.toClienteDTO(cliente);
            listaClienteDTO.add(clienteDTO);
        }

        return listaClienteDTO;
    }

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDni(clienteDTO.getDni());

        Cliente saveCliente = clienteRepository.save(cliente);

        return Mapper.toClienteDTO(saveCliente);
    }

    @Override
    public ClienteDTO findCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado el cliente."));

        return Mapper.toClienteDTO(cliente);
    }

    @Override
    public ClienteDTO updateCliente(Long idCliente, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new NotFoundException("No se encontro el cliente."));

        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDni(clienteDTO.getDni());

        Cliente saveCliente = clienteRepository.save(cliente);

        return Mapper.toClienteDTO(saveCliente);
    }

    @Override
    public void deleteCliente(Long idCliente) {
        clienteRepository.findById(idCliente)
                .orElseThrow(() -> new NotFoundException("No se encontro el cliente."));

        clienteRepository.deleteById(idCliente);
    }
}
