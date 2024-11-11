package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Ruta;

public class DAORuta {
	
	public List<Ruta> getRutas(Connection con) {
		List<Ruta> rutas = new ArrayList<>();
		String selectQuery = "SELECT nombre, link, foto, ciudad" +
							 "from Ruta";
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(selectQuery);
			result.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		return rutas;
	}

}
