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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ALERGENO")
@XmlRootElement
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
	private Integer id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "FOTO")
	private String foto;
	@JoinTable(name = "PLATOALERGENO", joinColumns = {
        	@JoinColumn(name = "ALERGENO", referencedColumnName = "ID")}, inverseJoinColumns = {
        	@JoinColumn(name = "PLATO", referencedColumnName = "ID")})
        @ManyToMany
	private List<Plato> platoList;

	public Alergeno() {
	}

	public Alergeno(Integer id) {
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
