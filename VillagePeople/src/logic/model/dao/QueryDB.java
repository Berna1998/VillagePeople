package logic.model.dao;


import java.util.List;

public class QueryDB {
	
	private String query;
	private String dataCorrente = "CURDATE()";
	
	public String queryInserisciPreferenze(String codiceID, String attivita) {
		query = "INSERT INTO preferenzeutente(CodiceUtente, CodiceAttivitaPreferita) VALUES('"+codiceID+"','"+attivita+"')";
		return query;
	}
	
	public String queryRuolo(String codice, String password) {
		query = "SELECT Ruolo FROM utente WHERE CodiceID='"+codice+"' AND Password='"+password+"'";
		return query;
	}
	public String queryInfoUtente(String codice) {
		query = "SELECT Nome, Cognome, Email, Ruolo, DataFineSoggiorno, Budget FROM utente where CodiceID='"+codice+"'";
		return query;
	}
	
	public String queryNumeroUtenti() {
		query = "SELECT COUNT(*) FROM utente where Ruolo=1";
		return query;
	}
	
	public String querySetNewInfo(String email, String budget, String codice) {
		query = "UPDATE Utente SET Email='"+email+"', Budget='"+budget+"' WHERE CodiceID='"+codice+"'";
		return query;
	}
	
	public String queryControlloAssociazione(String codice, String nome, String cognome) {
		query = "SELECT CodiceID, NomeUtente, CognomeUtente FROM villagepeople.codicidisponibili WHERE CodiceID='"+codice+"' AND NomeUtente='"+nome+"' AND CognomeUtente='"+cognome+"'";
		return query;
	}
	
	public String queryAggiungiUtente(String nome, String cognome, String codice, String email, String password, int giorni) {
		query = "INSERT INTO Utente(CodiceID, Nome, Cognome, Email, Password, DataFineSoggiorno, Ruolo) VALUES ('"+codice+"', '"+nome+"', '"+cognome+
				"', '"+email+"', '"+password+"', DATE_ADD(CURDATE(), INTERVAL "+giorni+" DAY), 1)";
		return query;
	}
	
	public String queryEliminaCodiceDisponibile(String codice) {
		query = "DELETE FROM codicidisponibili WHERE CodiceID='"+codice+"'";
		return query;
	}
	
	public String queryAggiungiMenu(int numero, String menu) {
		query = "INSERT INTO menu(codice,descrizione,data) VALUES ("+numero+", '"+menu+"',"+dataCorrente+")";
		return query;
	}
	
	public String queryCancellaMenu(int codice) {
		query = "DELETE FROM menu WHERE codice='"+codice+"' AND data=CURDATE()";
		return query;
	}
	
	public String queryPrendiMenu(int numero) {
		query = "SELECT descrizione FROM menu WHERE data=CURDATE() AND codice="+numero;
		return query;
	}
	
	public String queryAssociaMenu(String codiceCliente, int menuScelto) {
			query = "INSERT INTO menuPrenotati(codice, menu, data) VALUES ('"+codiceCliente+"', '"+menuScelto+"', "+dataCorrente+")";
		return query;
	}
	
	public String queryAssociaIntolleranze(String codiceCliente, String intolleranze, int menuScelto) {
		
			query = "INSERT INTO intolleranze(codiceCli, intolleranza, data, numMenu) VALUES ('"+codiceCliente+"', '"+intolleranze+"', "+dataCorrente+",'"+menuScelto+"')";

		return query;
	}
	
	public String queryCalcolaMenu(int numero) {
		query = "SELECT COUNT(*) FROM menuprenotati WHERE menu="+numero+" AND data = "+dataCorrente;
		return query;
	}
	public String queryCalcolaIntolleranze(int numero) {
		query = "SELECT COUNT(*) FROM intolleranze WHERE numMenu="+numero+" AND data = "+dataCorrente; 
		return query;
	}
	
	public String memorizzaElenco(int numero) {
		query = "SELECT intolleranza, codiceCli FROM intolleranze WHERE numMenu="+numero+" AND data ="+dataCorrente;
	    return query;
	}
	
	public String queryCercaAttivita(int codiceCategoria, String giornoAtt, double budget) {
		query = "SELECT CodiceAttivita, NomeAttivita, orario, Prezzo FROM attivita WHERE CategoriaAttivita="+codiceCategoria+" AND giorno='"+giornoAtt+"' AND Prezzo <= "+budget+"";
	    return query;
	}
	public String queryInserisciAttivita(String nomeAtt, int codiceAtt, String orarioAtt, double prezzoAtt, int partecipantiMax, List<Object> l) {
		int tipologia=(Integer)l.get(2);
		int categoriaAtt=(Integer)l.get(0);
		String giornoAtt=l.get(1).toString();
		if (tipologia == 1) {
		   query = "INSERT INTO attivita(CodiceAttivita, NomeAttivita, Prezzo, CategoriaAttivita, giorno, orario, tipologia) VALUES("+codiceAtt+", '"+nomeAtt+"', "+prezzoAtt+", "+categoriaAtt+", '"+giornoAtt+"', '"+orarioAtt+"',"+tipologia+")";
		} else {
		   query = "INSERT INTO attivita(CodiceAttivita, NomeAttivita, Prezzo, CategoriaAttivita, giorno, orario, tipologia,numPartecipantiMax) VALUES("+codiceAtt+", '"+nomeAtt+"', "+prezzoAtt+", "+categoriaAtt+", '"+giornoAtt+"', '"+orarioAtt+"',"+tipologia+","+partecipantiMax+")";	
		}
		return query;
	}
	
