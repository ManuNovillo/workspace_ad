/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
	, @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id")
	, @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha")
	, @NamedQuery(name = "Pedido.findByMesa", query = "SELECT p FROM Pedido p WHERE p.mesa = :mesa")})
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @Column(name = "ID")
	private Integer id;
	@Column(name = "FECHA")
        @Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "MESA")
	private Integer mesa;
	@JoinTable(name = "DETALLEPEDIDO", joinColumns = {
        	@JoinColumn(name = "PEDIDO", referencedColumnName = "ID")}, inverseJoinColumns = {
        	@JoinColumn(name = "PLATO", referencedColumnName = "ID")})
        @ManyToMany
	private List<Plato> platoList;

	public Pedido() {
	}

	public Pedido(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getMesa() {
		return mesa;
	}

	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}

	@XmlTransient
	public List<Plato> getPlatoList() {
		return platoList;
	}

	public void setPlatoList(List<Plato> platoList) {
		this.platoList = platoList;
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
		if (!(object instanceof Pedido)) {
			return false;
		}
		Pedido other = (Pedido) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Pedido[ id=" + id + " ]";
	}
	
}
