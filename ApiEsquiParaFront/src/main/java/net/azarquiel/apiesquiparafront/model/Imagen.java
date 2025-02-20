package net.azarquiel.apiesquiparafront.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "IMAGEN")
public class Imagen {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "FOTO")
    private String foto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "ESTACION")
    private Estacion estacion;

}