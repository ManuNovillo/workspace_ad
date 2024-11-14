package entities;

public class Jugador {
	private int id;
	private int equipo;
	private String nombre;
	private String imagen;
	private String link;
	private String pais;
	private int estatura;
	private int edad;
	private int likes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEquipo() {
		return equipo;
	}

	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", equipo=" + equipo + ", nombre=" + nombre + ", imagen=" + imagen + ", link="
				+ link + ", pais=" + pais + ", estatura=" + estatura + ", edad=" + edad + ", likes=" + likes + "]";
	}

}
