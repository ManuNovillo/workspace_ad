package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ruta;

public class DAORuta {
	
	public List<Ruta> getRutasByCiudad(Connection con, int ciudadId) {
		List<Ruta> rutas = new ArrayList<>();
		String selectQuery = "SELECT nombre, link, foto, ciudad" +
							 "FROM Ruta" +
							 "WHERE ciudad = ?";
		try {
			PreparedStatement statement = con.prepareStatement(selectQuery);
			statement.setInt(1, ciudadId);
			ResultSet result = statement.executeQuery(selectQuery);
			while (result.next()) {
				Ruta ruta = new Ruta();
				ruta.setNombre(result.getString("nombre"));
				ruta.setFoto(result.getString("foto"));
				ruta.setLink(result.getString("link"));
				ruta.setCiudad(result.getInt("ciudad"));
				rutas.add(ruta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return rutas;
	}

	public List<Ruta> getRutas(Connection con) {
		// TODO Auto-generated method stub
		List<Ruta> rutas = new ArrayList<>();
		String selectQuery = "SELECT nombre, link, imagen, ciudad " +
							 "FROM Ruta";
		try {
			PreparedStatement statement = con.prepareStatement(selectQuery);
			ResultSet result = statement.executeQuery(selectQuery);
			while (result.next()) {
				Ruta ruta = new Ruta();
				ruta.setNombre(result.getString("nombre"));
				ruta.setFoto(result.getString("imagen"));
				ruta.setLink(result.getString("link"));
				ruta.setCiudad(result.getInt("ciudad"));
				rutas.add(ruta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return rutas;
	}
}
