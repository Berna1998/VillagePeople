package logic.model.entity;

public class MenuEntity {
	private int codice;
	private String descrizione;
	private String statoMenu = "Non comunicato";

	
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getStatoMenu() {
		return statoMenu;
	}
	
	public void setStatoMenu(String statoMenu) {
		this.statoMenu = statoMenu;
	}

}
