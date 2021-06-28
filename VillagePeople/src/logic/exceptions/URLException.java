package logic.exceptions;

import javax.swing.JLabel;

public class URLException extends Exception{
	
    private static final long serialVersionUID = 1L;
	
	public URLException() {
		super();
	}
	
	public void printMessage(JLabel msgError) {

		msgError.setText("Errore nell'apertura dell'URL");
	}

}
