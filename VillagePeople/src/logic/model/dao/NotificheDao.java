package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificheDao {
	private Statement ps = null;
	private Statement ps1 = null;
	private QueryDB qd = new QueryDB();
	
	public void aggiungiNotificaModificaAttivita(String notifica, int numero, int codiceAtt, Connection con) throws SQLException {
		String query = qd.inserisciNotificaModificaAttivita(notifica, numero, codiceAtt);
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
	}

	public String prelevaNotificaModificaAttivita(String s, Connection con) throws SQLException {
		String notifica = "";
		String query = qd.prelevaNotificaModificaAttivita(s);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);

		notifica = concatenaNot(rs,2,con);
		rs.close();
        ps.close();
        return notifica;
		
	}

	public void aggiungiNotificaEliminaAttivita(String notifica, int numero, int codiceAtt, Connection con) throws SQLException {
		ps = con.createStatement();
		ps1 = con.createStatement();
		String codiceUt = "";
		String query = qd.ottieniPrenotati(codiceAtt);
		ResultSet rs = ps.executeQuery(query);
		while(rs.next()) {
			codiceUt = rs.getString(1);
		    String query1 = qd.inserisciNotificaEliminaAttivita(notifica, numero, codiceAtt, codiceUt);
	        ps1.executeUpdate(query1);
		}
		rs.close();
		
        ps.close();
        ps1.close();
		
	}

	public String prelevaNotificaEliminaAttivita(String s, Connection con) throws SQLException {
		ps = con.createStatement();
		String notifica = "";
		String query = qd.prelevaNotificaEliminaAttivita(s);
		ResultSet rs = ps.executeQuery(query);
		notifica = concatenaNot(rs,2,con);

		rs.close();
        ps.close();
	    return notifica;
	}

	public void aggiungiNotificaAttivitaGruppo(String notifica, int numero, int codiceAtt, Connection con) throws SQLException {
		ps = con.createStatement();
		String query = qd.queryInserisciNotificaAttivitaGruppo(notifica, numero, codiceAtt);
		ps.executeUpdate(query);
        ps.close();
			
	}

	public String prelevaNotificaAttivitaGruppo(String s, Connection con) throws SQLException {
		ps = con.createStatement();
		String notifica = "";
		String query = qd.queryPrelevaNotificaAttivitaGruppo(s);
		ResultSet rs = ps.executeQuery(query);
		notifica = concatenaNot(rs, 1, con);
		rs.close();
        ps.close();

		return notifica;
	}

	public void aggiungiNotificaMenuAdmin(String notifica1, Connection con) throws SQLException {
		ps = con.createStatement();
		String query = qd.queryInserisciNotificaMenuAdmin(notifica1);
	    ps.executeUpdate(query);
        ps.close();
		
	}

	public void aggiungiNotificaIntolleranze(String notifica5, Connection con) throws SQLException {
		ps = con.createStatement();
		String query = qd.queryInserisciNotificaIntolleranze(notifica5);
	    ps.executeUpdate(query);
        ps.close();
		
	}

	public void aggiungiNotificaPenale(String notifica6, Connection con) throws SQLException {
		ps = con.createStatement();
		String query = qd.queryInserisciNotificaPenale(notifica6);
	    ps.executeUpdate(query);
        ps.close();
	}

	public String prelevaNotificaIntolleranze(Connection con) throws SQLException {
		ps = con.createStatement();
		String notifica = "";
		String query = qd.queryPrelevaNotificaIntolleranze();
		ResultSet rs = ps.executeQuery(query);	
		while(rs.next()) {	
			notifica = notifica.concat(rs.getString(1));
			notifica = notifica.concat("\n ");
	    }
		rs.close();
        ps.close();
		return notifica;
	}

	public String prelevaNotificaPenale(Connection con) throws SQLException {
		ps = con.createStatement();
		String notifica = "";
		String query = qd.queryPrelevaNotificaPenale();
		ResultSet rs = ps.executeQuery(query);	
		while(rs.next()) {	
			notifica = notifica.concat(rs.getString(1));
			notifica = notifica.concat("\n ");
	    }
		rs.close();
        ps.close();
		return notifica;
	}

	public String prelevaNotificaMenu(Connection con) throws SQLException {
		ps = con.createStatement();
		String notifica = "";
		String query = qd.queryPrelevaNotificaMenu();
		ResultSet rs = ps.executeQuery(query);
		while(rs.next()) {	
				notifica = rs.getString(1);
		}
		rs.close();
        ps.close();
		return notifica;
	}

	public void aggiungiNotificaPostoLibero(String notifica7, int nAtt, int cod, Connection con) throws SQLException {
		ps = con.createStatement();
		String query = qd.queryInserisciNotificaPostoLibero(notifica7, nAtt, cod);
		ps.executeUpdate(query);
        ps.close();
	}

	public String prelevaNotificaPostoLibero(String s, Connection con) throws SQLException {	
		ps = con.createStatement();
		String notifica = "";
		String query = qd.queryPrelevaNotificaPostoLibero(s);
		ResultSet rs = ps.executeQuery(query);
		
		notifica = concatenaNot(rs,3,con);

		rs.close();
	    ps.close();

		return notifica;
		
	}
	
	public String concatenaNot(ResultSet rs, int tipo, Connection con ) throws SQLException {
		
		String notifica = "";
		String prendiNot = "";
		String prendiCod = "";
		int numPart;
		if(tipo == 1) {
			ps1= con.createStatement();
			while(rs.next()) {	
				prendiNot = rs.getString(1);
				prendiCod = String.valueOf(rs.getInt(2));
				String query2 = qd.queryPrelevaNumPrenotati(prendiCod);
				ResultSet rs1 = ps1.executeQuery(query2);	
				rs1.next();
				numPart = rs1.getInt(1);
				if(numPart>=2) {
					notifica = notifica.concat(prendiNot);
					notifica = notifica.concat(" - ");
					notifica = notifica.concat(prendiCod);
					notifica = notifica.concat(" - Numero Partecipanti: ");
					notifica = notifica.concat(String.valueOf(numPart));
					notifica = notifica.concat("\n ");
				}
				rs1.close();
			}
			 ps1.close();
		} else if (tipo == 2) {

			while(rs.next()) {	
				prendiNot = rs.getString(1);
				prendiCod = String.valueOf(rs.getInt(2));
				notifica = notifica.concat(prendiNot);
				notifica = notifica.concat(" - ");
				notifica = notifica.concat(" Codice attivita: ");
				notifica = notifica.concat(prendiCod);
				notifica = notifica.concat("\n ");
		    }
		} else if (tipo == 3) {
			ps1 = con.createStatement();
			while(rs.next()) {	
				prendiNot = rs.getString(1);
				prendiCod = String.valueOf(rs.getInt(2));
				String query2 = qd.queryPrelevaNumPrenotati(prendiCod);
				ResultSet rs1 = ps1.executeQuery(query2);	
				rs1.next();
				numPart = rs1.getInt(1);
				notifica = notifica.concat(prendiNot);
				notifica = notifica.concat(" - ");
				notifica = notifica.concat(prendiCod);
				notifica = notifica.concat(" - Nuovi Partecipanti: ");
				notifica = notifica.concat(String.valueOf(numPart));
				notifica = notifica.concat("\n ");
				rs1.close();
		    }
			ps1.close();
		}
	
		 return notifica;
	}
}
