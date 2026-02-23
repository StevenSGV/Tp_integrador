package com.cursospringboot.tp_integrador.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    private Long id;
    private LocalDate fecha;

    @NotBlank(message = "El estado de venta es obligatorio")
    private String estadoVenta;

    @NotNull(message = "El cliente es obligatorio")
    private Long idCliente;

    private List<DetalleVentaDTO> detalleVenta;

    private Double total;
}
