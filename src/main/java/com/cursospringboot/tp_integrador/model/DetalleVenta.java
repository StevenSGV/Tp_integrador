package com.cursospringboot.tp_integrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codigoVenta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "codigoProducto")
    private Producto producto;
    private Integer cantidad;
    private Double precioUnitario;
}
