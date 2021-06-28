package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import logic.bean.IntolleranzeBean;
import logic.model.dao.MenuDao;

public class MenuClientController extends MenuController {
	private MenuDao md = new MenuDao();
	
	public int comunicaIntolleranze(IntolleranzeBean ib, Connection con) throws SQLException{
		String codiceId = ib.getCodiceId();
		boolean menu1 = ib.isMenu1();
		boolean menu2 = ib.isMenu2();
		boolean menu3 = ib.isMenu3();
		String intolleranze = ib.getIntolleranze();
		if (menu1) {
			md.associaIntolleranza(codiceId, intolleranze, 1, con);
			return 1;	
		}
		else if (menu2) {
			md.associaIntolleranza(codiceId, intolleranze, 2, con);
			return 1;	
		}
		else if (menu3) {
			md.associaIntolleranza(codiceId, intolleranze, 3, con);
			return 1;	
		}
		return 0;		
	}
	
	/* Tale metodo viene invocato dal controller grafico e serve per inviare i dati al 
	 * database, in base al menu scelto  */
	public boolean selezionaDati(IntolleranzeBean ib, Connection con) throws SQLException {
		String codiceId = ib.getCodiceId();
		boolean menu1 = ib.isMenu1();
		boolean menu2 = ib.isMenu2();
		boolean menu3 = ib.isMenu3();
		if (menu1) {
			md.associaMenuCliente(codiceId, 1, con);
			return true;
		}
		else if (menu2) {
			md.associaMenuCliente(codiceId, 2, con);
			return true;
		}
		else if (menu3) {
			md.associaMenuCliente(codiceId, 3, con);
			return true;
		}
		return false;
 	}
}
