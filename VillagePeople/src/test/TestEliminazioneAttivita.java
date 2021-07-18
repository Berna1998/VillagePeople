package test;

//Paciotta Eddy
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import logic.bean.AttivitaBean;
import logic.controller.EliminaAttivitaController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;

public class TestEliminazioneAttivita {
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
	public void testEliminaAttivitaAdmin() throws SQLException {
		boolean risultato;
		AttivitaBean ab = new AttivitaBean();
		apriConnessione();
		ab.setCodice(99);
		EliminaAttivitaController eac = new EliminaAttivitaController();
	    risultato = eac.eliminaAttivita(ab, connessione);
	    chiudiConnessione();
	    assertEquals(true, risultato);	
	}

}
