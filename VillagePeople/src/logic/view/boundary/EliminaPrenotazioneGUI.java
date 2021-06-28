package logic.view.boundary;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import logic.exceptions.TableException;

import javax.swing.JTextField;
import javax.swing.JComboBox;


public class EliminaPrenotazioneGUI implements Subject {

	private JFrame frameElemPren;
	private JTable table;
	private DefaultTableModel tTabella;
	private JTextField textFieldCodPren;
	private JLabel errorLabelPren;
	private JComboBox<String> comboBox;
	private List<Observer> ob = new ArrayList<>();

	@Override
	public void attach(Observer o) {
		this.ob.add(o);
	}
	
	@Override
	public void notifica(String nome, int cod, String categoria) {
		for (Observer oo: ob) {
			oo.update(nome, cod, categoria);
		}
	}
	
	@Override
	public void notifica(String tipo, String codice) {//NOT USED
			

	}
	
	@Override
	public void detach(Observer o) {
		if (this.ob.contains(o)) {
			this.ob.remove(o);
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
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

	
	/**
	 * Create the application.
	 */
	public EliminaPrenotazioneGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1 = "Dialog";
		
		frameElemPren = new JFrame();
		frameElemPren.setBounds(100, 100, 450, 300);
		frameElemPren.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameElemPren.getContentPane().setLayout(null);
		
		frameElemPren = new JFrame();
		frameElemPren.setBounds(100, 100, 517, 700);
		frameElemPren.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelElemPren = new JPanel();
		panelElemPren.setBackground(new Color(255, 160, 122));
		frameElemPren.getContentPane().add(panelElemPren, BorderLayout.CENTER);
		panelElemPren.setLayout(null);
		
		JLabel lblElemPren = new JLabel("Seleziona la prenotazione da eliminare: ");
		lblElemPren.setFont(new Font(font, Font.BOLD, 20));
		lblElemPren.setBounds(10, 92, 461, 33);
		panelElemPren.add(lblElemPren);
		
		errorLabelPren = new JLabel("");
		errorLabelPren.setBounds(30, 517, 430, 51);
		panel.add(errorLabelPren);
		
		JButton indietro = new JButton("Indietro");
		Image img5=new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e) ->
		   frame.setVisible(false));
		   errorLabelPren.setText(" ");
	       StartApplication.c1.switchtoGestisciAttivitaClient();
		indietro.setFont(new Font(font1, Font.BOLD, 15));
		indietro.setBounds(131, 595, 229, 44);
		panel.add(indietro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 149, 430, 293);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 218, 185));
		tTabella=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Codice", "Nome Attivit\u00E0", "Orario", "Prezzo","Giorno"
			}
				) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		table.setModel(tTabella);
		scrollPane.setViewportView(table);
		
		
		JButton btnElimina = new JButton("Elimina Prenotazione");
		Image imgElimina = new ImageIcon(this.getClass().getResource("/cancella.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		btnElimina.setIcon(new ImageIcon(imgElimina));
		btnElimina.setEnabled(true);
		btnElimina.addActionListener((ActionEvent e) -> { 
			int riga = 0;
			riga = StartApplication.c1.controllaRiga(riga,3);
			try {
				int codice = (Integer.parseInt(table.getValueAt(riga, 0).toString()));
				String giorno = (table.getValueAt(riga, 5).toString());
				double prezzo = (Double.parseDouble(table.getValueAt(riga, 3).toString()));
				String categoria = (comboBox.getSelectedItem().toString());
			
				int i = StartApplication.c1.controllaEliminazione(codice, giorno, prezzo);
			
				if (i == 1) {
					notifica("postoLibero", codice,categoria);
				
				}
			
			}catch (ArrayIndexOutOfBoundsException ac){
				new TableException().printMessage(1,errorLabelPren);
				Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				errorLabelPren.setIcon(new ImageIcon(img));
			} 
			
		});
		btnElimina.setBounds(285, 483, 175, 23);
		panel.add(btnElimina);
		

		
		JButton btnNewButton = new JButton("Visualizza Prenotazioni");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener((ActionEvent e) -> {
		    String categoria = (comboBox.getSelectedItem().toString());
			StartApplication.c1.ricercaPrenotazioni(categoria);
		});
		btnNewButton.setBounds(292, 49, 152, 33);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Seleziona categoria attivit\u00E0:");
		lblNewLabel.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(39, 31, 229, 21);
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Sport", "Svago&Relax", "Salute&Benessere", "Bambini"}));
		comboBox.setBounds(79, 56, 122, 21);
		panel.add(comboBox);
		
	}
	


	@Override
	public void notifica(String tipo) {//NOT USED
		
	}
}
