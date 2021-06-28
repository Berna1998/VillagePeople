package logic.bean;

public class SignUpBean {
	private String nome;
	private String cognome;
	private String email;
	private String codiceID;
	private String password;
	private String confermaPassword;
	private int giorni;
	private boolean sport;
	private boolean saluteBenessere;
	private boolean svagoRelax;
	private boolean bambini;
	
	
	public boolean isSport() {
		return sport;
	}
	public void setSport(boolean sport) {
		this.sport = sport;
	}
	public boolean isSaluteBenessere() {
		return saluteBenessere;
	}
	public void setSaluteBenessere(boolean saluteBenessere) {
		this.saluteBenessere = saluteBenessere;
	}
	public boolean isSvagoRelax() {
		return svagoRelax;
	}
	public void setSvagoRelax(boolean svagoRelax) {
		this.svagoRelax = svagoRelax;
	}
	public boolean isBambini() {
		return bambini;
	}
	public void setBambini(boolean bambini) {
		this.bambini = bambini;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfermaPassword() {
		return confermaPassword;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodiceID() {
		return codiceID;
	}
	public void setCodiceID(String codiceID) {
		this.codiceID = codiceID;
	}
	public int getGiorni() {
		return giorni;
	}
	public void setGiorni(int giorni) {
		
		this.giorni = giorni;
	}
	
	
}
