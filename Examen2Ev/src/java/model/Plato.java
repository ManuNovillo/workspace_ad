/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "PLATO")
@XmlRootElement
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
	private Integer id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "FOTO")
	private String foto;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "PRECIO")
	private Float precio;
	@ManyToMany(mappedBy = "platoList")
	private List<Alergeno> alergenoList;
	@ManyToMany(mappedBy = "platoList")
	private List<Pedido> pedidoList;
	@JoinColumn(name = "CATEGORIA", referencedColumnName = "ID")
        @ManyToOne
	private Categoria categoria;

	public Plato() {
	}

	public Plato(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@XmlTransient
	public List<Alergeno> getAlergenoList() {
		return alergenoList;
	}

	public void setAlergenoList(List<Alergeno> alergenoList) {
		this.alergenoList = alergenoList;
	}

	@XmlTransient
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
