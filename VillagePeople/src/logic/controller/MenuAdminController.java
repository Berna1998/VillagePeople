package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import logic.bean.MenuBean;
import logic.model.dao.MenuDao;

public class MenuAdminController extends MenuController {
	private MenuDao md = new MenuDao();
	
	/* Il seguente metodo viene invocato dal controller grafico lato Admin e permette
	 * di inserire nel database i menu giornalieri */
	public boolean comunicaMenu(MenuBean mb, Connection con) throws SQLException {
		String menu1 = mb.getMenu1();
		String menu2 = mb.getMenu2();
		String menu3 = mb.getMenu3();
		md.aggiungiMenu(menu1, menu2, menu3, con);
		return true;	
	}
	
	public int contaIntolleranze(int numero, Connection con) throws SQLException {
		int totaleInt = 0;
		totaleInt = md.contaIntolleranze(numero, con);
		return totaleInt;
	}
	
	public int contaMenu(int numero, Connection con) throws SQLException {
		int totale = 0;
		totale = md.contaMenuPrenotati(numero, con);
		return totale;
	}
	
	public StringBuilder prendiElenco(int numero, Connection con) throws SQLException {
		return md.prelevaElenco(numero, con);
	}	
	
}
