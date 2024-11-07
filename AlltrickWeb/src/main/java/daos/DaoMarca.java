package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Marca;

public class DaoMarca {
	public ArrayList<Marca> getMarcas(Connection con){
		ResultSet rs;
		ArrayList<Marca> listaMarcas = new ArrayList<Marca>();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select * from marca order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Marca marca = new Marca();
				marca.setId(rs.getInt("ID"));
				marca.setNombre(rs.getString("NOMBRE"));
				
				listaMarcas.add(marca);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return listaMarcas;
	}

}
