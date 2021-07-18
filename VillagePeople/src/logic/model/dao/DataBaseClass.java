package logic.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseClass {
	
     public Connection openConnection() throws SQLException;

}