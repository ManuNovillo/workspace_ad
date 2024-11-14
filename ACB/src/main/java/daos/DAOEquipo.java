package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Equipo;

public class DAOEquipo {
	
	public List<Equipo> getCategorias(Connection connection) {
		List<Equipo> equipos = new ArrayList<>();
		String sentencia = "SELECT * "
						 + "FROM Equipo";
		try {
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Equipo equipo = new Equipo();
				equipo.setId(result.getInt("id"));
				equipo.setNombre(result.getString("nombre"));
				equipo.setImgescudo(result.getString("imgescudo"));
				equipo.setImgestadio(result.getString("imgestadio"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return equipos;
	}
}
