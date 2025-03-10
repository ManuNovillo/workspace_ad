/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azarquiel.japoapi.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ALERGENO")
@NamedQueries({
	@NamedQuery(name = "Alergeno.findAll", query = "SELECT a FROM Alergeno a")
	, @NamedQuery(name = "Alergeno.findById", query = "SELECT a FROM Alergeno a WHERE a.id = :id")
	, @NamedQuery(name = "Alergeno.findByNombre", query = "SELECT a FROM Alergeno a WHERE a.nombre = :nombre")
	, @NamedQuery(name = "Alergeno.findByFoto", query = "SELECT a FROM Alergeno a WHERE a.foto = :foto")})
public class Alergeno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private Short id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "FOTO")
	private String foto;
	@JoinTable(name = "PLATOALERGENO", joinColumns = {
		@JoinColumn(name = "ALERGENO", referencedColumnName = "ID")}, inverseJoinColumns = {
		@JoinColumn(name = "PLATO", referencedColumnName = "ID")})
	@ManyToMany
	@JsonIgnore
	private List<Plato> platoList;

	public Alergeno() {
	}

	public Alergeno(Short id) {
		this.id = id;
	}

    @Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Alergeno)) {
			return false;
		}
		Alergeno other = (Alergeno) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Alergeno[ id=" + id + " ]";
	}
	
}
