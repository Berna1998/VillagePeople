package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import logic.bean.AttivitaBean;
import logic.bean.UtenteBean;
import logic.model.dao.AttivitaDao;

public class EliminaPrenotazioneController extends AttivitaController {
     private AttivitaDao ad = new AttivitaDao();
	
    /* Il seguente metodo viene invocato dal controller grafico nel metodo "ricercaPrenotazioni" permette la ricerca 
     * nel database delle prenotazioni effettuate dal cliente */
	 public void ricercaPrenotazioni(String codice, List<Object> l, int categoria, Connection con) throws SQLException {
		   ad.ricercaPrenotazioni(codice, l, categoria, con);
	 }
		

	/* Il seguente metodo viene invocato dal controller grafico nel metodo "controllaEliminazione" e permette l'eliminazione
	* della prenotazione selezionata */
	 public boolean eliminaPrenotazione(UtenteBean ub, AttivitaBean ab, Connection con) throws SQLException {
			String codiceId = ub.getCodiceID();
			int codiceAtt = ab.getCodice();
			ad.eliminaPrenotazione(codiceId, codiceAtt, con);
			return true;	
	 }

}
