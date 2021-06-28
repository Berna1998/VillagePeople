package logic.model.dao;

public class DataBaseFactory {//factory 
	
	public DataBaseFactory() { //costruttore
		
	}
	
	public DataBaseClass getConnessione(String dB) {
		if (dB.equals("MySql")) {
			return new MySqlDB();
		}
		return null;
		
	}

}
