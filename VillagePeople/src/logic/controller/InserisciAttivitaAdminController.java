package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.bean.AttivitaBean;
import logic.model.dao.AttivitaDao;

public class InserisciAttivitaAdminController extends AttivitaController {
	private AttivitaDao ad = new AttivitaDao();
	private String bambini = "Bambini";
	private String sport = "Sport";
	private String svagoRelax = "Svago&Relax";
	private String saluteBenessere = "Salute&Benessere";
	
	/*aggiungiAttivita comunica al database i parametri della nuova attivita da aggiungere tra le disponibili */
	public boolean aggiungiAttivita(AttivitaBean ab, Connection con) throws SQLException {
		int tipNum = 0;
		String tipologia = ab.getTipologia();
		String categoria = ab.getCategoria();
		String nome = ab.getNome();
		int codice = ab.getCodice();
		String orario = ab.getOrario();
		double prezzo = ab.getPrezzo();
		int partecipantiMax = ab.getPartecipantiMax();
		String giorno = ab.getGiorno();
		ArrayList<Object> l = new ArrayList<>();
		if (tipologia.equals("Singolo")) {
			tipNum = 1;
		} else if (tipologia.equals("Gruppo")) {
			tipNum = 2;
		}
		l.add(categoria);
	    l.add(giorno);
		l.add(tipNum);
		l.add(partecipantiMax);
		
		if (categoria.equals(sport)) {
		    l.set(0, 1);
		    ad.aggiungiAttivita(nome, codice, orario, prezzo, l, con);
		    return true;
		}
		else if (categoria.equals(svagoRelax)) {
			l.set(0, 3);
			ad.aggiungiAttivita(nome, codice, orario, prezzo, l, con);
			return true;
		}
		else if (categoria.equals(saluteBenessere)) {
			l.set(0, 2);
			ad.aggiungiAttivita(nome, codice, orario, prezzo, l, con);
			return true;
		}
		else if (categoria.equals(bambini)) {
			l.set(0, 4);
			ad.aggiungiAttivita(nome, codice, orario, prezzo, l, con);
			return true;
		}
		return false;
	}

}
