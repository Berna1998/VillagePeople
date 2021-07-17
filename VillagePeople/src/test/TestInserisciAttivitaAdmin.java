package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import logic.bean.AttivitaBean;
import logic.controller.InserisciAttivitaAdminController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.view.controllergrafico.ControllerGraficoAdmin;

public class TestInserisciAttivitaAdmin {
	private String type = "MySql";
	private DataBaseFactory dbf = new DataBaseFactory();
	private DataBaseClass db = dbf.getConnessione(type);
	private Connection connessione;

	public void apriConnessione() throws SQLException {
		connessione = db.openConnection();
	}
	
	public void chiudiConnessione() throws SQLException {
		connessione.close();
	}
	
	@Test
	public void testInserisciAttivitaAdmin() throws SQLException {
		boolean risultato;
		AttivitaBean abIns = new AttivitaBean();
		apriConnessione();
		abIns.setCategoria("Sport");
		abIns.setPrezzo(12.5);
		abIns.setOrario("17");
		abIns.setNome("Pallavolo");
		abIns.setCodice(98);
		abIns.setGiorno("Domenica");
		abIns.setTipologia("Gruppo");
		abIns.setPartecipantiMax(18);
		InserisciAttivitaAdminController iaac = new InserisciAttivitaAdminController();
	    risultato = iaac.aggiungiAttivita(abIns, connessione);
	    chiudiConnessione();
	    assertEquals(true, risultato);	
	}
	
	@Test
	public void testControllaInserimentiFail() {
		int risultato;
		String nome = "";
		int codice = 0; 
		String orario = ""; 
		Double prezzo = 0.0;
		int partecipantiMax = 5;
		ArrayList<Object> l = new ArrayList<>();
		l.add("");
		l.add("");
		l.add("");
		ControllerGraficoAdmin c2 = new ControllerGraficoAdmin();
		risultato = c2.controllaInserimenti(nome, codice, orario, prezzo, partecipantiMax, l);
		assertEquals(0, risultato);	
	}

}
