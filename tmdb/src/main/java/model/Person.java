package model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "FOTO")
	private String foto;
	@Column(name = "POPULARIDAD")
	private BigDecimal popularidad;
	@ManyToMany(mappedBy = "personList")
	private List<Movie> movieList;
	@OneToMany(mappedBy = "idperson")
	private List<Rating> ratingList;
	@Transient
	private int media;

	public void setMedia(int media) {
		this.media = media;
	}

	public Person() {}

	public Person(Integer id) {
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

	public BigDecimal getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(BigDecimal popularidad) {
		this.popularidad = popularidad;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	public void setMedia() {
		int suma = 0;
		for (Rating rating : ratingList) {
			suma += rating.getPuntos();
		}
		int tamano = ratingList.size();
		media = tamano == 0? 0 : suma/tamano;
	}

	public int getMedia() {
		return media;
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
		if (!(object instanceof Person)) {
			return false;
		}
		Person other = (Person) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Person[ id=" + id + " ]";
	}
	
}
