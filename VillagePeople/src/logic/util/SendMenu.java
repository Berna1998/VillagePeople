package logic.util;

import java.sql.SQLException;
import java.util.concurrent.Callable;

import logic.bean.IntolleranzeBean;
import logic.controller.MenuClientController;
import java.sql.Connection;

public class SendMenu implements Callable<Boolean> {

	private MenuClientController mcc = new MenuClientController();
	private IntolleranzeBean ib;
	private Connection connessione;
    public SendMenu(IntolleranzeBean ib, Connection connessione) {
    	this.ib = ib;
    	this.connessione = connessione;
    }
 
    @Override
    public Boolean call() throws SQLException {
    	
    	boolean risp = false;

		risp = mcc.selezionaDati(ib, connessione);

        return risp;
    }
}
