package logic.exceptions;

import javax.swing.JLabel;

public class MenuException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MenuException() {
		super();
	}
	
	public void printMessage(JLabel msgError) {

		msgError.setText("Compila tutti i campi");
	}

}
