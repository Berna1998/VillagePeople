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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import logic.exceptions.FormatException;
import logic.exceptions.TableException;

import javax.swing.JTextField;

public class ModificaAttivitaAdminGUI implements Subject {

	private JFrame frame;
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
	public void notifica(String nome, int codice, String categoria) {
			for (Observer oo: ob) {
				oo.update(nome, codice, categoria);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.ob.contains(o)) {
			this.ob.remove(o);
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
	public ModificaAttivitaAdminGUI() {
		
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
		
		JLabel lblNewLabel1 = new JLabel("Seleziona l'attivit\u00E0 da modificare: ");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel1.setBounds(10, 31, 461, 33);
		panel.add(lblNewLabel1);
		
		JButton indietro = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e) -> {
		   detach(StartApplication.c1.getWindowNotifiche());
		   frame.setVisible(false);
		   errorLabelPren.setText(" ");
		   errorLabelPren.setIcon(new ImageIcon());
	       StartApplication.c2.switchtoGestisciAttivitaAdmin();
		});
		indietro.setFont(new Font(font1, Font.BOLD, 15));
		indietro.setBounds(131, 595, 229, 44);
		panel.add(indietro);
		
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
		lblNewLabel.setBounds(20, 74, 201, 13);
		panel.add(lblNewLabel);
		
		JLabel lblSelezionaGionoAttivita = new JLabel("Seleziona giorno attivit\u00E0:");
		lblSelezionaGionoAttivita.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblSelezionaGionoAttivita.setBounds(259, 75, 180, 13);
		panel.add(lblSelezionaGionoAttivita);
		
		
		JButton btnNewButton = new JButton("Cerca");
		Image imgCerca = new ImageIcon(this.getClass().getResource("/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnNewButton.setIcon(new ImageIcon(imgCerca));
		btnNewButton.addActionListener((ActionEvent e) -> {
			String categoria = (comboBox.getSelectedItem().toString());
			String giorno = (comboBox1.getSelectedItem().toString());
			StartApplication.c2.controllaCategoriaAttivita(categoria,giorno,1);
		});
		btnNewButton.setBounds(173, 136, 94, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 201, 430, 278);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 218, 185));
		tTabella=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Codice", "Nome Attivit\u00E0", "Orario", "Prezzo"
			}
				) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, true, true
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		table.setModel(tTabella);
		scrollPane.setViewportView(table);
		
		
		JButton btnModifica= new JButton("Salva modifiche");
		btnModifica.setEnabled(true);
		btnModifica.addActionListener((ActionEvent e) -> {
			int riga = 0;
			riga = StartApplication.c2.controllaRiga();
			try {
			    int codice = (Integer.parseInt(table.getValueAt(riga, 0).toString()));
			    String orario = (table.getValueAt(riga, 2).toString());
			    double prezzo = (Double.parseDouble(table.getValueAt(riga, 3).toString()));
			
			    int i = StartApplication.c2.controllaModifica(codice, orario, prezzo);
			    if (i == 1) {
				   notifica("modifica", codice, comboBox.getSelectedItem().toString());
			    }
			} catch (ArrayIndexOutOfBoundsException ac){
					new TableException().printMessage(1,errorLabelPren);
					Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
					errorLabelPren.setIcon(new ImageIcon(img));
		    } catch (NumberFormatException ec) {
		    	    new FormatException().printMessage(errorLabelPren);				   
				    Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				    errorLabelPren.setIcon(new ImageIcon(img));
			}
		});
		btnModifica.setBounds(329, 483, 131, 23);
		panel.add(btnModifica);
		
		errorLabelPren = new JLabel("");
		errorLabelPren.setBounds(30, 517, 430, 67);
		panel.add(errorLabelPren);
		
	}
	


	public JComboBox<String> getComboBox1() {
		return comboBox1;
	}


	public JFrame getFrame() {
		return frame;
	}


	@Override
	public void notifica(String tipo, String codice) {//NOT USED
		
	}
}