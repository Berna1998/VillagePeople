package logic.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import logic.bean.UtenteBean;
import logic.controller.AttivitaController;

public class AggiornaBudget implements Callable<Integer>{
	private UtenteBean ub;
	private Connection connessione;
	private AttivitaController ac = new AttivitaController();
	
    public AggiornaBudget(UtenteBean ub, Connection connessione) {
    	this.ub = ub;
    	this.connessione = connessione;
    }
    
    @Override
    public Integer call() throws SQLException {
    	int i = 0;
    	
		ac.aggiornaBudget(ub, connessione);
		i = 1;

    	return i;
    }
	
}
