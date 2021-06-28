package logic.model.entity;

import java.sql.Date;

public class Cliente extends Utente {
	private double budget = 0.0;
	private Date data;
	private int giorniPermanenza;
	private boolean sport = false;
	private boolean saluteBenessere = false;
	private boolean svagoRelax = false;
	private boolean bambini = false;
	
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getGiorniPermanenza() {
		return giorniPermanenza;
	}
	public void setGiorniPermanenza(int giorniPermanenza) {
		this.giorniPermanenza = giorniPermanenza;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
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
	
	
	
	

}
