package logic.exceptions;

import javax.swing.JLabel;

public class AddActivityException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AddActivityException() {
		super();
	}
	
	public void printMessage(JLabel msgError) {

		msgError.setText("Inserire tutti i campi!");
	}

}
