package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import logic.model.entity.AttivitaEntity;
import logic.model.entity.PrenotazioniEntity;

public class AttivitaDao {
	private Statement ps = null;
	private Statement ps1 = null;
	private QueryDB qd = new QueryDB();
	private AttivitaEntity ae = new AttivitaEntity();
	
	public void aggiungiAttivita(String nome, int codice, String orario, double prezzo, List<Object> l, Connection con) throws SQLException {
		ae.setNome(nome);
		ae.setCodice(codice);
		ae.setOrario(orario);
		ae.setPrezzo(prezzo);
		ae.setPartecipantiMax(Integer.valueOf(l.get(3).toString()));
		ae.setCategoria(l.get(0).toString());
		ae.setGiorno(l.get(1).toString());
		ae.setTipologia(l.get(2).toString());	
		String query = qd.queryInserisciAttivita(ae.getNome(), ae.getCodice(), ae.getOrario(), ae.getPrezzo(), ae.getPartecipantiMax(), l);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
		
	}
	
	public void cercaAttivita(int tipo, String giorno, List<Object> l, Connection con) throws SQLException{
		int codice = 0;
		String nome = "";
		String orario = "";
		double prezzo;
		String query = qd.cercaAttivitaAdmin(tipo, giorno);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while(rs.next()) {
			codice = rs.getInt(1);
			nome = rs.getString(2);
			orario = rs.getString(3);
			prezzo = rs.getDouble(4);
		    ae.setCodice(codice);
		    ae.setNome(nome);
		    ae.setOrario(orario);
		    ae.setPrezzo(prezzo);
			l.add(ae.getCodice());
			l.add(ae.getNome());
			l.add(ae.getOrario());
			l.add(ae.getPrezzo());

		}
		
		rs.close();
        ps.close();
	}
	
	public void aggiornaAttivita(String codice, String orario, double prezzo, Connection con) throws SQLException {
		ae.setCodice(Integer.parseInt(codice));
	    ae.setOrario(orario);
	    ae.setPrezzo(prezzo);
		String query = qd.modificaAttivita(String.valueOf(ae.getCodice()), ae.getOrario(), ae.getPrezzo());
		ps = con.createStatement();
		ps.executeUpdate(query);	
        ps.close();
		
	}
	

	public void eliminaPrenotazioni(int codice, Connection con) throws SQLException {
		
		String codiceAtt = String.valueOf(codice);
		String query = qd.cancellaPrenotazioni(codiceAtt);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
		
	}

	public void eliminaAttivita(int codice, Connection con) throws SQLException {
		String codiceAtt = String.valueOf(codice);
		String query = qd.cancellaAttivita(codiceAtt);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
		
	}
	
	public void cercaAttivitaCliente(int numCat, String giornoAtt, double budget, List<Object> l, String categoriaAtt, Connection con) throws SQLException {
		String query = qd.queryCercaAttivita(numCat, giornoAtt, budget);
		int codice;
		String nome;
		String orario;
		double prezzo;
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			codice = rs.getInt(1);
			nome = rs.getString(2);
			orario = rs.getString(3);
			prezzo = rs.getDouble(4);
			ae.setCategoria(categoriaAtt);
		    ae.setCodice(codice);
		    ae.setNome(nome);
		    ae.setOrario(orario);
		    ae.setPrezzo(prezzo);
		    l.add(ae.getCodice());
		    l.add(ae.getNome());
		    l.add(ae.getOrario());
		    l.add(ae.getPrezzo());			
		}
		
		rs.close();
        ps.close();
	}

	public void inserisciPrenotazione(String codiceId, String codiceAtt, Connection con) throws SQLException {
		PrenotazioniEntity pe = new PrenotazioniEntity();
		pe.setCodiceCliente(codiceId);
		pe.setCodiceAtt(Integer.parseInt(codiceAtt));
		String query = qd.queryInserisciPrenotazione(codiceId, codiceAtt);
		ps1 = con.createStatement();
		ps1.executeUpdate(query);
        ps1.close();
		
	}
	
	public void aggiornaBudget(double budget, String codiceId, Connection con) throws SQLException {
		String query = qd.queryAggiornaBudget( budget,codiceId);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
	}
	

	public void cercaAttivitaGruppo(int numCat, String giorno, double budget, List<Object> l, String categoria, Connection con) throws SQLException {
		String query = qd.queryCercaAttivitaGruppo(numCat, giorno, budget);
		int codice;
		String nome;
		String orario;
		double prezzo;
		int partecipantiMax;
		int partecipantiAttuali;
		ps = con.createStatement();
		ps1 = con.createStatement(); /* Questo Statement è stato creato per poter contare i partecipanti di ogni attività di gruppo
		                                            nel momento stesso in cui l'attività è presa   */
		
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			codice=rs.getInt(1);
			nome=rs.getString(2);
			orario=rs.getString(3);
			prezzo=rs.getDouble(4);
			partecipantiMax=rs.getInt(5);
		    query=qd.contaPrenotati(codice);
		    ResultSet rs1=ps1.executeQuery(query);
		    rs1.next();
		    partecipantiAttuali=rs1.getInt(1);
			ae.setCategoria(categoria);
		    ae.setCodice(codice);
		    ae.setNome(nome);
		    ae.setOrario(orario);
		    ae.setPrezzo(prezzo);
		    ae.setPartecipantiMax(partecipantiMax);	
		    l.add(ae.getCodice());
		    l.add(ae.getNome());
		    l.add(ae.getOrario());
		    l.add(ae.getPrezzo());
		    l.add(partecipantiAttuali);
		    l.add(ae.getPartecipantiMax());
		    rs1.close();
		}
        ps.close();
        ps1.close();
        rs.close();	
		
	}


	public void ricercaPrenotazioni(String codiceS, List<Object> l, int categoria, Connection con) throws SQLException {
		String query = qd.queryOttieniPrenotazioni(codiceS, categoria);
		int codice;
		String nome;
		String giorno;
		String orario;
		double prezzo;
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
	
		while(rs.next()) {
			codice = rs.getInt(1);
			nome = rs.getString(2);
			orario = rs.getString(3);
			prezzo = rs.getDouble(4);
			giorno = rs.getString(5);
		    ae.setCodice(codice);
		    ae.setNome(nome);
		    ae.setOrario(orario);
		    ae.setPrezzo(prezzo);
		    ae.setGiorno(giorno);
			l.add(ae.getCodice());
			l.add(ae.getNome());
			l.add(ae.getOrario());
			l.add(ae.getPrezzo());
			l.add(ae.getGiorno());
	    
       }
        	
        ps.close();
        rs.close();
				
	}
	

	public void eliminaPrenotazione(String codice, int codiceAtt, Connection con) throws SQLException {
		String query = qd.queryCancellaPrenotazione(codice, codiceAtt);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
		
	}

	public void prelevaPrenotati(int codiceAtt, List<Object> listaCli, Connection con) throws SQLException {
		String query = qd.queryCercaPrenotati(codiceAtt);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			listaCli.add(rs.getString(1));		
		}
		
		rs.close();
        ps.close();

	}

	public void eliminaNotificheAttivita(int codice, Connection con) throws SQLException {
		String codiceAtt = String.valueOf(codice);
		String query = qd.queryCancellaNotificheAttivita(codiceAtt);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
	}

	public double trovaBudget(String cod, Connection con) throws SQLException {
		double budget=0.0;
		String query = qd.queryCercaBudget(cod);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			budget= rs.getDouble(1);		
		}
		
		rs.close();
		ps.close();
		
		return  budget;
	}


}
