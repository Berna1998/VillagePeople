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

	private JFrame frame;
	private JTextArea textArea;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextPane txtCodiceId;
	private JLabel lblMenuError;
	

	public JLabel getLblMenuError() {
		return lblMenuError;
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public MenuClientGUI() {
		
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
		lblNewLabel.setBounds(300, 0, 289, 58);
		panel.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Notifiche");
		tglbtnNewToggleButton.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoNotifiche();
			frame.setVisible(false);
	    });
		tglbtnNewToggleButton.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNewToggleButton.setBounds(780, 166, 149, 33);
		panel.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPrenotaAttivit = new JToggleButton("Gestisci Attivit\u00E0");
		tglbtnPrenotaAttivit.addActionListener((ActionEvent e) -> {
			StartApplication.c1.switchtoGestisciAttivitaClient();
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
			StartApplication.c1.switchtoHomepage();
			frame.setVisible(false);
		});
		
		tglbtnNotifiche.setFont(new Font(font, Font.BOLD, 14));
		tglbtnNotifiche.setBounds(331, 166, 159, 33);
		panel.add(tglbtnNotifiche);
		
		JButton btnNewButton1 = new JButton("Log out");
		btnNewButton1.setForeground(new Color(0, 0, 0));
		Image imgLogOut=new ImageIcon(this.getClass().getResource("/logout.png")).getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		btnNewButton1.setIcon(new ImageIcon(imgLogOut));
		btnNewButton1.addActionListener((ActionEvent e) -> 
                           StartApplication.c1.disconnessione(3));
		btnNewButton1.setFont(new Font(font, Font.BOLD, 10));
		btnNewButton1.setBackground(Color.LIGHT_GRAY);
		btnNewButton1.setBounds(821, 36, 108, 23);
		panel.add(btnNewButton1);
		
		JLabel lblNewLabel11 = new JLabel("Menu 1");
		lblNewLabel11.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel11.setBounds(10, 195, 306, 41);
		panel.add(lblNewLabel11);
		
		JLabel lblNewLabel111 = new JLabel("Menu 2");
		lblNewLabel111.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel111.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel111.setBounds(300, 195, 306, 41);
		panel.add(lblNewLabel111);
		
		JLabel lblNewLabel112 = new JLabel("Menu 3");
		lblNewLabel112.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel112.setFont(new Font(font, Font.BOLD, 24));
		lblNewLabel112.setBounds(644, 195, 235, 41);
		panel.add(lblNewLabel112);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 218, 185));
		textArea.setEditable(false);
		textArea.setBounds(35, 240, 258, 297);
	    textArea.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panel.add(textArea);
		
		textArea1 = new JTextArea();
		textArea1.setBackground(new Color(255, 218, 185));
		textArea1.setEditable(false);
		textArea1.setBounds(331, 240, 258, 297);
		textArea1.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panel.add(textArea1);
		
		textArea2 = new JTextArea();
		textArea2.setBackground(new Color(255, 218, 185));
		textArea2.setEditable(false);
		textArea2.setBounds(633, 240, 258, 297);
		textArea2.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panel.add(textArea2);
		
		JButton btnNewButton21 = new JButton("Seleziona Menu");
		btnNewButton21.addActionListener((ActionEvent e) -> {
				StartApplication.c1.switchtointolerance();
				frame.setVisible(false);
		});
		btnNewButton21.setFont(new Font(font, Font.BOLD, 15));
		btnNewButton21.setBounds(353, 560, 216, 41);
		panel.add(btnNewButton21);
		
		JLabel codiceId = new JLabel("CodiceId: ");
		codiceId.setForeground(new Color(255, 160, 122));
		codiceId.setVerticalAlignment(SwingConstants.TOP);
		codiceId.setFont(new Font(font1, Font.BOLD, 11));
		codiceId.setBounds(10, 44, 61, 14);
		panel.add(codiceId);
		
		txtCodiceId = new JTextPane();
		txtCodiceId.setForeground(new Color(255, 160, 122));
		txtCodiceId.setBackground(new Color(0, 0, 0));
		txtCodiceId.setEditable(false);
		txtCodiceId.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceId.setBounds(71, 37, 92, 21);
		panel.add(txtCodiceId);
		
		JLabel lblMenu = new JLabel("");
		ImageIcon imgMenu=new ImageIcon(this.getClass().getResource("/piatto.jpg"));
		lblMenu.setIcon(imgMenu);
		lblMenu.setBounds(0, 59, 929, 140);
		panel.add(lblMenu);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(573, -13, 66, 84);
		panel.add(labell4);
		
		JPanel panel01 = new JPanel();
		panel01.setBackground(new Color(0, 0, 0));
		panel01.setBounds(0, 0, 929, 71);
		panel.add(panel01);
		
		lblMenuError = new JLabel("");
		lblMenuError.setBounds(90, 570, 203, 25);
		panel.add(lblMenuError);
	}
	
	public JTextPane getTxtCodiceId() {
		return txtCodiceId;
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
