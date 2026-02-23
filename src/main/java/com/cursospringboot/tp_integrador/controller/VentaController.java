package com.cursospringboot.tp_integrador.controller;

import com.cursospringboot.tp_integrador.dto.VentaDTO;
import com.cursospringboot.tp_integrador.service.IVentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ventas")
public class VentaController {

    private final IVentaService ventaService;

    @GetMapping
    public List<VentaDTO> getVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/{id}")
    public VentaDTO getVenta(@PathVariable Long id) {
        return ventaService.findVenta(id);
    }

    @PostMapping
    public VentaDTO createVenta(@Valid @RequestBody VentaDTO ventaDTO) {
        return ventaService.saveVenta(ventaDTO);
    }

    @PutMapping("/{id}")
    public VentaDTO editVenta(@PathVariable Long id,
                                  @Valid @RequestBody VentaDTO ventaDTO) {

        return ventaService.updateVenta(id, ventaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
    }
}
