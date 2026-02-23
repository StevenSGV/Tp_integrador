package com.cursospringboot.tp_integrador.controller;

import com.cursospringboot.tp_integrador.dto.ProductoDTO;
import com.cursospringboot.tp_integrador.service.IProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoService productoService;

    @GetMapping
    public List<ProductoDTO> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/{id}")
    public ProductoDTO getProducto(@PathVariable Long id) {
        return productoService.findProducto(id);
    }

    @PostMapping
    public ProductoDTO createProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        return productoService.saveProducto(productoDTO);
    }

    @PutMapping("/{id}")
    public ProductoDTO editProducto(@PathVariable Long id,
                                  @Valid @RequestBody ProductoDTO productoDTO) {

        return productoService.updateProducto(id, productoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
}
