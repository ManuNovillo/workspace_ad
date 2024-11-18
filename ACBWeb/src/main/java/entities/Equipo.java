package entities;

public class Equipo {
	private int id;
	private String nombre;
	private String imgestadio;
	private String imgescudo;
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equipo(int id, String nombre, String imgestadio, String imgescudo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imgestadio = imgestadio;
		this.imgescudo = imgescudo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImgestadio() {
		return imgestadio;
	}
	public void setImgestadio(String imgestadio) {
		this.imgestadio = imgestadio;
	}
	public String getImgescudo() {
		return imgescudo;
	}
	public void setImgescudo(String imgescudo) {
		this.imgescudo = imgescudo;
	}
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", imgestadio=" + imgestadio + ", imgescudo=" + imgescudo
				+ "]";
	}
	
	
}
