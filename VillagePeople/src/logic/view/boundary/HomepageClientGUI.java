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

	private JFrame frameHomCli;
	private JTextPane textNomeHomCli;
	private JTextPane textCognomeHomCli;
	private JTextPane textCodiceHomCli;
	private JTextPane textEmailHomCli;
	private JTextPane textBudgetHomCli;
	private JLabel lblModificaHomCli;

	public JLabel getLblModifica() {
		return lblModificaHomCli;
	}

	public JTextPane getTextNome() {
		return textNomeHomCli;
	}

	public JTextPane getTextCognome() {
		return textCognomeHomCli;
	}


	public JTextPane getTextCodice() {
		return textCodiceHomCli;
	}


	public JTextPane getTextEmail() {
		return textEmailHomCli;
	}


	public JTextPane getTextBudget() {
		return textBudgetHomCli;
	}

  
	public JFrame getFrame() {
		return frameHomCli;
	}


	/**
	 * Create the application.
	 */
	public HomepageClientGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1 = "Dialog";
		
		frameHomCli = new JFrame();
		frameHomCli.setBounds(100, 100, 943, 693);
		frameHomCli.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameHomCli.getContentPane().setLayout(null);
		
		JPanel panelHomCli = new JPanel();
		panelHomCli.setLayout(null);
		panelHomCli.setBackground(new Color(255, 160, 122));
		panelHomCli.setBounds(0, 0, 929, 656);
		frameHomCli.getContentPane().add(panelHomCli);
		
		JLabel lblHomCli = new JLabel(" VillagePeople ");
		lblHomCli.setForeground(new Color(255, 160, 122));
		lblHomCli.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblHomCli.setBounds(323, 0, 282, 58);
		panelHomCli.add(lblHomCli);
		
		JToggleButton tglbtnNewToggleButtonHomCli = new JToggleButton("Notifiche");
		tglbtnNewToggleButtonHomCli.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoNotifiche();
			frameHomCli.setVisible(false);
	    });
		tglbtnNewToggleButtonHomCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNewToggleButtonHomCli.setBounds(780, 191, 149, 33);
		panelHomCli.add(tglbtnNewToggleButtonHomCli);
		
		JToggleButton tglbtnPrenotaAttivitHomCli = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivitHomCli.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoGestisciAttivitaClient();
			frameHomCli.setVisible(false);
		
		});
		tglbtnPrenotaAttivitHomCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivitHomCli.setBounds(637, 191, 149, 33);
		panelHomCli.add(tglbtnPrenotaAttivitHomCli);
		
		JToggleButton tglbtnMenDelGiornoHomCli = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiornoHomCli.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoMenu();
			frameHomCli.setVisible(false);				
	
		});
		tglbtnMenDelGiornoHomCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiornoHomCli.setBounds(490, 191, 149, 33);
		panelHomCli.add(tglbtnMenDelGiornoHomCli);
		
		JToggleButton tglbtnNotificheHomCli = new JToggleButton("Profilo Personale");
		tglbtnNotificheHomCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotificheHomCli.setEnabled(false);
		tglbtnNotificheHomCli.setSelected(true);
		tglbtnNotificheHomCli.setBounds(333, 191, 159, 33);
		panelHomCli.add(tglbtnNotificheHomCli);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font(font1, Font.BOLD, 20));
		labelNome.setBounds(29, 295, 155, 35);
		panelHomCli.add(labelNome);
		
		JLabel lblNewLabel21 = new JLabel("Cognome:");
		lblNewLabel21.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel21.setBounds(29, 356, 155, 35);
		panelHomCli.add(lblNewLabel21);
		
		JLabel lblNewLabel22 = new JLabel("CodiceID:");
		lblNewLabel22.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel22.setBounds(29, 416, 155, 35);
		panelHomCli.add(lblNewLabel22);
		
		JLabel lblNewLabel23 = new JLabel("E-mail:");
		lblNewLabel23.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel23.setBounds(501, 295, 155, 35);
		panelHomCli.add(lblNewLabel23);
		
		textNomeHomCli = new JTextPane();
		textNomeHomCli.setFont(new Font(font, Font.BOLD, 24));
		textNomeHomCli.setBackground(new Color(255, 160, 122));
		textNomeHomCli.setEditable(false);
		textNomeHomCli.setBounds(186, 295, 241, 35);
		panelHomCli.add(textNomeHomCli);
		
		textCognomeHomCli = new JTextPane();
		textCognomeHomCli.setFont(new Font(font, Font.BOLD, 24));
		textCognomeHomCli.setBackground(new Color(255, 160, 122));
		textCognomeHomCli.setEditable(false);
		textCognomeHomCli.setBounds(186, 356, 241, 35);
		panelHomCli.add(textCognomeHomCli);
		
		textCodiceHomCli = new JTextPane();
		textCodiceHomCli.setFont(new Font(font, Font.BOLD, 24));
		textCodiceHomCli.setBackground(new Color(255, 160, 122));
		textCodiceHomCli.setEditable(false);
		textCodiceHomCli.setBounds(186, 416, 241, 35);
		panelHomCli.add(textCodiceHomCli);
		
		textEmailHomCli = new JTextPane();
		textEmailHomCli.setFont(new Font(font1, Font.BOLD, 16));
		textEmailHomCli.setBackground(new Color(255, 255, 255));
		textEmailHomCli.setBounds(580, 295, 339, 35);
		panelHomCli.add(textEmailHomCli);
		
		JButton btnNewButton1 = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnNewButton1.setIcon(new ImageIcon(imgLogOut));
		btnNewButton1.addActionListener((ActionEvent e) -> 
		            StartApplication.c1.disconnessione(1));
		btnNewButton1.setFont(new Font(font, Font.BOLD, 10));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setBounds(833, 37, 96, 21);
		panelHomCli.add(btnNewButton1);
		
		JLabel lblNewLabel251 = new JLabel("Budget Disponibile:");
		lblNewLabel251.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel251.setBounds(490, 356, 248, 35);
		panelHomCli.add(lblNewLabel251);
		
		textBudget = new JTextPane();
		textBudget.setFont(new Font(font, Font.BOLD, 24));
		textBudget.setBounds(684, 356, 159, 35);
		panelHomCli.add(textBudget);
		
		JLabel lblNewLabel2511 = new JLabel("\u20AC");
		lblNewLabel2511.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel2511.setBounds(861, 355, 24, 35);
		panelHomCli.add(lblNewLabel2511);
		
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
		panelHomCli.add(btnModificaDati);
		
		
		JLabel lblPersonale = new JLabel("lblPersonale");
		ImageIcon imgPersonale=new ImageIcon(this.getClass().getResource("/cameraResort.jpg"));
		lblPersonale.setIcon(imgPersonale);
		lblPersonale.setBounds(0, 57, 929, 167);
		panelHomCli.add(lblPersonale);
		
		JLabel lblNewLabel51 = new JLabel("PROFILO PERSONALE");
		lblNewLabel51.setFont(new Font(font1, Font.BOLD, 30));
		lblNewLabel51.setBounds(21, 235, 339, 39);
		panelHomCli.add(lblNewLabel51);
		
		lblModifica = new JLabel("");
		lblModifica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModifica.setBounds(416, 464, 503, 52);
		panel.add(lblModifica);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(603, -13, 66, 84);
		panelHomCli.add(labell4);
		
		JPanel panel71 = new JPanel();
		panel71.setBackground(new Color(0, 0, 0));
		panel71.setBounds(0, 0, 929, 58);
		panelHomCli.add(panel71);
	}

}
