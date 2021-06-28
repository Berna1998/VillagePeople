package logic.exceptions;

import javax.swing.JLabel;

public class FormatException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FormatException() {
		
	}
	
	public void printMessage(JLabel msgError) {

		msgError.setText("Devi scrivere correttamente i dati da modificare");
	}

}
