package conexion;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;


public class Conexion {
    public static Connection conecta(){
		// change username password please
		// 80.28.158.14 ip donde se ubica el Oracle Server del Azarquiel
		// 1521:oradai, puerto default Oracle y servicio creado en este Server 
    	String url="jdbc:oracle:thin:alltricks/alltricks@80.28.158.14:1521:oradai";
 
        OracleConnectionPoolDataSource ocpds;
        Connection con=null;
       	try {
			ocpds=new OracleConnectionPoolDataSource();
		    ocpds.setURL(url);
		    con=ocpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error Conexion.\n"+e.getMessage());
		}
       	if (con!=null) System.out.println("Successful Conexion.");

       	return con;
    }
}
