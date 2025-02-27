/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "MESA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m")
	, @NamedQuery(name = "Mesa.findById", query = "SELECT m FROM Mesa m WHERE m.id = :id")
	, @NamedQuery(name = "Mesa.findByNombre", query = "SELECT m FROM Mesa m WHERE m.nombre = :nombre")})
public class Mesa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @Column(name = "ID")
	private Short id;
	@Column(name = "NOMBRE")
	private String nombre;
	@OneToMany(mappedBy = "mesa")
	private List<Pedido> pedidoList;

	public Mesa() {
	}

	public Mesa(Short id) {
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

	@XmlTransient
	public List<Pedido> getPedidoList() {
		return pedidoList;
	}

	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidoList = pedidoList;
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
		if (!(object instanceof Mesa)) {
			return false;
		}
		Mesa other = (Mesa) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Mesa[ id=" + id + " ]";
	}
	
}
