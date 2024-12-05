package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
public class DaoCategoria {
	
	public List<Categoria> getAllCategorias(Connection con) {
		List<Categoria> categorias = new ArrayList<>();
		String select = "SELECT * " +
						"FROM Categoria ";
		try {
			Statement statement = con.createStatement();
			ResultSet set = statement.executeQuery(select);
			while (set.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(set.getInt("id"));
				categoria.setNombre(set.getString("nombre"));
				categoria.setImagen(set.getString("imagen"));
				categorias.add(categoria);
			}
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorias;
	}
}
