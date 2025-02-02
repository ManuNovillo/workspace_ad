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






				String url = "http:874289472";
				categoria.setImagen(set.getString("imagen"));
				String plusurl = categoria.getImagen();
				String urlDefinitiva = url + plusurl;
				categoria.setImagen(urlDefinitiva);


				categoria.setImagen(set.getString(4));
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
