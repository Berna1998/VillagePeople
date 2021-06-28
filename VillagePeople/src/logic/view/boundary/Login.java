package logic.view.boundary;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel3;


	public JFrame getFrame() {
		return frame;
	}


	public Login() {
		
		String font="Georgia Pro Cond Semibold";
		String font1="Georgia Pro Semibold";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 611);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" VillagePeople ");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setBounds(386, 0, 261, 85);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel2 = new JLabel("CodiceId:");
		lblNewLabel2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel2.setBounds(411, 85, 155, 35);
		panel.add(lblNewLabel2);
		
		JLabel lblNewLabel21 = new JLabel("Password:");
		lblNewLabel21.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel21.setBounds(411, 176, 155, 36);
		panel.add(lblNewLabel21);
		
		textField = new JTextField();
		textField.setFont(new Font(font, Font.BOLD, 18));
		textField.setBounds(411, 118, 256, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font(font, Font.BOLD, 18));
		passwordField.setBounds(411, 212, 256, 36);
		panel.add(passwordField);

		JButton btnNewButton = new JButton(" Log In");
		Image img3 = new ImageIcon(this.getClass().getResource("/user.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnNewButton.setIcon(new ImageIcon(img3));
		btnNewButton.addActionListener((ActionEvent e) -> {
			
			String codiceId = textField.getText();
			String password = String.valueOf(passwordField.getPassword());
			
			StartApplication.c1.login(codiceId, password);
			
		});
			

		btnNewButton.setFont(new Font(font1, Font.BOLD, 20));
		btnNewButton.setBounds(411, 311, 289, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel1 = new JLabel("OR");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 17));
		lblNewLabel1.setBounds(543, 357, 34, 24);
		panel.add(lblNewLabel1);
		
		JButton btnSignup = new JButton("Sign-up");
		Image img4=new ImageIcon(this.getClass().getResource("/signup.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnSignup.setIcon(new ImageIcon(img4));
		btnSignup.addActionListener((ActionEvent e) -> {
		        frame.setVisible(false);
				StartApplication.c1.switchtoSignUp();
		});
		btnSignup.setFont(new Font(font1, Font.BOLD, 20));
		btnSignup.setBounds(411, 392, 289, 35);
		panel.add(btnSignup);
		
		lblNewLabel3 = new JLabel("");
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3.setBounds(411, 460, 289, 25);
		panel.add(lblNewLabel3);
		
		JLabel labell= new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/resort.jpg"));
		labell.setIcon(img);
		labell.setBounds(0, 0, 374, 572);
		panel.add(labell);
		
		JLabel labell2 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/password.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		labell2.setIcon(new ImageIcon(img5));
		labell2.setBounds(666, 216, 34, 32);
		panel.add(labell2);
		
		JLabel labell3 = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("/login.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		labell3.setIcon(new ImageIcon(img6));
		labell3.setBounds(666, 106, 44, 58);
		panel.add(labell3);
		
		JLabel labell4 = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/simboloResort.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		labell4.setIcon(new ImageIcon(img7));
		labell4.setBounds(634, 0, 66, 84);
		panel.add(labell4);
		
		JPanel panel111 = new JPanel();
		panel111.setBackground(new Color(0, 0, 0));
		panel111.setBounds(372, 0, 338, 77);
		panel.add(panel111);
		
		
		
		
	}
	


	public JLabel getLabelErrore() {
		return lblNewLabel3;
	}
}
