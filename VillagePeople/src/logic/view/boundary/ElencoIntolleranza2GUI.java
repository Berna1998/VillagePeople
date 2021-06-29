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


public class ElencoIntolleranza2GUI {

	private JFrame frameElenInt2;
	private JTextArea textAreaElenInt2; 
	private JLabel lblErrorElenInt2;

	public JLabel getLblError() {
		return lblErrorElenInt2;
	}


	public JTextArea getTextArea() {
		return textAreaElenInt2;
	}

	/**
	 * Create the application.
	 */
	public ElencoIntolleranza2GUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frameElenInt2 = new JFrame();
		frameElenInt2.setBounds(100, 100, 450, 300);
		frameElenInt2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameElenInt2.getContentPane().setLayout(null);
		
		frameElenInt2 = new JFrame();
		frameElenInt2.setBounds(100, 100, 517, 700);
		frameElenInt2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelElenInt2 = new JPanel();
		panelElenInt2.setBackground(new Color(255, 160, 122));
		frameElenInt2.getContentPane().add(panelElenInt2, BorderLayout.CENTER);
		panelElenInt2.setLayout(null);
		
		JLabel lblElenInt2= new JLabel("Intolleranza relative al Men\u00F9 2");
		lblElenInt2.setFont(new Font(font, Font.BOLD, 20));
		lblElenInt2.setBounds(10, 11, 378, 33);
		panelElenInt2.add(lblElenInt2);
		
		JButton indietroElenInt2 = new JButton("Indietro");
		Image img5=new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietroElenInt2.setIcon(new ImageIcon(img5));
		indietroElenInt2.addActionListener((ActionEvent e)->
		  frameElenInt2.setVisible(false));
		indietroElenInt2.setFont(new Font(font1, Font.BOLD, 20));
		indietroElenInt2.setBounds(135, 584, 229, 44);
		panelElenInt2.add(indietroElenInt2);
		
		JScrollPane scrollPaneElenInt2 = new JScrollPane();
		scrollPaneElenInt2.setBounds(10, 55, 481, 518);
		panelElenInt2.add(scrollPaneElenInt2);
		
		textAreaElenInt2 = new JTextArea();
		textAreaElenInt2.setBackground(new Color(255, 218, 185));
		textAreaElenInt2.setEditable(false);
		scrollPaneElenInt2.setViewportView(textAreaElenInt2);
		
		lblErrorElenInt2 = new JLabel("");
		lblErrorElenInt2.setBounds(305, 11, 186, 27);
		panelElenInt2.add(lblErrorElenInt2);
   }
	

	public JFrame getFrame() {
		return frameElenInt2;
	}

}
