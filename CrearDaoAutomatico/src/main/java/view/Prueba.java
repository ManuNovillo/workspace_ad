package view;

import conexion.Conexion;
import dao.DAO;

public class Prueba {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(DAO.getAll(Categoria.class, Conexion.conecta()));
	}
}

//.select *, nombres row, Reflexion para crear clase, attrb nombre ro