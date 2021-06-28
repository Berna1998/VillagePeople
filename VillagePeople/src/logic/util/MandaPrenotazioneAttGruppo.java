package logic.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import logic.bean.AttivitaBean;
import logic.bean.UtenteBean;
import logic.controller.PrenotazioneAttivitaController;

public class MandaPrenotazioneAttGruppo implements Callable<Boolean> {
	private UtenteBean ub;
	private AttivitaBean ab;
	private Connection connessione;
	private PrenotazioneAttivitaController pac = new PrenotazioneAttivitaController();
	
    public MandaPrenotazioneAttGruppo(AttivitaBean ab, UtenteBean ub, Connection connessione) {
        this.ab = ab;
    	this.ub = ub;
    	this.connessione = connessione;
    }
    
    @Override
    public Boolean call() throws SQLException {

    	boolean risultato = false;

       risultato = pac.aggiungiPrenotazione(ab, ub, connessione);
    	

    	
    	return risultato;
    }
	
    

}
