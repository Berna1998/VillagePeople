package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import logic.bean.AttivitaBean;
import logic.bean.UtenteBean;
import logic.controller.PrenotazioneAttivitaController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.util.AggiornaBudget;
import logic.util.MandaPrenotazioneAttGruppo;

public class TestPrenotazioneAttivita {
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
	public void testPrenotazioneAttivita() throws SQLException {
		boolean risultato;
		apriConnessione();
		AttivitaBean ab = new AttivitaBean();
		UtenteBean ub = new UtenteBean();
		ab.setCodice(11);
		ab.setPrezzo(2);
		//50 consiste in un valore casuale preso in questo caso cpme budget originario del cliente
		double budgetN = 50 - ab.getPrezzo();
		ub.setBudget(budgetN);
		ub.setCodiceID("12344");
		PrenotazioneAttivitaController ac = new PrenotazioneAttivitaController();
		risultato = ac.aggiungiPrenotazione(ab, ub, connessione);
		ac.aggiornaBudget(ub, connessione);
		chiudiConnessione();
		assertEquals(true, risultato);
		
	}
	
	@Test
	public void testPrenotazioneAttivitaGruppo() throws SQLException, InterruptedException, ExecutionException {
		boolean risultato;
		apriConnessione();
		int codiceRet = 0;
		AttivitaBean ab = new AttivitaBean();
		UtenteBean ub = new UtenteBean();
		ab.setCodice(23);
		double prezzo = 4;
		ExecutorService service = Executors.newFixedThreadPool(2); //creazione di un pool di 2 thread 

		double budgetN = 50 - prezzo;
		ub.setBudget(budgetN);
		ub.setCodiceID("12345");
		Future<Integer> retBudg = service.submit(new AggiornaBudget(ub, connessione));
		  
		Future<Boolean> risult = service.submit(new MandaPrenotazioneAttGruppo(ab, ub, connessione));
		 
		codiceRet = retBudg.get();
		risultato = risult.get();
		
		if (codiceRet == 0) {
			risultato = false;
		}
		service.shutdown(); //chiusura dei thread
	
		chiudiConnessione();
		assertEquals(true, risultato);
	}
	

}
