package logic.exceptions;

import javax.swing.JLabel;

public class AddClientException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddClientException() {
		super();
	}
	
	public void printMessage(JLabel msgError) {

		msgError.setText("Riempire tutti i campi");
	}

}
