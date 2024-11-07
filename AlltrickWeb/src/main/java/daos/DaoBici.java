package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Bici;

public class DaoBici {
	public ArrayList<Bici> getBicis(Connection con, String marca,String order, String fav){
		ResultSet rs;
		ArrayList<Bici> listaBicis = new ArrayList<Bici>();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select b.id biciId, b.foto, b.marca, b.descripcion, b.precio, b.fav, m.nombre nombreMarca "
							+ "from Bici b, Marca m "
							+ "where m.id = b.marca and "
							+ "marca like '"+marca+"' and "
							+ "fav like '"+fav+"' "
							+ "order by "+order;
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Bici bici = new Bici();
				bici.setId(rs.getInt("biciId"));
				bici.setFoto(rs.getString("FOTO"));
				bici.setNombreMarca(rs.getString("nombreMarca"));
				bici.setMarca(rs.getInt("MARCA"));
				bici.setDescripcion(rs.getString("DESCRIPCION"));
				bici.setPrecio(rs.getFloat("PRECIO"));
				bici.setFav(rs.getInt("FAV"));
				
				listaBicis.add(bici);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return listaBicis;
	}
}


