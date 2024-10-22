package view;

import dao.PrimaryKey;

public class Categoria {
	private String nombre;
	@PrimaryKey
	private int id;
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + "]";
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
