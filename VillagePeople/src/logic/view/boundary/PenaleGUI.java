package logic.view.boundary;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;




import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;



public class PenaleGUI implements Subject {

	private JFrame frame;
	private JTextPane textPanePenale;
	private JTextPane textPaneCodicePenale;
	private JLabel lblPenale;
	private JTextPane textPaneCodiceAtt;
	private JTextPane txtPcodiceUtente;
	private JTextPane txtPanePrezzo;
	private List<Observer> ob = new ArrayList<>();
	

	@Override
	public void attach(Observer o) {
		this.ob.add(o);
	}
		
	@Override
	public void notifica(String tipo, String codice) {
			for (Observer oo: ob) {
				oo.update(tipo, codice);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.ob.contains(o)) {
			this.ob.remove(o);
		}
	}
	
	
	
	public JTextPane getTxtPanePrezzo() {
		return txtPanePrezzo;
	}

	public JTextPane getTxtPcodiceUtente() {
		return txtPcodiceUtente;
	}

	public JTextPane getTextPaneCodiceAtt() {
		return textPaneCodiceAtt;
	}

	public JTextPane getTextPanePenale() {
		return textPanePenale;
	}

	public JTextPane getTextPaneCodicePenale() {
		return textPaneCodicePenale;
	}

	public JLabel getLblPenale() {
		return lblPenale;
	}

