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
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

public class GestisciAttivitaAdminGUI {

	private JFrame frameGestAttAdm;
	private JLabel lblErrorGestAttAdm;
	
	public JLabel getLblError() {
		return lblErrorGestAttAdm;
	}

	public JFrame getFrame() {
		return frameGestAttAdm;
	}

	public GestisciAttivitaAdminGUI() {
		
		String font = "Georgia Pro Semibold";
		
		frameGestAttAdm = new JFrame();
		frameGestAttAdm.setBounds(100, 100, 937, 663);
		frameGestAttAdm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameGestAttAdm.getContentPane().setLayout(null);
		
		JPanel panelGestAttAdm = new JPanel();
		panelGestAttAdm.setLayout(null);
		panelGestAttAdm.setBackground(new Color(255, 160, 122));
		panelGestAttAdm.setBounds(0, 0, 923, 626);
		frameGestAttAdm.getContentPane().add(panelGestAttAdm);
		
		JLabel lblGestAttAdm = new JLabel(" VillagePeople ");
		lblGestAttAdm.setForeground(new Color(255, 160, 122));
		lblGestAttAdm.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblGestAttAdm.setBounds(322, -2, 276, 58);
		panelGestAttAdm.add(lblGestAttAdm);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Notifiche");
		tglbtnNewToggleButton.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchtoNotificheAdmin();
			frame.setVisible(false);
	    });
		tglbtnNewToggleButton.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(780, 175, 149, 33);
		panelGestAttAdm.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPrenotaAttivit = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivit.setEnabled(false);
		tglbtnPrenotaAttivit.setSelected(true);
		tglbtnPrenotaAttivit.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivit.setBounds(624, 175, 159, 33);
		panelGestAttAdm.add(tglbtnPrenotaAttivit);
		
		JToggleButton tglbtnMenDelGiorno = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiorno.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchtoMenu();
			frame.setVisible(false);
		});
		tglbtnMenDelGiorno.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiorno.setBounds(479, 175, 149, 33);
		panel.add(tglbtnMenDelGiorno);
		
		JToggleButton tglbtnNotifiche = new JToggleButton("Profilo Personale");
		tglbtnNotifiche.addActionListener((ActionEvent e) -> { 
			StartApplication.c2.switchtoHomepage();
			frame.setVisible(false);
		});
		tglbtnNotifiche.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifiche.setBounds(322, 175, 159, 33);
		panelGestAttAdm.add(tglbtnNotifiche);
		
		JButton btnLogOutGestAttAdm = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnLogOutGestAttAdm.setIcon(new ImageIcon(imgLogOut));
		btnLogOutGestAttAdm.addActionListener((ActionEvent e) -> 
                          StartApplication.c2.disconnessione(2));
		btnLogOutGestAttAdm.setFont(new Font(font, Font.BOLD, 10));
		btnLogOutGestAttAdm.setBackground(Color.LIGHT_GRAY);
		btnLogOutGestAttAdm.setBounds(831, 35, 92, 21);
		panelGestAttAdm.add(btnLogOutGestAttAdm);
		
		JLabel lblGestAttAdm3 = new JLabel("Aggiungi Attivit\u00E0");
		lblGestAttAdm3.setFont(new Font(font, Font.BOLD, 25));
		lblGestAttAdm3.setBounds(136, 274, 203, 71);
		panelGestAttAdm.add(lblGestAttAdm3);
		
		JLabel lblGestAttAdm2 = new JLabel("Cancella Attivit\u00E0");
		lblGestAttAdm2.setFont(new Font(font, Font.BOLD, 25));
		lblGestAttAdm2.setBounds(343, 444, 203, 71);
		panelGestAttAdm.add(lblGestAttAdm2);
		
		JButton aggiungi = new JButton("Aggiungi");
		Image imgAggiungi = new ImageIcon(this.getClass().getResource("/aggiungi.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		aggiungi.setIcon(new ImageIcon(imgAggiungi));
		aggiungi.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
	       StartApplication.c2.switchtoSelectCategories();
		});
		aggiungi.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		aggiungi.setBounds(159, 332, 133, 33);
		panelGestAttAdm.add(aggiungi);
		
		JButton cancella = new JButton("Cancella");
		Image imgCancella=new ImageIcon(this.getClass().getResource("/cancella.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		cancella.setIcon(new ImageIcon(imgCancella));
		cancella.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
	       StartApplication.c2.switchtoEliminaAttivita();
		});
		cancella.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		cancella.setBounds(375, 505, 133, 33);
		panelGestAttAdm.add(cancella);
		
		JLabel lblNewLabel12 = new JLabel("Modifica  Attivit\u00E0");
		lblNewLabel12.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel12.setBounds(580, 274, 203, 71);
		panelGestAttAdm.add(lblNewLabel12);
		
		JButton modifica = new JButton("Modifica");
		Image imgModifica=new ImageIcon(this.getClass().getResource("/modifica.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		modifica.setIcon(new ImageIcon(imgModifica));
		modifica.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
	       StartApplication.c2.switchtoModificaAttivita();
		});
		modifica.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		modifica.setBounds(617, 332, 141, 33);
		panelGestAttAdm.add(modifica);
		
		JLabel lblAttivita = new JLabel("");
		ImageIcon imgAttivita=new ImageIcon(this.getClass().getResource("/villaggioT.jpg"));
		lblAttivita.setIcon(imgAttivita);
		lblAttivita.setBounds(0, 57, 929, 151);
		panelGestAttAdm.add(lblAttivita);
		
		JLabel lblNewLabel11111 = new JLabel("GESTISCI ATTIVITA'");
		lblNewLabel11111.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel11111.setBounds(10, 219, 329, 44);
		panelGestAttAdm.add(lblNewLabel11111);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(606, -16, 66, 84);
		panelGestAttAdm.add(labell4);
		
		JPanel panel21 = new JPanel();
		panel21.setBackground(new Color(0, 0, 0));
		panel21.setBounds(-42, -2, 971, 70);
		panelGestAttAdm.add(panel21);
		
		lblErrorGestAttAdm = new JLabel("");
		lblErrorGestAttAdm.setFont(new Font("Dialog", Font.BOLD, 17));
		lblErrorGestAttAdm.setBounds(661, 507, 203, 33);
		panelGestAttAdm.add(lblErrorGestAttAdm);
	}

}
