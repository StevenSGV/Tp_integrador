package com.cursospringboot.tp_integrador.mapper;

import com.cursospringboot.tp_integrador.dto.ClienteDTO;
import com.cursospringboot.tp_integrador.dto.DetalleVentaDTO;
import com.cursospringboot.tp_integrador.dto.ProductoDTO;
import com.cursospringboot.tp_integrador.dto.VentaDTO;
import com.cursospringboot.tp_integrador.model.Cliente;
import com.cursospringboot.tp_integrador.model.DetalleVenta;
import com.cursospringboot.tp_integrador.model.Producto;
import com.cursospringboot.tp_integrador.model.Venta;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static ClienteDTO toClienteDTO (Cliente cliente) {
        if(cliente == null) return null;

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setDni(cliente.getDni());

        return clienteDTO;
    }

    public static ProductoDTO toProductoDTO (Producto producto) {
        if(producto == null) return null;

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setMarca(producto.getMarca());
        productoDTO.setCosto(producto.getCosto());
        productoDTO.setCantidadDisponible(producto.getCantidadDisponible());

        return productoDTO;
    }

    public static VentaDTO toVentaDTO (Venta venta) {
        if(venta == null) return null;

        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setId(venta.getId());
        ventaDTO.setFecha(venta.getFechaVenta());
        ventaDTO.setEstadoVenta(venta.getEstadoVenta());
        ventaDTO.setIdCliente(venta.getCliente().getId());

        List<DetalleVentaDTO> listaDetallesVentaDTO = new ArrayList<>();

        for (DetalleVenta detalle : venta.getDetalleVenta()){
            if(venta.getDetalleVenta() != null) {
                DetalleVentaDTO detalleVentaDTO = new DetalleVentaDTO();

                detalleVentaDTO.setId(detalle.getId());
                detalleVentaDTO.setNombreProducto(detalle.getProducto().getNombre());
                detalleVentaDTO.setCantidadProducto(detalle.getCantidad());
                detalleVentaDTO.setPrecioUnitario(detalle.getPrecioUnitario());
                detalleVentaDTO.setSubTotal(detalle.getCantidad() * detalle.getPrecioUnitario());

                listaDetallesVentaDTO.add(detalleVentaDTO);
            }
        }

        ventaDTO.setDetalleVenta(listaDetallesVentaDTO);

        ventaDTO.setTotal(venta.getTotal());

        return ventaDTO;
    }
}
