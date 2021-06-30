package logic.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDB implements DataBaseClass { //concrete product

	public Connection openConnection() throws SQLException {
		Connection con = null;
		String password = getPassword();
		String url = "jdbc:mysql://localhost:3306/villagepeople?useSSL=false";
		con = DriverManager.getConnection(url,"root",password);

		return con;
	}
	
	private String getPassword() {
		String pass;
		pass = "Marchisio97";
		return pass;
	}

}
