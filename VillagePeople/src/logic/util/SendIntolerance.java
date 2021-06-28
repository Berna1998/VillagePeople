package logic.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;

import logic.bean.IntolleranzeBean;
import logic.controller.MenuClientController;

public class SendIntolerance implements Callable<Integer> {

	private MenuClientController mcc = new MenuClientController();
	private IntolleranzeBean ib;
	private Connection connessione;
    
	public SendIntolerance(IntolleranzeBean ib, Connection connessione) {
    	this.ib = ib;
    	this.connessione = connessione;
    }
 
    @Override
    public Integer call() throws SQLException {
    	int i = 0;
   	
		i = mcc.comunicaIntolleranze(ib, connessione);

        return i;
    }
}
