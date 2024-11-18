package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Equipo;

public class DaoEquipo {
	public ArrayList<Equipo> getEquipos(Connection con){
		ResultSet rs;
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Equipo order by nombre";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Equipo equipo = new Equipo();
				equipo.setId(rs.getInt("ID"));
				equipo.setNombre(rs.getString("NOMBRE"));
				equipo.setImgestadio(rs.getString("IMGESTADIO"));
				equipo.setImgescudo(rs.getString("IMGESCUDO"));
				equipos.add(equipo);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return equipos;
	}
	
	public Equipo getEquipo(int equipoId, Connection con){
		ResultSet rs;
		Equipo equipo = null;

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Equipo where id = " + equipoId;
			rs = st.executeQuery(ordenSql);
			if (rs.next()) {
				equipo = new Equipo();
				equipo.setId(rs.getInt("ID"));
				equipo.setNombre(rs.getString("NOMBRE"));
				equipo.setImgestadio(rs.getString("IMGESTADIO"));
				equipo.setImgescudo(rs.getString("IMGESCUDO"));
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error DAO.\n"+e.getMessage());
		}
		return equipo;
	}


}
