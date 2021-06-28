package logic.controller;

import java.sql.Connection;
import java.sql.SQLException;

import logic.bean.MenuBean;
import logic.model.dao.MenuDao;

public class MenuController {
	private MenuDao md = new MenuDao();
	
	public void mostraMenu(MenuBean mb, Connection con) throws SQLException { 
		String menu1 = "";
		String menu2 = "";
		String menu3 = "";
		menu1 = md.prelevaMenu(1, con);
		menu2 = md.prelevaMenu(2, con);
		menu3 = md.prelevaMenu(3, con);
		mb.setMenu1(menu1);
		mb.setMenu2(menu2);
		mb.setMenu3(menu3);
		
	}
	
}
