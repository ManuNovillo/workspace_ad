package conexion;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class Conexion {

	public Connection getConnection() {
		String url = "jdbc:oracle:thin:foster/foster@80.28.158.14:1521:oradai";
		OracleConnectionPoolDataSource ocpds;
		Connection con = null;
		try {
			ocpds = new OracleConnectionPoolDataSource();
			ocpds.setURL(url);
			con = ocpds.getConnection();
		} catch (SQLException e) {
			System.out.println("Error en la conexion: " + e.getMessage());
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error en la conexion: " + e.getMessage());
		}
	}

}
