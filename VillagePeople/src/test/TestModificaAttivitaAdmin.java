package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import logic.bean.AttivitaBean;
import logic.controller.ModificaAttivitaAdminController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.view.controllergrafico.ControllerGraficoAdmin;

public class TestModificaAttivitaAdmin {
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
	public void testModificaAttivitaAdmin() throws SQLException {
		boolean risultato;
		AttivitaBean ab = new AttivitaBean();
		apriConnessione();
		ab.setCategoria("Sport");
		ab.setPrezzo(20);
		ab.setOrario("15");
	    ab.setNome("Calciotto");
		ab.setCodice(97);
		ab.setGiorno("Domenica");
		ab.setTipologia("Gruppo");
		ab.setPartecipantiMax(19);
		ModificaAttivitaAdminController maac = new ModificaAttivitaAdminController();
	    risultato = maac.modificaAttivita(ab, connessione);
	    chiudiConnessione();
	    assertEquals(true, risultato);	
	}
	
	@Test
	public void testControllaModificaFail() {
		int codice = 25;
	    String orario = "";  
	    double prezzo = 50.5;
	    ControllerGraficoAdmin c2 = new ControllerGraficoAdmin();
	    int risultato;
	    risultato = c2.controllaModifica(codice, orario, prezzo);
	    assertEquals(0, risultato);
	}
	
	

}
