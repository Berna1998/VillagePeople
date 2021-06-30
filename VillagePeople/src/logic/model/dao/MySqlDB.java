package logic.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDB implements DataBaseClass { //concrete product
	
	private String password="Marchisio97";
	public Connection openConnection() throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/villagepeople?useSSL=false";
		con = DriverManager.getConnection(url,"root",this.password);
		return con;
	}

}
