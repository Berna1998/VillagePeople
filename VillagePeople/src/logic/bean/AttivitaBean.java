package logic.bean;

public class AttivitaBean {

	private String categoriaBean;
	private String giornoBean;
	private int codiceBean;
	private String nomeBean;
	private double prezzoBean;
	private String orarioBean;
	private String tipologiaBean;
	private int partecipantiMaxBean;
	private int partecipantiAttualiBean;
	
	public int getPartecipantiAttuali() {
		return partecipantiAttualiBean;
	}

	public void setPartecipantiAttuali(int partecipantiAttuali) {
		this.partecipantiAttualiBean = partecipantiAttuali;
	}

	public int getPartecipantiMax() {
		return partecipantiMaxBean;
	}

	public void setPartecipantiMax(int partecipantiMax) {
		this.partecipantiMaxBean = partecipantiMax;
	}

	public String getTipologia() {
		return tipologiaBean;
	}

	public void setTipologia(String tipologia) {
		this.tipologiaBean = tipologia;
	}

	public int getCodice() {
		return codiceBean;
	}

	public void setCodice(int codice) {
		this.codiceBean = codice;
	}

	public String getNome() {
		return nomeBean;
	}

	public void setNome(String nome) {
		this.nomeBean = nome;
	}

	public double getPrezzo() {
		return prezzoBean;
	}

	public void setPrezzo(double prezzo) {
		this.prezzoBean = prezzo;
	}

	public String getOrario() {
		return orarioBean;
	}

	public void setOrario(String orario) {
		this.orarioBean = orario;
	}

	public String getCategoria() {
		return categoriaBean;
	}
	
	public void setCategoria(String categoria) {
		this.categoriaBean = categoria;
	}
	
	public String getGiorno() {
		return giornoBean;
	}

	public void setGiorno(String giorno) {
		this.giornoBean = giorno;
	}
	


}