	public String queryInserisciPrenotazione(String codiceId, String codiceAtt) {
		query = "INSERT INTO prenotazioniattivita(CodiceUtente,CodiceAttivita) VALUES('"+codiceId+"','"+codiceAtt+"')";
		return query;
	}
	public String queryAggiornaBudget(double budget, String codiceId) {
		query = "UPDATE utente SET Budget="+budget+" WHERE CodiceID='"+codiceId+"'";
		return query;
	}
	
	public String cercaAttivitaAdmin(int codiceCategoria, String giorno) {
		query = "SELECT CodiceAttivita, NomeAttivita, orario, Prezzo FROM attivita WHERE CategoriaAttivita="+codiceCategoria+" AND giorno='"+giorno+"'";
		return query;
	}
	
	public String modificaAttivita(String codice, String orario, double prezzo) {
		query = "UPDATE attivita SET orario='"+orario+"',Prezzo="+prezzo+" WHERE CodiceAttivita='"+codice+"'";
		return query;
	}

	public String cancellaAttivita(String codice) {
		query = "DELETE FROM attivita WHERE CodiceAttivita='"+codice+"'";
		return query;
	}

	public String cancellaPrenotazioni(String codice) {
		query = "DELETE FROM prenotazioniattivita WHERE CodiceAttivita='"+codice+"'";
		return query;
	}

	public String queryOttieniPrenotazioni(String codiceCliente, int categoria) {
		
		query = "SELECT a.CodiceAttivita,a.NomeAttivita,a.orario,a.Prezzo,a.giorno FROM attivita AS a, prenotazioniattivita AS pa WHERE a.CodiceAttivita=pa.CodiceAttivita AND pa.CodiceUtente='"+codiceCliente+"' AND a.CategoriaAttivita="+categoria;
		return query;
	}
	
	public String queryCancellaPrenotazione(String codiceCli, int codiceAtt) {
		query = "DELETE FROM prenotazioniattivita WHERE CodiceAttivita='"+codiceAtt+"' AND CodiceUtente='"+codiceCli+"'";
		return query;
	}

	public String queryCercaAttivitaGruppo(int codiceCategoria, String giorno, double budget) {
		query = "SELECT CodiceAttivita, NomeAttivita, orario, Prezzo, numPartecipantiMax FROM attivita WHERE Prezzo <= "+budget+" AND CategoriaAttivita='"+codiceCategoria+"' AND giorno='"+giorno+"' AND numPartecipantiMax IS NOT NULL";
		return query;
	}

	public String contaPrenotati(int codice) {
		query = "SELECT COUNT(*) FROM prenotazioniattivita WHERE CodiceAttivita='"+codice+"'";
		return query;
	}
	
	public String queryInserisciNotificaMenuAdmin(String notifica1) {
		int numero = 1;
		query = "INSERT INTO notifiche(Notifiche, tipoNotifica,data) VALUES ('"+notifica1+"', "+numero+",CURDATE())";
		return query;
	}
	
	public String queryPrelevaNotificaMenu() {
		query="SELECT Notifiche FROM notifiche WHERE tipoNotifica=1 AND data=CURDATE()";
		return query;
	}
	
	public String inserisciNotificaModificaAttivita(String notifica, int numeroCat, int codiceAttivita) {
		int numero = 2;
		query = "INSERT INTO notifiche(Notifiche, IdCategoria, tipoNotifica, codiceAttivita, data) VALUES ('"+notifica+"', "+numeroCat+", "+numero+", '"+codiceAttivita+"', CURDATE())";
        return query;
	}
	
	public String prelevaNotificaModificaAttivita(String codice) {
		query = "SELECT n.Notifiche,n.codiceAttivita FROM notifiche AS n JOIN prenotazioniattivita AS p ON n.codiceAttivita=p.CodiceAttivita WHERE p.CodiceUtente='"+codice+"' AND n.tipoNotifica=2 AND n.data>=SUBDATE(CURDATE(), INTERVAL 3 DAY)";
	    return query;
	}

