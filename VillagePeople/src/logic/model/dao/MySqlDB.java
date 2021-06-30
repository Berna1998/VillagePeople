package logic.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDB implements DataBaseClass { //concrete product
	private String username = "root";
	//private String password="Marchisio97";
	public Connection openConnection() throws SQLException {
		Connection con = null;
		String encoded = "";
		String password = "Marchisio97";
		String url = "jdbc:mysql://localhost:3306/villagepeople?useSSL=false";
	    byte[] travB=password.getBytes();
		byte[] bytes=Base64.getEncoder().encode(travB);
		try {
			encoded = new String(travB,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		con = DriverManager.getConnection(url,"root",encoded);

		//con = DriverManager.getConnection(url,this.username,this.password);
		//return DriverManager.getConnection(url,this.username,"Marchisio97");
		return con;
	}

}
