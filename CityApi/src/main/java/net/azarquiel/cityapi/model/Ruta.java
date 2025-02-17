package net.azarquiel.cityapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "RUTA")
public class Ruta {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CIUDAD")
    private Ciudad ciudad;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "IMAGEN")
    private String imagen;

    @Column(name = "DESCRIPCION", length = 512)
    private String descripcion;

    @Column(name = "LINK", length = 128)
    private String link;

    @OneToMany(mappedBy = "ruta", orphanRemoval = true)
    @JsonManagedReference
    private List<Punto> puntos = new ArrayList<>();

}