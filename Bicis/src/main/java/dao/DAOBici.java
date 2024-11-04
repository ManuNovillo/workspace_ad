package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Bici;

public class DAOBici {
	
	public List<Bici> getBicis(String marca, String order, String fav, Connection con) {
		List<Bici> bicis = new ArrayList<>();
		String select = "SELECT * FROM Bici WHERE marca like ? AND fav like ? ORDER BY ?";
		try {
			PreparedStatement ps = con.prepareStatement(select);
			ps.setString(1, marca);
			ps.setString(2, fav);
			ps.setString(3, order);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				Bici bici = new Bici();
				bici.setFav(set.getInt("fav"));
				bici.setDescripcion(set.getString("descripcion"));
				bici.setPrecio(set.getDouble("precio"));
				bici.setMarca(set.getInt("marca"));
				bici.setFoto(set.getString("foto"));
				bicis.add(bici);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bicis;
	}
}
