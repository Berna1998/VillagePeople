package logic.view.boundary;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import javax.swing.JTextField;

public class AggiungiNuovoClienteGUI {

	private JFrame frame;
	private JTextField textFieldCodice;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
    private JLabel labelErroreUt;

	public JLabel getLabelErroreUt() {
		return labelErroreUt;
	}

	public JTextField getTextFieldCodice() {
		return textFieldCodice;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldCognome() {
		return textFieldCognome;
	}

	/**
	 * Create the application.
	 */
	public AggiungiNuovoClienteGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1 = "Dialog";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 363);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel1 = new JLabel("Aggiungi un nuovo cliente\r\n");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel1.setBounds(118, 11, 304, 33);
		panel.add(lblNewLabel1);
		
		JButton btnIndietro = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnIndietro.setIcon(new ImageIcon(img5));
		btnIndietro.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
		   labelErroreUt.setText(" ");
		   labelErroreUt.setIcon(new ImageIcon());
	       StartApplication.c2.switchtoHomepage();
		});
		btnIndietro.setFont(new Font(font1, Font.BOLD, 15));
		btnIndietro.setBounds(39, 272, 159, 33);
		panel.add(btnIndietro);
		
		JLabel lblCodice = new JLabel("Codice:");
		lblCodice.setFont(new Font(font, Font.BOLD, 20));
		lblCodice.setBounds(61, 86, 200, 33);
		panel.add(lblCodice);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font(font, Font.BOLD, 20));
		lblNome.setBounds(61, 134, 200, 33);
		panel.add(lblNome);
		
		JLabel lblOrario = new JLabel("Cognome:");
		lblOrario.setFont(new Font(font, Font.BOLD, 20));
		lblOrario.setBounds(38, 182, 200, 33);
		panel.add(lblOrario);
		
		textFieldCodice = new JTextField();
		textFieldCodice.setBounds(165, 82, 200, 33);
		panel.add(textFieldCodice);
		textFieldCodice.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(165, 134, 200, 33);
		panel.add(textFieldNome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(165, 182, 200, 33);
		panel.add(textFieldCognome);
		
		JButton btnAggiungiUtente = new JButton("Aggiungi utente");
		btnAggiungiUtente.addActionListener((ActionEvent e) -> {
		   String nome = textFieldNome.getText();
		   String cognome = textFieldCognome.getText();
		   String codice = textFieldCodice.getText();
		   
	       StartApplication.c2.aggiungiCliente(nome, cognome, codice);
		});
		btnAggiungiUtente.setFont(new Font("Dialog", Font.BOLD, 15));
		btnAggiungiUtente.setBounds(292, 272, 166, 33);
		panel.add(btnAggiungiUtente);
		
		labelErroreUt = new JLabel("");
		labelErroreUt.setBounds(85, 235, 337, 27);
		panel.add(labelErroreUt);
	}


	public JFrame getFrame() {
		return frame;
	}

}
