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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author smurf
 */
@Entity
@Table(name = "PLAYA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Playa.findAll", query = "SELECT p FROM Playa p"),
    @NamedQuery(name = "Playa.findById", query = "SELECT p FROM Playa p WHERE p.id = :id"),
    @NamedQuery(name = "Playa.findByNombre", query = "SELECT p FROM Playa p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Playa.findByDescripcion", query = "SELECT p FROM Playa p WHERE p.descripcion = :descripcion")})
public class Playa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "playa")
    private List<Images> imagenes;
    @JoinColumn(name = "MUNICIPIO", referencedColumnName = "ID")
    @ManyToOne
    private Municipio municipio;
    @OneToMany(mappedBy = "playa")
    private List<Punto> puntos;

	@Transient
	private int media;

	public int getMedia() {
		int tamano = puntos.size();
		if (puntos.isEmpty()) {
			media = 3;
			return media;
		}
		double suma = 0;
		for (Punto punto : puntos) {
			if(punto.getPuntos()==null){
				
			}
			else{
			suma += punto.getPuntos();}
			
		}
		media = (int) Math.round(suma / tamano);
		System.out.println("Media: " + media);
		return media;
	}
    public Playa() {
    }

    public Playa(Integer id) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Images> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Images> imagenes) {
        this.imagenes = imagenes;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @XmlTransient
    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
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
        if (!(object instanceof Playa)) {
            return false;
        }
        Playa other = (Playa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
