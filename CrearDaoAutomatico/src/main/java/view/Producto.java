package view;

import dao.PrimaryKey;

public class Producto {
	private String sumario;
	private String titulo;
	@PrimaryKey
	private int id;
	@Override
	public String toString() {
		return "Producto [sumario=" + sumario + ", id=" + id + ", titulo= " + titulo + "]";
	}
	
	
}
