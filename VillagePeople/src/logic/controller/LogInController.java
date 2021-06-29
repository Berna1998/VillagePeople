package logic.controller;

import java.sql.*;

import logic.bean.LoginBean;
import logic.bean.UtenteBean;
import logic.model.dao.UtenteDao;

import java.util.ArrayList;
import java.util.List;


public class LogInController {
	private UtenteDao ud = new UtenteDao();
	
	/*Questo metodo serve per aggiungere tutte le informazioni dell'utente in una lista di oggetti*/
	public void getInformazioni(List<Object> l, UtenteBean ub) {
		l.add(ub.getCodiceID());
		l.add(ub.getNome());
		l.add(ub.getCognome());
		l.add(ub.getEmail());
		l.add(ub.getBudget());
	}
	
	public void getInformazioniAdmin(List<Object> l, UtenteBean ub) {
		l.add(ub.getCodiceID());
		l.add(ub.getNome());
		l.add(ub.getCognome());
		l.add(ub.getEmail());
		l.add(ub.getNumeroUtenti());
	}
	
	public void logOut(Connection con) throws SQLException {
			ud.chiudiConnessione(con);
	}
	
	/* Questo metodo si occupa di verificare all'interno del DB il ruolo dell'utente che effettua il login (se presente)*/
	public int ritornaRuolo(LoginBean lb, Connection con) throws SQLException{
		String password = lb.getPassword();
		String codice = lb.getCodiceID();
		int role;
		role = ud.cercaRuolo(codice, password, con);
		return role;
	}
	
	public void setInfoAdmin(String codice, UtenteBean ub, Connection con) throws SQLException {
		ArrayList<Object> l2 = new ArrayList<>();
		ud.prelevaInfoAdmin(l2, codice, con);
		ub.setCodiceID(codice);
		ub.setNome(l2.get(0).toString());
	    ub.setCognome(l2.get(1).toString());
	    ub.setEmail(l2.get(2).toString());
		ub.setNumeroUtenti((int)l2.get(4));
	}
	
	/*Questo metodo setta le informazion del cliente che vediamo nella homepage*/
	public void setInfoCliente(String codice, UtenteBean ub, Connection con) throws SQLException {
		ArrayList<Object> l2 = new ArrayList<>();
		ud.prelevaInfoCliente(l2, codice, con);
		ub.setCodiceID(codice);
		ub.setNome(l2.get(0).toString());
	    ub.setCognome(l2.get(1).toString());
	    ub.setEmail(l2.get(2).toString());
		ub.setData((Date)l2.get(4));
		ub.setBudget((double)l2.get(5));
	}

	/*Questo metodo serve per settare i nuovi valori di email o password modificati dal client con l'apposito bottone*/
	public void setNewInfo(String email, String budget, Connection con) throws SQLException {
		ud.aggiornaInfo(email, budget, con);
	}

}
