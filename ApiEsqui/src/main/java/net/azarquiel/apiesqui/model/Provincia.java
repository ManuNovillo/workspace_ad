package net.azarquiel.apiesqui.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PROVINCIA")
public class Provincia {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "provincia", orphanRemoval = true)
    @JsonManagedReference
    private List<Estacion> estaciones = new ArrayList<>();

}