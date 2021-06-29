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

	private JFrame frameElenInt1;
	private JTextArea textAreaElenInt1;
	private JLabel lblErrorElenInt1;

	public JLabel getLblError() {
		return lblErrorElenInt1;
	}


	public JTextArea getTextArea() {
		return textAreaElenInt1;
	}


	/**
	 * Create the application.
	 */
	public ElencoIntolleranze1GUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frameElenInt1 = new JFrame();
		frameElenInt1.setBounds(100, 100, 450, 300);
		frameElenInt1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameElenInt1.getContentPane().setLayout(null);
		
		frameElenInt1 = new JFrame();
		frameElenInt1.setBounds(100, 100, 517, 700);
		frameElenInt1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelElenInt1 = new JPanel();
		panelElenInt1.setBackground(new Color(255, 160, 122));
		frameElenInt1.getContentPane().add(panelElenInt1, BorderLayout.CENTER);
		panelElenInt1.setLayout(null);
		
		JLabel lblElenInt1 = new JLabel("Intolleranza relative al Men\u00F9 1");
		lblElenInt1.setFont(new Font(font, Font.BOLD, 20));
		lblElenInt1.setBounds(10, 11, 378, 33);
		panelElenInt1.add(lblElenInt1);
		
		JButton indietroElenInt1 = new JButton("Indietro");
		Image img5=new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietroElenInt1.setIcon(new ImageIcon(img5));
		indietroElenInt1.addActionListener((ActionEvent e)->
		   frameElenInt1.setVisible(false));
		indietroElenInt1.setFont(new Font(font1, Font.BOLD, 20));
		indietroElenInt1.setBounds(135, 584, 229, 44);
		panelElenInt1.add(indietroElenInt1);
		
		JScrollPane scrollPaneElenInt1 = new JScrollPane();
		scrollPaneElenInt1.setBounds(10, 55, 481, 518);
		panelElenInt1.add(scrollPaneElenInt1);
		
		textAreaElenInt1 = new JTextArea();
		textAreaElenInt1.setBackground(new Color(255, 218, 185));
		textAreaElenInt1.setEditable(false);
		scrollPaneElenInt1.setViewportView(textAreaElenInt1);
		
		lblErrorElenInt1 = new JLabel("");
		lblErrorElenInt1.setBounds(305, 11, 186, 27);
		panelElenInt1.add(lblErrorElenInt1);
   }
	

	public JFrame getFrame() {
		return frameElenInt1;
	}

}
