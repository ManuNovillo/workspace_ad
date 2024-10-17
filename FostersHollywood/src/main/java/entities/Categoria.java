package entities;

import java.util.List;

public class Categoria {
	
	private int id;
	private String guarnicion;
	private String descrpcion;
	private String nombre;
	private List<Producto> productos;
	
	public Categoria(int id, String guarnicion, String descrpcion, String nombre, List<Producto> productos) {
		this.id = id;
		this.guarnicion = guarnicion;
		this.descrpcion = descrpcion;
		this.nombre = nombre;
		this.productos = productos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGuarnicion() {
		return guarnicion;
	}

	public void setGuarnicion(String guarnicion) {
		this.guarnicion = guarnicion;
	}

	public String getDescrpcion() {
		return descrpcion;
	}

	public void setDescrpcion(String descrpcion) {
		this.descrpcion = descrpcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
}
