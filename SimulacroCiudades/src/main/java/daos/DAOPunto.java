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
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, rutaId);
			ResultSet result = ps.executeQuery();
			result.next();
			media = result.getInt("media");
			ps.close();
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
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, puntos);
			ps.setInt(2, rutaId);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
