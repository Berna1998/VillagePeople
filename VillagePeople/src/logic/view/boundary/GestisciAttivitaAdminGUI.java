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

	private JFrame frame;
	private JLabel lblError;
	
	public JLabel getLblError() {
		return lblError;
	}

	public JFrame getFrame() {
		return frame;
	}

	public GestisciAttivitaAdminGUI() {
		
		String font = "Georgia Pro Semibold";
		
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
			StartApplication.c2.switchtoNotificheAdmin();
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
		panel.add(tglbtnNotifiche);
		
		JButton btnNewButton1 = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnNewButton1.setIcon(new ImageIcon(imgLogOut));
		btnNewButton1.addActionListener((ActionEvent e) -> 
                          StartApplication.c2.disconnessione(2));
		btnNewButton1.setFont(new Font(font, Font.BOLD, 10));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setBounds(831, 35, 92, 21);
		panel.add(btnNewButton1);
		
		JLabel lblNewLabel11 = new JLabel("Aggiungi Attivit\u00E0");
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel11.setBounds(136, 274, 203, 71);
		panel.add(lblNewLabel11);
		
		JLabel lblNewLabel111 = new JLabel("Cancella Attivit\u00E0");
		lblNewLabel111.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel111.setBounds(343, 444, 203, 71);
		panel.add(lblNewLabel111);
		
		JButton aggiungi = new JButton("Aggiungi");
		Image imgAggiungi = new ImageIcon(this.getClass().getResource("/aggiungi.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		aggiungi.setIcon(new ImageIcon(imgAggiungi));
		aggiungi.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
	       StartApplication.c2.switchtoSelectCategories();
		});
		aggiungi.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		aggiungi.setBounds(159, 332, 133, 33);
		panel.add(aggiungi);
		
		JButton cancella = new JButton("Cancella");
		Image imgCancella=new ImageIcon(this.getClass().getResource("/cancella.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		cancella.setIcon(new ImageIcon(imgCancella));
		cancella.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
	       StartApplication.c2.switchtoEliminaAttivita();
		});
		cancella.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		cancella.setBounds(375, 505, 133, 33);
		panel.add(cancella);
		
		JLabel lblNewLabel12 = new JLabel("Modifica  Attivit\u00E0");
		lblNewLabel12.setFont(new Font(font, Font.BOLD, 25));
		lblNewLabel12.setBounds(580, 274, 203, 71);
		panel.add(lblNewLabel12);
		
		JButton modifica = new JButton("Modifica");
		Image imgModifica=new ImageIcon(this.getClass().getResource("/modifica.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		modifica.setIcon(new ImageIcon(imgModifica));
		modifica.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
	       StartApplication.c2.switchtoModificaAttivita();
		});
		modifica.setFont(new Font(font, Font.BOLD | Font.ITALIC, 15));
		modifica.setBounds(617, 332, 141, 33);
		panel.add(modifica);
		
		JLabel lblAttivita = new JLabel("");
		ImageIcon imgAttivita=new ImageIcon(this.getClass().getResource("/villaggioT.jpg"));
		lblAttivita.setIcon(imgAttivita);
		lblAttivita.setBounds(0, 57, 929, 151);
		panel.add(lblAttivita);
		
		JLabel lblNewLabel11111 = new JLabel("GESTISCI ATTIVITA'");
		lblNewLabel11111.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel11111.setBounds(10, 219, 329, 44);
		panel.add(lblNewLabel11111);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(606, -16, 66, 84);
		panel.add(labell4);
		
		JPanel panel21 = new JPanel();
		panel21.setBackground(new Color(0, 0, 0));
		panel21.setBounds(-42, -2, 971, 70);
		panel.add(panel21);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Dialog", Font.BOLD, 17));
		lblError.setBounds(661, 507, 203, 33);
		panel.add(lblError);
	}

}
