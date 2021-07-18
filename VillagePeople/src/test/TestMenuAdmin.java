package test;

//Ardovino Luca
import static org.junit.Assert.assertEquals;



import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;


import logic.bean.MenuBean;
import logic.controller.MenuAdminController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.view.controllergrafico.ControllerGraficoAdmin;

public class TestMenuAdmin {
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
	public void testAggiungiMenuAdmin() throws SQLException {
		boolean risultato;
		MenuBean mb = new MenuBean();
		apriConnessione();
		mb.setMenu1("ciao22");
		mb.setMenu2("ciao23");
		mb.setMenu3("ciao24");
		MenuAdminController mac = new MenuAdminController();
		risultato = mac.comunicaMenu(mb, connessione);
		chiudiConnessione();
		assertEquals(true, risultato);
		
	}
	
	@Test
	public void testAggiungiMenuAdminFail() {
		String menu1 = "";
		String menu2 = "";
		String menu3 = "";
		int risultato;
		ControllerGraficoAdmin c2 = new ControllerGraficoAdmin();
		risultato = c2.controllaModificheMenu(menu1, menu2, menu3);
		assertEquals(0, risultato);
	}
}
