package test;

//Paciotta Eddy
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import logic.bean.AttivitaBean;
import logic.bean.UtenteBean;
import logic.controller.EliminaPrenotazioneController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.util.ConcretePenalStrategy2;
import logic.util.PenalDiscount;
import logic.util.PenalStrategy;

public class TestEliminazionePrenotazione {
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
	public void testEliminazionePrenotazione() throws SQLException {
	   boolean risultato = false;
	   apriConnessione();
	   AttivitaBean ab = new AttivitaBean();
	   UtenteBean ub = new UtenteBean();
	   double prezzo = 10;
	   ab.setCodice(97);
	   ab.setPrezzo(prezzo);
	   
	   ub.setCodiceID("12344");
	   double budgetN = 60 + prezzo;
	   ub.setBudget(budgetN);
	   EliminaPrenotazioneController epc = new EliminaPrenotazioneController();
	  
	   risultato = epc.eliminaPrenotazione(ub, ab, connessione);
	   epc.aggiornaBudget(ub, connessione);
     
	   chiudiConnessione();
	   assertEquals(true, risultato);

	}
	
	@Test
	public void testPenale() {
		double prezzo = 150.00;
		int risultato = 0;
		PenalDiscount penal = new PenalDiscount();
		double prezzoPenale = penal.execute(prezzo);
		if (prezzoPenale == 67.5) {
			risultato = 1;
		}
		assertEquals(1, risultato);
	}
	
	@Test
	public void testPenale2() {
		double prezzo = 150.00;
		int risultato = 0;
		PenalDiscount penal = new PenalDiscount();
		PenalStrategy newStrategy = new ConcretePenalStrategy2();
		penal.setStrategy(newStrategy);
		double prezzoPenale = penal.execute(prezzo);
		if (prezzoPenale == 45) {
			risultato = 1;
		}
		assertEquals(1, risultato);
	}

}
