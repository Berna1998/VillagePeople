package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import logic.bean.AttivitaBean;
import logic.bean.UtenteBean;
import logic.model.dao.AttivitaDao;

public class PrenotazioneAttivitaController extends AttivitaController {
	private AttivitaDao ad = new AttivitaDao();
	private String bambini = "Bambini";
	private String sport = "Sport";
	private String svagoRelax = "Svago&Relax";
	private String saluteBenessere = "Salute&Benessere";
	
	/* Il seguente metodo viene invocato dal controller grafico e permette
	 * di aggiungere la prenotazione per una determinata attività */
	public boolean aggiungiPrenotazione(AttivitaBean ab, UtenteBean ub, Connection con) throws SQLException {
		String codiceId = ub.getCodiceID();
		String codiceAtt = String.valueOf(ab.getCodice());
		ad.inserisciPrenotazione(codiceId, codiceAtt, con);
		return true;
	}
	
	/*verificaAttivita cerca le attivita singole della categoria e giorno scelti dall'utente*/
	public void verificaAttivita(AttivitaBean ab, List<Object> l, UtenteBean ub, Connection con) throws SQLException {
		String categoriaAtt = ab.getCategoria();
		String giornoAtt= ab.getGiorno();
		double budget = ub.getBudget();
		if (categoriaAtt.equals(sport)) {
			ad.cercaAttivitaCliente(1, giornoAtt, budget , l, con);		    
		}
		else if (categoriaAtt.equals(svagoRelax)) {
			ad.cercaAttivitaCliente(3, giornoAtt, budget , l, con);
		}
		else if (categoriaAtt.equals(saluteBenessere)) {
			ad.cercaAttivitaCliente(2, giornoAtt, budget , l, con);
        }
		else if (categoriaAtt.equals(bambini)) {
			ad.cercaAttivitaCliente(4, giornoAtt, budget , l, con);
	    }
	}
	
	/*verificaAttivita cerca le attivita di gruppo della categoria e giorno scelti dall'utente*/
	public void verificaAttivitaGruppo(AttivitaBean ab, List<Object> l, UtenteBean ub, Connection con) throws SQLException {
		double budget = ub.getBudget();
		String giorno = ab.getGiorno();
		String categoria = ab.getCategoria();
		if (categoria.equals("Sport")) {	
			ad.cercaAttivitaGruppo(1, giorno, budget, l, categoria, con);
		}
		else if (categoria.equals(svagoRelax)) {
			ad.cercaAttivitaGruppo(3, giorno, budget, l, categoria, con);	
		}
		else if (categoria.equals(saluteBenessere)) {
			ad.cercaAttivitaGruppo(2, giorno, budget, l, categoria, con);
        }
		else if (categoria.equals(bambini)) {
			ad.cercaAttivitaGruppo(4, giorno, budget, l, categoria, con);
		
	    }	
	}	
}
