package logic.exceptions;

import javax.swing.JLabel;

public class TeamActivityException  extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int n;

	public  TeamActivityException(int n) {
		super();
		this.n = n;
	
	}
	
	public void printMessage(JLabel msgError) {
		if(n == 1) {
			msgError.setText("Seleziona una delle attività mostrate");
		} else if (n == 2) {
			msgError.setText("Quest'attività ha raggiunto il numero massimo di partecipanti");
		}
	}
}
