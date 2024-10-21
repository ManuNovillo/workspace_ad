package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class DAOPunto {

	public static int getMedia(int productoID) {
		int media = 0;
		Connection connection = new Conexion().getConnection();
		String sentencia = "SELECT AVG(puntos) as media "
						 + "FROM Punto "
						 + "WHERE idProducto = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setInt(1, productoID);
			ResultSet result = ps.executeQuery();
			result.next();
			media = (int) result.getDouble("media");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return media;
	}
}
