package logic.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import logic.model.entity.Cliente;
import logic.model.entity.Utente;

public class UtenteDao {
	private Statement ps = null;
	private QueryDB qd = new QueryDB();
	private Cliente c = new Cliente();
	private Utente u = new Utente();
	
	public void verificaAssociazione(List<Object> l, String nome, String cognome, String codice, Connection con) throws SQLException{
		String nomequery = "";
		String cognomequery = "";
		String codicequery = "";
	    String query = qd.queryControlloAssociazione(codice, nome, cognome);
	    ps = con.createStatement();
	    ResultSet rs = ps.executeQuery(query);

		while(rs.next()) {	
				codicequery = rs.getString(1);
				nomequery = rs.getString(2);
				cognomequery = rs.getString(3);
		}
		l.add(codicequery);
		l.add(nomequery);
		l.add(cognomequery);     
	    rs.close();
	    ps.close();
       	
	}
	
	public void aggiungiUtente(String nome, String cognome, String codice, String email, String password, int giorni, Connection con) throws SQLException {
		c.setNome(nome);
		c.setCognome(cognome);
		c.setCodiceID(codice);
		c.setEmail(email);
		c.setPassword(password);
		c.setGiorniPermanenza(giorni);
		ps = con.createStatement();
		
		String query2=qd.queryAggiungiUtente(c.getNome(), c.getCognome(), c.getCodiceID(), c.getEmail(), c.getPassword(), c.getGiorniPermanenza());
		
	    ps.executeUpdate(query2);
	    String query3=qd.queryEliminaCodiceDisponibile(c.getCodiceID());
	    ps.executeUpdate(query3);
        ps.close();
	}
	
	public int cercaRuolo(String codice, String password, Connection con) throws SQLException {
		 int ruolo = 3;
	     String query = qd.queryRuolo(codice, password);
	     ps = con.createStatement();
	     ResultSet rs = ps.executeQuery(query);
	     while(rs.next()) {	
				ruolo=rs.getInt(1);
		 }
	     rs.close();
	     ps.close();
			
	     return ruolo;
	}
	
	public void inserisciPreferenze(String codiceCliente, String numeroAttivita, Connection con) throws SQLException {
		 if (numeroAttivita.equals("1")) {
			 c.setSport(true);
		 }
         if (numeroAttivita.equals("2")) {
        	 c.setSaluteBenessere(true);
		 }
         if (numeroAttivita.equals("3")) {
        	 c.setSvagoRelax(true);
         }
         if (numeroAttivita.equals("4")) {
        	 c.setBambini(true);
         }
	     String query = qd.queryInserisciPreferenze(codiceCliente, numeroAttivita);
	     ps = con.createStatement();
         ps.executeUpdate(query);
    	 ps.close();
	
     }
	
	public void prelevaInfoCliente(List<Object> l2, String codice, Connection con) throws SQLException {
		String nome = "";
		String cognome = "";
		String email = "";
		int ruolo = 3;
		Date dataFine = null;
		double budget = 0;
		String query = qd.queryInfoUtente(codice);
		ps = con.createStatement();
	    ResultSet rs = ps.executeQuery(query);
	    while(rs.next()) {	
			nome = rs.getString(1);
			cognome = rs.getString(2);
			email = rs.getString(3);
			ruolo = rs.getInt(4);
			dataFine = rs.getDate(5);
			budget = rs.getDouble(6);
			
		}
	    rs.close();
	    ps.close();
	    c.setCodiceID(codice);
		c.setNome(nome);
		c.setCognome(cognome);
		c.setEmail(email);
		c.setRole(ruolo);
		c.setData(dataFine);
		c.setBudget(budget);
		
	    l2.add(0, c.getNome());
	    l2.add(1, c.getCognome());
	    l2.add(2, c.getEmail());
	    l2.add(3, c.getRole());
	    l2.add(4, c.getData());
	    l2.add(5, c.getBudget());
		
	}
	
	public void prelevaInfoAdmin(List<Object> l2, String codice, Connection con) throws SQLException {
		String nome = "";
		String cognome = "";
		String email = "";
		int ruolo = 3;
		int numeroUtenti = 0;
		String query = qd.queryInfoUtente(codice);
		ps = con.createStatement();
	    ResultSet rs = ps.executeQuery(query);
	    while(rs.next()) {	
			nome = rs.getString(1);
			cognome = rs.getString(2);
			email = rs.getString(3);
			ruolo = rs.getInt(4);
			
		}
	    rs.close();
	    query = qd.queryNumeroUtenti();
	    ResultSet rs2 = ps.executeQuery(query);
	    while(rs2.next()) {	
	    	numeroUtenti = rs2.getInt(1);			
		}
	    rs2.close();
        ps.close();
	    u.setCodiceID(codice);
		u.setNome(nome);
		u.setCognome(cognome);
		u.setEmail(email);
		u.setRole(ruolo);
		
		
	    l2.add(0, u.getNome());
	    l2.add(1, u.getCognome());
	    l2.add(2, u.getEmail());
	    l2.add(3, u.getRole());
		l2.add(4, numeroUtenti);
	}
	
	public void aggiornaInfo(String email, String budget, Connection con) throws SQLException {
		String query = qd.querySetNewInfo(email, budget, c.getCodiceID());

		ps = con.createStatement();
	    ps.executeUpdate(query);
	    c.setEmail(email);
	    double budget2 = Double.parseDouble(budget);
	    c.setBudget(budget2);
        ps.close();
	}
	
	public void chiudiConnessione(Connection con) throws SQLException {
		 if (con != null) {
	            con.close();
	     }
	}

	public void inserisciNuovoCliente(String nome, String cognome, String codice, Connection con) throws SQLException {
		String query = qd.queryInserimentoCliente(nome, cognome, codice);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
		
	}

	public int vediCodiceCliente(String codice, Connection con) throws SQLException {
		int cod = 0;
	    String query = qd.queryPrendiCodice(codice);
	    ps = con.createStatement();
	    ResultSet rs = ps.executeQuery(query);

	    while(rs.next()) {	
				cod=rs.getInt(1);
		}
   
	    rs.close();    	
	    ps.close();
	    return cod;
	}

}
