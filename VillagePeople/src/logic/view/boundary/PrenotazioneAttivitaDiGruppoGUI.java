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

	private JFrame framePrenAttGruppo;
	private JTextPane txtCodiceIdPrenAttGruppo;
	private JTable tablePrenAttGruppo;
	private JComboBox<String> comboBoxPrenAttGruppo;
	private JComboBox<String> comboBox1PrenAttGruppo;
	private DefaultTableModel tTabellaPrenAttGruppo;
	private JTextField textFieldCodPrenPrenAttGruppo;
	private JLabel errorLabelPrenPrenAttGruppo;
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
		return tablePrenAttGruppo;
	}


	public JLabel getErrorLabelPren() {
		return errorLabelPrenPrenAttGruppo;
	}


	public JTextField getTextFieldCodPren() {
		return textFieldCodPrenPrenAttGruppo;
	}

	public DefaultTableModel getTabella() {
		return tTabellaPrenAttGruppo;
	}

	public JComboBox<String> getComboBox() {
		return comboBoxPrenAttGruppo;
	}
	
	/**
	 * Create the application.
	 */
	public PrenotazioneAttivitaDiGruppoGUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		framePrenAttGruppo = new JFrame();
		framePrenAttGruppo.setBounds(100, 100, 450, 300);
		framePrenAttGruppo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		framePrenAttGruppo.getContentPane().setLayout(null);
		
		framePrenAttGruppo = new JFrame();
		framePrenAttGruppo.setBounds(100, 100, 517, 700);
		framePrenAttGruppo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelPrenAttGruppo = new JPanel();
		panelPrenAttGruppo.setBackground(new Color(255, 160, 122));
		framePrenAttGruppo.getContentPane().add(panelPrenAttGruppo, BorderLayout.CENTER);
		panelPrenAttGruppo.setLayout(null);
		
		JLabel lblPrenAttGruppo = new JLabel("Seleziona l'attivit\u00E0 da prenotare: ");
		lblPrenAttGruppo.setFont(new Font(font, Font.BOLD, 20));
		lblPrenAttGruppo.setBounds(10, 31, 461, 33);
		panelPrenAttGruppo.add(lblPrenAttGruppo);
		
		JButton indietroPrenAttGruppo = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietroPrenAttGruppo.setIcon(new ImageIcon(img5));
		indietroPrenAttGruppo.addActionListener((ActionEvent e) -> {
		   detach(StartApplication.c1.getWindowNotifiche());
		   errorLabelPrenPrenAttGruppo.setText(" ");
		   framePrenAttGruppo.setVisible(false);
	       StartApplication.c1.switchtoGestisciAttivitaClient();
		});
		indietroPrenAttGruppo.setFont(new Font(font1, Font.BOLD, 15));
		indietroPrenAttGruppo.setBounds(131, 595, 229, 44);
		panelPrenAttGruppo.add(indietroPrenAttGruppo);
		
		JLabel codiceIdPrenAttGruppo = new JLabel("CodiceId: ");
		codiceIdPrenAttGruppo.setVerticalAlignment(SwingConstants.TOP);
		codiceIdPrenAttGruppo.setFont(new Font(font1, Font.BOLD, 11));
		codiceIdPrenAttGruppo.setBounds(10, 18, 62, 14);
		panelPrenAttGruppo.add(codiceIdPrenAttGruppo);
		
		txtCodiceIdPrenAttGruppo = new JTextPane();
		txtCodiceIdPrenAttGruppo.setBackground(new Color(255, 160, 122));
		txtCodiceIdPrenAttGruppo.setEditable(false);
		txtCodiceIdPrenAttGruppo.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceIdPrenAttGruppo.setBounds(62, 11, 92, 21);
		panelPrenAttGruppo.add(txtCodiceIdPrenAttGruppo);
		
		comboBoxPrenAttGruppo = new JComboBox<>();
		comboBoxPrenAttGruppo.setModel(new DefaultComboBoxModel<>(new String[] {"Sport", "Svago&Relax", "Salute&Benessere", "Bambini"}));
		comboBoxPrenAttGruppo.setBounds(30, 94, 155, 21);
		panelPrenAttGruppo.add(comboBoxPrenAttGruppo);
		
		comboBox1PrenAttGruppo = new JComboBox<>();
		comboBox1PrenAttGruppo.setModel(new DefaultComboBoxModel<>(new String[] {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"}));
		comboBox1PrenAttGruppo.setBounds(269, 93, 157, 22);
		panelPrenAttGruppo.add(comboBox1PrenAttGruppo);
		
		JLabel lbl2PrenAttGruppo = new JLabel("Seleziona categoria attivit\u00E0:");
		lbl2PrenAttGruppo.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lbl2PrenAttGruppo.setBounds(20, 74, 229, 21);
		panelPrenAttGruppo.add(lbl2PrenAttGruppo);
		
		JLabel lblSelezionaGionoAttivitaPrenAttGruppo = new JLabel("Seleziona giorno attivit\u00E0:");
		lblSelezionaGionoAttivitaPrenAttGruppo.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblSelezionaGionoAttivitaPrenAttGruppo.setBounds(259, 75, 194, 20);
		panelPrenAttGruppo.add(lblSelezionaGionoAttivitaPrenAttGruppo);
		
		
		JButton btnCercaPrenAttGruppo = new JButton("Cerca");
		Image imgCerca=new ImageIcon(this.getClass().getResource("/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCercaPrenAttGruppo.setIcon(new ImageIcon(imgCerca));
		btnCercaPrenAttGruppo.addActionListener((ActionEvent e) -> {
			String categoria = (comboBoxPrenAttGruppo.getSelectedItem().toString());
			String giorno = (comboBox1PrenAttGruppo.getSelectedItem().toString());
			StartApplication.c1.controllaCategoriaAttivitaGruppo(categoria, giorno);
		});
		btnCercaPrenAttGruppo.setBounds(182, 136, 99, 21);
		panelPrenAttGruppo.add(btnCercaPrenAttGruppo);
		
		JLabel lbl3PrenAttGruppo = new JLabel("Le attivit\u00E0 mostrate nella tabella rientrano nei limiti del budget dichiarato");
		lbl3PrenAttGruppo.setBounds(30, 171, 441, 13);
		panelPrenAttGruppo.add(lbl3PrenAttGruppo);
		
		JScrollPane scrollPanePrenAttGruppo = new JScrollPane();
		scrollPanePrenAttGruppo.setBounds(30, 195, 430, 278);
		panelPrenAttGruppo.add(scrollPanePrenAttGruppo);
		
		tablePrenAttGruppo = new JTable();
		tablePrenAttGruppo.setBackground(new Color(255, 218, 185));
		tTabellaPrenAttGruppo=new DefaultTableModel(
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
		tablePrenAttGruppo.setModel(tTabellaPrenAttGruppo);
		scrollPanePrenAttGruppo.setViewportView(tablePrenAttGruppo);
		
		
		JButton btnPrenotaPrenAttGruppo = new JButton("Prenota");
		Image imgPrenota = new ImageIcon(this.getClass().getResource("/prenotazione2.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnPrenotaPrenAttGruppo.setIcon(new ImageIcon(imgPrenota));
		btnPrenotaPrenAttGruppo.setEnabled(true);
		btnPrenotaPrenAttGruppo.addActionListener((ActionEvent e) -> {
			int riga = 0;
			riga = StartApplication.c1.controllaRiga(riga,2);
			try {
			    int codice = (Integer.parseInt(tablePrenAttGruppo.getValueAt(riga, 0).toString()));
			    double prezzo = (Double.parseDouble(tablePrenAttGruppo.getValueAt(riga, 3).toString()));
			    int partecipantiAttuali = (Integer.parseInt(tablePrenAttGruppo.getValueAt(riga, 4).toString()));
			    int partecipantiMax = (Integer.parseInt(tablePrenAttGruppo.getValueAt(riga, 5).toString()));
			
			    int i = StartApplication.c1.controllaPrenotazioneGruppo(codice, prezzo, partecipantiAttuali, partecipantiMax);
			    if (i == 1) {
				    notifica("team", codice, comboBoxPrenAttGruppo.getSelectedItem().toString());
			    }
			} catch (ArrayIndexOutOfBoundsException ac){
				new TableException().printMessage(1,errorLabelPrenPrenAttGruppo);
				Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				errorLabelPrenPrenAttGruppo.setIcon(new ImageIcon(img));
			}
		});
		btnPrenotaPrenAttGruppo.setBounds(331, 485, 129, 23);
		panelPrenAttGruppo.add(btnPrenotaPrenAttGruppo);
		
		errorLabelPrenPrenAttGruppo = new JLabel("");
		errorLabelPrenPrenAttGruppo.setBounds(30, 517, 430, 67);
		panelPrenAttGruppo.add(errorLabelPrenPrenAttGruppo);
		
	
		
	}
	


	public JComboBox<String> getComboBox1() {
		return comboBox1PrenAttGruppo;
	}

	public JTextPane getTxtCodiceId() {
		return txtCodiceIdPrenAttGruppo;
	}

	public JFrame getFrame() {
		return framePrenAttGruppo;
	}


	@Override
	public void notifica(String tipo, String codice) {//NOT USED
		
	}
}