	/**
	 * Create the application.
	 */
	public PenaleGUI() {
		
		String font1 = "Dialog";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton indietro = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e)-> {
		   detach(StartApplication.c2.getWindowNotificheAdmin());
		   lblPenale.setText(" ");
		   lblPenale.setIcon(new ImageIcon());
		   frame.setVisible(false);
		});
		indietro.setFont(new Font(font1, Font.BOLD, 19));
		indietro.setBounds(135, 584, 229, 44);
		panel.add(indietro);
		
		JLabel lblNewLabel = new JLabel("La cancellazione della prenotazione non \u00E8 possibile ");
		lblNewLabel.setFont(new Font(font1, Font.BOLD, 19));
		lblNewLabel.setBounds(10, 24, 493, 35);
		panel.add(lblNewLabel);
		
		JLabel label1 = new JLabel("Per procedere comunque con la cancellazione ");
		label1.setFont(new Font(font1, Font.BOLD, 19));
		label1.setBounds(10, 100, 444, 26);
		panel.add(label1);
		
		JLabel label2 = new JLabel("poich\u00E8 l'attivit\u00E0 si svolge in data odierna.       \r\n");
		label2.setFont(new Font(font1, Font.BOLD, 19));
		label2.setBounds(10, 57, 463, 26);
		panel.add(label2);
		
		JLabel label3 = new JLabel("\u00E8 richiesto il pagamento della penale.");
		label3.setFont(new Font(font1, Font.BOLD, 19));
		label3.setBounds(10, 126, 444, 26);
		panel.add(label3);
		
		JLabel label4 = new JLabel("Il pagamento della penale pu\u00F2 essere effettuato ");
		label4.setFont(new Font(font1, Font.BOLD, 19));
		label4.setBounds(10, 221, 444, 26);
		panel.add(label4);
		
		JLabel label5 = new JLabel("New label");
		label5.setBounds(10, 274, 45, -26);
		panel.add(label5);
		
		JLabel label6 = new JLabel("alla cassa utilizzando il relativo codice:");
		label6.setFont(new Font(font1, Font.BOLD, 19));
		label6.setBounds(10, 249, 431, 26);
		panel.add(label6);
		
		JLabel label7 = new JLabel("Codice:");
		label7.setFont(new Font(font1, Font.BOLD, 15));
		label7.setBounds(62, 285, 65, 21);
		panel.add(label7);
		
		textPaneCodicePenale = new JTextPane();
		textPaneCodicePenale.setEditable(false);
		textPaneCodicePenale.setBackground(new Color(255, 222, 173));
		textPaneCodicePenale.setBounds(135, 285, 96, 26);
		panel.add(textPaneCodicePenale);
		
		JButton button1 = new JButton("Elimina prenotazione");
		Image imgCancella = new ImageIcon(this.getClass().getResource("/cancella.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		button1.setIcon(new ImageIcon(imgCancella));
		button1.setFont(new Font(font1, Font.BOLD, 19));
		button1.addActionListener((ActionEvent e) -> {
            String codice = txtPcodiceUtente.getText() ;
            double prezzo = (Double.parseDouble(txtPanePrezzo.getText()));
			int i = StartApplication.c1.controllaEliminazionePenale(prezzo);
			if (i == 1) {
				notifica("penale", codice);
			}
		
		});
		
		button1.setBounds(119, 380, 261, 44);
		panel.add(button1);
		
		lblPenale = new JLabel("");
		lblPenale.setBounds(10, 317, 448, 57);
		panel.add(lblPenale);
		
		JLabel labelCostoPenale = new JLabel("Costo penale: \u20AC");
		labelCostoPenale.setFont(new Font(font1, Font.BOLD, 14));
		labelCostoPenale.setBounds(10, 179, 110, 21);
		panel.add(labelCostoPenale);
		
		textPanePenale = new JTextPane();
		textPanePenale.setEditable(false);
		textPanePenale.setBackground(new Color(255, 160, 122));
		textPanePenale.setFont(new Font(font1, Font.BOLD, 12));
		textPanePenale.setBounds(135, 179, 71, 19);
		panel.add(textPanePenale);
		
		JLabel label9 = new JLabel("Codice attivit\u00E0:");
		label9.setFont(new Font(font1, Font.BOLD, 14));
		label9.setBounds(10, 158, 119, 21);
		panel.add(label9);
		
		textPaneCodiceAtt = new JTextPane();
		textPaneCodiceAtt.setFont(new Font(font1, Font.BOLD, 12));
		textPaneCodiceAtt.setEditable(false);
		textPaneCodiceAtt.setBackground(new Color(255, 160, 122));
		textPaneCodiceAtt.setBounds(130, 158, 101, 19);
		panel.add(textPaneCodiceAtt);
		
		JLabel lblNewLabel081 = new JLabel("Codice utente: ");
		lblNewLabel081.setFont(new Font(font1, Font.BOLD, 14));
		lblNewLabel081.setBounds(263, 182, 117, 14);
		panel.add(lblNewLabel081);
		
		txtPcodiceUtente = new JTextPane();
		txtPcodiceUtente.setFont(new Font(font1, Font.BOLD, 12));
		txtPcodiceUtente.setEditable(false);
		txtPcodiceUtente.setBackground(new Color(255, 160, 122));
		txtPcodiceUtente.setBounds(369, 179, 72, 20);
		panel.add(txtPcodiceUtente);
		
		JLabel lblNewLabel992 = new JLabel("Prezzo attivit\u00E0: ");
		lblNewLabel992.setFont(new Font(font1, Font.BOLD, 14));
		lblNewLabel992.setBounds(263, 161, 124, 14);
		panel.add(lblNewLabel992);
		
		txtPanePrezzo = new JTextPane();
		txtPanePrezzo.setFont(new Font(font1, Font.BOLD, 12));
		txtPanePrezzo.setBackground(new Color(255, 160, 122));
		txtPanePrezzo.setEditable(false);
		txtPanePrezzo.setBounds(373, 158, 81, 20);
		panel.add(txtPanePrezzo);
		
		JButton btnPayPal = new JButton();
		Image img3 = new ImageIcon(this.getClass().getResource("/paypalLogo.png")).getImage().getScaledInstance(150, 70, Image.SCALE_SMOOTH);
		btnPayPal.setIcon(new ImageIcon(img3));
		btnPayPal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPayPal.setBounds(170, 470, 131, 63);
		btnPayPal.addActionListener((ActionEvent e)-> 
			   StartApplication.c1.chiamaPayPal()
			);
		panel.add(btnPayPal);
		

   }
	
	public JFrame getFrame() {
		return frame;
	}


	@Override
	public void notifica(String nome, int cod, String categoria) {//NOT USED
		
	}

	@Override
	public void notifica(String tipo) {//NOT USED
		
	}
}
