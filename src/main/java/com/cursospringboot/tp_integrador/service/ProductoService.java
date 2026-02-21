package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.ProductoDTO;
import com.cursospringboot.tp_integrador.exception.NotFoundException;
import com.cursospringboot.tp_integrador.mapper.Mapper;
import com.cursospringboot.tp_integrador.model.Producto;
import com.cursospringboot.tp_integrador.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        List<ProductoDTO> listaProductosDTO = new ArrayList<>();

        for(Producto producto : listaProductos){
            ProductoDTO productoDTO = Mapper.toProductoDTO(producto);
            listaProductosDTO.add(productoDTO);
        }

        return listaProductosDTO;
    }

    @Override
    public ProductoDTO saveProducto(ProductoDTO productoDTO) {
            Producto producto = new Producto();

            producto.setNombre(productoDTO.getNombre());
            producto.setMarca(productoDTO.getMarca());
            producto.setCosto(productoDTO.getCosto());
            producto.setCantidadDisponible(productoDTO.getCantidadDisponible());

            productoRepository.save(producto);

            return Mapper.toProductoDTO(producto);
    }

    @Override
    public ProductoDTO findProducto(Long codigoProducto) {
        Producto producto = productoRepository.findById(codigoProducto)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        return Mapper.toProductoDTO(producto);
    }

    @Override
    public ProductoDTO updateProducto(Long codigoProducto, ProductoDTO productoDTO) {
        Producto producto = productoRepository.findById(codigoProducto)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        producto.setNombre(productoDTO.getNombre());
        producto.setMarca(productoDTO.getMarca());
        producto.setCosto(productoDTO.getCosto());
        producto.setCantidadDisponible(productoDTO.getCantidadDisponible());

        Producto productoActual = productoRepository.save(producto);

        return Mapper.toProductoDTO(productoActual);
    }

    @Override
    public void deleteProducto(Long codigoProducto) {
        productoRepository.findById(codigoProducto)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        productoRepository.deleteById(codigoProducto);
    }
}
