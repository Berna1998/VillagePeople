package logic.view.boundary;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import logic.exceptions.TableException;

import javax.swing.JTextField;

public class PrenotazioneAttivitaDiGruppoGUI implements Subject  {

	private JFrame frame;
	private JTextPane txtCodiceId;
	private JTable table;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox1;
	private DefaultTableModel tTabella;
	private JTextField textFieldCodPren;
	private JLabel errorLabelPren;
	private List<Observer> ob = new ArrayList<>();

	
	@Override
	public void attach(Observer o) {
		this.ob.add(o);
	}
		
	@Override
	public void notifica(String tipo) {
			for (Observer oo: ob) {
				oo.update(tipo);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.ob.contains(o)) {
			this.ob.remove(o);
		}
	}
	
	@Override
	public void notifica(String nome, int codice, String categoria) {
			for (Observer oo: ob) {
				oo.update(nome, codice, categoria);
			}
	}
	
	
	public JTable getTable() {
		return table;
	}


	public JLabel getErrorLabelPren() {
		return errorLabelPren;
	}


	public JTextField getTextFieldCodPren() {
		return textFieldCodPren;
	}

	public DefaultTableModel getTabella() {
		return tTabella;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	
	/**
	 * Create the application.
	 */
	public PrenotazioneAttivitaDiGruppoGUI() {
		
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
		
		JLabel lblNewLabel1 = new JLabel("Seleziona l'attivit\u00E0 da prenotare: ");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel1.setBounds(10, 31, 461, 33);
		panel.add(lblNewLabel1);
		
		JButton indietro = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e) -> {
		   detach(StartApplication.c1.getWindowNotifiche());
		   errorLabelPren.setText(" ");
		   frame.setVisible(false);
	       StartApplication.c1.switchtoGestisciAttivitaClient();
		});
		indietro.setFont(new Font(font1, Font.BOLD, 15));
		indietro.setBounds(131, 595, 229, 44);
		panel.add(indietro);
		
		JLabel codiceId = new JLabel("CodiceId: ");
		codiceId.setVerticalAlignment(SwingConstants.TOP);
		codiceId.setFont(new Font(font1, Font.BOLD, 11));
		codiceId.setBounds(10, 18, 62, 14);
		panel.add(codiceId);
		
		txtCodiceId = new JTextPane();
		txtCodiceId.setBackground(new Color(255, 160, 122));
		txtCodiceId.setEditable(false);
		txtCodiceId.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceId.setBounds(62, 11, 92, 21);
		panel.add(txtCodiceId);
		
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Sport", "Svago&Relax", "Salute&Benessere", "Bambini"}));
		comboBox.setBounds(30, 94, 155, 21);
		panel.add(comboBox);
		
		comboBox1 = new JComboBox<>();
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"}));
		comboBox1.setBounds(269, 93, 157, 22);
		panel.add(comboBox1);
		
		JLabel lblNewLabel = new JLabel("Seleziona categoria attivit\u00E0:");
		lblNewLabel.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 74, 229, 21);
		panel.add(lblNewLabel);
		
		JLabel lblSelezionaGionoAttivita = new JLabel("Seleziona giorno attivit\u00E0:");
		lblSelezionaGionoAttivita.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblSelezionaGionoAttivita.setBounds(259, 75, 194, 20);
		panel.add(lblSelezionaGionoAttivita);
		
		
		JButton btnNewButton = new JButton("Cerca");
		Image imgCerca=new ImageIcon(this.getClass().getResource("/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnNewButton.setIcon(new ImageIcon(imgCerca));
		btnNewButton.addActionListener((ActionEvent e) -> {
			String categoria = (comboBox.getSelectedItem().toString());
			String giorno = (comboBox1.getSelectedItem().toString());
			StartApplication.c1.controllaCategoriaAttivitaGruppo(categoria, giorno);
		});
		btnNewButton.setBounds(182, 136, 99, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel11 = new JLabel("Le attivit\u00E0 mostrate nella tabella rientrano nei limiti del budget dichiarato");
		lblNewLabel11.setBounds(30, 171, 441, 13);
		panel.add(lblNewLabel11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 195, 430, 278);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 218, 185));
		tTabella=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice", "Nome Attivit\u00E0", "Orario", "Prezzo", "Numero Partecipanti", "Numero Partecipanti Max"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		table.setModel(tTabella);
		scrollPane.setViewportView(table);
		
		
		JButton btnPrenota = new JButton("Prenota");
		Image imgPrenota = new ImageIcon(this.getClass().getResource("/prenotazione2.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnPrenota.setIcon(new ImageIcon(imgPrenota));
		btnPrenota.setEnabled(true);
		btnPrenota.addActionListener((ActionEvent e) -> {
			int riga = 0;
			riga = StartApplication.c1.controllaRiga(riga,2);
			try {
			    int codice = (Integer.parseInt(table.getValueAt(riga, 0).toString()));
			    double prezzo = (Double.parseDouble(table.getValueAt(riga, 3).toString()));
			    int partecipantiAttuali = (Integer.parseInt(table.getValueAt(riga, 4).toString()));
			    int partecipantiMax = (Integer.parseInt(table.getValueAt(riga, 5).toString()));
			
			    int i = StartApplication.c1.controllaPrenotazioneGruppo(codice, prezzo, partecipantiAttuali, partecipantiMax);
			    if (i == 1) {
				    notifica("team", codice, comboBox.getSelectedItem().toString());
			    }
			} catch (ArrayIndexOutOfBoundsException ac){
				new TableException().printMessage(1,errorLabelPren);
				Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				errorLabelPren.setIcon(new ImageIcon(img));
			}
		});
		btnPrenota.setBounds(331, 485, 129, 23);
		panel.add(btnPrenota);
		
		errorLabelPren = new JLabel("");
		errorLabelPren.setBounds(30, 517, 430, 67);
		panel.add(errorLabelPren);
		
	
		
	}
	


	public JComboBox<String> getComboBox1() {
		return comboBox1;
	}

	public JTextPane getTxtCodiceId() {
		return txtCodiceId;
	}

	public JFrame getFrame() {
		return frame;
	}


	@Override
	public void notifica(String tipo, String codice) {//NOT USED
		
	}
}
