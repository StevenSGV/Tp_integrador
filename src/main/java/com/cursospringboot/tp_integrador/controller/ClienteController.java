package com.cursospringboot.tp_integrador.controller;

import com.cursospringboot.tp_integrador.dto.ClienteDTO;
import com.cursospringboot.tp_integrador.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteController {

    private final IClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/{idCliente}")
    public ClienteDTO getCliente(@PathVariable Long idCliente) {
        return clienteService.findCliente(idCliente);
    }

    @PostMapping
    public ClienteDTO createCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        return clienteService.saveCliente(clienteDTO);
    }

    @PutMapping("/{idCliente}")
    public ClienteDTO editCliente(@Valid @PathVariable Long idCliente,
                                  @RequestBody ClienteDTO clienteDTO) {

        return clienteService.updateCliente(idCliente, clienteDTO);
    }

    @DeleteMapping("/{idCliente}")
    public void deleteCliente(@PathVariable Long idCliente) {
        clienteService.deleteCliente(idCliente);
    }
}