	public String inserisciNotificaEliminaAttivita(String notifica, int numeroCat, int codiceAttivita, String codiceUt) {
		int numero = 3;
		query = "INSERT INTO notifiche(Notifiche, IdCategoria, tipoNotifica, codiceAttivita, data, IdUtente) VALUES ('"+notifica+"', "+numeroCat+", "+numero+", '"+codiceAttivita+"', CURDATE(),'"+codiceUt+"')";
        return query;
	}

	public String prelevaNotificaEliminaAttivita(String codice) {
		query = "SELECT Notifiche,codiceAttivita FROM notifiche WHERE IdUtente='"+codice+"' AND tipoNotifica=3 AND data>=SUBDATE(CURDATE(), INTERVAL 3 DAY)";
	    return query;
	}

	public String ottieniPrenotati(int codiceAtt) {
		query = "SELECT p.CodiceUtente FROM prenotazioniattivita AS p WHERE p.CodiceAttivita="+codiceAtt;
		return query;
	}

	public String queryInserisciNotificaAttivitaGruppo(String notifica, int numeroCat, int codiceAttivita) {
		int numero = 4;
		query = "INSERT INTO notifiche(Notifiche, IdCategoria, tipoNotifica, codiceAttivita, data) VALUES ('"+notifica+"', "+numeroCat+", "+numero+", '"+codiceAttivita+"', CURDATE())";
        return query;
	}

	public String queryPrelevaNotificaAttivitaGruppo(String codice) {
		query = "SELECT DISTINCT n.Notifiche,n.codiceAttivita FROM notifiche AS n JOIN prenotazioniattivita AS p ON n.codiceAttivita=p.CodiceAttivita WHERE p.CodiceUtente='"+codice+"' AND n.tipoNotifica=4 AND n.data>=SUBDATE(CURDATE(), INTERVAL 3 DAY)";
	    return query;
	}

	public String queryPrelevaNumPrenotati(String codAtt) {
		query = "SELECT COUNT(*) FROM prenotazioniattivita WHERE CodiceAttivita='"+codAtt+"'";
		return query;
	}

	public String queryInserisciNotificaIntolleranze(String notifica5) {
		int numero = 5;
		query = "INSERT INTO notifiche(Notifiche, tipoNotifica,data) VALUES ('"+notifica5+"', "+numero+",CURDATE())";
		return query;
	}

	public String queryPrelevaNotificaIntolleranze() {
		query = "SELECT Notifiche FROM notifiche WHERE tipoNotifica=5 AND data=CURDATE()";
	    return query;
	}

	public String queryInserisciNotificaPenale(String notifica6) {
		int numero = 6;
		query = "INSERT INTO notifiche(Notifiche, tipoNotifica, data) VALUES ('"+notifica6+"', "+numero+", CURDATE())";
		return query;
	}

	public String queryPrelevaNotificaPenale() {
		query = "SELECT Notifiche FROM notifiche WHERE tipoNotifica=6 AND data=CURDATE()";
	    return query;
	}

	public String queryCercaPrenotati(int codiceAtt) {
		query = "SELECT CodiceUtente FROM prenotazioniattivita WHERE CodiceAttivita="+codiceAtt;
	    return query;
	}

	public String queryCancellaNotificheAttivita(String codice) {
		query = "DELETE FROM notifiche WHERE CodiceAttivita='"+codice+"'";
		return query;
	}

	public String queryInserisciNotificaPostoLibero(String notifica7, int numeroCat, int codAtt) {
		int numero = 8;
		query = "INSERT INTO notifiche (Notifiche, IdCategoria, tipoNotifica, data, codiceAttivita) VALUES ('"+notifica7+"', "+numeroCat+", "+numero+",  CURDATE(), '"+codAtt+"')";
		return query;
	}

	public String queryPrelevaNotificaPostoLibero(String codice) {
		query = "SELECT DISTINCT n.Notifiche,n.codiceAttivita FROM attivita AS a JOIN notifiche AS n ON a.CodiceAttivita = n.codiceAttivita JOIN preferenzeutente AS p ON n.idCategoria=p.CodiceAttivitaPreferita WHERE p.CodiceUtente='"+codice+"' AND n.tipoNotifica=8 AND a.tipologia = 2 AND n.data>=SUBDATE(CURDATE(), INTERVAL 3 DAY)";
	    return query;
	}

	public String queryInserimentoCliente(String nome, String cognome, String codice) {
		query = "INSERT INTO codicidisponibili(CodiceID, NomeUtente, CognomeUtente) VALUES ('"+codice+"', '"+nome+"', '"+cognome+"')";
		return query;
	}

	public String queryPrendiCodice(String codice) {
		query = "SELECT COUNT(*) FROM utente WHERE CodiceID='"+codice+"'";
		return query;
	}

	public String queryCercaBudget(String cod) {
		query = "SELECT Budget FROM utente WHERE CodiceID='"+cod+"'";
		return query;
	}
	

}
