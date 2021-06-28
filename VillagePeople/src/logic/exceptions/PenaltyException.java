package logic.exceptions;

import javax.swing.JLabel;

public class PenaltyException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PenaltyException() {
		super();
	}
	
	public void printMessage(JLabel msgError) {
		msgError.setText("Non hai generato il codice");
		}
}
	

