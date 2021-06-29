package logic.view.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class MenuClientGUI {

	private JFrame frameMenuCli;
	private JTextArea textArea;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextPane txtCodiceIdMenuCli;
	private JLabel lblMenuError;
	

	public JLabel getLblMenuError() {
		return lblMenuError;
	}

	public JFrame getFrame() {
		return frameMenuCli;
	}

	/**
	 * Create the application.
	 */
	public MenuClientGUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frameMenuCli = new JFrame();
		frameMenuCli.setBounds(100, 100, 937, 663);
		frameMenuCli.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameMenuCli.getContentPane().setLayout(null);
		
		JPanel panelMenuCli = new JPanel();
		panelMenuCli.setLayout(null);
		panelMenuCli.setBackground(new Color(255, 160, 122));
		panelMenuCli.setBounds(0, 0, 929, 656);
		frameMenuCli.getContentPane().add(panelMenuCli);
		
		JLabel lblMenuCli = new JLabel(" VillagePeople ");
		lblMenuCli.setForeground(new Color(255, 160, 122));
		lblMenuCli.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblMenuCli.setBounds(300, 0, 289, 58);
		panelMenuCli.add(lblMenuCli);
		
		JToggleButton tglbtnNotifMenuCli = new JToggleButton("Notifiche");
		tglbtnNotifMenuCli.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoNotifiche();
			frame.setVisible(false);
	    });
		tglbtnNotifMenuCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifMenuCli.setBounds(780, 166, 149, 33);
		panelMenuCli.add(tglbtnNotifMenuCli);
		
		JToggleButton tglbtnPrenotaAttivitMenuCli = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivitMenuCli.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoGestisciAttivitaClient();
			frameMenuCli.setVisible(false);
		});
		
		tglbtnPrenotaAttivitMenuCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnPrenotaAttivitMenuCli.setBounds(634, 166, 149, 33);
		panelMenuCli.add(tglbtnPrenotaAttivitMenuCli);
		
		JToggleButton tglbtnMenDelGiornoMenuCli = new JToggleButton("Men\u00F9");
		tglbtnMenDelGiornoMenuCli.setSelected(true);
		tglbtnMenDelGiornoMenuCli.setEnabled(false);
		tglbtnMenDelGiornoMenuCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnMenDelGiornoMenuCli.setBounds(487, 166, 149, 33);
		panelMenuCli.add(tglbtnMenDelGiornoMenuCli);
		
		JToggleButton tglbtnNotificheMenuCli = new JToggleButton("Profilo Personale");
		tglbtnNotificheMenuCli.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoHomepage();
			frameMenuCli.setVisible(false);
		});
		
		tglbtnNotificheMenuCli.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotificheMenuCli.setBounds(331, 166, 159, 33);
		panelMenuCli.add(tglbtnNotificheMenuCli);
		
		JButton btnLogOutMenuCli = new JButton("Log out");
		btnLogOutMenuCli.setForeground(new Color(0, 0, 0));
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnLogOutMenuCli.setIcon(new ImageIcon(imgLogOut));
		btnLogOutMenuCli.addActionListener((ActionEvent e) -> 
                           StartApplication.c1.disconnessione(3));
		btnLogOutMenuCli.setFont(new Font(font, Font.BOLD, 10));
		btnLogOutMenuCli.setBackground(Color.LIGHT_GRAY);
		btnLogOutMenuCli.setBounds(821, 36, 108, 23);
		panelMenuCli.add(btnLogOutMenuCli);
		
		JLabel lblNewLabel11 = new JLabel("Menu 1");
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel11.setBounds(10, 195, 306, 41);
		panelMenuCli.add(lblNewLabel11);
		
		JLabel lblNewLabel111 = new JLabel("Menu 2");
		lblNewLabel111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel111.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel111.setBounds(300, 195, 306, 41);
		panelMenuCli.add(lblNewLabel111);
		
		JLabel lblNewLabel112 = new JLabel("Menu 3");
		lblNewLabel112.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel112.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel112.setBounds(644, 195, 235, 41);
		panelMenuCli.add(lblNewLabel112);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 218, 185));
		textArea.setEditable(false);
		textArea.setBounds(35, 240, 258, 297);
	    textArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panelMenuCli.add(textArea);
		
		textArea1 = new JTextArea();
		textArea1.setBackground(new Color(255, 218, 185));
		textArea1.setEditable(false);
		textArea1.setBounds(331, 240, 258, 297);
		textArea1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panelMenuCli.add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBackground(new Color(255, 218, 185));
		textArea2.setEditable(false);
		textArea2.setBounds(633, 240, 258, 297);
		textArea2.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panelMenuCli.add(textArea2);
		
		JButton btnNewButton21 = new JButton("Seleziona Menu");
		btnNewButton21.addActionListener((ActionEvent e) -> {
				StartApplication.c1.switchtointolerance();
				frameMenuCli.setVisible(false);
		});
		btnNewButton21.setFont(new Font(font, Font.BOLD, 15));
		btnNewButton21.setBounds(353, 560, 216, 41);
		panelMenuCli.add(btnNewButton21);
		
		JLabel codiceId = new JLabel("CodiceId: ");
		codiceId.setForeground(new Color(255, 160, 122));
		codiceId.setVerticalAlignment(SwingConstants.TOP);
		codiceId.setFont(new Font(font1, Font.BOLD, 11));
		codiceId.setBounds(10, 44, 61, 14);
		panelMenuCli.add(codiceId);
		
		txtCodiceIdMenuCli = new JTextPane();
		txtCodiceIdMenuCli.setForeground(new Color(255, 160, 122));
		txtCodiceIdMenuCli.setBackground(new Color(0, 0, 0));
		txtCodiceIdMenuCli.setEditable(false);
		txtCodiceIdMenuCli.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceIdMenuCli.setBounds(71, 37, 92, 21);
		panelMenuCli.add(txtCodiceIdMenuCli);
		
		JLabel lblMenu = new JLabel("");
		ImageIcon imgMenu=new ImageIcon(this.getClass().getResource("/piatto.jpg"));
		lblMenu.setIcon(imgMenu);
		lblMenu.setBounds(0, 59, 929, 140);
		panelMenuCli.add(lblMenu);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(573, -13, 66, 84);
		panelMenuCli.add(labell4);
		
		JPanel panel01 = new JPanel();
		panel01.setBackground(new Color(0, 0, 0));
		panel01.setBounds(0, 0, 929, 71);
		panelMenuCli.add(panel01);
		
		lblMenuError = new JLabel("");
		lblMenuError.setBounds(90, 570, 203, 25);
		panelMenuCli.add(lblMenuError);
	}
	
	public JTextPane getTxtCodiceId() {
		return txtCodiceIdMenuCli;
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

}
