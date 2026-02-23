package com.cursospringboot.tp_integrador.service;

import com.cursospringboot.tp_integrador.dto.VentaDTO;

import java.util.List;

public interface IVentaService {

    List<VentaDTO> getVentas();

    VentaDTO saveVenta(VentaDTO ventaDTO);

    VentaDTO findVenta(Long id);

    VentaDTO updateVenta(Long id, VentaDTO ventaDTO);

    void deleteVenta(Long id);
}
