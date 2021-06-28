package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import logic.bean.SignUpBean;
import logic.controller.SignUpController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;

public class TestSignUp {
	private String type = "MySql";
	private DataBaseFactory dbf = new DataBaseFactory();
	private DataBaseClass db = dbf.getConnessione(type);
	private Connection connessione;

	public void apriConnessione() throws SQLException{
		connessione = db.openConnection();
	}
	
	public void chiudiConnessione() throws SQLException {
		connessione.close();
	}
 
	@Test
	public void testSignUpValido() throws SQLException {
		boolean risultato;
		boolean risultato2 = false;
		boolean risultato3 = false;
		SignUpBean sb = new SignUpBean();
		apriConnessione();
		sb.setNome("Cristiano");
		sb.setCognome("Ronaldo");
		sb.setCodiceID("999999");
		sb.setEmail("cristiano@gmail.com");
		sb.setPassword("12345");
		sb.setConfermaPassword("12345");
		sb.setGiorni(10);
		sb.setSport(true);
		sb.setSaluteBenessere(false);
		sb.setSvagoRelax(true);
		sb.setBambini(false);
		SignUpController sc = new SignUpController();
		risultato = sc.controlloAssociazione(sb, connessione);
		if(risultato) {
			risultato2 = sc.aggiungiContatto(sb,connessione);
		}
		if(risultato2) {
			risultato3=sc.verificaCategorie(sb, connessione);
		}
		chiudiConnessione();
		assertEquals(true, risultato3);
	}
	
	@Test
	public void testSignUpFail() throws SQLException {
		boolean risultato;
		boolean risultato2 = false;
		boolean risultato3 = false;
		SignUpBean sb = new SignUpBean();
		apriConnessione();
		sb.setNome("Nessuno");
		sb.setCognome("Niente");
		sb.setCodiceID("090909");
		sb.setEmail("Nulla@gmail.com");
		sb.setPassword("76767");
		sb.setConfermaPassword("76767");
		sb.setGiorni(8);
		sb.setSport(true);
		sb.setSaluteBenessere(false);
		sb.setSvagoRelax(true);
		sb.setBambini(false);
		SignUpController sc = new SignUpController();
		risultato = sc.controlloAssociazione(sb, connessione);
		if(risultato) {
			risultato2 = sc.aggiungiContatto(sb,connessione);
		}
		if(risultato2) {
			risultato3=sc.verificaCategorie(sb, connessione);
		}
		chiudiConnessione();
		assertEquals(false, risultato3);
	}
}
