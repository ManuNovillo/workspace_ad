package net.azarquiel.apiesquiparafront.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

}