package logic.exceptions;

import javax.swing.JLabel;

public class TableException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TableException() {
		super();
	}
	public void printMessage(int n, JLabel msgError) {
		if ( n == 1) {
			msgError.setText("Non hai cercato nessuna attività");
		} else if (n == 2) {
			msgError.setText("Non hai selezionato nessuna attività");
		}
	}

}
