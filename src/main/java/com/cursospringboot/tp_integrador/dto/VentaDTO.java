package com.cursospringboot.tp_integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    private Long codigoVenta;
    private LocalDate fecha;
    private String estadoVenta;

    private Long idCliente;

    private List<DetalleVentaDTO> detalleVenta;

    private Double total;
}
