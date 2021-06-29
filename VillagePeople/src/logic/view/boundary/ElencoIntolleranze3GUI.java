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


public class ElencoIntolleranze3GUI {

	private JFrame frameElenInt3;
	private JTextArea textAreaElenInt3;
	private JLabel lblErrorElenInt3;

	public JLabel getLblError() {
		return lblErrorElenInt3;
	}

	public JTextArea getTextArea() {
		return textAreaElenInt3;
	}

	/**
	 * Create the application.
	 */
	public ElencoIntolleranze3GUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frameElenInt3 = new JFrame();
		frameElenInt3.setBounds(100, 100, 450, 300);
		frameElenInt3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameElenInt3.getContentPane().setLayout(null);
		
		frameElenInt3 = new JFrame();
		frameElenInt3.setBounds(100, 100, 517, 700);
		frameElenInt3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelElenInt3 = new JPanel();
		panelElenInt3.setBackground(new Color(255, 160, 122));
		frameElenInt3.getContentPane().add(panelElenInt3, BorderLayout.CENTER);
		panelElenInt3.setLayout(null);
		
		JLabel lblElenInt3 = new JLabel("Intolleranza relative al Men\u00F9 3");
		lblElenInt3.setFont(new Font(font, Font.BOLD, 20));
		lblElenInt3.setBounds(10, 11, 378, 33);
		panelElenInt3.add(lblElenInt3);
		
		JButton indietroElenInt3 = new JButton("Indietro");
		Image img5=new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietroElenInt3.setIcon(new ImageIcon(img5));
		indietroElenInt3.addActionListener((ActionEvent e)->
		   frameElenInt3.setVisible(false));
		indietroElenInt3.setFont(new Font(font1, Font.BOLD, 20));
		indietroElenInt3.setBounds(135, 584, 229, 44);
		panelElenInt3.add(indietroElenInt3);
		
		JScrollPane scrollPaneElenInt3 = new JScrollPane();
		scrollPaneElenInt3.setBounds(10, 55, 481, 518);
		panelElenInt3.add(scrollPaneElenInt3);
		
		textAreaElenInt3 = new JTextArea();
		textAreaElenInt3.setBackground(new Color(255, 218, 185));
		textAreaElenInt3.setEditable(false);
		scrollPaneElenInt3.setViewportView(textAreaElenInt3);
		
		lblErrorElenInt3 = new JLabel("");
		lblErrorElenInt3.setBounds(305, 11, 186, 27);
		panelElenInt3.add(lblErrorElenInt3);
   }
	

	public JFrame getFrame() {
		return frameElenInt3;
	}

}

