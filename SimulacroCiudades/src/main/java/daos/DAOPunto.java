package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOPunto {
	
	public int getMedia(int rutaId, Connection con) {
		int media = 0;
		String selectQuery = "SELECT round(avg(puntos)) media " + 
							 "FROM Punto " +
							 "WHERE ruta = ?";
		try {
			PreparedStatement statement = con.prepareStatement(selectQuery);
			statement.setInt(1, rutaId);
			ResultSet result = statement.executeQuery();
			result.next();
			media = result.getInt("media");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return media;
	}
	
	public void addPuntos(int puntos, int rutaId, Connection con) {
		String insert = "INSERT INTO Punto(puntos, ruta) values (?, ?)";
		try {
			PreparedStatement statement = con.prepareStatement(insert);
			statement.setInt(1, puntos);
			statement.setInt(2, rutaId);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
