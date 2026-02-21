package com.cursospringboot.tp_integrador.controller;

import com.cursospringboot.tp_integrador.dto.ProductoDTO;
import com.cursospringboot.tp_integrador.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoDTO> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/productos/{codigoProducto}")
    public ProductoDTO getProducto(@PathVariable Long codigoProducto) {
        return productoService.findProducto(codigoProducto);
    }

    @PostMapping("/productos/crear")
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.saveProducto(productoDTO);
    }

    @PutMapping("/productos/editar/{codigoProducto}")
    public ProductoDTO editProducto(@PathVariable Long codigoProducto,
                                  @RequestBody ProductoDTO productoDTO) {

        return productoService.updateProducto(codigoProducto, productoDTO);
    }

    @DeleteMapping("/productos/eliminar/{codigoProducto}")
    public void deleteProducto(@PathVariable Long codigoProducto) {
        productoService.deleteProducto(codigoProducto);
    }
}
