package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.ProductoDTO;
import com.cursospringboot.tp_integrador.exception.NotFoundException;
import com.cursospringboot.tp_integrador.mapper.Mapper;
import com.cursospringboot.tp_integrador.model.Producto;
import com.cursospringboot.tp_integrador.repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService{

    private final IProductoRepository productoRepository;

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
    public ProductoDTO findProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        return Mapper.toProductoDTO(producto);
    }

    @Override
    public ProductoDTO updateProducto(Long id, ProductoDTO productoDTO) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        producto.setNombre(productoDTO.getNombre());
        producto.setMarca(productoDTO.getMarca());
        producto.setCosto(productoDTO.getCosto());
        producto.setCantidadDisponible(productoDTO.getCantidadDisponible());

        Producto productoActual = productoRepository.save(producto);

        return Mapper.toProductoDTO(productoActual);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        productoRepository.deleteById(id);
    }
}
