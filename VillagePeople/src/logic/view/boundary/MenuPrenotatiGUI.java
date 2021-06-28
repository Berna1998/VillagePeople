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
import javax.swing.JTextPane;
import javax.swing.WindowConstants;


import java.awt.event.ActionEvent;


public class MenuPrenotatiGUI {

	private JFrame frame;
	private JTextPane counterMenu1;
	private JTextPane counterMenu2;
	private JTextPane counterMenu3;
	private JTextPane countIntoll1;
	private JTextPane countIntoll2;
	private JTextPane countIntoll3;
	private JLabel lblError;
	

	public JLabel getLblError() {
		return lblError;
	}



	public JTextPane getCountIntoll1() {
		return countIntoll1;
	}


	public JTextPane getCountIntoll2() {
		return countIntoll2;
	}


	public JTextPane getCountIntoll3() {
		return countIntoll3;
	}


	public JTextPane getCounterMenu1() {
		return counterMenu1;
	}


	public JTextPane getCounterMenu2() {
		return counterMenu2;
	}


	public JTextPane getCounterMenu3() {
		return counterMenu3;
	}


	/**
	 * Create the application.
	 */
	public MenuPrenotatiGUI() {
		
		String font1="Dialog";
		String labelIntoll="Intolleranze segnalate:";
		String label2="Vedi intolleranze";
		
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
		
		JLabel lblNewLabel1 = new JLabel("Elenco menu prenotati dai clienti");
		lblNewLabel1.setFont(new Font(font1, Font.BOLD, 25));
		lblNewLabel1.setBounds(10, 23, 481, 33);
		panel.add(lblNewLabel1);
		
		JButton indietro = new JButton("Indietro");
		Image img5=new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e)-> 
		   frame.setVisible(false));
		indietro.setFont(new Font(font1, Font.BOLD, 20));
		indietro.setBounds(135, 584, 229, 44);
		panel.add(indietro);
		
		JLabel menuPrenotati1 = new JLabel("Men\u00F9 1 prenotati:");
		menuPrenotati1.setFont(new Font(font1, Font.BOLD, 24));
		menuPrenotati1.setBounds(10, 114, 208, 44);
		panel.add(menuPrenotati1);
		
		JLabel menuPrenotati2 = new JLabel("Men\u00F9 2 prenotati:");
		menuPrenotati2.setFont(new Font(font1, Font.BOLD, 24));
		menuPrenotati2.setBounds(10, 226, 208, 44);
		panel.add(menuPrenotati2);
		
		JLabel menuPrenotati3 = new JLabel("Men\u00F9 3 prenotati:");
		menuPrenotati3.setFont(new Font(font1, Font.BOLD, 24));
		menuPrenotati3.setBounds(10, 352, 208, 33);
		panel.add(menuPrenotati3);
		
		JButton intolleranze1 = new JButton(label2);
		intolleranze1.addActionListener((ActionEvent e)-> 
		   StartApplication.c2.switchtoElenco(1));
		intolleranze1.setFont(new Font(font1, Font.BOLD, 12));
		intolleranze1.setBounds(10, 182, 175, 33);
		panel.add(intolleranze1);
		
		JButton intolleranze2 = new JButton(label2);
		intolleranze2.addActionListener((ActionEvent e)-> 
		   StartApplication.c2.switchtoElenco(2));
		intolleranze2.setFont(new Font(font1, Font.BOLD, 12));
		intolleranze2.setBounds(10, 299, 175, 33);
		panel.add(intolleranze2);
		
		JButton intolleranze3 = new JButton(label2);
		intolleranze3.addActionListener((ActionEvent e)-> 
		   StartApplication.c2.switchtoElenco(3));
		intolleranze3.setFont(new Font(font1, Font.BOLD, 12));
		intolleranze3.setBounds(10, 418, 175, 33);
		panel.add(intolleranze3);
		
		counterMenu1 = new JTextPane();
		counterMenu1.setBackground(new Color(255, 160, 122));
		counterMenu1.setFont(new Font(font1, Font.BOLD, 24));
		counterMenu1.setEditable(false);
		counterMenu1.setBounds(210, 116, 87, 30);
		panel.add(counterMenu1);
		
		counterMenu2 = new JTextPane();
		counterMenu2.setBackground(new Color(255, 160, 122));
		counterMenu2.setFont(new Font(font1, Font.BOLD, 24));
		counterMenu2.setEditable(false);
		counterMenu2.setBounds(210, 228, 95, 33);
		panel.add(counterMenu2);
		
		counterMenu3 = new JTextPane();
		counterMenu3.setBackground(new Color(255, 160, 122));
		counterMenu3.setFont(new Font(font1, Font.BOLD, 24));
		counterMenu3.setEditable(false);
		counterMenu3.setBounds(210, 348, 95, 39);
		panel.add(counterMenu3);
		
		JLabel intSegnalate1 = new JLabel(labelIntoll);
		intSegnalate1.setFont(new Font(font1, Font.BOLD, 24));
		intSegnalate1.setBounds(10, 154, 263, 27);
		panel.add(intSegnalate1);
		
		JLabel intSegnalate2 = new JLabel(labelIntoll);
		intSegnalate2.setFont(new Font(font1, Font.BOLD, 24));
		intSegnalate2.setBounds(10, 267, 263, 33);
		panel.add(intSegnalate2);
		
		JLabel intSegnalate3 = new JLabel(labelIntoll);
		intSegnalate3.setFont(new Font(font1, Font.BOLD, 24));
		intSegnalate3.setBounds(10, 385, 263, 33);
		panel.add(intSegnalate3);
		
		countIntoll1 = new JTextPane();
		countIntoll1.setFont(new Font(font1, Font.BOLD, 24));
		countIntoll1.setBackground(new Color(255, 160, 122));
		countIntoll1.setEditable(false);
		countIntoll1.setBounds(266, 146, 87, 72);
		panel.add(countIntoll1);
		
		countIntoll2 = new JTextPane();
		countIntoll2.setFont(new Font(font1, Font.BOLD, 24));
		countIntoll2.setBackground(new Color(255, 160, 122));
		countIntoll2.setEditable(false);
		countIntoll2.setBounds(266, 263, 98, 39);
		panel.add(countIntoll2);
		
		countIntoll3 = new JTextPane();
		countIntoll3.setFont(new Font(font1, Font.BOLD, 24));
		countIntoll3.setBackground(new Color(255, 160, 122));
		countIntoll3.setEditable(false);
		countIntoll3.setBounds(266, 380, 98, 38);
		panel.add(countIntoll3);
		
		lblError = new JLabel("");
		lblError.setBounds(80, 507, 312, 33);
		panel.add(lblError);
   }
	

	public JFrame getFrame() {
		return frame;
	}


}
