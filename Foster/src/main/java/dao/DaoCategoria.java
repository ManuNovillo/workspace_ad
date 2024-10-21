package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import entities.Categoria;

public class DaoCategoria {

	public static List<Categoria> getCategorias() {
		List<Categoria> categorias = new ArrayList<>();
		Connection connection = new Conexion().getConnection();
		String sentencia = "SELECT id, nombre "
						 + "FROM Categoria";
		try {
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				String nombre = result.getString("nombre");
				int id = result.getInt("id");
				categorias.add(new Categoria(id, nombre));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorias;
	}
}
