package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import logic.bean.LoginBean;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.controller.LogInController;

public class TestLogin {
	private String type = "MySql";
	private DataBaseFactory dbf = new DataBaseFactory();
	private DataBaseClass db = dbf.getConnessione(type);
	private Connection connessione;

	public void apriConnessione() throws SQLException{
		connessione = db.openConnection();
	}
	
	public void chiudiConnessione() throws SQLException {
		connessione.close();
	}
	
	@Test
	public void testLoginClient() throws SQLException {
		int role;
		LoginBean lb = new LoginBean();
		apriConnessione();
		lb.setCodiceID("12344");
		lb.setPassword("panino98");
		LogInController cli = new LogInController();
		role = cli.ritornaRuolo(lb, connessione);
		chiudiConnessione();
		assertEquals(1, role);
		
	}
	
	@Test
	public void testLoginAdmin() throws SQLException {
		int role;
		LoginBean lb = new LoginBean();
		apriConnessione();
		lb.setCodiceID("12333");
		lb.setPassword("ciaociao");
		LogInController cli = new LogInController();
		role = cli.ritornaRuolo(lb, connessione);
		chiudiConnessione();
		assertEquals(0, role);
		
	}
	
	@Test
	public void testLoginFail() throws SQLException {
		int role;
		LoginBean lb = new LoginBean();
		apriConnessione();
		lb.setCodiceID("76543");
		lb.setPassword("NonEsisto");
		LogInController cli = new LogInController();
		role = cli.ritornaRuolo(lb, connessione);
		chiudiConnessione();
		assertEquals(3, role);
	}

}
