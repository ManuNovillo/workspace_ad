package net.azarquiel.cityapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CIUDAD")
public class Ciudad {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "IMAGEN")
    private String imagen;

    @Column(name = "DESCRIPCION", length = 512)
    private String descripcion;

    @Column(name = "LINK", length = 256)
    private String link;

    @Column(name = "MAPA", length = 256)
    private String mapa;

    @OneToMany(mappedBy = "ciudad", orphanRemoval = true)
    @JsonManagedReference
    private List<Ruta> rutas = new ArrayList<>();

}