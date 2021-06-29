package logic.view.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class MenuAdminGUI  implements Subject {

	private JFrame frameMenuAdm;
	private JTextArea textArea;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JLabel lblErrore;
	private List<Observer> obMenuAdm = new ArrayList<>();
	
	@Override
	public void attach(Observer o) {
		this.obMenuAdm.add(o);
	}
		
	@Override
	public void notifica(String tipo) {
			for (Observer oo: obMenuAdm) {
				oo.update(tipo);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.obMenuAdm.contains(o)) {
			this.obMenuAdm.remove(o);
		}
	}


	public JLabel getLblErrore() {
		return lblErrore;
	}


	public JFrame getFrame() {
		return frameMenuAdm;
	}

	/**
	 * Create the application.
	 */
	public MenuAdminGUI() {
		
		String font = "Georgia Pro Semibold";
		
		frameMenuAdm = new JFrame();
		frameMenuAdm.setBounds(100, 100, 937, 663);
		frameMenuAdm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameMenuAdm.getContentPane().setLayout(null);
		
		JPanel panelMenuAdm = new JPanel();
		panelMenuAdm.setLayout(null);
		panelMenuAdm.setBackground(new Color(255, 160, 122));
		panelMenuAdm.setBounds(0, 0, 929, 656);
		frameMenuAdm.getContentPane().add(panelMenuAdm);
		
		JLabel lblNewLabel = new JLabel(" VillagePeople ");
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblNewLabel.setBounds(300, 0, 289, 58);
		panel.add(lblNewLabel);
		
		JToggleButton tglbtnNotifMenuAdm = new JToggleButton("Notifiche");
		tglbtnNotifMenuAdm .addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
			lblErrore.setIcon(new ImageIcon());
			StartApplication.c2.switchtoNotificheAdmin();
			frameMenuAdm.setVisible(false);
	    });
		tglbtnNotifMenuAdm .setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifMenuAdm .setBounds(780, 166, 149, 33);
		panelMenuAdm.add(tglbtnNotifMenuAdm );
		
		JToggleButton tglbtnPrenotaAttivitMenuAdm = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivitMenuAdm.addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
			lblErrore.setIcon(new ImageIcon());
			StartApplication.c2.switchtoGestisciAttivitaAdmin();
			frameMenuAdm.setVisible(false);
		
		});
		tglbtnPrenotaAttivitMenuAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivitMenuAdm.setBounds(634, 166, 149, 33);
		panelMenuAdm.add(tglbtnPrenotaAttivitMenuAdm);
		
		JToggleButton tglbtnMenDelGiornoMenuAdm = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiornoMenuAdm.setSelected(true);
		tglbtnMenDelGiornoMenuAdm.setEnabled(false);
		tglbtnMenDelGiornoMenuAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiornoMenuAdm.setBounds(487, 166, 149, 33);
		panelMenuAdm.add(tglbtnMenDelGiornoMenuAdm);
		
		JToggleButton tglbtnNotificheMenuAdm = new JToggleButton("Profilo Personale");
		tglbtnNotificheMenuAdm.addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
			lblErrore.setIcon(new ImageIcon());
			StartApplication.c2.switchtoHomepage();
			frameMenuAdm.setVisible(false);
		});
		tglbtnNotificheMenuAdm.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotificheMenuAdm.setBounds(331, 166, 159, 33);
		panelMenuAdm.add(tglbtnNotificheMenuAdm);
		
		JButton btnLogOutMenuAdm = new JButton("Log out");
		Image imgLogOut = new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnLogOutMenuAdm.setIcon(new ImageIcon(imgLogOut));
		btnLogOutMenuAdm.addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
            StartApplication.c2.disconnessione(3);                           
		});
		btnLogOutMenuAdm.setFont(new Font(font, Font.BOLD, 10));
		btnLogOutMenuAdm.setBackground(Color.LIGHT_GRAY);
		btnLogOutMenuAdm.setBounds(821, 36, 108, 23);
		panelMenuAdm.add(btnLogOutMenuAdm);
		
		JLabel lblNewLabel1 = new JLabel("Menu 1");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(10, 195, 306, 41);
		panelMenuAdm.add(lblNewLabel1);
		
		JLabel lblNewLabel11 = new JLabel("Menu 2");
		lblNewLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel11.setBounds(300, 195, 306, 41);
		panelMenuAdm.add(lblNewLabel11);
		
		JLabel lblNewLabel12 = new JLabel("Menu 3");
		lblNewLabel12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel12.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel12.setBounds(644, 195, 235, 41);
		panelMenuAdm.add(lblNewLabel12);
		
		textArea = new JTextArea();
		textArea.setBounds(35, 240, 258, 297);
		panelMenuAdm.add(textArea);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(331, 240, 258, 297);
		panelMenuAdm.add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(633, 240, 258, 297);
		panelMenuAdm.add(textArea2);
		
		JButton btnNewButton21 = new JButton("Conferma Modifiche");
		btnNewButton21.addActionListener((ActionEvent e) ->{
			String txtMenu1 = textArea.getText();
			String txtMenu2 = textArea1.getText();
			String txtMenu3 = textArea2.getText();
			
			int i = StartApplication.c2.controllaModificheMenu(txtMenu1, txtMenu2, txtMenu3);
			if (i == 1) {
				notifica("menu");
			}
			
			
		});
		btnNewButton21.setFont(new Font(font, Font.BOLD, 15));
		btnNewButton21.setBounds(204, 571, 216, 41);
		panelMenuAdm.add(btnNewButton21);
		
		JButton btnNewButton211 = new JButton("Menu Prenotati");
		btnNewButton211.addActionListener((ActionEvent e)-> {
		   detach(StartApplication.c1.getWindowNotifiche());
		   lblErrore.setText(" ");
		   lblErrore.setIcon(new ImageIcon());
		   StartApplication.c2.switchtoMenuPrenotati();
		});
		btnNewButton211.setFont(new Font(font, Font.BOLD, 15));
		btnNewButton211.setBounds(494, 571, 216, 41);
		panelMenuAdm.add(btnNewButton211);
		
		lblErrore = new JLabel("");
		lblErrore.setFont(new Font("Dialog", Font.BOLD, 14));
		lblErrore.setBounds(375, 535, 335, 41);
		panelMenuAdm.add(lblErrore);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(573, -13, 66, 84);
		panelMenuAdm.add(labell4);
		
		JLabel lblMenu = new JLabel("");
		ImageIcon imgMenu = new ImageIcon(this.getClass().getResource("/piatto.jpg"));
		lblMenu.setIcon(imgMenu);
		lblMenu.setBounds(0, 59, 929, 140);
		panelMenuAdm.add(lblMenu);
		
		JPanel panel81 = new JPanel();
		panel81.setBackground(new Color(0, 0, 0));
		panel81.setBounds(0, 0, 929, 71);
		panelMenuAdm.add(panel81);
		
	}


	public JTextArea getTextArea() {
		return textArea;
	}

	public JTextArea getTextArea1() {
		return textArea1;
	}


	public JTextArea getTextArea2() {
		return textArea2;
	}


	@Override
	public void notifica(String nome, int cod, String categoria) {//NOT USED
	}

	@Override
	public void notifica(String tipo, String codice) {//NOT USED
	}
}
