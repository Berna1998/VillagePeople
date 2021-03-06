package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logic.model.entity.IntolleranzeEntity;
import logic.model.entity.MenuEntity;

public class MenuDao {
	private Statement ps = null;
	private QueryDB qd = new QueryDB();
	private MenuEntity m1 = new MenuEntity();
	private MenuEntity m2 = new MenuEntity();
	private MenuEntity m3 = new MenuEntity();
	private IntolleranzeEntity ie = new IntolleranzeEntity();
	private String comunicato = "comunicato";

	
	public void associaMenuCliente(String codiceCliente, int numeroMenu, Connection con) throws SQLException {
		String query = qd.queryAssociaMenu(codiceCliente, numeroMenu);
		ps = con.createStatement();
	    ps.executeUpdate(query);
        ps.close();
		
	}
	
	
	public void associaIntolleranza(String codiceCliente, String intolleranza, int numeroMenu, Connection con) throws SQLException {
		ie.setCodiceCliente(codiceCliente);
		ie.setIntolleranza(intolleranza);
		ie.setNumeroMenu(numeroMenu);
		String query = qd.queryAssociaIntolleranze(ie.getCodiceCliente(), ie.getIntolleranza(), ie.getNumeroMenu());
		ps = con.createStatement();
		ps.executeUpdate(query);
        ps.close();
	}
	

	
	public void aggiungiMenu(String menu1, String menu2, String menu3, Connection con) throws SQLException {
		m1.setDescrizione(menu1);
		m1.setCodice(1);
		m2.setDescrizione(menu2);
		m2.setCodice(2);
		m3.setDescrizione(menu3);
		m3.setCodice(3);
		String query = qd.queryCancellaMenu(1);
		ps = con.createStatement();
		ps.executeUpdate(query);
		query = qd.queryAggiungiMenu(1, m1.getDescrizione());
		ps.executeUpdate(query);
		query=qd.queryCancellaMenu(2);
		ps.executeUpdate(query);
		query = qd.queryAggiungiMenu(2, m2.getDescrizione());
		ps.executeUpdate(query);
		query = qd.queryCancellaMenu(3);
		ps.executeUpdate(query);
		query = qd.queryAggiungiMenu(3, m3.getDescrizione());
		ps.executeUpdate(query);
		m1.setStatoMenu(comunicato);
		m2.setStatoMenu(comunicato);
		m3.setStatoMenu(comunicato);
        ps.close();
		
	}
	
	public int contaMenuPrenotati(int numero, Connection con) throws SQLException {
		int totaleMenu = 0;
		String query = qd.queryCalcolaMenu(numero);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			totaleMenu = rs.getInt(1);
		}
		rs.close();
        ps.close();
		return totaleMenu;
	}
	
	public int contaIntolleranze(int numero, Connection con) throws SQLException {
		int totaleIntolleranze = 0;
		String query = qd.queryCalcolaIntolleranze(numero);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			totaleIntolleranze=rs.getInt(1);
		}
		rs.close();
        ps.close();
		return totaleIntolleranze;
	}
	
	public String prelevaMenu(int numero, Connection con) throws SQLException {
		String menu = "";
		String query = qd.queryPrendiMenu(numero);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while (rs.next()) {
			menu = rs.getString(1);
		}
		rs.close();
        ps.close();
        return menu;
		
	}
	
	public StringBuilder prelevaElenco(int numero, Connection con) throws SQLException {
		StringBuilder totaleElenco = new StringBuilder(); 
		String elenco = "";
		String clienti = "";
		String query = qd.memorizzaElenco(numero);
		ps = con.createStatement();
		ResultSet rs = ps.executeQuery(query);
		while(rs.next()) {	
			elenco = rs.getString(1);
			clienti = rs.getString(2);
			totaleElenco.append(elenco + "-" + clienti + "\n");
		}
		rs.close();
        ps.close();
        return totaleElenco;
		
	}

}
