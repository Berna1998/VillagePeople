package logic.bean;

import java.sql.Date;

public class UtenteBean {
	
	private String codiceID;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int role; 
	private double budget;
	private Date data;
	private int numeroUtenti;
	
	public String getCodiceID() {
		return codiceID;
	}
	public void setCodiceID(String codiceID) {
		this.codiceID = codiceID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getNumeroUtenti() {
		return numeroUtenti;
	}
	public void setNumeroUtenti(int numeroUtenti) {
		this.numeroUtenti = numeroUtenti;
	}
	
	
	
}
