package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Provincia;

public class DaoProvincia {
	
	public List<Provincia> getAllProvincias(Connection con) {
		List<Provincia> provincias = new ArrayList<>();
		String select = "SELECT * " +
						"FROM Provincia ";
		try {
			Statement statement = con.createStatement();
			ResultSet set = statement.executeQuery(select);
			while (set.next()) {
				Provincia provincia = new Provincia();
				provincia.setId(set.getInt("id"));
				provincia.setNombre(set.getString("nombre"));
				provincia.setImagen(set.getString("imagen"));
				provincia.setFolleto(set.getString("folleto"));
				provincias.add(provincia);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return provincias;
	}

}
