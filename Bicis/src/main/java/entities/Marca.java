package entities;

import java.util.List;

import dao.Entity;
import dao.PrimaryKey;

public class Marca {

	@PrimaryKey
	private int id;
	private String nombre;
	@Entity(className = "entities.Bici")
	private List<Bici> bicis;
	
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
	public List<Bici> getBicis() {
		return bicis;
	}
	public void setBicis(List<Bici> bicis) {
		this.bicis = bicis;
	}

	
	
	
}
