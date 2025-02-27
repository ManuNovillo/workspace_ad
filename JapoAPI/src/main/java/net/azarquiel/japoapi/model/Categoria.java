package net.azarquiel.japoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "NOMBRE")
    private String nombre;

}