package net.azarquiel.apiesquiparafront.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ESTACION")
public class Estacion {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "LOGO")
    private String logo;

    @Column(name = "PLANO")
    private String plano;

    @Column(name = "KM")
    private Short km;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PROVINCIA")
    private Provincia provincia;

    @JsonManagedReference
    @OneToMany(mappedBy = "estacion", orphanRemoval = true)
    private List<Imagen> imagenes = new ArrayList<>();

    @OneToMany(mappedBy = "estacion", orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

}