package logic.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDB implements DataBaseClass { //concrete product
	private String username = "root";
	//private String password="Marchisio97";
	public Connection openConnection() throws SQLException {
		Connection con = null;
		String password = getPassword();
		String url = "jdbc:mysql://localhost:3306/villagepeople?useSSL=false";
		con = DriverManager.getConnection(url,"root",password);

		//con = DriverManager.getConnection(url,this.username,this.password);
		//return DriverManager.getConnection(url,this.username,"Marchisio97");
		return con;
	}
	
	private String getPassword() {
		return "Marchisio97";
	}

}
