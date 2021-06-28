package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import logic.bean.AttivitaBean;
import logic.bean.UtenteBean;
import logic.model.dao.AttivitaDao;


public class AttivitaController {
	private AttivitaDao ad = new AttivitaDao();
	private String bambini = "Bambini";
	private String sport = "Sport";
	private String svagoRelax = "Svago&Relax";
	private String saluteBenessere = "Salute&Benessere";
	
	public void aggiornaBudget(UtenteBean ub, Connection con) throws SQLException{
		double budget = ub.getBudget();
		String codiceId = ub.getCodiceID();
		ad.aggiornaBudget(budget, codiceId, con);
	}
	
	
	/*Questo metodo è stato implementato solamente per il codice html nelle pagine jsp 
	* PrenotaAttivitaGruppo e PrenotaAttivitaSingola   */
	public double cercaBudget(String cod, Connection con) throws SQLException {
		return ad.trovaBudget(cod, con);
	}
	
	
	/* Tale metodo serve per cancellare le prenotazioni dopo l'inserimento della notifica così che si possa associare 
    la notifica ai clienti che si sono prenotati alla determinata attività che si sta cancellando */
	public void eliminaPrenotazioni(int cod, Connection con) throws SQLException {
		ad.eliminaPrenotazioni(cod, con);
	}
	
	
    /*Questo metodo è chiamato quando dalla GUI si cerca un'attività   */
	public void ricercaAttivita(AttivitaBean ab, List<Object> l, Connection con) throws SQLException {
		String categoria = ab.getCategoria();
		String giorno = ab.getGiorno();
		if (categoria.equals(sport)) {
			ad.cercaAttivita(1, giorno, l, con);
	    
		}
		else if (categoria.equals(svagoRelax)) {
			ad.cercaAttivita(3, giorno, l, con);

		}
		else if (categoria.equals(saluteBenessere)) {
			ad.cercaAttivita(2, giorno, l, con);

       }
		else if (categoria.equals(bambini)) {
			ad.cercaAttivita(4, giorno, l, con);
			

	    }
		
	}
	
}
