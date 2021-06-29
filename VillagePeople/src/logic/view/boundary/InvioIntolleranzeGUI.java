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

import javax.swing.JCheckBox;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;



public class InvioIntolleranzeGUI implements Subject {

	private JFrame frameInvInt;
	private JCheckBox chckbxMenu1;
	private JCheckBox chckbxMenu2;
	private JCheckBox chckbxMenu3;
	private JLabel erroreIntoll;
	private JTextPane txtCodiceId;
	private JRadioButton rdBtnScelta;
	private List<Observer> obInvInt = new ArrayList<>();
	private JTextPane txtIntol;
	
	@Override
	public void attach(Observer o) {
		this.obInvInt.add(o);
	}
		
	@Override
	public void notifica(String tipo, String codice) {
			for (Observer oo: obInvInt) {
				oo.update(tipo, codice);
			}
	}
	
	@Override
	public void detach(Observer o) {
		if (this.obInvInt.contains(o)) {
			this.obInvInt.remove(o);
		}
	}
	

	public JTextPane getTxtCodiceId() {
		return txtCodiceId;
	}

	
	public JLabel getErroreIntoll() {
		return erroreIntoll;
	}


	/**
	 * Create the application.
	 */
	public InvioIntolleranzeGUI() {
		
		String font = "Georgia Pro Semibold";
		String font1="Dialog";
		
		frameInvInt = new JFrame();
		frameInvInt.setBounds(100, 100, 450, 300);
		frameInvInt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameInvInt.getContentPane().setLayout(null);
		
		frameInvInt = new JFrame();
		frameInvInt.setBounds(100, 100, 517, 700);
		frameInvInt.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panelInvInt = new JPanel();
		panelInvInt.setBackground(new Color(255, 160, 122));
		frameInvInt.getContentPane().add(panelInvInt, BorderLayout.CENTER);
		panelInvInt.setLayout(null);
		
		txtIntol = new JTextPane();
		txtIntol.setFont(new Font(font1, Font.BOLD, 18));
		txtIntol.setBounds(10, 350, 480, 141);
		txtIntol.setEditable(false);
		panelInvInt.add(txtIntol);
		
		JButton azzera = new JButton("Azzera ");
		azzera.addActionListener((ActionEvent e)-> {
	             chckbxMenu1.setSelected(false); 
	             chckbxMenu2.setSelected(false);
	             chckbxMenu3.setSelected(false);
	             txtIntol.setText(null);
	    });
		azzera.setFont(new Font(font1, Font.BOLD, 15));
		azzera.setBounds(10, 525, 206, 33);
		panelInvInt.add(azzera);
		
		JButton invia = new JButton("Invia");
		invia.addActionListener((ActionEvent e)-> {
			String codice = txtCodiceId.getText();
			boolean checkMenu1 = chckbxMenu1.isSelected();
			boolean checkMenu2 = chckbxMenu2.isSelected();
			boolean checkMenu3 = chckbxMenu3.isSelected();
			String  txtIntolleranze=txtIntol.getText();
			boolean radioBtn = rdBtnScelta.isSelected();
			int j = StartApplication.c1.controllaScelteMenu(checkMenu1, checkMenu2, checkMenu3);
			int i = 0;
			if (j == 1) {
			    i = StartApplication.c1.inviaDatiIntolleranze(codice, checkMenu1, checkMenu2, checkMenu3, txtIntolleranze, radioBtn);
			}
			if (i == 1) {
				notifica("intolleranze", codice);
			}
			
			
	    });
		invia.setFont(new Font(font1, Font.BOLD, 15));
		invia.setBounds(284, 525, 206, 33);
		panelInvInt.add(invia);
		
		JLabel lblNewLabel = new JLabel("Inserire eventuali intolleranze qui:");
		lblNewLabel.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel.setBounds(17, 307, 347, 33);
		panelInvInt.add(lblNewLabel);
		
		chckbxMenu1 = new JCheckBox("Menu 1");
		chckbxMenu1.addActionListener((ActionEvent e)-> 
			StartApplication.c1.selezionaCheckBox(1)
		);
		chckbxMenu1.setFont(new Font(font, Font.BOLD, 15));
		chckbxMenu1.setBounds(46, 83, 118, 33);
		panelInvInt.add(chckbxMenu1);
		
		chckbxMenu2 = new JCheckBox("Menu 2");
		chckbxMenu2.addActionListener((ActionEvent e)-> 
			StartApplication.c1.selezionaCheckBox(2)

	    );
		chckbxMenu2.setFont(new Font(font, Font.BOLD, 15));
		chckbxMenu2.setBounds(46, 141, 118, 33);
		panelInvInt.add(chckbxMenu2);
		
		chckbxMenu3 = new JCheckBox("Menu 3");
		chckbxMenu3.addActionListener((ActionEvent e)-> 
			StartApplication.c1.selezionaCheckBox(3)
	    );
		chckbxMenu3.setFont(new Font(font, Font.BOLD, 15));
		chckbxMenu3.setBounds(46, 198, 118, 33);
		panelInvInt.add(chckbxMenu3);
		
		JLabel lblNewLabel1 = new JLabel("Selezionare Menu:");
		lblNewLabel1.setFont(new Font(font, Font.BOLD, 20));
		lblNewLabel1.setBounds(10, 26, 378, 33);
		panelInvInt.add(lblNewLabel1);
		
		JButton indietro = new JButton("Indietro");
		Image img5 = new ImageIcon(this.getClass().getResource("/indietro.jpg")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		indietro.setIcon(new ImageIcon(img5));
		indietro.addActionListener((ActionEvent e)-> {
		  detach(StartApplication.c2.getWindowNotificheAdmin());
		   frameInvInt.setVisible(false);
		   erroreIntoll.setText(" ");
		   StartApplication.c1.switchtoMenu();
		});
		indietro.setFont(new Font(font1, Font.BOLD, 20));
		indietro.setBounds(135, 594, 229, 44);
		panelInvInt.add(indietro);
		
		erroreIntoll = new JLabel("");
		erroreIntoll.setHorizontalAlignment(SwingConstants.CENTER);
		erroreIntoll.setBounds(20, 554, 460, 33);
		panelInvInt.add(erroreIntoll);
		
		JLabel codiceId = new JLabel("CodiceId: ");
		codiceId.setVerticalAlignment(SwingConstants.TOP);
		codiceId.setFont(new Font(font1, Font.BOLD, 11));
		codiceId.setBounds(10, 18, 54, 14);
		panelInvInt.add(codiceId);
		
		txtCodiceId = new JTextPane();
		txtCodiceId.setBackground(new Color(255, 160, 122));
		txtCodiceId.setEditable(false);
		txtCodiceId.setFont(new Font(font1, Font.BOLD, 11));
		txtCodiceId.setBounds(61, 11, 92, 21);
		panelInvInt.add(txtCodiceId);
		
		JLabel lblCibo = new JLabel("");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/cibo3.jpeg"));
		lblCibo.setIcon(img);
		lblCibo.setBounds(222, 83, 268, 148);
		panelInvInt.add(lblCibo);
		
		rdBtnScelta= new JRadioButton("");
		rdBtnScelta.addActionListener((ActionEvent e)-> 
		StartApplication.c1.selezionaRadioButton(rdBtnScelta.isSelected())

		);
		rdBtnScelta.setBounds(447, 268, 21, 21);
		panelInvInt.add(rdBtnScelta);
		
		JLabel lblNewLabel111 = new JLabel("Seleziona per aggiungere intolleranze sul men\u00F9 scelto");
		lblNewLabel111.setFont(new Font(font1, Font.BOLD, 16));
		lblNewLabel111.setBounds(15, 268, 420, 21);
		panelInvInt.add(lblNewLabel111);
		
   }
	

	public JTextPane getTxtIntol() {
		return txtIntol;
	}

	public JRadioButton getRdBtnScelta() {
		return rdBtnScelta;
	}


	public JCheckBox getChckbxMenu1() {
		return chckbxMenu1;
	}


	public JCheckBox getChckbxMenu2() {
		return chckbxMenu2;
	}


	public JCheckBox getChckbxMenu3() {
		return chckbxMenu3;
	}

	public JFrame getFrame() {
		return frameInvInt;
	}


	@Override
	public void notifica(String nome, int cod, String categoria) {//NOT USED
		
	}

	@Override
	public void notifica(String tipo) {//NOT USED
		
		
	}
}
