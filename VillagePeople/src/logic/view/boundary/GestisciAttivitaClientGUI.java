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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class GestisciAttivitaClientGUI {

	private JFrame frame;
	private JTextPane txtCodiceId;
	private JLabel lblError;
	
	public JLabel getLblError() {
		return lblError;
	}

	public JTextPane getTxtCodiceId() {
		return txtCodiceId;
	}


	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Create the application.
	 */
	public GestisciAttivitaClientGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1 = "Dialog";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 937, 663);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 923, 626);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel(" VillagePeople ");
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblNewLabel.setBounds(322, -2, 276, 58);
		panel.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Notifiche");
		tglbtnNewToggleButton.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoNotifiche();
			frame.setVisible(false);
	    });
		tglbtnNewToggleButton.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(780, 175, 149, 33);
		panel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPrenotaAttivit = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivit.setEnabled(false);
		tglbtnPrenotaAttivit.setSelected(true);
		tglbtnPrenotaAttivit.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivit.setBounds(624, 175, 159, 33);
		panel.add(tglbtnPrenotaAttivit);
		
		JToggleButton tglbtnMenDelGiorno = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiorno.addActionListener((ActionEvent e) -> {
				StartApplication.c1.switchtoMenu();
				frame.setVisible(false);
		});
		tglbtnMenDelGiorno.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiorno.setBounds(479, 175, 149, 33);
		panel.add(tglbtnMenDelGiorno);
		
		JToggleButton tglbtnNotifiche = new JToggleButton("Profilo Personale");
		tglbtnNotifiche.addActionListener((ActionEvent e) -> {
				StartApplication.c1.switchtoHomepage();
				frame.setVisible(false);
		});
		tglbtnNotifiche.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifiche.setBounds(322, 175, 159, 33);
		panel.add(tglbtnNotifiche);
		
		JButton btnNewButton1 = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnNewButton1.setIcon(new ImageIcon(imgLogOut));
		btnNewButton1.addActionListener((ActionEvent e) -> 
                              StartApplication.c1.disconnessione(2));
		btnNewButton1.setFont(new Font(font, Font.BOLD, 10));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setBounds(831, 35, 92, 21);
		panel.add(btnNewButton1);
		
		JLabel lblNewLabel1 = new JLabel("Prenotazione attivit\u00E0 singole");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel1.setBounds(10, 274, 346, 71);
		panel.add(lblNewLabel1);
		
		JLabel lblNewLabel11 = new JLabel("Cancella Prenotazione");
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel11.setBounds(290, 445, 273, 71);
		panel.add(lblNewLabel11);
		
		JButton prenota = new JButton("Prenota");
		Image imgPrenota=new ImageIcon(this.getClass().getResource("/prenotazione2.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		prenota.setIcon(new ImageIcon(imgPrenota));
		prenota.addActionListener((ActionEvent e) -> {
			   frame.setVisible(false);
		       StartApplication.c1.switchToPrenotation(1);
		});
		prenota.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		prenota.setBounds(99, 406, 133, 33);
		panel.add(prenota);
		
		JButton btnNewButton21 = new JButton("Cancella");
		Image imgCancella=new ImageIcon(this.getClass().getResource("/cancella.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnNewButton21.setIcon(new ImageIcon(imgCancella));
		btnNewButton21.addActionListener((ActionEvent e) -> {
			   frame.setVisible(false);
		       StartApplication.c1.switchtoEliminaPrenotazione();
		});
		btnNewButton21.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		btnNewButton21.setBounds(371, 507, 149, 33);
		panel.add(btnNewButton21);
		
		JLabel codiceId = new JLabel("CodiceId: ");
		codiceId.setBackground(new Color(255, 160, 122));
		codiceId.setForeground(new Color(255, 160, 122));
		codiceId.setVerticalAlignment(SwingConstants.TOP);
		codiceId.setFont(new Font(font1, Font.BOLD, 11));
		codiceId.setBounds(10, 37, 56, 14);
		panel.add(codiceId);
		
		txtCodiceId = new JTextPane();
		txtCodiceId.setForeground(new Color(255, 160, 122));
		txtCodiceId.setBackground(new Color(0, 0, 0));
		txtCodiceId.setEditable(false);
		txtCodiceId.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceId.setBounds(65, 35, 92, 21);
		panel.add(txtCodiceId);
		
		JLabel lblPrenotazioneAttivitIn = new JLabel("Prenotazione attivit\u00E0 in team");
		lblPrenotazioneAttivitIn.setFont(new Font(font, Font.BOLD, 25));
		lblPrenotazioneAttivitIn.setBounds(517, 274, 365, 71);
		panel.add(lblPrenotazioneAttivitIn);
		
		JButton prenota1 = new JButton("Prenota");
		Image imgPrenota1=new ImageIcon(this.getClass().getResource("/prenotazione2.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		prenota1.setIcon(new ImageIcon(imgPrenota1));
		prenota1.addActionListener((ActionEvent e) -> {
			   frame.setVisible(false);
		       StartApplication.c1.switchToPrenotation(2);
		});
		prenota1.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		prenota1.setBounds(642, 406, 141, 33);
		panel.add(prenota1);
		
		JLabel lblAttivita = new JLabel("");
		ImageIcon imgAttivita=new ImageIcon(this.getClass().getResource("/villaggioT.jpg"));
		lblAttivita.setIcon(imgAttivita);
		lblAttivita.setBounds(0, 57, 929, 151);
		panel.add(lblAttivita);
		
		JLabel lblNewLabel221 = new JLabel("GESTISCI ATTIVITA'");
		lblNewLabel221.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel221.setBounds(10, 219, 329, 44);
		panel.add(lblNewLabel221);
		
		JLabel lblattSingola = new JLabel("");
		Image imgAttSingola=new ImageIcon(this.getClass().getResource("/attivitaSingola.jpeg")).getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		lblattSingola.setIcon(new ImageIcon(imgAttSingola));
		lblattSingola.setBounds(100, 324, 120, 71);
		panel.add(lblattSingola);
		
		JLabel lblattGruppo = new JLabel("");
		Image imgAttGruppo=new ImageIcon(this.getClass().getResource("/attivitaDiGruppo.jpg")).getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		lblattGruppo.setIcon(new ImageIcon(imgAttGruppo));
		lblattGruppo.setBounds(642, 324, 121, 71);
		panel.add(lblattGruppo);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(606, -16, 66, 84);
		panel.add(labell4);
		
		JPanel panel231 = new JPanel();
		panel231.setBackground(new Color(0, 0, 0));
		panel231.setBounds(-42, -2, 971, 70);
		panel.add(panel231);
		
		lblError = new JLabel("");
		lblError.setFont(new Font(font1, Font.BOLD, 17));
		lblError.setBounds(624, 547, 228, 33);
		panel.add(lblError);
	}
}
