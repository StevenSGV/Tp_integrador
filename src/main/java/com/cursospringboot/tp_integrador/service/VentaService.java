package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.DetalleVentaDTO;
import com.cursospringboot.tp_integrador.dto.VentaDTO;
import com.cursospringboot.tp_integrador.mapper.Mapper;
import com.cursospringboot.tp_integrador.model.Cliente;
import com.cursospringboot.tp_integrador.model.DetalleVenta;
import com.cursospringboot.tp_integrador.model.Producto;
import com.cursospringboot.tp_integrador.model.Venta;
import com.cursospringboot.tp_integrador.repository.IClienteRepository;
import com.cursospringboot.tp_integrador.repository.IProductoRepository;
import com.cursospringboot.tp_integrador.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<VentaDTO> getVentas() {
        List<Venta> listaVentas = ventaRepository.findAll();
        List<VentaDTO> listaVentasDTO = new ArrayList<>();

        for(Venta venta : listaVentas) {
            VentaDTO ventaDTO = Mapper.toVentaDTO(venta);
            listaVentasDTO.add(ventaDTO);
        }

        return listaVentasDTO;
    }

    @Override
    public VentaDTO saveVenta(VentaDTO ventaDTO) {
        if(ventaDTO == null) throw new RuntimeException("La venta no puede ser nula");
        if(ventaDTO.getIdCliente() == null) throw new RuntimeException("El cliente no existe");
        if(ventaDTO.getDetalleVenta() == null || ventaDTO.getDetalleVenta().isEmpty())
            throw new RuntimeException("El detalle de venta no existe");

        Venta venta = new Venta();

        venta.setFechaVenta(ventaDTO.getFecha());
        venta.setEstadoVenta(ventaDTO.getEstadoVenta());

        Cliente cliente = clienteRepository.findById(ventaDTO.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado") );

        venta.setCliente(cliente);

        List<DetalleVenta> listaDetalleVenta = construccionDetallesVenta(venta, ventaDTO);

        venta.setDetalleVenta(listaDetalleVenta);

        venta = ventaRepository.save(venta);

        return Mapper.toVentaDTO(venta);
    }

    @Override
    public VentaDTO findVenta(Long codigoVenta) {
        Venta venta = ventaRepository.findById(codigoVenta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        return Mapper.toVentaDTO(venta);
    }

    @Override
    public VentaDTO updateVenta(Long codigoVenta, VentaDTO ventaDTO) {
        Venta venta = ventaRepository.findById(codigoVenta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        if(ventaDTO.getFecha() != null) {
            venta.setFechaVenta(ventaDTO.getFecha());
        }

        if(ventaDTO.getEstadoVenta() != null) {
            venta.setEstadoVenta(ventaDTO.getEstadoVenta());
        }

        if(ventaDTO.getDetalleVenta() != null) {
            venta.getDetalleVenta().clear();

            List<DetalleVenta> nuevosDetalles = construccionDetallesVenta(venta, ventaDTO);

            venta.getDetalleVenta().addAll(nuevosDetalles);
        }

        if(ventaDTO.getIdCliente() != null) {
            Cliente cliente = clienteRepository.findById(ventaDTO.getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

            venta.setCliente(cliente);
        }

        venta = ventaRepository.save(venta);

        return Mapper.toVentaDTO(venta);
    }

    @Override
    public void deleteVenta(Long codigoVenta) {
        Venta venta = ventaRepository.findById(codigoVenta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        ventaRepository.delete(venta);
    }

    public List<DetalleVenta> construccionDetallesVenta (Venta venta, VentaDTO ventaDTO) {
        List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
        Double totalVenta = 0.0;

        for(DetalleVentaDTO detalleDTO : ventaDTO.getDetalleVenta()) {
            Producto producto = productoRepository.findByNombre(detalleDTO.getNombreProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            DetalleVenta detalleVenta = new DetalleVenta();

            detalleVenta.setVenta(venta);
            detalleVenta.setProducto(producto);
            detalleVenta.setCantidad(detalleDTO.getCantidadProducto());
            detalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
            totalVenta = totalVenta + (detalleDTO.getCantidadProducto() * detalleDTO.getPrecioUnitario());

            listaDetalleVenta.add(detalleVenta);
        }

        venta.setTotal(totalVenta);

        return listaDetalleVenta;
    }
}
