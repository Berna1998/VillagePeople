package logic.bean;

public class SignUpBean {
	private String nomeBean;
	private String cognomeBean;
	private String emailBean;
	private String codiceIDBean;
	private String passwordBean;
	private String confermaPasswordBean;
	private int giorniBean;
	private boolean sportBean;
	private boolean saluteBenessereBean;
	private boolean svagoRelaxBean;
	private boolean bambiniBean;
	
	
	public boolean isSport() {
		return sportBean;
	}
	public void setSport(boolean sport) {
		this.sportBean = sport;
	}
	public boolean isSaluteBenessere() {
		return saluteBenessereBean;
	}
	public void setSaluteBenessere(boolean saluteBenessere) {
		this.saluteBenessereBean = saluteBenessere;
	}
	public boolean isSvagoRelax() {
		return svagoRelaxBean;
	}
	public void setSvagoRelax(boolean svagoRelax) {
		this.svagoRelaxBean = svagoRelax;
	}
	public boolean isBambini() {
		return bambiniBean;
	}
	public void setBambini(boolean bambini) {
		this.bambiniBean = bambini;
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
	public String getPassword() {
		return passwordBean;
	}
	public void setPassword(String password) {
		this.passwordBean = password;
	}
	public String getConfermaPassword() {
		return confermaPasswordBean;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPasswordBean = confermaPassword;
	}
	public String getEmail() {
		return emailBean;
	}
	public void setEmail(String email) {
		this.emailBean = email;
	}
	public String getCodiceID() {
		return codiceIDBean;
	}
	public void setCodiceID(String codiceID) {
		this.codiceIDBean = codiceID;
	}
	public int getGiorni() {
		return giorniBean;
	}
	public void setGiorni(int giorni) {
		
		this.giorniBean = giorni;
	}
	
	
}
