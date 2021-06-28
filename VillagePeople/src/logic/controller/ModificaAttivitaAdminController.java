package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import logic.bean.AttivitaBean;
import logic.model.dao.AttivitaDao;

public class ModificaAttivitaAdminController extends AttivitaController {
	private AttivitaDao ad = new AttivitaDao();
	
	/* Il seguente metodo viene invocato dal controller grafico lato Admin e permette la modifica 
    * nel database dei parametri di un'attività */
	public boolean modificaAttivita(AttivitaBean ab, Connection con) throws SQLException {	
		String codice = String.valueOf(ab.getCodice());
		String orario = ab.getOrario();
		double prezzo = ab.getPrezzo();
		ad.aggiornaAttivita(codice, orario, prezzo, con);
		return true;		
	}
}
