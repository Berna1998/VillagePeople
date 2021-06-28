package logic.view.boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.JTextPane;

public class HomepageClientGUI  {

	private JFrame frame;
	private JTextPane textNome;
	private JTextPane textCognome;
	private JTextPane textCodice;
	private JTextPane textEmail;
	private JTextPane textBudget;
	private JLabel lblModifica;

	public JLabel getLblModifica() {
		return lblModifica;
	}

	public JTextPane getTextNome() {
		return textNome;
	}

	public JTextPane getTextCognome() {
		return textCognome;
	}


	public JTextPane getTextCodice() {
		return textCodice;
	}


	public JTextPane getTextEmail() {
		return textEmail;
	}


	public JTextPane getTextBudget() {
		return textBudget;
	}

  
	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Create the application.
	 */
	public HomepageClientGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1 = "Dialog";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 943, 693);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 929, 656);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel(" VillagePeople ");
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblNewLabel.setBounds(323, 0, 282, 58);
		panel.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Notifiche");
		tglbtnNewToggleButton.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoNotifiche();
			frame.setVisible(false);
	    });
		tglbtnNewToggleButton.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(780, 191, 149, 33);
		panel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPrenotaAttivit = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivit.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoGestisciAttivitaClient();
			frame.setVisible(false);
		
		});
		tglbtnPrenotaAttivit.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivit.setBounds(637, 191, 149, 33);
		panel.add(tglbtnPrenotaAttivit);
		
		JToggleButton tglbtnMenDelGiorno = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiorno.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoMenu();
			frame.setVisible(false);				
	
		});
		tglbtnMenDelGiorno.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiorno.setBounds(490, 191, 149, 33);
		panel.add(tglbtnMenDelGiorno);
		
		JToggleButton tglbtnNotifiche = new JToggleButton("Profilo Personale");
		tglbtnNotifiche.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifiche.setEnabled(false);
		tglbtnNotifiche.setSelected(true);
		tglbtnNotifiche.setBounds(333, 191, 159, 33);
		panel.add(tglbtnNotifiche);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font(font1, Font.BOLD, 20));
		labelNome.setBounds(29, 295, 155, 35);
		panel.add(labelNome);
		
		JLabel lblNewLabel21 = new JLabel("Cognome:");
		lblNewLabel21.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel21.setBounds(29, 356, 155, 35);
		panel.add(lblNewLabel21);
		
		JLabel lblNewLabel22 = new JLabel("CodiceID:");
		lblNewLabel22.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel22.setBounds(29, 416, 155, 35);
		panel.add(lblNewLabel22);
		
		JLabel lblNewLabel23 = new JLabel("E-mail:");
		lblNewLabel23.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel23.setBounds(501, 295, 155, 35);
		panel.add(lblNewLabel23);
		
		textNome = new JTextPane();
		textNome.setFont(new Font(font, Font.BOLD, 24));
		textNome.setBackground(new Color(255, 160, 122));
		textNome.setEditable(false);
		textNome.setBounds(186, 295, 241, 35);
		panel.add(textNome);
		
		textCognome = new JTextPane();
		textCognome.setFont(new Font(font, Font.BOLD, 24));
		textCognome.setBackground(new Color(255, 160, 122));
		textCognome.setEditable(false);
		textCognome.setBounds(186, 356, 241, 35);
		panel.add(textCognome);
		
		textCodice = new JTextPane();
		textCodice.setFont(new Font(font, Font.BOLD, 24));
		textCodice.setBackground(new Color(255, 160, 122));
		textCodice.setEditable(false);
		textCodice.setBounds(186, 416, 241, 35);
		panel.add(textCodice);
		
		textEmail = new JTextPane();
		textEmail.setFont(new Font(font1, Font.BOLD, 16));
		textEmail.setBackground(new Color(255, 255, 255));
		textEmail.setBounds(580, 295, 339, 35);
		panel.add(textEmail);
		
		JButton btnNewButton1 = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnNewButton1.setIcon(new ImageIcon(imgLogOut));
		btnNewButton1.addActionListener((ActionEvent e) -> 
		            StartApplication.c1.disconnessione(1));
		btnNewButton1.setFont(new Font(font, Font.BOLD, 10));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setBounds(833, 37, 96, 21);
		panel.add(btnNewButton1);
		
		JLabel lblNewLabel251 = new JLabel("Budget Disponibile:");
		lblNewLabel251.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel251.setBounds(490, 356, 248, 35);
		panel.add(lblNewLabel251);
		
		textBudget = new JTextPane();
		textBudget.setFont(new Font(font, Font.BOLD, 24));
		textBudget.setBounds(684, 356, 159, 35);
		panel.add(textBudget);
		
		JLabel lblNewLabel2511 = new JLabel("\u20AC");
		lblNewLabel2511.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel2511.setBounds(861, 355, 24, 35);
		panel.add(lblNewLabel2511);
		
		JButton btnModificaDati = new JButton("Modifica Dati");
		Image imgModificaDati = new ImageIcon(this.getClass().getResource("/modifica.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnModificaDati.setIcon(new ImageIcon(imgModificaDati));
		btnModificaDati.addActionListener((ActionEvent e) -> {
		
		        String email = textEmail.getText(); 
		        String budget = textBudget.getText();
				StartApplication.c1.modificaDatiPersonali(email, budget);
		});
		
		btnModificaDati.setFont(new Font(font, Font.BOLD, 12));
		btnModificaDati.setBounds(740, 420, 179, 33);
		panel.add(btnModificaDati);
		
		
		JLabel lblPersonale = new JLabel("lblPersonale");
		ImageIcon imgPersonale=new ImageIcon(this.getClass().getResource("/cameraResort.jpg"));
		lblPersonale.setIcon(imgPersonale);
		lblPersonale.setBounds(0, 57, 929, 167);
		panel.add(lblPersonale);
		
		JLabel lblNewLabel51 = new JLabel("PROFILO PERSONALE");
		lblNewLabel51.setFont(new Font(font1, Font.BOLD, 30));
		lblNewLabel51.setBounds(21, 235, 339, 39);
		panel.add(lblNewLabel51);
		
		lblModifica = new JLabel("");
		lblModifica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifica.setBounds(416, 464, 503, 52);
		panel.add(lblModifica);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(603, -13, 66, 84);
		panel.add(labell4);
		
		JPanel panel71 = new JPanel();
		panel71.setBackground(new Color(0, 0, 0));
		panel71.setBounds(0, 0, 929, 58);
		panel.add(panel71);
	}

}
