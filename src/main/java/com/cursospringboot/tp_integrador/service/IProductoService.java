package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> getProductos();

    ProductoDTO saveProducto(ProductoDTO productoDTO);

    ProductoDTO findProducto(Long id);

    ProductoDTO updateProducto(Long id, ProductoDTO productoDTO);

    void deleteProducto(Long id);
}
