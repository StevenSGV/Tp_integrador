package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    public List<ProductoDTO> getProductos();

    public ProductoDTO saveProducto(ProductoDTO productoDTO);

    public ProductoDTO findProducto(Long codigoProducto);

    public ProductoDTO updateProducto(Long codigoProducto, ProductoDTO productoDTO);

    public void deleteProducto(Long codigoProducto);
}
