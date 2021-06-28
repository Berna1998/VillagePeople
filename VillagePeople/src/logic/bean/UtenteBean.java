package logic.bean;

import java.sql.Date;

public class UtenteBean {
	
	private String codiceIDBean;
	private String nomeBean;
	private String cognomeBean;
	private String emailBean;
	private String passwordBean;
	private int role; 
	private double budgetBean;
	private Date dataBean;
	private int numeroUtentiBean;
	
	public String getCodiceID() {
		return codiceIDBean;
	}
	public void setCodiceID(String codiceID) {
		this.codiceIDBean = codiceID;
	}
	public String getNome() {
		return nomeBean;
	}
	public void setNome(String nome) {
		this.nomeBean = nome;
	}
	public String getCognome() {
		return cognomeBean;
	}
	public void setCognome(String cognome) {
		this.cognomeBean = cognome;
	}
	public String getEmail() {
		return emailBean;
	}
	public void setEmail(String email) {
		this.emailBean = email;
	}
	public String getPassword() {
		return passwordBean;
	}
	public void setPassword(String password) {
		this.passwordBean = password;
	}
	public int getRole() {
		return roleBean;
	}
	public void setRole(int role) {
		this.roleBean = role;
	}
	public double getBudget() {
		return budgetBean;
	}
	public void setBudget(double budget) {
		this.budgetBean = budget;
	}
	public Date getData() {
		return dataBean;
	}
	public void setData(Date data) {
		this.dataBean = data;
	}
	public int getNumeroUtenti() {
		return numeroUtentiBean;
	}
	public void setNumeroUtenti(int numeroUtenti) {
		this.numeroUtentiBean = numeroUtenti;
	}
	
	
	
}
