package logic.view.boundary;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class InserisciAttivitaAdminGUI {

	private JFrame frameInsAtt;
	private JTextField textFieldCodice;
	private JTextField textFieldNome;
	private JTextField textFieldOrario;
	private JTextField textFieldPrezzo;

	private JLabel labelErroreAtt;
	private JComboBox<String> comboBoxCateg;
	private JComboBox<String> comboBoxGiorno;
	private JTextField textFieldPartecipanti;
	private JComboBox<String> comboBoxTipologia;
	
	

	

	
	public JComboBox<String> getComboBoxTipologia() {
		return comboBoxTipologia;
	}


	public JComboBox<String> getComboBoxCateg() {
		return comboBoxCateg;
	}

	public JComboBox<String> getComboBoxGiorno() {
		return comboBoxGiorno;
	}

	public JLabel getLabelErroreAtt() {
		return labelErroreAtt;
	}

	public JTextField getTextFieldCodice() {
		return textFieldCodice;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public JTextField getTextFieldOrario() {
		return textFieldOrario;
	}

	public JTextField getTextFieldPrezzo() {
		return textFieldPrezzo;
	}

	/**
	 * Create the application.
	 */
	public InserisciAttivitaAdminGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1 = "Dialog";
		
		frameInsAtt = new JFrame();
		frameInsAtt.setBounds(100, 100, 450, 300);
		frameInsAtt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameInsAtt.getContentPane().setLayout(null);
		
		frameInsAtt = new JFrame();
		frameInsAtt.setBounds(100, 100, 517, 700);
		frameInsAtt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelInsAtt = new JPanel();
		panelInsAtt.setBackground(new Color(255, 160, 122));
		frameInsAtt.getContentPane().add(panelInsAtt, BorderLayout.CENTER);
		panelInsAtt.setLayout(null);
		
		JLabel lblInsAtt = new JLabel("Aggiungi un'attivit\u00E0");
		lblInsAtt.setFont(new Font(font, Font.BOLD, 20));
		lblInsAtt.setBounds(148, 20, 200, 33);
		panelInsAtt.add(lblInsAtt);
		
		JButton indietro = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e) -> {
		   frame.setVisible(false);
		   labelErroreAtt.setText(" ");
		   labelErroreAtt.setIcon(new ImageIcon());
	       StartApplication.c2.switchtoGestisciAttivitaAdmin();
		});
		indietro.setFont(new Font(font1, Font.BOLD, 15));
		indietro.setBounds(39, 606, 171, 33);
		panelInsAtt.add(indietro);
		
		JLabel lblCodice = new JLabel("Codice:");
		lblCodice.setFont(new Font(font, Font.BOLD, 20));
		lblCodice.setBounds(10, 82, 200, 33);
		panelInsAtt.add(lblCodice);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font(font, Font.BOLD, 20));
		lblNome.setBounds(10, 130, 200, 33);
		panelInsAtt.add(lblNome);
		
		JLabel lblOrario = new JLabel("Orario:");
		lblOrario.setFont(new Font(font, Font.BOLD, 20));
		lblOrario.setBounds(10, 178, 200, 33);
		panelInsAtt.add(lblOrario);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font(font, Font.BOLD, 20));
		lblPrezzo.setBounds(10, 226, 200, 33);
		panelInsAtt.add(lblPrezzo);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font(font, Font.BOLD, 20));
		lblCategoria.setBounds(10, 269, 109, 33);
		panelInsAtt.add(lblCategoria);
		
		textFieldCodice = new JTextField();
		textFieldCodice.setText("0");
		textFieldCodice.setBounds(131, 82, 200, 33);
		panelInsAtt.add(textFieldCodice);
		textFieldCodice.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(131, 130, 200, 33);
		panelInsAtt.add(textFieldNome);
		
		textFieldOrario = new JTextField();
		textFieldOrario.setColumns(10);
		textFieldOrario.setBounds(131, 178, 200, 33);
		panelInsAtt.add(textFieldOrario);
		
		textFieldPrezzo = new JTextField();
		textFieldPrezzo.setText("0.0");
		textFieldPrezzo.setColumns(10);
		textFieldPrezzo.setBounds(131, 226, 200, 33);
		panelInsAtt.add(textFieldPrezzo);
		
		JButton inserisciAttivita = new JButton("Inserisci Attivit\u00E0");
		Image imgInserisci = new ImageIcon(this.getClass().getResource("/aggiungi.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		inserisciAttivita.setIcon(new ImageIcon(imgInserisci));
		inserisciAttivita.addActionListener((ActionEvent e) -> {
		   String categoria = comboBoxCateg.getSelectedItem().toString();
		   double prezzo = (Double.parseDouble(textFieldPrezzo.getText()));
		   String orario = (textFieldOrario.getText());
		   String nome = (textFieldNome.getText());
		   int codice = (Integer.parseInt(textFieldCodice.getText()));
		   String giorno = (comboBoxGiorno.getSelectedItem().toString());
		   String tipologia = (comboBoxTipologia.getSelectedItem().toString());
		   int partecipantiMax = (Integer.parseInt(textFieldPartecipanti.getText()));
		   ArrayList<Object> l = new ArrayList<>();
		   l.add(categoria);
		   l.add(giorno);
		   l.add(tipologia);
		
	       StartApplication.c2.controllaInserimenti(nome, codice, orario, prezzo, partecipantiMax, l);
		});
		inserisciAttivita.setFont(new Font("Dialog", Font.BOLD, 15));
		inserisciAttivita.setBounds(261, 606, 200, 33);
		panelInsAtt.add(inserisciAttivita);
		
		labelErroreAtt = new JLabel("");
		labelErroreAtt.setBounds(54, 539, 386, 39);
		panelInsAtt.add(labelErroreAtt);
		
		JLabel lblNewLabel = new JLabel("Giorno:");
		lblNewLabel.setFont(new Font(font1, Font.BOLD, 20));
		lblNewLabel.setBounds(10, 317, 98, 17);
		panelInsAtt.add(lblNewLabel);
		
		comboBoxCateg = new JComboBox<>();
		comboBoxCateg.setModel(new DefaultComboBoxModel<>(new String[] {"Sport", "Svago&Relax", "Salute&Benessere", "Bambini"}));
		comboBoxCateg.setBounds(131, 274, 200, 22);
		panelInsAtt.add(comboBoxCateg);
		
		comboBoxGiorno = new JComboBox<>();
		comboBoxGiorno.setModel(new DefaultComboBoxModel<>(new String[] {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"}));
		comboBoxGiorno.setBounds(131, 317, 201, 22);
		panelInsAtt.add(comboBoxGiorno);
		
		JLabel lblTipologia = new JLabel("Tipologia:");
		lblTipologia.setFont(new Font(font1, Font.BOLD, 20));
		lblTipologia.setBounds(10, 367, 150, 17);
		panelInsAtt.add(lblTipologia);
		
		JLabel lblPartecipanti = new JLabel("Partecipanti:");
		lblPartecipanti.setFont(new Font(font1, Font.BOLD, 20));
		lblPartecipanti.setBounds(10, 416, 150, 17);
		panelInsAtt.add(lblPartecipanti);
		
		textFieldPartecipanti = new JTextField();
		textFieldPartecipanti.setText("0");
		textFieldPartecipanti.setColumns(10);
		textFieldPartecipanti.setBounds(148, 412, 190, 33);
		panelInsAtt.add(textFieldPartecipanti);
		
		comboBoxTipologia = new JComboBox<>();
		comboBoxTipologia.setModel(new DefaultComboBoxModel<>(new String[] {"Singolo", "Gruppo"}));
		comboBoxTipologia.setBounds(147, 368, 201, 22);
		panelInsAtt.add(comboBoxTipologia);
	}


	public JFrame getFrame() {
		return frameInsAtt;
	}


}
