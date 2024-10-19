package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import entities.Producto;

public class DAOProducto {

	public static List<Producto> getProductos(int categoriaID) {
		List<Producto> productos = new ArrayList<>();
		Connection connection = new Conexion().getConnection();
		String sentencia = "SELECT titulo, imagen, fondo, body "
						 + "FROM Producto "
						 + "WHERE categoriaID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setInt(1, categoriaID);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				String fondo = result.getString("fondo");
				String imagen = result.getString("imagen");
				String titulo = result.getString("titulo");
				String body = result.getString("body");
				productos.add(new Producto(titulo, body, fondo, imagen));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}
}
