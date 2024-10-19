package entities;

public class Producto {

	private String titulo;
	private String body;
	private String fondo;
	private String imagen;
	private int id;
	
	public Producto(int id, String titulo, String body, String fondo, String imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.body = body;
		this.fondo = fondo;
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFondo() {
		return fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
