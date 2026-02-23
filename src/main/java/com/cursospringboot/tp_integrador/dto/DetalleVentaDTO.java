package com.cursospringboot.tp_integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDTO {

    private Long id;
    private String nombreProducto;
    private Integer cantidadProducto;
    private Double precioUnitario;
    private Double subTotal;
}
