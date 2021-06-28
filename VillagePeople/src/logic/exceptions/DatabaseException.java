package logic.exceptions;

import javax.swing.JLabel;

public class DatabaseException extends Exception{

	private static final long serialVersionUID = 1L;

	public DatabaseException ()
	{
		super();
	}
	
	public void showMessage(int n, JLabel msgError) {
		if (n == 1) {
			msgError.setText("Problemi di connessione al database");
		} else if (n == 2) {
			msgError.setText("Il codice Utente è già inserito");
		} else if (n == 3) {
			msgError.setText("Hai sbagliato a inserire codice");
		} else if (n == 4) {
			msgError.setText("I Menu non sono ancora stati inseriti");
		} else if (n == 5) {
			msgError.setText("Hai già prenotato un menu, per cambiarlo chiedi alla Reception");
		} else if (n == 6) {
			msgError.setText("Questo codice è già presente");
		}
	}
}
	
