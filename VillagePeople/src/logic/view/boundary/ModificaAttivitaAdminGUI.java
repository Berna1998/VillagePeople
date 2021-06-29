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

	private JFrame frameModifAtt;
	private JTable tableModifAtt;
	private JComboBox<String> comboBoxModifAtt;
	private JComboBox<String> comboBox1ModifAtt;
	private DefaultTableModel tTabellaModifAtt;
	private JTextField textFieldCodPrenModifAtt;
	private JLabel errorLabelPrenModifAtt;
	private List<Observer> obModifAtt = new ArrayList<>();
	
	@Override
	public void attach(Observer o) {
		this.obModifAtt.add(o);
	}
		
	@Override
	public void notifica(String tipo) {
			for (Observer oo: obModifAtt) {
				oo.update(tipo);
			}
	}
	
	@Override
	public void notifica(String nome, int codice, String categoria) {
			for (Observer oo: obModifAtt) {
				oo.update(nome, codice, categoria);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.obModifAtt.contains(o)) {
			this.obModifAtt.remove(o);
		}
	}
		
	public JTable getTable() {
		return tableModifAtt;
	}

	public JLabel getErrorLabelPren() {
		return errorLabelPrenModifAtt;
	}

	public JTextField getTextFieldCodPren() {
		return textFieldCodPrenModifAtt;
	}


	public DefaultTableModel getTabella() {
		return tTabellaModifAtt;
	}


	public JComboBox<String> getComboBox() {
		return comboBoxModifAtt;
	}


	/**
	 * Create the application.
	 */
	public ModificaAttivitaAdminGUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frameModifAtt = new JFrame();
		frameModifAtt.setBounds(100, 100, 450, 300);
		frameModifAtt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameModifAtt.getContentPane().setLayout(null);
		
		frameModifAtt = new JFrame();
		frameModifAtt.setBounds(100, 100, 517, 700);
		frameModifAtt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelModifAtt = new JPanel();
		panelModifAtt.setBackground(new Color(255, 160, 122));
		frameModifAtt.getContentPane().add(panelModifAtt, BorderLayout.CENTER);
		panelModifAtt.setLayout(null);
		
		JLabel lbl2ModifAtt = new JLabel("Seleziona l'attivit\u00E0 da modificare: ");
		lbl2ModifAtt.setFont(new Font(font, Font.BOLD, 20));
		lbl2ModifAtt.setBounds(10, 31, 461, 33);
		panelModifAtt.add(lbl2ModifAtt);
		
		JButton indietroModifAtt = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietroModifAtt.setIcon(new ImageIcon(img5));
		indietroModifAtt.addActionListener((ActionEvent e) -> {
		   detach(StartApplication.c1.getWindowNotifiche());
		   frameModifAtt.setVisible(false);
		   errorLabelPrenModifAtt.setText(" ");
		   errorLabelPrenModifAtt.setIcon(new ImageIcon());
	       StartApplication.c2.switchtoGestisciAttivitaAdmin();
		});
		indietroModifAtt.setFont(new Font(font1, Font.BOLD, 15));
		indietroModifAtt.setBounds(131, 595, 229, 44);
		panelModifAtt.add(indietroModifAtt);
		
		comboBoxModifAtt = new JComboBox<>();
		comboBoxModifAtt.setModel(new DefaultComboBoxModel<>(new String[] {"Sport", "Svago&Relax", "Salute&Benessere", "Bambini"}));
		comboBoxModifAtt.setBounds(30, 94, 155, 21);
		panelModifAtt.add(comboBoxModifAtt);
		
		comboBox1ModifAtt = new JComboBox<>();
		comboBox1ModifAtt.setModel(new DefaultComboBoxModel<>(new String[] {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"}));
		comboBox1ModifAtt.setBounds(269, 93, 157, 22);
		panelModifAtt.add(comboBox1ModifAtt);
		
		JLabel lblModifAtt = new JLabel("Seleziona categoria attivit\u00E0:");
		lblModifAtt.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblModifAtt.setBounds(20, 74, 201, 13);
		panelModifAtt.add(lblModifAtt);
		
		JLabel lblSelezionaGionoAttivitaModifAtt = new JLabel("Seleziona giorno attivit\u00E0:");
		lblSelezionaGionoAttivitaModifAtt.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblSelezionaGionoAttivitaModifAtt.setBounds(259, 75, 180, 13);
		panelModifAtt.add(lblSelezionaGionoAttivitaModifAtt);
		
		
		JButton btnCercaModifAtt = new JButton("Cerca");
		Image imgCerca = new ImageIcon(this.getClass().getResource("/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCercaModifAtt.setIcon(new ImageIcon(imgCerca));
		btnCercaModifAtt.addActionListener((ActionEvent e) -> {
			String categoria = (comboBoxModifAtt.getSelectedItem().toString());
			String giorno = (comboBox1ModifAtt.getSelectedItem().toString());
			StartApplication.c2.controllaCategoriaAttivita(categoria,giorno,1);
		});
		btnCercaModifAtt.setBounds(173, 136, 94, 21);
		panelModifAtt.add(btnCercaModifAtt);
		
		JScrollPane scrollPaneModifAtt = new JScrollPane();
		scrollPaneModifAtt.setBounds(30, 201, 430, 278);
		panelModifAtt.add(scrollPaneModifAtt);
		
		tableModifAtt = new JTable();
		tableModifAtt.setBackground(new Color(255, 218, 185));
		tTabellaModifAtt=new DefaultTableModel(
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
		tableModifAtt.setModel(tTabellaModifAtt);
		scrollPaneModifAtt.setViewportView(tableModifAtt);
		
		
		JButton btnModifica= new JButton("Salva modifiche");
		btnModifica.setEnabled(true);
		btnModifica.addActionListener((ActionEvent e) -> {
			int riga = 0;
			riga = StartApplication.c2.controllaRiga();
			try {
			    int codice = (Integer.parseInt(tableModifAtt.getValueAt(riga, 0).toString()));
			    String orario = (tableModifAtt.getValueAt(riga, 2).toString());
			    double prezzo = (Double.parseDouble(tableModifAtt.getValueAt(riga, 3).toString()));
			
			    int i = StartApplication.c2.controllaModifica(codice, orario, prezzo);
			    if (i == 1) {
				   notifica("modifica", codice, comboBoxModifAtt.getSelectedItem().toString());
			    }
			} catch (ArrayIndexOutOfBoundsException ac){
					new TableException().printMessage(1,errorLabelPrenModifAtt);
					Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
					errorLabelPrenModifAtt.setIcon(new ImageIcon(img));
		    } catch (NumberFormatException ec) {
		    	    new FormatException().printMessage(errorLabelPrenModifAtt);				   
				    Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				    errorLabelPrenModifAtt.setIcon(new ImageIcon(img));
			}
		});
		btnModifica.setBounds(329, 483, 131, 23);
		panelModifAtt.add(btnModifica);
		
		errorLabelPrenModifAtt = new JLabel("");
		errorLabelPrenModifAtt.setBounds(30, 517, 430, 67);
		panelModifAtt.add(errorLabelPrenModifAtt);
		
	}
	


	public JComboBox<String> getComboBox1() {
		return comboBox1ModifAtt;
	}


	public JFrame getFrame() {
		return frameModifAtt;
	}


	@Override
	public void notifica(String tipo, String codice) {//NOT USED
		
	}
}