package logic.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseClass {//abstract product
	
	public abstract Connection openConnection() throws SQLException;

}