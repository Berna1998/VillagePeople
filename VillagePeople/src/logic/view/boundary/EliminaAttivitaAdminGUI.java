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

import logic.exceptions.TableException;

import javax.swing.JTextField;

public class EliminaAttivitaAdminGUI implements Subject {

	private JFrame frameElemAtt;
	private JTable tableElemAtt;
	private JComboBox<String> comboBoxElemAtt;
	private JComboBox<String> comboBox1ElemAtt;
	private DefaultTableModel tTabellaElemAtt;
	private JTextField textFieldCodPrenElemAtt;
	private JLabel errorLabelPrenElemAtt;
	private List<Observer> obElemAtt = new ArrayList<>();
	
	
	@Override
	public void attach(Observer o) {
		this.obElemAtt.add(o);
	}
		
	@Override
	public void notifica(String tipo) {
			for (Observer oo: obElemAtt) {
				oo.update(tipo);
			}
	}
	
	@Override
	public void notifica(String nome, int codice, String categoria) {
			for (Observer oo: obElemAtt) {
				oo.update(nome, codice, categoria);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.obElemAtt.contains(o)) {
			this.obElemAtt.remove(o);
		}
	}
	

	public JTable getTable() {
		return tableElemAtt;
	}



	public JLabel getErrorLabelPren() {
		return errorLabelPrenElemAtt;
	}


	public JTextField getTextFieldCodPren() {
		return textFieldCodPrenElemAtt;
	}


	public DefaultTableModel getTabella() {
		return tTabellaElemAtt;
	}


	public JComboBox<String> getComboBox() {
		return comboBoxElemAtt;
	}


	/**
	 * Create the application.
	 */
	public EliminaAttivitaAdminGUI() {
		
		String font="Georgia Pro Semibold";
		String font1="Dialog";
		
		frameElemAtt = new JFrame();
		frameElemAtt.setBounds(100, 100, 450, 300);
		frameElemAtt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameElemAtt.getContentPane().setLayout(null);
		
		frameElemAtt = new JFrame();
		frameElemAtt.setBounds(100, 100, 517, 700);
		frameElemAtt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelElemAtt = new JPanel();
		panelElemAtt.setBackground(new Color(255, 160, 122));
		frameElemAtt.getContentPane().add(panelElemAtt, BorderLayout.CENTER);
		panelElemAtt.setLayout(null);
		
		JLabel lblElemAtt = new JLabel("Seleziona l'attivit\u00E0 da eliminare: ");
		lblElemAtt.setFont(new Font(font, Font.BOLD, 20));
		lblElemAtt.setBounds(10, 31, 461, 33);
		panelElemAtt.add(lblElemAtt);
		
		JButton indietroElemAtt = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietroElemAtt.setIcon(new ImageIcon(img5));
		indietroElemAtt.addActionListener((ActionEvent e) -> {
		   detach(StartApplication.c1.getWindowNotifiche());
		   errorLabelPrenElemAtt.setText(" ");
		   errorLabelPrenElemAtt.setIcon(new ImageIcon());
		   frameElemAtt.setVisible(false);
	       StartApplication.c2.switchtoGestisciAttivitaAdmin();
		});
		indietroElemAtt.setFont(new Font(font1, Font.BOLD, 15));
		indietroElemAtt.setBounds(131, 595, 229, 44);
		panelElemAtt.add(indietroElemAtt);
		
		comboBoxElemAtt = new JComboBox<>();
		comboBoxElemAtt.setModel(new DefaultComboBoxModel<>(new String[] {"Sport", "Svago&Relax", "Salute&Benessere", "Bambini"}));
		comboBoxElemAtt.setBounds(30, 94, 155, 21);
		panelElemAtt.add(comboBoxElemAtt);
		
		comboBox1ElemAtt = new JComboBox<>();
		comboBox1ElemAtt.setModel(new DefaultComboBoxModel<>(new String[] {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"}));
		comboBox1ElemAtt.setBounds(269, 93, 157, 22);
		panelElemAtt.add(comboBox1ElemAtt);
		
		JLabel lblElemAtt2 = new JLabel("Se2leziona categoria attivit\u00E0:");
		lblElemAtt2.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblElemAtt2.setBounds(20, 74, 196, 13);
		panelElemAtt.add(lblElemAtt);
		
		JLabel lblSelezionaGionoAttivita = new JLabel("Seleziona giorno attivit\u00E0:");
		lblSelezionaGionoAttivita.setFont(new Font("Georgia Pro Cond Semibold", Font.BOLD, 15));
		lblSelezionaGionoAttivita.setBounds(259, 75, 180, 13);
		panel.add(lblSelezionaGionoAttivita);
		
		
		JButton btnCercaElemAtt = new JButton("Cerca");
		Image imgCerca=new ImageIcon(this.getClass().getResource("/search.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCercaElemAtt.setIcon(new ImageIcon(imgCerca));
		btnCercaElemAtt.addActionListener((ActionEvent e) -> {
			String categoria = (comboBox.getSelectedItem().toString());
			String giorno = (comboBox1.getSelectedItem().toString());
			StartApplication.c2.controllaCategoriaAttivita(categoria, giorno,2);
		});
		btnCercaElemAtt.setBounds(171, 136, 96, 21);
		panelElemAtt.add(btnCercaElemAtt);
		
		JScrollPane scrollPaneElemAtt = new JScrollPane();
		scrollPaneElemAtt.setBounds(30, 201, 430, 278);
		panelElemAtt.add(scrollPaneElemAtt);
		
		tableElemAtt = new JTable();
		tableElemAtt.setBackground(new Color(255, 218, 185));
		tTabellaElemAtt=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Codice", "Nome Attivit\u00E0", "Orario", "Prezzo"
			}
				) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditablesElemAtt = new boolean[] {
				false, false, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditablesElemAtt[column];
			}
		};
		tableElemAtt.setModel(tTabellaElemAtt);
		scrollPaneElemAtt.setViewportView(tableElemAtt);
		
		
		JButton btnElimina = new JButton("Elimina attivit\u00E0");
		Image imgCancella = new ImageIcon(this.getClass().getResource("/cancella.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		btnElimina.setIcon(new ImageIcon(imgCancella));
		btnElimina.setEnabled(true);
		btnElimina.addActionListener((ActionEvent e) -> {
			int riga = 0;
			riga = StartApplication.c2.controllaRigaElimin();
			try {
			    int codice = (Integer.parseInt(table.getValueAt(riga, 0).toString()));
			    double prezzo = (Double.parseDouble(table.getValueAt(riga, 3).toString()));
			    String categoria = comboBox.getSelectedItem().toString();
			
			    int i = StartApplication.c2.controllaEliminazione(codice, prezzo);
		
			    if (i == 1) {
				   notifica("elimina", codice, categoria);
			    }
			} catch (ArrayIndexOutOfBoundsException ac){
				new TableException().printMessage(1,errorLabelPren);
				Image img = new ImageIcon(this.getClass().getResource("/errore.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				errorLabelPren.setIcon(new ImageIcon(img));
			}
			
		});
		btnElimina.setBounds(320, 483, 140, 23);
		panelElemAtt.add(btnElimina);
		
		errorLabelPrenElemAtt = new JLabel("");
		errorLabelPrenElemAtt.setBounds(30, 517, 430, 67);
		panelElemAtt.add(errorLabelPrenElemAtt);
		
	}
	


	public JComboBox<String> getComboBox1() {
		return comboBox1ElemAtt;
	}


	public JFrame getFrame() {
		return frameElemAtt;
	}


	@Override
	public void notifica(String tipo, String codice) {//NOT USED
		
	}
}