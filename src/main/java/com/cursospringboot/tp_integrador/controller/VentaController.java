package com.cursospringboot.tp_integrador.controller;

import com.cursospringboot.tp_integrador.dto.VentaDTO;
import com.cursospringboot.tp_integrador.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("/ventas")
    public List<VentaDTO> getVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/ventas/{codigoVenta}")
    public VentaDTO getVenta(@PathVariable Long codigoVenta) {
        return ventaService.findVenta(codigoVenta);
    }

    @PostMapping("/ventas/crear")
    public VentaDTO createVenta(@RequestBody VentaDTO ventaDTO) {
        return ventaService.saveVenta(ventaDTO);
    }

    @PutMapping("/ventas/editar/{codigoVenta}")
    public VentaDTO editVenta(@PathVariable Long codigoVenta,
                                  @RequestBody VentaDTO ventaDTO) {

        return ventaService.updateVenta(codigoVenta, ventaDTO);
    }

    @DeleteMapping("/ventas/eliminar/{codigoVenta}")
    public void deleteVenta(@PathVariable Long codigoVenta) {
        ventaService.deleteVenta(codigoVenta);
    }
}
