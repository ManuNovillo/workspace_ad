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

@Entity
@Table(name = "CCAA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Ccaa.findAll", query = "SELECT c FROM Ccaa c")
	, @NamedQuery(name = "Ccaa.findById", query = "SELECT c FROM Ccaa c WHERE c.id = :id")
	, @NamedQuery(name = "Ccaa.findByNombre", query = "SELECT c FROM Ccaa c WHERE c.nombre = :nombre")})
public class Ccaa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @Column(name = "ID")
	private Short id;
	@Column(name = "NOMBRE")
	private String nombre;
	@OneToMany(mappedBy = "ccaa")
	private List<Provincia> provincias;

	public Ccaa() {
	}

	public Ccaa(Short id) {
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
	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
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
		if (!(object instanceof Ccaa)) {
			return false;
		}
		Ccaa other = (Ccaa) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication2.Ccaa[ id=" + id + " ]";
	}
	
}