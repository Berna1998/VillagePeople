package logic.bean;

public class AttivitaBean {

	private String categoria;
	private String giorno;
	private int codice;
	private String nome;
	private double prezzo;
	private String orario;
	private String tipologia;
	private int partecipantiMax;
	private int partecipantiAttuali;
	
	public int getPartecipantiAttuali() {
		return partecipantiAttuali;
	}

	public void setPartecipantiAttuali(int partecipantiAttuali) {
		this.partecipantiAttuali = partecipantiAttuali;
	}

	public int getPartecipantiMax() {
		return partecipantiMax;
	}

	public void setPartecipantiMax(int partecipantiMax) {
		this.partecipantiMax = partecipantiMax;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	


}
