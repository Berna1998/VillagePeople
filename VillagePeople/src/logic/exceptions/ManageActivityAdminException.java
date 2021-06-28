package logic.exceptions;

import javax.swing.JLabel;

public class ManageActivityAdminException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageActivityAdminException() {
		super();
	}
	
	public void printMessage(JLabel msgError) {

		msgError.setText("Seleziona una delle attività mostrate");
	}

}
