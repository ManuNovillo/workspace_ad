package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ciudad;

public class DAOCiudad {
	public List<Ciudad> getCiudades(Connection con) {
		List<Ciudad> ciudades = new ArrayList<>();
		String selectQuery = "SELECT nombre, link, imagen, descripcion " +
							 "FROM Ciudad";
		try {
			PreparedStatement statement = con.prepareStatement(selectQuery);
			ResultSet result = statement.executeQuery(selectQuery);
			while (result.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setNombre(result.getString("nombre"));
				ciudad.setDescripcion(result.getString("descripcion"));
				ciudad.setImagen(result.getString("imagen"));
				ciudad.setLink(result.getString("link"));
				ciudades.add(ciudad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ciudades;
	}
	
	public List<Ciudad> getCiudadesConRutas(Connection con) {
		List<Ciudad> ciudades = new ArrayList<>();
		String selectQuery = "SELECT c.nombre, c.link, c.imagen, c.descripcion " +
							 "FROM Ciudad c " +
							 "WHERE c.id in (SELECT distinct r.ciudad FROM Ruta r)";
		try {
			PreparedStatement statement = con.prepareStatement(selectQuery);
			ResultSet result = statement.executeQuery(selectQuery);
			while (result.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setNombre(result.getString("nombre"));
				ciudad.setDescripcion(result.getString("descripcion"));
				ciudad.setImagen(result.getString("imagen"));
				ciudad.setLink(result.getString("link"));
				ciudades.add(ciudad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ciudades;
	}
}
