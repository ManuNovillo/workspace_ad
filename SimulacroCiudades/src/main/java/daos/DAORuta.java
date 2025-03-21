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
		String selectQuery = "SELECT id, nombre, descripcion, link, imagen, ciudad " +
							 "FROM Ruta " +
							 "WHERE ciudad = ?";
		try {
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, ciudadId);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Ruta ruta = new Ruta();
				ruta.setId(result.getInt("id"));
				ruta.setDescripcion(result.getString("descripcion"));
				ruta.setNombre(result.getString("nombre"));
				ruta.setFoto(result.getString("imagen"));
				ruta.setLink(result.getString("link"));
				ruta.setCiudad(result.getInt("ciudad"));
				int media = new DAOPunto().getMedia(ruta.getId(), con);
				ruta.setMedia(media);
				rutas.add(ruta);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return rutas;
	}
}
