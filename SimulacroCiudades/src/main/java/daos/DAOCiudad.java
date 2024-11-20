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
		String selectQuery = "SELECT * " +
							 "FROM Ciudad";
		try {
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setId(result.getInt("id"));
				ciudad.setNombre(result.getString("nombre"));
				ciudad.setDescripcion(result.getString("descripcion"));
				ciudad.setImagen(result.getString("imagen"));
				ciudad.setLink(result.getString("link"));
				ciudad.setMapa(result.getString("mapa"));
				ciudades.add(ciudad);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ciudades;
	}
	
	public List<Ciudad> getCiudadesConRutas(Connection con) {
		List<Ciudad> ciudades = new ArrayList<>();
		String selectQuery = "SELECT * " +
							 "FROM Ciudad c " +
							 "WHERE c.id in (SELECT distinct r.ciudad FROM Ruta r)";
		try {
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setId(result.getInt("id"));
				ciudad.setNombre(result.getString("nombre"));
				ciudad.setDescripcion(result.getString("descripcion"));
				ciudad.setImagen(result.getString("imagen"));
				ciudad.setLink(result.getString("link"));
				ciudad.setMapa(result.getString("mapa"));
				ciudades.add(ciudad);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ciudades;
	}

	public Ciudad getCiudadById(int ciudadId, Connection con) {
		// TODO Auto-generated method stub
		Ciudad ciudad = null;
		String select = "SELECT * " +
				 		"FROM Ciudad " + 
				 		"WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(select);
			ps.setInt(1, ciudadId);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				ciudad = new Ciudad();
				ciudad.setId(ciudadId);
				ciudad.setNombre(result.getString("nombre"));
				ciudad.setDescripcion(result.getString("descripcion"));
				ciudad.setImagen(result.getString("imagen"));
				ciudad.setLink(result.getString("link"));
				ciudad.setMapa(result.getString("mapa"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ciudad;
	}
}
