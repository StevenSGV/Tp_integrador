package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.VentaDTO;

import java.util.List;

public interface IVentaService {

    public List<VentaDTO> getVentas();

    public VentaDTO saveVenta(VentaDTO ventaDTO);

    public VentaDTO findVenta(Long codigoVenta);

    public VentaDTO updateVenta(Long codigoVenta, VentaDTO ventaDTO);

    public void deleteVenta(Long codigoVenta);
}
