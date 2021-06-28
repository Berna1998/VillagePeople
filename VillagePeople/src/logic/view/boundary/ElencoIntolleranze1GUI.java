package logic.view.boundary;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ElencoIntolleranze1GUI {

	private JFrame frame;
	private JTextArea textArea;
	private JLabel lblError;

	public JLabel getLblError() {
		return lblError;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	/**
	 * Create the application.
	 */
	public ElencoIntolleranze1GUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Intolleranza relative al Men\u00F9 1");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel1.setBounds(10, 11, 378, 33);
		panel.add(lblNewLabel1);
		
		JButton indietro = new JButton("Indietro");
		Image img5=new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e)->
		   frame.setVisible(false));
		indietro.setFont(new Font(font1, Font.BOLD, 20));
		indietro.setBounds(135, 584, 229, 44);
		panel.add(indietro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 481, 518);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 218, 185));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		lblError = new JLabel("");
		lblError.setBounds(305, 11, 186, 27);
		panel.add(lblError);
   }
	

	public JFrame getFrame() {
		return frame;
	}

}
