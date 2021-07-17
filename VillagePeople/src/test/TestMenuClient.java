package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import logic.bean.IntolleranzeBean;
import logic.controller.MenuClientController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.view.controllergrafico.ControllerGrafico;

public class TestMenuClient {
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
	public void testInvioMenu() throws SQLException {
		boolean risultato;
		IntolleranzeBean ib = new IntolleranzeBean();
		apriConnessione();
		ib.setCodiceId("12344");
		ib.setMenu1(true);
		ib.setMenu2(false);
		ib.setMenu3(false);
		MenuClientController mcc = new MenuClientController();
		risultato = mcc.selezionaDati(ib, connessione);
		chiudiConnessione();
		assertEquals(true, risultato);	
	}
	
	@Test
	public void testInvioIntolleranze() throws SQLException {
		int risultato;
		IntolleranzeBean ib = new IntolleranzeBean();
		apriConnessione();
		ib.setCodiceId("12344");
		ib.setMenu1(true);
		ib.setMenu2(false);
		ib.setMenu3(false);
		ib.setIntolleranze("Intollerante al lattosio");
		MenuClientController mcc = new MenuClientController();
		risultato = mcc.comunicaIntolleranze(ib, connessione);
		chiudiConnessione();
		assertEquals(1, risultato);	
	}
	
	@Test
	public void testInvioMenuFail() {
		boolean menu1 = false;
		boolean menu2 = false;
		boolean menu3 = false;
		int risultato;
		ControllerGrafico c1 = new ControllerGrafico();
		risultato = c1.controllaScelteMenu(menu1, menu2, menu3);
		assertEquals(0, risultato);
	}

}
