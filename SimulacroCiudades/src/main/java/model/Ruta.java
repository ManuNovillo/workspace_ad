package model;

public class Ruta {

	private int id;
	private String nombre;
	private String foto;
	private String link;
	private String descripcion;
	private int ciudad;
	private int media;

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getCiudad() {
		return ciudad;
	}

	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

}
