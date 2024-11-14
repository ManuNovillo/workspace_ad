package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Jugador;

public class DAOJugador {
	public List<Jugador> getJugadoresByEquipo(int equipoId, Connection connection) {
		List<Jugador> jugadores = new ArrayList<>();
		String sentencia = "SELECT * " +
						   "FROM Jugador" +
						   "WHERE equipo = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sentencia);
			ps.setInt(1, equipoId);
			ResultSet result = ps.executeQuery();
			while (result.next()) {
				Jugador jugador = new Jugador();
				jugador.setId(result.getInt("id"));
				jugador.setNombre(result.getString("nombre"));
				jugador.setEdad(result.getInt("edad"));
				jugador.setEquipo(result.getInt("equipo"));
				jugador.setEstatura(result.getInt("estatura"));
				jugador.setImagen(result.getString("imagen"));
				jugador.setLink(result.getString("link"));
				jugador.setLikes(result.getInt("likes"));
				jugador.setPais(result.getString("pais"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jugadores;
	}
}
