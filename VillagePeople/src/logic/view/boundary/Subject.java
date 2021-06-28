package logic.view.boundary;

public interface Subject {
	 public void attach(Observer o);
	 public void detach(Observer o);
	 public void notifica(String tipo);
	 public void notifica(String tipo, String codice);
	 public void notifica(String nome, int cod, String categoria);
		
}
