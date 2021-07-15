package logic.controller;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.bean.SignUpBean;
import logic.model.dao.UtenteDao;


public class SignUpController {
	
	private UtenteDao ud = new UtenteDao();
	
	/* Il seguente metodo viene invocato dal controller grafico a condizione che il metodo "controlloAssociazione" abbia restiuito
     * true. In tal caso, tale metodo invoca altre funzioni per completare l'aggiunta di un nuovo utente nel database del sistema */
	public boolean aggiungiContatto(SignUpBean sb, Connection con) throws SQLException {
		String nome = sb.getNome(); 
		String cognome = sb.getCognome();
		String codice = sb.getCodiceID();
		String email = sb.getEmail();
		String password = sb.getPassword();
		int giorni = sb.getGiorni();
		ud.aggiungiUtente(nome, cognome, codice, email, password, giorni, con);
		return true;
	}
	
	public void aggiungiNuovoCliente(SignUpBean sb, Connection con) throws SQLException {
		String nome = sb.getNome(); 
		String cognome = sb.getCognome();
		String codice = sb.getCodiceID();
		ud.inserisciNuovoCliente(nome, cognome, codice, con);
	}
	
	
	/* Il seguente metodo viene invocato dal controller grafico e controlla se nel database è presente l'utente che vuole 
	 * registrarsi al sistema */
	public boolean controlloAssociazione(SignUpBean sb, Connection con) throws SQLException{
		String nome = sb.getNome();
		String cognome = sb.getCognome();
		String codice = sb.getCodiceID();
		String nomequery= "";
		String cognomequery = "";
		String codicequery = "";
		ArrayList<Object> l = new ArrayList<>();
		ud.verificaAssociazione(l, nome, cognome, codice, con);
		codicequery = String.valueOf(l.get(0));
		nomequery = String.valueOf(l.get(1));
		cognomequery = String.valueOf(l.get(2));
		return (codicequery.equals(codice) && nomequery.equals(nome) && cognomequery.equals(cognome));		
	}

	public int controllaCodiceCliente(SignUpBean sb, Connection con) throws SQLException {
		int cod = 0;
		String codice = sb.getCodiceID();
		cod = ud.vediCodiceCliente(codice, con);
		return cod;
	}
	
	/* Il seguente metodo viene invocato dal controller grafico nel metodo "controllaCheckBox" e serve ad aggiungere nel database
	 * le preferenze indicate dal cliente durante il Sign Up*/
	public boolean verificaCategorie(SignUpBean sb, Connection con) throws SQLException {
		String codiceId = sb.getCodiceID();
		boolean sport = sb.isSport();
		boolean salutebenessere = sb.isSaluteBenessere();
		boolean svagorelax = sb.isSvagoRelax();
		boolean bambini = sb.isBambini();
		if (sport) {
			ud.inserisciPreferenze(codiceId, "1", con);
		}
		if (salutebenessere) {
			ud.inserisciPreferenze(codiceId, "2", con);
		}
		if (svagorelax) {
			ud.inserisciPreferenze(codiceId, "3", con);
		}
		if (bambini) {
			ud.inserisciPreferenze(codiceId, "4", con);
		}
		return true;
	}
}
