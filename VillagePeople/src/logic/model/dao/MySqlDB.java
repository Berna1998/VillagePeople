package logic.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDB implements DataBaseClass { //concrete product
	String url = "jdbc:mysql://localhost:3306/villagepeople?useSSL=false";
	Connection con = null;

	public Connection openConnection() throws SQLException {
		con = DriverManager.getConnection(url,"root","Marchisio97");
		return con;
	}

}
