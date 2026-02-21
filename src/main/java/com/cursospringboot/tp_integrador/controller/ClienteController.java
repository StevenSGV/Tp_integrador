package com.cursospringboot.tp_integrador.controller;

import com.cursospringboot.tp_integrador.dto.ClienteDTO;
import com.cursospringboot.tp_integrador.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<ClienteDTO> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/clientes/{idCliente}")
    public ClienteDTO getCliente(@PathVariable Long idCliente) {
        return clienteService.findCliente(idCliente);
    }

    @PostMapping("/clientes/crear")
    public ClienteDTO createCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.saveCliente(clienteDTO);
    }

    @PutMapping("/clientes/editar/{idCliente}")
    public ClienteDTO editCliente(@PathVariable Long idCliente,
                                  @RequestBody ClienteDTO clienteDTO) {

        return clienteService.updateCliente(idCliente, clienteDTO);
    }

    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public void deleteCliente(@PathVariable Long idCliente) {
        clienteService.deleteCliente(idCliente);
    }
}
