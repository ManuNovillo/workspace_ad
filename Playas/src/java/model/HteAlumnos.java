/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author smurf
 */
@Entity
@Table(name = "HTE_ALUMNOS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "HteAlumnos.findAll", query = "SELECT h FROM HteAlumnos h")
	, @NamedQuery(name = "HteAlumnos.findByRn", query = "SELECT h FROM HteAlumnos h WHERE h.rn = :rn")
	, @NamedQuery(name = "HteAlumnos.findById", query = "SELECT h FROM HteAlumnos h WHERE h.id = :id")
	, @NamedQuery(name = "HteAlumnos.findByNota", query = "SELECT h FROM HteAlumnos h WHERE h.nota = :nota")
	, @NamedQuery(name = "HteAlumnos.findByApellidos", query = "SELECT h FROM HteAlumnos h WHERE h.apellidos = :apellidos")
	, @NamedQuery(name = "HteAlumnos.findByCurso", query = "SELECT h FROM HteAlumnos h WHERE h.curso = :curso")
	, @NamedQuery(name = "HteAlumnos.findByNombre", query = "SELECT h FROM HteAlumnos h WHERE h.nombre = :nombre")})
public class HteAlumnos implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @Column(name = "RN_")
	private Long rn;
	@Column(name = "ID")
	private BigInteger id;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "NOTA")
	private Double nota;
	@Column(name = "APELLIDOS")
	private String apellidos;
	@Column(name = "CURSO")
	private String curso;
	@Column(name = "NOMBRE")
	private String nombre;

	public HteAlumnos() {
	}

	public HteAlumnos(Long rn) {
		this.rn = rn;
	}

	public Long getRn() {
		return rn;
	}

	public void setRn(Long rn) {
		this.rn = rn;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rn != null ? rn.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof HteAlumnos)) {
			return false;
		}
		HteAlumnos other = (HteAlumnos) object;
		if ((this.rn == null && other.rn != null) || (this.rn != null && !this.rn.equals(other.rn))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.HteAlumnos[ rn=" + rn + " ]";
	}
	
}
