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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class NotificheAdminGUI implements Observer {

	private JFrame frameNotifAdm;
	private JTextArea textArea;
	private JLabel lblError;
	
	@Override
	public void update(String s, String codice) {
		if (s.equals("intolleranze")) {
			StartApplication.c2.aggiungiNotificaIntolleranze(codice);
		} else if (s.equals("penale")) {
			StartApplication.c2.aggiungiNotificaPenale(codice);
		}
	}
		
	public JLabel getLblError() {
		return lblError;
	}

	public JFrame getFrame() {
		return frameNotifAdm;
	}

	/**
	 * Create the application.
	 */
	public NotificheAdminGUI() {
		
		String font = "Georgia Pro Semibold";
		
		frameNotifAdm = new JFrame();
		frameNotifAdm.setBounds(100, 100, 937, 663);
		frameNotifAdm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameNotifAdm.getContentPane().setLayout(null);
		
		JPanel panelNotifAdm = new JPanel();
		panelNotifAdm.setLayout(null);
		panelNotifAdm.setBackground(new Color(255, 160, 122));
		panelNotifAdm.setBounds(0, 0, 929, 656);
		frameNotifAdm.getContentPane().add(panelNotifAdm);
		
		JLabel lblNotifAdm = new JLabel(" VillagePeople ");
		lblNotifAdm.setForeground(new Color(255, 160, 122));
		lblNotifAdm.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblNotifAdm.setBounds(333, 0, 291, 58);
		panelNotifAdm.add(lblNotifAdm;
		
		JToggleButton tglbtnNotifAdm = new JToggleButton("Notifiche");
		tglbtnNotifAdm.setEnabled(false);
		tglbtnNotifAdm.setSelected(true);
		tglbtnNotifAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifAdm.setBounds(780, 150, 149, 33);
		panelNotifAdm.add(tglbtnNotifAdm);
		
		JToggleButton tglbtnPrenotaAttivitNotifAdm = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivitNotifAdm.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchtoGestisciAttivitaAdmin();
			frameNotifAdm.setVisible(false);
		});
		
		tglbtnPrenotaAttivitNotifAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivitNotifAdm.setBounds(634, 150, 149, 33);
		panelNotifAdm.add(tglbtnPrenotaAttivitNotifAdm);
		
		JToggleButton tglbtnMenDelGiornoNotifAdm = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiornoNotifAdm.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchtoMenu();
			frameNotifAdm.setVisible(false);
	    });
			
		tglbtnMenDelGiornoNotifAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiornoNotifAdm.setBounds(487, 150, 149, 33);
		panelNotifAdm.add(tglbtnMenDelGiornoNotifAdm);
		
		JToggleButton tglbtnHomepageNotifAdm = new JToggleButton("Profilo Personale");
		tglbtnHomepageNotifAdm.addActionListener((ActionEvent e) -> {
			StartApplication.c2.switchtoHomepage();
			frameNotifAdm.setVisible(false);
		});
		
		tglbtnHomepageNotifAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnHomepageNotifAdm.setBounds(333, 150, 159, 33);
		panelNotifAdm.add(tglbtnHomepageNotifAdm);
		
		JButton btnLogOutNotifAdm = new JButton("Log out");
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnLogOutNotifAdm.setIcon(new ImageIcon(imgLogOut));
		btnLogOutNotifAdm.addActionListener((ActionEvent e) -> 
                           StartApplication.c2.disconnessione(4));
		btnLogOutNotifAdm.setFont(new Font(font, Font.BOLD, 10));
		btnLogOutNotifAdm.setBackground(Color.LIGHT_GRAY);
		btnLogOutNotifAdm.setBounds(827, 37, 102, 21);
		panelNotifAdm.add(btnLogOutNotifAdm);
		
		JLabel lbl2NotifAdm = new JLabel("Notifiche");
		lbl2NotifAdm.setFont(new Font(font, Font.BOLD, 24));
		lbl2NotifAdm.setHorizontalAlignment(SwingConstants.LEFT);
		lbl2NotifAdm.setBounds(34, 176, 306, 41);
		panelNotifAdm.add(lbl2NotifAdm);
		
		JScrollPane scrollPaneNotifAdm = new JScrollPane();
		scrollPaneNotifAdm.setBounds(35, 215, 859, 370);
		panelNotifAdm.add(scrollPaneNotifAdm);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 171, 746, 414);
		textArea.setBackground(new Color(255, 218, 185));
		textArea.setEditable(false);
		scrollPaneNotifAdm.setViewportView(textArea);
		
		
		JLabel lblNotificheNotifAdm = new JLabel("");
		ImageIcon imgNotifiche=new ImageIcon(this.getClass().getResource("/notifiche-fb.jpg"));
		lblNotificheNotifAdm.setIcon(imgNotifiche);
		lblNotificheNotifAdm.setBounds(0, 58, 850, 125);
		panelNotifAdm.add(lblNotificheNotifAdm);
		
		JLabel lblNotifiche2NotifAdm = new JLabel("");
		lblNotifiche2NotifAdm.setIcon(imgNotifiche);
		lblNotifiche2NotifAdm.setBounds(848, 58, 81, 125);
		panelNotifAdm.add(lblNotifiche2NotifAdm);
		
		JLabel lbl3NotifAdm = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		lbl3NotifAdm.setIcon(new ImageIcon(img7));
		lbl3NotifAdm.setBounds(608, -15, 66, 84);
		panelNotifAdm.add(lbl3NotifAdm);
		
		JPanel panel9991 = new JPanel();
		panel9991.setBackground(Color.BLACK);
		panel9991.setBounds(0, 0, 929, 58);
		panelNotifAdm.add(panel9991);
		
		lblError = new JLabel("");
		lblError.setBounds(99, 589, 537, 21);
		panelNotifAdm.add(lblError);
	}

	public JTextArea getTextArea() {
		return textArea;
	}


	@Override
	public void update(String tipo, int cod, String categoria) {//NOT USED
		
	}


	@Override
	public void update(String s) {//NOT USED
		
	}

}
