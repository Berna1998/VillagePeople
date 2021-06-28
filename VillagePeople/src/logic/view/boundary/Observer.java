package logic.view.boundary;

public interface Observer {
	  public void update(String s);
	  public void update(String s, String codice);
	  public void update(String s, int cod, String categoria);
}
