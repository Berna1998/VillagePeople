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

	private JFrame frameGestAttCli;
	private JTextPane txtCodiceIdGestAttCli;
	private JLabel lblErrorGestAttCli;
	
	public JLabel getLblError() {
		return lblErrorGestAttCli;
	}

	public JTextPane getTxtCodiceId() {
		return txtCodiceIdGestAttCli;
	}


	public JFrame getFrame() {
		return frameGestAttCli;
	}


	/**
	 * Create the application.
	 */
	public GestisciAttivitaClientGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1 = "Dialog";
		
		frameGestAttCli = new JFrame();
		frameGestAttCli.setBounds(100, 100, 937, 663);
		frameGestAttCli.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameGestAttCli.getContentPane().setLayout(null);
		
		JPanel panelGestAttCli = new JPanel();
		panelGestAttCli.setLayout(null);
		panelGestAttCli.setBackground(new Color(255, 160, 122));
		panelGestAttCli.setBounds(0, 0, 923, 626);
		frameGestAttCli.getContentPane().add(panelGestAttCli);
		
		JLabel lblGestAttCli = new JLabel(" VillagePeople ");
		lblGestAttCli.setForeground(new Color(255, 160, 122));
		lblGestAttCli.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblGestAttCli.setBounds(322, -2, 276, 58);
		panelGestAttCli.add(lblGestAttCli);
		
		JToggleButton tglbtnNotificheGestAttCli = new JToggleButton("Notifiche");
		tglbtnNotificheGestAttCli.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoNotifiche();
			frame.setVisible(false);
	    });
		tglbtnNotificheGestAttCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotificheGestAttCli.setBounds(780, 175, 149, 33);
		panelGestAttCli.add(tglbtnNotificheGestAttCli);
		
		JToggleButton tglbtnPrenotaAttivitGestAttCli = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivitGestAttCli.setEnabled(false);
		tglbtnPrenotaAttivitGestAttCli.setSelected(true);
		tglbtnPrenotaAttivitGestAttCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivitGestAttCli.setBounds(624, 175, 159, 33);
		panelGestAttCli.add(tglbtnPrenotaAttivitGestAttCli);
		
		JToggleButton tglbtnMenDelGiornoGestAttCli = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiornoGestAttCli.addActionListener((ActionEvent e) -> {
				StartApplication.c1.switchtoMenu();
				frame.setVisible(false);
		});
		tglbtnMenDelGiornoGestAttCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiornoGestAttCli.setBounds(479, 175, 149, 33);
		panelGestAttCli.add(tglbtnMenDelGiornoGestAttCli);
		
		JToggleButton tglbtnNotificheGestAttCli = new JToggleButton("Profilo Personale");
		tglbtnNotifiche.addActionListener((ActionEvent e) -> {
				StartApplication.c1.switchtoHomepage();
				frame.setVisible(false);
		});
		tglbtnNotificheGestAttCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotificheGestAttCli.setBounds(322, 175, 159, 33);
		panelGestAttCli.add(tglbtnNotificheGestAttCli);
		
		JButton btnLogOutGestAttCli = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnLogOutGestAttCli .setIcon(new ImageIcon(imgLogOut));
		btnLogOutGestAttCli .addActionListener((ActionEvent e) -> 
                              StartApplication.c1.disconnessione(2));
		btnLogOutGestAttCli .setFont(new Font(font, Font.BOLD, 10));
		btnLogOutGestAttCli .setBackground(Color.LIGHT_GRAY);
		btnLogOutGestAttCli .setBounds(831, 35, 92, 21);
		panelGestAttCli.add(btnLogOutGestAttCli );
		
		JLabel lblNewLabel1 = new JLabel("Prenotazione attivit\u00E0 singole");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel1.setBounds(10, 274, 346, 71);
		panelGestAttCli.add(lblNewLabel1);
		
		JLabel lblNewLabel11 = new JLabel("Cancella Prenotazione");
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel11.setBounds(290, 445, 273, 71);
		panelGestAttCli.add(lblNewLabel11);
		
		JButton prenota = new JButton("Prenota");
		Image imgPrenota=new ImageIcon(this.getClass().getResource("/prenotazione2.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		prenota.setIcon(new ImageIcon(imgPrenota));
		prenota.addActionListener((ActionEvent e) -> {
			   frame.setVisible(false);
		       StartApplication.c1.switchToPrenotation(1);
		});
		prenota.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		prenota.setBounds(99, 406, 133, 33);
		panelGestAttCli.add(prenota);
		
		JButton btnNewButton21 = new JButton("Cancella");
		Image imgCancella=new ImageIcon(this.getClass().getResource("/cancella.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnNewButton21.setIcon(new ImageIcon(imgCancella));
		btnNewButton21.addActionListener((ActionEvent e) -> {
			   frame.setVisible(false);
		       StartApplication.c1.switchtoEliminaPrenotazione();
		});
		btnNewButton21.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		btnNewButton21.setBounds(371, 507, 149, 33);
		panelGestAttCli.add(btnNewButton21);
		
		JLabel codiceIdGestAttCli = new JLabel("CodiceId: ");
		codiceIdGestAttCli.setBackground(new Color(255, 160, 122));
		codiceIdGestAttCli.setForeground(new Color(255, 160, 122));
		codiceIdGestAttCli.setVerticalAlignment(SwingConstants.TOP);
		codiceIdGestAttCli.setFont(new Font(font1, Font.BOLD, 11));
		codiceIdGestAttCli.setBounds(10, 37, 56, 14);
		panelGestAttCli.add(codiceIdGestAttCli);
		
		txtCodiceIdGestAttCli = new JTextPane();
		txtCodiceIdGestAttCli.setForeground(new Color(255, 160, 122));
		txtCodiceIdGestAttCli.setBackground(new Color(0, 0, 0));
		txtCodiceIdGestAttCli.setEditable(false);
		txtCodiceIdGestAttCli.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceIdGestAttCli.setBounds(65, 35, 92, 21);
		panelGestAttCli.add(txtCodiceIdGestAttCli);
		
		JLabel lblPrenotazioneAttivitIn = new JLabel("Prenotazione attivit\u00E0 in team");
		lblPrenotazioneAttivitIn.setFont(new Font(font, Font.BOLD, 25));
		lblPrenotazioneAttivitIn.setBounds(517, 274, 365, 71);
		panelGestAttCli.add(lblPrenotazioneAttivitIn);
		
		JButton prenota1 = new JButton("Prenota");
		Image imgPrenota1=new ImageIcon(this.getClass().getResource("/prenotazione2.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		prenota1.setIcon(new ImageIcon(imgPrenota1));
		prenota1.addActionListener((ActionEvent e) -> {
			   frame.setVisible(false);
		       StartApplication.c1.switchToPrenotation(2);
		});
		prenota1.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		prenota1.setBounds(642, 406, 141, 33);
		panelGestAttCli.add(prenota1);
		
		JLabel lblAttivita = new JLabel("");
		ImageIcon imgAttivita=new ImageIcon(this.getClass().getResource("/villaggioT.jpg"));
		lblAttivita.setIcon(imgAttivita);
		lblAttivita.setBounds(0, 57, 929, 151);
		panelGestAttCli.add(lblAttivita);
		
		JLabel lblNewLabel221 = new JLabel("GESTISCI ATTIVITA'");
		lblNewLabel221.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel221.setBounds(10, 219, 329, 44);
		panelGestAttCli.add(lblNewLabel221);
		
		JLabel lblattSingola = new JLabel("");
		Image imgAttSingola=new ImageIcon(this.getClass().getResource("/attivitaSingola.jpeg")).getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		lblattSingola.setIcon(new ImageIcon(imgAttSingola));
		lblattSingola.setBounds(100, 324, 120, 71);
		panelGestAttCli.add(lblattSingola);
		
		JLabel lblattGruppo = new JLabel("");
		Image imgAttGruppo=new ImageIcon(this.getClass().getResource("/attivitaDiGruppo.jpg")).getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		lblattGruppo.setIcon(new ImageIcon(imgAttGruppo));
		lblattGruppo.setBounds(642, 324, 121, 71);
		panelGestAttCli.add(lblattGruppo);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(606, -16, 66, 84);
		panelGestAttCli.add(labell4);
		
		JPanel panel231 = new JPanel();
		panel231.setBackground(new Color(0, 0, 0));
		panel231.setBounds(-42, -2, 971, 70);
		panelGestAttCli.add(panel231);
		
		lblErrorGestAttCli = new JLabel("");
		lblErrorGestAttCli.setFont(new Font(font1, Font.BOLD, 17));
		lblErrorGestAttCli.setBounds(624, 547, 228, 33);
		panelGestAttCli.add(lblErrorGestAttCli);
	}
}
