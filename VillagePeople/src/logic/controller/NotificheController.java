package logic.controller;


import java.sql.Connection;
import java.sql.SQLException;

import logic.model.dao.NotificheDao;


public class NotificheController {
	private NotificheDao nd = new NotificheDao();
	
	public void comunicaNotificaAttivitaGruppo(String notifica, int numero, int codiceAtt, Connection con) throws SQLException {
		nd.aggiungiNotificaAttivitaGruppo(notifica, numero, codiceAtt, con);
	}
	
	public void comunicaNotificaEliminaAttivita(String notifica, int numero, int codiceAtt, Connection con) throws SQLException {
		nd.aggiungiNotificaEliminaAttivita(notifica, numero, codiceAtt, con);
	}
	
	public void comunicaNotificaIntolleranze(String notifica5, Connection con) throws SQLException {
		 nd.aggiungiNotificaIntolleranze(notifica5, con);
	}

	public void comunicaNotificaMenuAdmin(String notifica1, Connection con) throws SQLException {
	    nd.aggiungiNotificaMenuAdmin(notifica1, con);
	}
	
	public void comunicaNotificaModificaAttivita(String notifica, int numero, int codiceAtt, Connection con) throws SQLException {
		nd.aggiungiNotificaModificaAttivita(notifica, numero, codiceAtt, con);
	}
	
	public void comunicaNotificaPenale(String notifica6, Connection con) throws SQLException {
		 nd.aggiungiNotificaPenale(notifica6, con);	
	}
	
	public void comunicaNotificaPostoLibero(String notifica7, int nAtt, int cod, Connection con) throws SQLException {
		nd.aggiungiNotificaPostoLibero(notifica7, nAtt, cod, con);	
	}
	
	public String prendiNotificaAttivitaGruppo(String s, Connection con) throws SQLException {
		String notifica = "";	
		notifica = nd.prelevaNotificaAttivitaGruppo(s, con);
		return notifica;
    }
	
	public String prendiNotificaEliminaAttivita(String s, Connection con) throws SQLException {
		String notifica = "";	
		notifica = nd.prelevaNotificaEliminaAttivita(s, con);
		return notifica;
	}
	
	public String prendiNotificaIntolleranze(Connection con) throws SQLException {
		String notifica = "";	
		notifica = nd.prelevaNotificaIntolleranze(con);
		return notifica;
	}

	public String prendiNotificaMenu(Connection con) throws SQLException {
		String notifica = "";	
		notifica = nd.prelevaNotificaMenu(con);
		return notifica;
	}
	
	public String prendiNotificaModificaAttivita(String s, Connection con) throws SQLException {
		String notifica = "";	
		notifica = nd.prelevaNotificaModificaAttivita(s, con);
		return notifica;
    }

	public String prendiNotificaPenale(Connection con) throws SQLException {
		String notifica = "";	
		notifica = nd.prelevaNotificaPenale(con);
		return notifica;
	}

	public String prendiNotificaPostoLibero(String s, Connection con) throws SQLException {
		String notifica = "";	
		notifica = nd.prelevaNotificaPostoLibero(s, con);
		return notifica;
	}

}
