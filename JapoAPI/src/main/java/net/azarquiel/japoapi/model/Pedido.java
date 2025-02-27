package net.azarquiel.japoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "MESA")
    private Short mesa;

}