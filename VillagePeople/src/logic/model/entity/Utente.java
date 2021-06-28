package logic.model.entity;

public class Utente {
	private String codiceID;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private int role; 
	
	
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
	
	
}
