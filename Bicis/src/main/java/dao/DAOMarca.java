package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Marca;

public class DAOMarca {

	public List<Marca> getMarcas(Connection con) {
		List<Marca> marcas = new ArrayList<>();
		String select = "SELECT * FROM Marca";
		try {
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				Marca marca = new Marca();
				marca.setId(set.getInt("id"));
				marca.setNombre(set.getString("nombre"));
				marcas.add(marca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marcas;
	}

}
