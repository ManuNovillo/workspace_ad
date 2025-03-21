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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TITULO")
	private String titulo;
	@Column(name = "FECHA")
        @Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "POSTER")
	private String poster;
	@Column(name = "TRAMA")
	private String trama;
	@JoinTable(name = "PERSONMOVIE", joinColumns = {
        	@JoinColumn(name = "IDMOVIE", referencedColumnName = "ID")}, inverseJoinColumns = {
        	@JoinColumn(name = "IDPERSON", referencedColumnName = "ID")})
        @ManyToMany
	private List<Person> personList;

	public Movie() {
	}

	public Movie(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;

	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
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
		if (!(object instanceof Movie)) {
			return false;
		}
		Movie other = (Movie) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Movie[ id=" + id + " ]";
	}
}
