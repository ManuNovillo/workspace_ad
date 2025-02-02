package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "DNI")
	private String dni;
	@Column(name = "NOMBRE")
	private String nombre;
	@OneToMany(mappedBy = "dni")
	private List<Rating> ratingList;

	public Usuario() {
	}

	public Usuario(String dni) {
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (dni != null ? dni.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Usuario[ dni=" + dni + " ]";
	}
	
}