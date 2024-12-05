package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lugar;

public class DaoLugar {
	
	public List<Lugar> getAllLugares(String categoriaId, String provinciaId, String fav, Connection con) {
		List<Lugar> lugares = new ArrayList<>();
		String select = "SELECT * " +
						"FROM Lugar " +
						"WHERE categoria like ? " +
						"AND provincia like ? " +
						"AND fav like ?";
		try {
			PreparedStatement ps = con.prepareStatement(select);
			ps.setString(1, categoriaId);
			ps.setString(2, provinciaId);
			ps.setString(3, fav);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				Lugar lugar = new Lugar();
				lugar.setId(set.getInt("id"));
				lugar.setNombre(set.getString("nombre"));
				lugar.setImagen(set.getString("imagen"));
				lugar.setFav(set.getInt("fav"));
				lugar.setProvincia(set.getInt("provincia"));
				lugar.setCategoria(set.getInt("categoria"));
				lugares.add(lugar);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lugares;
	}
	
	public void cambiarFav(int lugarId, int fav, Connection con) {
		String update = "UPDATE Lugar " + 
						"SET fav = ? " +
						"WHERE id = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(update);
			ps.setInt(1, fav);
			ps.setInt(2, lugarId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
