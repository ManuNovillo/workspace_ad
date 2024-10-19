package view;

import java.util.List;

import dao.DaoCategoria;
import entities.Categoria;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Categoria> categorias = DaoCategoria.getCategorias();
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}
	}

}
