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
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @Column(name = "ID", nullable = false)
    private Short id;

    @Column(name = "NICK", length = 64)
    private String nick;

    @Column(name = "PASS", length = 64)
    private String pass;

    @OneToMany(mappedBy = "usuario", orphanRemoval = true)
    @JsonManagedReference
    private List<Comentario> comentarios = new ArrayList<>();

}