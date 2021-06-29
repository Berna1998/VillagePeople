package logic.view.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;



public class HomepageAdminGUI {

	private JFrame frameHomAdm;
	private JTextPane textNomeHomAdm;
	private JTextPane textCognomeHomAdm;
	private JTextPane textCodiceHomAdm;
	private JTextPane textEmailHomAdm;
	private JTextPane textNumeroUtentiHomAdm;
	private JLabel lblErrorHomAdm;
	
	
	
	public JLabel getLblError() {
		return lblErrorHomAdm;
	}

	public JFrame getFrame() {
		return frameHomAdm;
	}

	public JTextPane getTextNome() {
		return textNomeHomAdm;
	}

	public JTextPane getTextCognome() {
		return textCognomeHomAdm;
	}

	public JTextPane getTextCodice() {
		return textCodiceHomAdm;
	}

	public JTextPane getTextEmail() {
		return textEmailHomAdm;
	}

	public JTextPane getTextNumeroUtenti() {
		return textNumeroUtentiHomAdm;
	}

	public HomepageAdminGUI() {
		
		String font = "Georgia Pro Semibold";
		
		frameHomAdm = new JFrame();
		frameHomAdm.setBounds(100, 100, 943, 693);
		frameHomAdm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameHomAdm.getContentPane().setLayout(null);
		
		JPanel panelHomAdm = new JPanel();
		panelHomAdm.setLayout(null);
		panelHomAdm.setBackground(new Color(255, 160, 122));
		panelHomAdm.setBounds(0, 0, 929, 656);
		frameHomAdm.getContentPane().add(panelHomAdm);
		
		JLabel lblHomAdm = new JLabel(" VillagePeople ");
		lblHomAdm.setForeground(new Color(255, 160, 122));
		lblHomAdm.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblHomAdm.setBounds(323, 0, 282, 58);
		panelHomAdm.add(lblHomAdm);
		
		JToggleButton tglbtnNotifHomAdm = new JToggleButton("Notifiche");
		tglbtnNotifHomAdm.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchtoNotificheAdmin();
			frame.setVisible(false);
	    });
		tglbtnNotifHomAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifHomAdm.setBounds(780, 191, 149, 33);
		panelHomAdm.add(tglbtnNotifHomAdm);
		
		JToggleButton tglbtnPrenotaAttivit = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivit.addActionListener((ActionEvent e) -> {
				StartApplication.c2.switchtoGestisciAttivitaAdmin();
				frame.setVisible(false);
		});
		
		tglbtnPrenotaAttivit.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivit.setBounds(637, 191, 149, 33);
		panelHomAdm.add(tglbtnPrenotaAttivit);
		
		JToggleButton tglbtnMenDelGiorno = new JToggleButton("Men\u00F9 ");
		tglbtnMenDelGiorno.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchtoMenu();
			frameHomAdm.setVisible(false);				
		
		});
		tglbtnMenDelGiorno.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiorno.setBounds(490, 191, 149, 33);
		panelHomAdm.add(tglbtnMenDelGiorno);
		
		JToggleButton tglbtnNotifiche = new JToggleButton("Profilo Personale");
		tglbtnNotifiche.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifiche.setEnabled(false);
		tglbtnNotifiche.setSelected(true);
		tglbtnNotifiche.setBounds(333, 191, 159, 33);
		panelHomAdm.add(tglbtnNotifiche);
		
		JLabel lblNewLabel2 = new JLabel("Nome:");
		lblNewLabel2.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel2.setBounds(29, 295, 155, 35);
		panelHomAdm.add(lblNewLabel2);
		
		JLabel lblNewLabel21 = new JLabel("Cognome:");
		lblNewLabel21.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel21.setBounds(29, 356, 155, 35);
		panelHomAdm.add(lblNewLabel21);
		
		JLabel lblNewLabel22 = new JLabel("CodiceID:");
		lblNewLabel22.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel22.setBounds(29, 416, 155, 35);
		panelHomAdm.add(lblNewLabel22);
		
		JLabel lblNewLabel23 = new JLabel("E-mail:");
		lblNewLabel23.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel23.setBounds(501, 295, 155, 35);
		panelHomAdm.add(lblNewLabel23);
		
		textNomeHomAdm = new JTextPane();
		textNomeHomAdm.setFont(new Font(font, Font.BOLD, 24));
		textNomeHomAdm.setBackground(new Color(255, 160, 122));
		textNomeHomAdm.setEditable(false);
		textNomeHomAdm.setBounds(186, 295, 241, 35);
		panelHomAdm.add(textNomeHomAdm);
		
		textCognomeHomAdm = new JTextPane();
		textCognomeHomAdm.setFont(new Font(font, Font.BOLD, 24));
		textCognomeHomAdm.setBackground(new Color(255, 160, 122));
		textCognomeHomAdm.setEditable(false);
		textCognomeHomAdm.setBounds(186, 356, 241, 35);
		panelHomAdm.add(textCognomeHomAdm);
		
		textCodiceHomAdm = new JTextPane();
		textCodiceHomAdm.setFont(new Font(font, Font.BOLD, 24));
		textCodiceHomAdm.setBackground(new Color(255, 160, 122));
		textCodiceHomAdm.setEditable(false);
		textCodiceHomAdm.setBounds(186, 416, 202, 35);
		panelHomAdm.add(textCodiceHomAdm);
		
		textEmailHomAdm = new JTextPane();
		textEmailHomAdm.setEditable(false);
		textEmailHomAdm.setFont(new Font(font, Font.BOLD, 24));
		textEmailHomAdm.setBackground(new Color(255, 160, 122));
		textEmailHomAdm.setBounds(580, 295, 339, 35);
		panelHomAdm.add(textEmailHomAdm);
		
		JButton btnLogOutHomAdm = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnLogOutHomAdm.setIcon(new ImageIcon(imgLogOut));
		btnLogOutHomAdm.addActionListener((ActionEvent e) -> 
                         StartApplication.c2.disconnessione(1));
		btnLogOutHomAdm.setFont(new Font(font, Font.BOLD, 10));
		btnLogOutHomAdm.setBackground(Color.LIGHT_GRAY);
		btnLogOutHomAdm.setBounds(833, 37, 96, 21);
		panelHomAdm.add(btnLogOutHomAdm);
		
		JLabel lblNewLabel221 = new JLabel("Numero Utenti:");
		lblNewLabel221.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel221.setBounds(490, 356, 248, 35);
		panelHomAdm.add(lblNewLabel221);
		
		textNumeroUtentiHomAdm = new JTextPane();
		textNumeroUtentiHomAdm.setEditable(false);
		textNumeroUtentiHomAdm.setFont(new Font(font, Font.BOLD, 24));
		textNumeroUtentiHomAdm.setBackground(new Color(255, 160, 122));
		textNumeroUtentiHomAdm.setBounds(684, 356, 159, 35);
		panelHomAdm.add(textNumeroUtentiHomAdm);
		
		
		JLabel lblPersonale = new JLabel("lblPersonale");
		ImageIcon imgPersonale=new ImageIcon(this.getClass().getResource("/cameraResort.jpg"));
		lblPersonale.setIcon(imgPersonale);
		lblPersonale.setBounds(0, 57, 929, 167);
		panel.add(lblPersonale);
		
		JLabel lblNewLabel311 = new JLabel("PROFILO PERSONALE");
		lblNewLabel311.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel311.setBounds(21, 235, 339, 39);
		panelHomAdm.add(lblNewLabel311);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(603, -13, 66, 84);
		panelHomAdm.add(labell4);
		
		JPanel panel22341 = new JPanel();
		panel22341.setBackground(new Color(0, 0, 0));
		panel22341.setBounds(0, 0, 929, 58);
		panelHomAdm.add(panel22341);
		
		JButton btnAggiungi = new JButton("Aggiungi cliente");
		Image imgAggiungi = new ImageIcon(this.getClass().getResource("/aggiungi.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnAggiungi.setIcon(new ImageIcon(imgAggiungi));
		btnAggiungi.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchToAggiungiCliente();
			frame.setVisible(false);
	    });
		btnAggiungi.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		btnAggiungi.setBounds(702, 416, 183, 35);
		panelHomAdm.add(btnAggiungi);
		
		lblErrorHomAdm = new JLabel("");
		lblErrorHomAdm.setBounds(292, 462, 248, 60);
		panelHomAdm.add(lblErrorHomAdm);
	}
}
