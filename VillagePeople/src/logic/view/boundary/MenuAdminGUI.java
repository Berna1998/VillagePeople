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

	private JFrame frame;
	private JTextArea textArea;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JLabel lblErrore;
	private List<Observer> ob = new ArrayList<>();
	
	@Override
	public void attach(Observer o) {
		this.ob.add(o);
	}
		
	@Override
	public void notifica(String tipo) {
			for (Observer oo: ob) {
				oo.update(tipo);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.ob.contains(o)) {
			this.ob.remove(o);
		}
	}


	public JLabel getLblErrore() {
		return lblErrore;
	}


	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public MenuAdminGUI() {
		
		String font = "Georgia Pro Semibold";
		
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
		lblNewLabel.setBounds(300, 0, 289, 58);
		panel.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Notifiche");
		tglbtnNewToggleButton.addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
			lblErrore.setIcon(new ImageIcon());
			StartApplication.c2.switchtoNotificheAdmin();
			frame.setVisible(false);
	    });
		tglbtnNewToggleButton.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(780, 166, 149, 33);
		panel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPrenotaAttivit = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivit.addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
			lblErrore.setIcon(new ImageIcon());
			StartApplication.c2.switchtoGestisciAttivitaAdmin();
			frame.setVisible(false);
		
		});
		tglbtnPrenotaAttivit.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivit.setBounds(634, 166, 149, 33);
		panel.add(tglbtnPrenotaAttivit);
		
		JToggleButton tglbtnMenDelGiorno = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiorno.setSelected(true);
		tglbtnMenDelGiorno.setEnabled(false);
		tglbtnMenDelGiorno.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiorno.setBounds(487, 166, 149, 33);
		panel.add(tglbtnMenDelGiorno);
		
		JToggleButton tglbtnNotifiche = new JToggleButton("Profilo Personale");
		tglbtnNotifiche.addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
			lblErrore.setIcon(new ImageIcon());
			StartApplication.c2.switchtoHomepage();
			frame.setVisible(false);
		});
		tglbtnNotifiche.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifiche.setBounds(331, 166, 159, 33);
		panel.add(tglbtnNotifiche);
		
		JButton btnNewButton1 = new JButton("Log out");
		Image imgLogOut = new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnNewButton1.setIcon(new ImageIcon(imgLogOut));
		btnNewButton1.addActionListener((ActionEvent e) -> {
			detach(StartApplication.c1.getWindowNotifiche());
			lblErrore.setText(" ");
            StartApplication.c2.disconnessione(3);                           
		});
		btnNewButton1.setFont(new Font(font, Font.BOLD, 10));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setBounds(821, 36, 108, 23);
		panel.add(btnNewButton1);
		
		JLabel lblNewLabel1 = new JLabel("Menu 1");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(10, 195, 306, 41);
		panel.add(lblNewLabel1);
		
		JLabel lblNewLabel11 = new JLabel("Menu 2");
		lblNewLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel11.setBounds(300, 195, 306, 41);
		panel.add(lblNewLabel11);
		
		JLabel lblNewLabel12 = new JLabel("Menu 3");
		lblNewLabel12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel12.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel12.setBounds(644, 195, 235, 41);
		panel.add(lblNewLabel12);
		
		textArea = new JTextArea();
		textArea.setBounds(35, 240, 258, 297);
		panel.add(textArea);
		
		textArea1 = new JTextArea();
		textArea1.setBounds(331, 240, 258, 297);
		panel.add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBounds(633, 240, 258, 297);
		panel.add(textArea2);
		
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
		panel.add(btnNewButton21);
		
		JButton btnNewButton211 = new JButton("Menu Prenotati");
		btnNewButton211.addActionListener((ActionEvent e)-> {
		   detach(StartApplication.c1.getWindowNotifiche());
		   lblErrore.setText(" ");
		   lblErrore.setIcon(new ImageIcon());
		   StartApplication.c2.switchtoMenuPrenotati();
		});
		btnNewButton211.setFont(new Font(font, Font.BOLD, 15));
		btnNewButton211.setBounds(494, 571, 216, 41);
		panel.add(btnNewButton211);
		
		lblErrore = new JLabel("");
		lblErrore.setFont(new Font("Dialog", Font.BOLD, 14));
		lblErrore.setBounds(375, 535, 335, 41);
		panel.add(lblErrore);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(573, -13, 66, 84);
		panel.add(labell4);
		
		JLabel lblMenu = new JLabel("");
		ImageIcon imgMenu = new ImageIcon(this.getClass().getResource("/piatto.jpg"));
		lblMenu.setIcon(imgMenu);
		lblMenu.setBounds(0, 59, 929, 140);
		panel.add(lblMenu);
		
		JPanel panel81 = new JPanel();
		panel81.setBackground(new Color(0, 0, 0));
		panel81.setBounds(0, 0, 929, 71);
		panel.add(panel81);
		
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
