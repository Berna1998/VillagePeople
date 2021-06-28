package logic.view.boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;

public class SignUpGUI {
	
	private JFrame frame;
	private JTextField textNome;
	private JPasswordField passwordField;
	private JTextField textCognome;
	private JTextField textEmail;
	private JPasswordField passwordConfirm;
	private JCheckBox chckbxSport;
	private JCheckBox chckbxSaluteBenessere;
	private JCheckBox chckbxSvagoRelax;
	private JCheckBox chckbxBambini;
	private JTextField textCodiceID;
	private JTextField textGiorni;
	private JLabel msgError;

	public JTextField getTextNome() {
		return textNome;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public JTextField getTextCognome() {
		return textCognome;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public JPasswordField getPasswordConfirm() {
		return passwordConfirm;
	}

	public JCheckBox getChckbxSport() {
		return chckbxSport;
	}

	public JCheckBox getChckbxSaluteBenessere() {
		return chckbxSaluteBenessere;
	}


	public JCheckBox getChckbxSvagoRelax() {
		return chckbxSvagoRelax;
	}

	public JCheckBox getChckbxBambini() {
		return chckbxBambini;
	}

	public JTextField getTextCodiceID() {
		return textCodiceID;
	}

	public JTextField getTextGiorni() {
		return textGiorni;
	}

	/**
	 * Launch the application.
	 */

	public JFrame getFrame() {
		return frame;
	}


	/**
	 * Create the application.
	 */
	public SignUpGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String font = "Georgia Pro Cond Semibold";
		String font1 = "Georgia Pro Semibold";
		String font2 = "Dialog";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 943, 693);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 160, 122));
		panel.setBounds(0, 0, 939, 666);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel(" VillagePeople ");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblNewLabel.setBounds(327, -5, 281, 68);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("Nome");
		lblNewLabel2.setFont(new Font(font2, Font.BOLD, 20));
		lblNewLabel2.setBounds(31, 253, 80, 35);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel21 = new JLabel("Password");
		lblNewLabel21.setFont(new Font(font2, Font.BOLD, 20));
		lblNewLabel21.setBounds(528, 307, 111, 36);
		panel.add(lblNewLabel21);
		
		textNome = new JTextField();
		textNome.setFont(new Font(font2, Font.BOLD, 15));
		textNome.setColumns(10);
		textNome.setBounds(189, 253, 203, 36);
		panel.add(textNome);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font(font2, Font.BOLD, 15));
		passwordField.setBounds(705, 308, 209, 36);
		panel.add(passwordField);
		
		JButton btnSignup = new JButton("Sign-up");
		Image img4 = new ImageIcon(this.getClass().getResource("/signup.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnSignup.setIcon(new ImageIcon(img4));
		btnSignup.addActionListener((ActionEvent e) -> {
			
			String nome = textNome.getText();
			String cognome = textCognome.getText();
		    String codiceID = textCodiceID.getText();
			String email = textEmail.getText();
			String password = String.valueOf(passwordField.getPassword());
			String confermaPassword = String.valueOf(passwordConfirm.getPassword());
			int giorni = Integer.parseInt(textGiorni.getText());
			boolean saluteBenessere = chckbxSaluteBenessere.isSelected();
			boolean svagoRelax = chckbxSvagoRelax.isSelected();
			boolean sport = chckbxSport.isSelected();
			boolean bambini = chckbxBambini.isSelected();
			
			
			StartApplication.c1.controllaDatiRegistrazione(nome , cognome , codiceID, email, password, confermaPassword, giorni);
			
			StartApplication.c1.controllaCheckBox(sport, saluteBenessere, svagoRelax, bambini);

		});
		
		btnSignup.setFont(new Font(font1, Font.BOLD, 20));
		btnSignup.setBounds(736, 598, 178, 36);
		panel.add(btnSignup);
		
		JLabel lblNewLabel22 = new JLabel("Cognome");
		lblNewLabel22.setFont(new Font(font2, Font.BOLD, 20));
		lblNewLabel22.setBounds(31, 308, 133, 35);
		panel.add(lblNewLabel22);
		
		textCognome = new JTextField();
		textCognome.setFont(new Font(font2, Font.BOLD, 15));
		textCognome.setColumns(10);
		textCognome.setBounds(189, 308, 203, 36);
		panel.add(textCognome);
		
		JLabel lblNewLabel221 = new JLabel("E-mail");
		lblNewLabel221.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel221.setBounds(31, 367, 86, 35);
		panel.add(lblNewLabel221);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font(font2, Font.BOLD, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(189, 367, 203, 36);
		panel.add(textEmail);
		
		JLabel lblNewLabel211 = new JLabel("Conferma");
		lblNewLabel211.setFont(new Font(font2, Font.BOLD, 17));
		lblNewLabel211.setBounds(528, 354, 86, 27);
		panel.add(lblNewLabel211);
		
		JLabel lblNewLabel212 = new JLabel("Password");
		lblNewLabel212.setFont(new Font(font2, Font.BOLD, 17));
		lblNewLabel212.setBounds(528, 374, 80, 28);
		panel.add(lblNewLabel212);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setFont(new Font(font2, Font.BOLD, 15));
		passwordConfirm.setBounds(705, 367, 209, 36);
		panel.add(passwordConfirm);
		
		JLabel lblNewLabel222 = new JLabel("Categorie attivit\u00E0 di interesse");
		lblNewLabel222.setFont(new Font(font1, Font.BOLD, 24));
		lblNewLabel222.setBounds(31, 451, 448, 35);
		panel.add(lblNewLabel222);
		
		chckbxSport = new JCheckBox(" Sport");
		chckbxSport.setFont(new Font(font1, Font.BOLD, 15));
		chckbxSport.setBackground(new Color(255, 160, 122));
		chckbxSport.setBounds(31, 527, 95, 27);
		panel.add(chckbxSport);
		
		chckbxSaluteBenessere = new JCheckBox(" Salute e benessere");
		chckbxSaluteBenessere.setFont(new Font(font1, Font.BOLD, 15));
		chckbxSaluteBenessere.setBackground(new Color(255, 160, 122));
		chckbxSaluteBenessere.setBounds(189, 497, 178, 27);
		panel.add(chckbxSaluteBenessere);
		
		chckbxSvagoRelax = new JCheckBox(" Svago e relax");
		chckbxSvagoRelax.setFont(new Font(font1, Font.BOLD, 15));
		chckbxSvagoRelax.setBackground(new Color(255, 160, 122));
		chckbxSvagoRelax.setBounds(189, 527, 147, 27);
		panel.add(chckbxSvagoRelax);
		
		chckbxBambini = new JCheckBox(" Bambini");
		chckbxBambini.setFont(new Font(font1, Font.BOLD, 15));
		chckbxBambini.setBackground(new Color(255, 160, 122));
		chckbxBambini.setBounds(31, 497, 106, 27);
		panel.add(chckbxBambini);
		
		JLabel lblNewLabel24 = new JLabel("CodiceID");
		lblNewLabel24.setFont(new Font(font2, Font.BOLD, 20));
		lblNewLabel24.setBounds(528, 253, 95, 35);
		panel.add(lblNewLabel24);
		
		JLabel lblNewLabel213 = new JLabel("Giorni di permanenza:");
		lblNewLabel213.setFont(new Font(font1, Font.BOLD, 24));
		lblNewLabel213.setBounds(528, 450, 284, 36);
		panel.add(lblNewLabel213);
		
		textCodiceID = new JTextField();
		textCodiceID.setFont(new Font(font2, Font.BOLD, 15));
		textCodiceID.setColumns(10);
		textCodiceID.setBounds(705, 253, 209, 36);
		panel.add(textCodiceID);
		
		textGiorni = new JTextField();
		textGiorni.setText("0");
		textGiorni.setFont(new Font(font, Font.BOLD, 18));
		textGiorni.setColumns(10);
		textGiorni.setBounds(795, 451, 80, 34);
		panel.add(textGiorni);
		
		msgError = new JLabel("");
		msgError.setHorizontalAlignment(SwingConstants.CENTER);
		msgError.setBounds(249, 593, 446, 41);
		panel.add(msgError);
		
		JButton indietro = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.setFont(new Font(font2, Font.BOLD, 20));
		indietro.addActionListener((ActionEvent e)-> 
		   frame.setVisible(false));
		   msgError.setText(" ");
		   StartApplication.c1.startwithLoginGUI();
		indietro.setBounds(31, 599, 178, 35);
		panel.add(indietro);
		
		JButton azzera = new JButton("Azzera");
		azzera.setFont(new Font(font2, Font.BOLD, 11));
		azzera.addActionListener((ActionEvent e)-> {
            chckbxSport.setSelected(false); 
            chckbxSaluteBenessere.setSelected(false);
            chckbxSvagoRelax.setSelected(false);
            chckbxBambini.setSelected(false);
            textNome.setText(null);
            textCognome.setText(null);
            textCodiceID.setText(null);
            textEmail.setText(null);
            passwordField.setText(null);
            passwordConfirm.setText(null);
            textGiorni.setText("0");
        });
		azzera.setBounds(819, 494, 95, 35);
		panel.add(azzera);
		
		JLabel labelSfondo = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/reception.jpg"));
		labelSfondo.setIcon(img);
		labelSfondo.setBounds(0, 59, 929, 133);
		panel.add(labelSfondo);
		
		JLabel lblpsw = new JLabel("");
		Image imgpsw = new ImageIcon(this.getClass().getResource("/password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblpsw.setIcon(new ImageIcon(imgpsw));
		lblpsw.setBounds(665, 307, 30, 28);
		panel.add(lblpsw);
		
		JLabel lblpsw2 = new JLabel("");
		Image imgpsw2 = new ImageIcon(this.getClass().getResource("/password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		lblpsw2.setIcon(new ImageIcon(imgpsw2));
		lblpsw2.setBounds(665, 367, 30, 36);
		panel.add(lblpsw2);
		
		JLabel lblID = new JLabel("");
		Image imgID = new ImageIcon(this.getClass().getResource("/login.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblID.setIcon(new ImageIcon(imgID));
		lblID.setBounds(655, 242, 40, 49);
		panel.add(lblID);
		
		JLabel lblMail = new JLabel("");
		Image imgMail = new ImageIcon(this.getClass().getResource("/email.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblMail.setIcon(new ImageIcon(imgMail));
		lblMail.setBounds(152, 367, 46, 35);
		panel.add(lblMail);
		
		JLabel lblNome = new JLabel("");
		Image imgNome = new ImageIcon(this.getClass().getResource("/anagrafici.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		lblNome.setIcon(new ImageIcon(imgNome));
		lblNome.setBounds(152, 253, 46, 35);
		panel.add(lblNome);
		
		JLabel lblCognome = new JLabel("");
		Image imgCognome = new ImageIcon(this.getClass().getResource("/anagrafici.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		lblCognome.setIcon(new ImageIcon(imgCognome));
		lblCognome.setBounds(152, 308, 46, 35);
		panel.add(lblCognome);
		
		JLabel lblCalendario = new JLabel("");
		Image imgCalendario=new ImageIcon(this.getClass().getResource("/calendario.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblCalendario.setIcon(new ImageIcon(imgCalendario));
		lblCalendario.setBounds(874, 444, 40, 42);
		panel.add(lblCalendario);
		
		JLabel lblNewLabel321 = new JLabel("REGISTRAZIONE DATI");
		lblNewLabel321.setFont(new Font(font2, Font.BOLD, 30));
		lblNewLabel321.setBounds(31, 188, 704, 43);
		panel.add(lblNewLabel321);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(606, -16, 66, 84);
		panel.add(labell4);
		
		JPanel panel561 = new JPanel();
		panel561.setBackground(new Color(0, 0, 0));
		panel561.setBounds(0, -5, 929, 68);
		panel.add(panel561);
	}
	


	public JLabel getMsgError() {
		return msgError;
	}
}
