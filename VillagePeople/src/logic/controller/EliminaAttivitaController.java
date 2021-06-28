package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import logic.bean.AttivitaBean;
import logic.model.dao.AttivitaDao;

public class EliminaAttivitaController extends AttivitaController {
    private AttivitaDao ad = new AttivitaDao();


	/*Il seguente metodo viene invocato dal controller grafico e permette la cancellazione 
    * dal database di un'attività */
	public boolean eliminaAttivita(AttivitaBean ab, Connection con) throws SQLException {
		int codice = ab.getCodice();
		ad.eliminaAttivita(codice, con);
		return true;	
	}

}
