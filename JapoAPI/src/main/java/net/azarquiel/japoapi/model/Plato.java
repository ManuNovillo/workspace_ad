/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azarquiel.japoapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "PLATO")
@NamedQueries({
	@NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")
	, @NamedQuery(name = "Plato.findById", query = "SELECT p FROM Plato p WHERE p.id = :id")
	, @NamedQuery(name = "Plato.findByNombre", query = "SELECT p FROM Plato p WHERE p.nombre = :nombre")
	, @NamedQuery(name = "Plato.findByFoto", query = "SELECT p FROM Plato p WHERE p.foto = :foto")
	, @NamedQuery(name = "Plato.findByPrecio", query = "SELECT p FROM Plato p WHERE p.precio = :precio")})
public class Plato implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private Short id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "FOTO")
	private String foto;

	@Column(name = "PRECIO")
	private BigDecimal precio;

	@ManyToMany(mappedBy = "platoList")
	@JsonIgnore
	private List<Alergeno> alergenoList;

	@ManyToMany(mappedBy = "platoList")
	@JsonIgnore
	private List<Pedido> pedidoList;

	@JoinColumn(name = "CATEGORIA", referencedColumnName = "ID")
	@ManyToOne
	@JsonBackReference
	private Categoria categoria;

	public Plato() {
	}

	public Plato(Short id) {
		this.id = id;
	}

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Alergeno> getAlergenoList() {
		return alergenoList;
	}

	public void setAlergenoList(List<Alergeno> alergenoList) {
		this.alergenoList = alergenoList;
	}

	public List<Pedido> getPedidoList() {
		return pedidoList;
	}

	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidoList = pedidoList;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		if (!(object instanceof Plato)) {
			return false;
		}
		Plato other = (Plato) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Plato[ id=" + id + " ]";
	}

}
