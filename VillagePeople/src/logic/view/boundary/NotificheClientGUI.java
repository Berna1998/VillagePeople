package logic.view.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;

public class NotificheClientGUI implements Observer {

	private JFrame frame;
	private JTextArea testo;
	private JTextPane txtCodiceId;
	private JLabel lblMsgNotifiche;

	public JLabel getLblMsgNotifiche() {
		return lblMsgNotifiche;
	}

	@Override
	public void update(String s) {
		if (s.equals("menu")) {
			StartApplication.c1.aggiungiNotificaMenu();
		} 
	}
	

	@Override
	public void update(String s, String codice) {//NOT USED

	}
	
	@Override
	public void update(String s, int codiceAtt, String categoria) {

		if (s.equals("modifica")) {
		   StartApplication.c1.aggiungiNotificaModificaAttivita(categoria, codiceAtt);
	    }
		else if (s.equals("elimina")) {
			
		   StartApplication.c1.aggiungiNotificaEliminaAttivita(categoria, codiceAtt);
		}
		else if (s.equals("team")) {
		   StartApplication.c1.aggiungiNotificaAttivitaGruppo(categoria, codiceAtt);
		} else if (s.equals("postoLibero")) {
			
		   StartApplication.c1.aggiungiNotificaPostoLibero(categoria,codiceAtt);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public NotificheClientGUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 937, 663);
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
		lblNewLabel.setBounds(333, 0, 291, 58);
		panel.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Notifiche ");
		tglbtnNewToggleButton.setEnabled(false);
		tglbtnNewToggleButton.setSelected(true);
		tglbtnNewToggleButton.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(780, 150, 149, 33);
		panel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPrenotaAttivit = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivit.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoGestisciAttivitaClient();
			frame.setVisible(false);
		});
		
		tglbtnPrenotaAttivit.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivit.setBounds(634, 150, 149, 33);
		panel.add(tglbtnPrenotaAttivit);
		
		JToggleButton tglbtnMenDelGiorno = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiorno.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoMenu();
			frame.setVisible(false);
	    });
			
		tglbtnMenDelGiorno.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiorno.setBounds(487, 150, 149, 33);
		panel.add(tglbtnMenDelGiorno);
		
		JToggleButton tglbtnNotifiche = new JToggleButton("Profilo Personale");
		tglbtnNotifiche.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoHomepage();
			frame.setVisible(false);
		});
		
		tglbtnNotifiche.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifiche.setBounds(333, 150, 159, 33);
		panel.add(tglbtnNotifiche);
		
		JButton btnNewButton1 = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnNewButton1.setIcon(new ImageIcon(imgLogOut));
		btnNewButton1.addActionListener((ActionEvent e) -> 
            StartApplication.c1.disconnessione(4));
		btnNewButton1.setFont(new Font(font, Font.BOLD, 10));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setBounds(827, 37, 102, 21);
		panel.add(btnNewButton1);
		
		JLabel lblNewLabel11 = new JLabel("Notifiche");
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel11.setBounds(34, 176, 306, 41);
		panel.add(lblNewLabel11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 215, 859, 370);
		panel.add(scrollPane);
		
		
		testo = new JTextArea();
		testo.setEditable(false);
		testo.setBackground(new Color(255, 218, 185));
		testo.setBounds(10, 171, 746, 414);
		scrollPane.setViewportView(testo);
		
		JLabel codiceId = new JLabel("CodiceId: ");
		codiceId.setForeground(new Color(255, 160, 122));
		codiceId.setVerticalAlignment(SwingConstants.TOP);
		codiceId.setFont(new Font(font1, Font.BOLD, 11));
		codiceId.setBounds(10, 33, 62, 14);
		panel.add(codiceId);
		
		txtCodiceId = new JTextPane();
		txtCodiceId.setForeground(new Color(255, 160, 122));
		txtCodiceId.setBackground(new Color(0, 0, 0));
		txtCodiceId.setEditable(false);
		txtCodiceId.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceId.setBounds(62, 26, 92, 21);
		panel.add(txtCodiceId);
		
		
		JLabel lblNotifiche = new JLabel("");
		ImageIcon imgNotifiche=new ImageIcon(this.getClass().getResource("/notifiche-fb.jpg"));
		lblNotifiche.setIcon(imgNotifiche);
		lblNotifiche.setBounds(0, 58, 850, 125);
		panel.add(lblNotifiche);
		
		JLabel lblNotifiche2 = new JLabel("");
		lblNotifiche2.setIcon(imgNotifiche);
		lblNotifiche2.setBounds(848, 58, 81, 125);
		panel.add(lblNotifiche2);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(608, -15, 66, 84);
		panel.add(labell4);
		
		JPanel panel71 = new JPanel();
		panel71.setBackground(Color.BLACK);
		panel71.setBounds(0, 0, 929, 58);
		panel.add(panel71);
		
		lblMsgNotifiche = new JLabel("");
		lblMsgNotifiche.setBounds(205, 187, 287, 30);
		panel.add(lblMsgNotifiche);
	}
	
	

	public JTextPane getTxtCodiceId() {
		return txtCodiceId;
	}

	public JTextArea getTextArea() {
		return testo;
	}

}