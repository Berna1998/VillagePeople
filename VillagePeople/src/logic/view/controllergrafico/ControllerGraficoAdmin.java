package logic.view.controllergrafico;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import javax.swing.ImageIcon;

import logic.exceptions.AddActivityException;
import logic.exceptions.AddClientException;
import logic.exceptions.DatabaseException;
import logic.exceptions.ManageActivityAdminException;
import logic.exceptions.MenuException;
import logic.bean.AttivitaBean;
import logic.bean.MenuBean;
import logic.bean.SignUpBean;
import logic.bean.UtenteBean;
import logic.controller.AttivitaController;
import logic.controller.EliminaAttivitaController;
import logic.controller.InserisciAttivitaAdminController;
import logic.controller.LogInController;
import logic.controller.MenuAdminController;
import logic.controller.ModificaAttivitaAdminController;
import logic.controller.NotificheController;
import logic.controller.SignUpController;
import logic.view.boundary.AggiungiNuovoClienteGUI;
import logic.view.boundary.InserisciAttivitaAdminGUI;
import logic.view.boundary.ElencoIntolleranza2GUI;
import logic.view.boundary.ElencoIntolleranze1GUI;
import logic.view.boundary.ElencoIntolleranze3GUI;
import logic.view.boundary.EliminaAttivitaAdminGUI;
import logic.view.boundary.GestisciAttivitaAdminGUI;
import logic.view.boundary.HomepageAdminGUI;
import logic.view.boundary.MenuAdminGUI;
import logic.view.boundary.MenuPrenotatiGUI;
import logic.view.boundary.ModificaAttivitaAdminGUI;
import logic.view.boundary.NotificheAdminGUI;
import logic.view.boundary.StartApplication;

public class ControllerGraficoAdmin {
	private SignUpController sc = new SignUpController();
	private LogInController cli = new LogInController();
	private MenuAdminController mac = new MenuAdminController();	
	private MenuAdminGUI windowMenuAdmin = new MenuAdminGUI();
	private MenuBean mb = new MenuBean();
	private HomepageAdminGUI windowHomepageAdmin;
	private GestisciAttivitaAdminGUI windowAttivita;
	private NotificheAdminGUI windowNotificheAdmin = new NotificheAdminGUI();
	private MenuPrenotatiGUI windowMenuPrenotati;
	private ElencoIntolleranze1GUI windowElenco1;
	private ElencoIntolleranza2GUI windowElenco2;
	private ElencoIntolleranze3GUI windowElenco3;
	private InserisciAttivitaAdminGUI windowCategorieAdmin = new InserisciAttivitaAdminGUI();
	private AggiungiNuovoClienteGUI windowAggiungiCliente;
	private ModificaAttivitaAdminGUI windowModificaAttAdmin = new ModificaAttivitaAdminGUI();
	private EliminaAttivitaAdminGUI windowEliminaAttAdmin = new EliminaAttivitaAdminGUI();
	private AttivitaController ac = new AttivitaController();
	private EliminaAttivitaController eac = new EliminaAttivitaController();
	private ModificaAttivitaAdminController maac = new ModificaAttivitaAdminController();
	private InserisciAttivitaAdminController iaac = new InserisciAttivitaAdminController();
	private NotificheController nc = new NotificheController();
	private UtenteBean ub = new UtenteBean();
	private AttivitaBean ab = new AttivitaBean();
	private SignUpBean sb = new SignUpBean();
	private Connection connessioneAdm; 
	private String errore = "/errore.png";
	private String spuntaVerde = "/spuntaVerde.png";

    /* GETTER E SETTER */
    public NotificheAdminGUI getWindowNotificheAdmin() {
		return windowNotificheAdmin;
	}

	public void setWindowNotificheAdmin(NotificheAdminGUI windowNotificheAdmin) {
		this.windowNotificheAdmin = windowNotificheAdmin;
	}

	/* METODI */
	
	public void aggiornaElencoIntolleranze(int num, StringBuilder tot) {
		if (num	==	1) {
			windowElenco1.getTextArea().setText(tot.toString());
		}
		else if (num == 2) {
			windowElenco2.getTextArea().setText(tot.toString());	
		}
		else if (num == 3) {
			windowElenco3.getTextArea().setText(tot.toString());
		}	
	}
	
	public void aggiornaInterfacciaMenuPrenotati(int totaleMenu1, int totaleMenu2, int totaleMenu3, int totaleIntolleranze1, int totaleIntolleranze2, int totaleIntolleranze3) {
		windowMenuPrenotati.getCounterMenu1().setText(String.valueOf(totaleMenu1));
		windowMenuPrenotati.getCounterMenu2().setText(String.valueOf(totaleMenu2));
		windowMenuPrenotati.getCounterMenu3().setText(String.valueOf(totaleMenu3));
		windowMenuPrenotati.getCountIntoll1().setText(String.valueOf(totaleIntolleranze1));
		windowMenuPrenotati.getCountIntoll2().setText(String.valueOf(totaleIntolleranze2));
		windowMenuPrenotati.getCountIntoll3().setText(String.valueOf(totaleIntolleranze3));
	}
	
	public void aggiungiCliente(String nome, String cognome, String codice) {
		sb.setNome(nome);
		sb.setCognome(cognome);
		sb.setCodiceID(codice);
		try {
			if (codice.equals(" ") || nome.equals(" ") || cognome.equals(" ")) {
				throw new AddClientException();
			}
			else {
				int n = 0;
				n = sc.controllaCodiceCliente(sb, connessioneAdm);
				if( n == 1) {
					throw new DatabaseException();
				}
				sc.aggiungiNuovoCliente(sb, connessioneAdm);
					
				windowAggiungiCliente.getLabelErroreUt().setText("Codice aggiunto");
				Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowAggiungiCliente.getLabelErroreUt().setIcon(new ImageIcon(img));
				 
				
			}
		} catch(AddClientException ace) {
			ace.printMessage(windowAggiungiCliente.getLabelErroreUt());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowAggiungiCliente.getLabelErroreUt().setIcon(new ImageIcon(img));
		} catch (SQLException e) {
			new DatabaseException().showMessage(6,windowAggiungiCliente.getLabelErroreUt());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowAggiungiCliente.getLabelErroreUt().setIcon(new ImageIcon(img));
		} catch (DatabaseException de) {
			de.showMessage(6, windowAggiungiCliente.getLabelErroreUt());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowAggiungiCliente.getLabelErroreUt().setIcon(new ImageIcon(img));
		}

	}

	
	public void aggiungiNotificaIntolleranze(String codCli) {
		String notifica5 = "HA AGGIUNTO LE INTOLLERANZE IL CLIENTE: ";
		notifica5 = notifica5.concat(codCli);
		try {
			nc.comunicaNotificaIntolleranze(notifica5, connessioneAdm);
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowNotificheAdmin.getLblError());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowNotificheAdmin.getLblError().setIcon(new ImageIcon(img));
		}
	}
	
	public void aggiungiNotificaPenale(String codCli) {
		String notifica6 = "DEVE PAGARE UNA PENALE IL CLIENTE: ";
		notifica6 = notifica6.concat(codCli);
		try {
			nc.comunicaNotificaPenale(notifica6, connessioneAdm);
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowNotificheAdmin.getLblError());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowNotificheAdmin.getLblError().setIcon(new ImageIcon(img));
		}
	}
	
	public void controllaCategoriaAttivita(String categoria, String giorno, int tipo) {
		try {
			ArrayList<Object> l = new ArrayList<>();
			ab.setCategoria(categoria);
			ab.setGiorno(giorno);
			ac.ricercaAttivita(ab, l, connessioneAdm);
			creaTabella(l, tipo);
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowCategorieAdmin.getLabelErroreAtt());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowCategorieAdmin.getLabelErroreAtt().setIcon(new ImageIcon(img));
		}	
	}
	
	/* Il seguente metodo viene invocato dalla view per eliminare un'attività lato Admin premendo il bottone Elimina attivita
	 * e controlla che sia stata selezionata la una riga dalla tabella. Se ciò accade invoca un metodo del controller delle attività
	 * per eliminare l'attività selezionata */
	public int controllaEliminazione(int codice, double prezzo) {
		ab.setCodice(codice);
		ab.setPrezzo(prezzo);
		boolean risultato = false;
		try {
			if (windowEliminaAttAdmin.getTable().getSelectedRow() == -1) {
				throw new ManageActivityAdminException();

			}
			else {
				risultato = eac.eliminaAttivita(ab, connessioneAdm);
			}
			if (risultato) {
				windowEliminaAttAdmin.getErrorLabelPren().setText("Attivita cancellata");
				Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowEliminaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
		} catch(ManageActivityAdminException ma) {
			ma.printMessage(windowEliminaAttAdmin.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowEliminaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
			return 0;
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowEliminaAttAdmin.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowEliminaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
			return 0;
		}
		return 1;
		
	}
	
	/* Il seguente metodo verifica lato admin se tutti i campi per aggiungere un'attività sono stati riempiti*/
	public int controllaInserimenti(String nome, int codice, String orario, double prezzo, int partecipantiMax, List<Object> l) {
		boolean risultato = false;
		ab.setNome(nome);
		ab.setCodice(codice);
		ab.setOrario(orario);
		ab.setPrezzo(prezzo);
		ab.setPartecipantiMax(partecipantiMax);
		ab.setCategoria(l.get(0).toString());
		ab.setGiorno(l.get(1).toString());
		ab.setTipologia(l.get(2).toString());
		try {
			if (nome.equals("") || codice == 0 || orario.equals("") || prezzo == 0.0) {
				throw new AddActivityException();
			}
			else {
				risultato = iaac.aggiungiAttivita(ab, connessioneAdm);
			}
			if (risultato) {
			windowCategorieAdmin.getLabelErroreAtt().setText("Attività inserita correttamente");
			}
		} catch(AddActivityException aae) {
			aae.printMessage(windowCategorieAdmin.getLabelErroreAtt());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowCategorieAdmin.getLabelErroreAtt().setIcon(new ImageIcon(img));
			return 0;
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowCategorieAdmin.getLabelErroreAtt());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowCategorieAdmin.getLabelErroreAtt().setIcon(new ImageIcon(img));
			return 0;
		}
		return 1;		
	}
	
	/* Il seguente metodo viene invocato dalla view per modificare un'attività lato Admin premendo il tasto Salva modifiche
	 * e controlla se è stata selezionata un'attività dalla tabella. In tal caso viene invocato un metodo del controller dell'attività
	 * per modificare la suddetta attività*/
	public int controllaModifica(int codice, String orario, double prezzo) {
		boolean risultato = false;
		ab.setCodice(codice);
		ab.setOrario(orario);
		ab.setPrezzo(prezzo);
		try {
			if (windowModificaAttAdmin.getTable().getSelectedRow() == -1) {			
				throw new ManageActivityAdminException();
			}
			else if (orario.equals("")){
				windowModificaAttAdmin.getErrorLabelPren().setText("Inserisci il nuovo orario");
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowModificaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
				return 0;
			}
			else {
				risultato = maac.modificaAttivita(ab, connessioneAdm);
			}
			if (risultato) {
				windowModificaAttAdmin.getErrorLabelPren().setText("Attivita modificata");
				Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowModificaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
		} catch(ManageActivityAdminException ma) {
			ma.printMessage(windowModificaAttAdmin.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowModificaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
			return 0;
		}catch (SQLException e) {
			new DatabaseException().showMessage(1, windowModificaAttAdmin.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowModificaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
			return 0;
		}
		return 1;
		
	}
	
	/* controllaModificheMenu controlla che le tre aree di inserimento del menu non siano vuote. In tal caso invia i menu scritti */
	public int controllaModificheMenu(String menu1, String menu2, String menu3) {
		mb.setMenu1(menu1);
		mb.setMenu2(menu2);
		mb.setMenu3(menu3);
		boolean risultato = false;
		try {
			if (menu1.isEmpty() || menu2.isEmpty() || menu3.isEmpty()) {
				throw new MenuException();

			}
			else {
					risultato = mac.comunicaMenu(mb, connessioneAdm);
			}
			if (risultato) {
				windowMenuAdmin.getLblErrore().setText("Menu aggiornato correttamente");
				Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowMenuAdmin.getLblErrore().setIcon(new ImageIcon(img));
			}
		} catch (MenuException me){
			me.printMessage(windowMenuAdmin.getLblErrore());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowMenuAdmin.getLblErrore().setIcon(new ImageIcon(img));
			return 0;
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowMenuAdmin.getLblErrore());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowMenuAdmin.getLblErrore().setIcon(new ImageIcon(img));
		}
		return 1;	
	}
	
	/* Qui controlliamo se una riga è stata selezionata, in caso questo non avvenga per default settiamo la riga selezionata a 0
	 * così che poi si potranno fare i getter e i setter evitando l'eccezione e si potrà mandare il messaggio che la riga non è stata selezionata*/
	public int controllaRiga() {
	    int riga = windowModificaAttAdmin.getTable().getSelectedRow();
		if (riga == -1) {
			windowModificaAttAdmin.getErrorLabelPren().setText("Seleziona una delle attività mostrate!");
			Image img=new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowModificaAttAdmin.getErrorLabelPren().setIcon(new ImageIcon(img));
			riga = 0;
		}
		return riga;
	}
	
	/* Questo metodo serve per poter controllare se è stata selezionata una riga nella tabella, l'utilità è che grazie all'indice di riga 
	 * settiamo  i valori della tabella da prendere in considerazione, in caso non fosse selezionata alcuna riga avremmo
	 * un eccezione di index out of bound. In caso avvenga questo settiamo per default a 0 l'indice di riga*/
	public int controllaRigaElimin() {
	    int riga = windowEliminaAttAdmin.getTable().getSelectedRow();
		if (riga == -1) {
			riga = 0;
		}
		return riga;
	}
	
	public void creaTabella(List<Object> l, int tipo) {
		
		int lunghezza = l.size();
		int i = 0;
		if (tipo == 1) {
		    windowModificaAttAdmin.getTabella().setRowCount(0);
		    for (i = 0; i < (lunghezza); i = i + 4) {
		        windowModificaAttAdmin.getTabella().addRow(new Object[] {l.get(i), l.get(i+1), l.get(i+2), l.get(i+3)});
		    }
		} else {
			windowEliminaAttAdmin.getTabella().setRowCount(0);
			for (i = 0; i < (lunghezza); i = i + 4) {
			   windowEliminaAttAdmin.getTabella().addRow(new Object[] {l.get(i), l.get(i+1), l.get(i+2), l.get(i+3)});
			}	
		}
	}
	
    public void disconnessione(int i) {
        if (i == 1) {	
		    windowHomepageAdmin.getFrame().setVisible(false);
		}
		else if (i == 2) {
		    windowAttivita.getFrame().setVisible(false);
		}
		else if (i == 3) {
		    windowMenuAdmin.getFrame().setVisible(false);
		}
		else if (i == 4) {
			windowNotificheAdmin.getFrame().setVisible(false);
		}
		try {
			cli.logOut(connessioneAdm);
		} catch (SQLException e) {
	        if (i == 1) {	
				new DatabaseException().showMessage(1, windowHomepageAdmin.getLblError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowHomepageAdmin.getLblError().setIcon(new ImageIcon(img));
			}
			else if (i == 2) {
				new DatabaseException().showMessage(1, windowAttivita.getLblError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowAttivita.getLblError().setIcon(new ImageIcon(img));
			}
			else if (i == 3) {
				new DatabaseException().showMessage(1, windowMenuAdmin.getLblErrore());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowMenuAdmin.getLblErrore().setIcon(new ImageIcon(img));
			}
			else if (i == 4) {
				new DatabaseException().showMessage(1, windowNotificheAdmin.getLblError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotificheAdmin.getLblError().setIcon(new ImageIcon(img));
			}
		}
		StartApplication.c1.startwithLoginGUI();
	}
	
	public void modificaInterfacciaAdmin(HomepageAdminGUI  windowHomepageAdmin, List<Object> l) {
		windowHomepageAdmin.getTextNome().setText(String.valueOf(l.get(1)));
		windowHomepageAdmin.getTextCognome().setText(String.valueOf(l.get(2)));
		windowHomepageAdmin.getTextCodice().setText(String.valueOf(l.get(0)));
		windowHomepageAdmin.getTextEmail().setText(String.valueOf(l.get(3)));
		windowHomepageAdmin.getTextNumeroUtenti().setText(String.valueOf(l.get(4)));
	}
	
	public void switchToAggiungiCliente() {
		windowAggiungiCliente = new AggiungiNuovoClienteGUI();
		windowAggiungiCliente.getFrame().setVisible(true);	
	}
	
	public void switchtoElenco(int numero) {
	    if (numero == 1) {
		   windowElenco1 = new ElencoIntolleranze1GUI();
		   windowElenco1.getFrame().setVisible(true);
		   StringBuilder totale1 = new StringBuilder();
		   try {
			   totale1 = mac.prendiElenco(1, connessioneAdm);
		   } catch (SQLException e) {
			   new DatabaseException().showMessage(1, windowElenco1.getLblError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowElenco1.getLblError().setIcon(new ImageIcon(img));
		   }
		   aggiornaElencoIntolleranze(numero, totale1);
	   }  
		else if (numero == 2) {
			windowElenco2 = new ElencoIntolleranza2GUI();
			windowElenco2.getFrame().setVisible(true);
			StringBuilder totale2 = new StringBuilder();
			try {
				totale2 = mac.prendiElenco(2, connessioneAdm);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowElenco2.getLblError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowElenco2.getLblError().setIcon(new ImageIcon(img));
			}
			aggiornaElencoIntolleranze(numero, totale2);
			
		}
		else if (numero == 3) {
			windowElenco3 = new ElencoIntolleranze3GUI();
			windowElenco3.getFrame().setVisible(true);
			StringBuilder totale3 = new StringBuilder();
			try {
				totale3 = mac.prendiElenco(3, connessioneAdm);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowElenco3.getLblError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowElenco3.getLblError().setIcon(new ImageIcon(img));
			}
			aggiornaElencoIntolleranze(numero, totale3);
		}
   }
	
	public void switchtoEliminaAttivita() {
		windowEliminaAttAdmin.attach(StartApplication.c1.getWindowNotifiche());
		windowEliminaAttAdmin.getFrame().setVisible(true);	
	}
	
	public void switchtoGestisciAttivitaAdmin() {
		windowAttivita = new GestisciAttivitaAdminGUI();
		windowAttivita.getFrame().setVisible(true);
	}
	
	
	/* Il seguente metodo viene invocato per effettuare il primo accesso alla Homepage lato Admin*/
	public void switchtoHomepage(String codice, Connection connessione) {
		try {
			connessioneAdm = connessione;
			windowHomepageAdmin = new HomepageAdminGUI();
			windowHomepageAdmin.getFrame().setVisible(true);
			ArrayList<Object> l = new ArrayList<>();
			ub.setCodiceID(codice);
			cli.setInfoAdmin(ub, connessioneAdm);
			cli.getInformazioniAdmin(l, ub);
			modificaInterfacciaAdmin(windowHomepageAdmin, l);
		} catch (Exception e) {
			new DatabaseException().showMessage(1, windowHomepageAdmin.getLblError());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowHomepageAdmin.getLblError().setIcon(new ImageIcon(img));
		}
	}
	
	/* Il seguente metodo permette di passare da qualsiasi pagina dell'account dell'Admin alla pagina di Homepage dell'Admin */
	public void switchtoHomepage() {
		try {
			windowHomepageAdmin = new HomepageAdminGUI();
			windowHomepageAdmin.getFrame().setVisible(true);
			ArrayList<Object> l = new ArrayList<>();
			cli.getInformazioniAdmin(l, ub);
			modificaInterfacciaAdmin(windowHomepageAdmin, l);
		} catch (Exception e) {
			new DatabaseException().showMessage(1, windowHomepageAdmin.getLblError());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowHomepageAdmin.getLblError().setIcon(new ImageIcon(img));
		}
	}
	
	
	public void switchtoMenu() {
		try {
			windowMenuAdmin.attach(StartApplication.c1.getWindowNotifiche());
			windowMenuAdmin.getFrame().setVisible(true);
			mac.mostraMenu(mb, connessioneAdm);
			windowMenuAdmin.getTextArea().setText(mb.getMenu1());
			windowMenuAdmin.getTextArea1().setText(mb.getMenu2());
			windowMenuAdmin.getTextArea2().setText(mb.getMenu3());
		} catch (Exception e) {
			new DatabaseException().showMessage(2, windowMenuAdmin.getLblErrore());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowMenuAdmin.getLblErrore().setIcon(new ImageIcon(img));
		}
	}
	
	public void switchtoMenuPrenotati() {
		try {
			int numeroMenu1;
			int numeroMenu2;
			int numeroMenu3;
			int numeroIntolleranze1;
			int numeroIntolleranze2;
			int numeroIntolleranze3;
			windowMenuPrenotati = new MenuPrenotatiGUI();
			windowMenuPrenotati.getFrame().setVisible(true);
			numeroMenu1 = mac.contaMenu(1, connessioneAdm);
			numeroMenu2 = mac.contaMenu(2, connessioneAdm);
			numeroMenu3 = mac.contaMenu(3, connessioneAdm);
			numeroIntolleranze1 = mac.contaIntolleranze(1, connessioneAdm);
			numeroIntolleranze2 = mac.contaIntolleranze(2, connessioneAdm);
			numeroIntolleranze3 = mac.contaIntolleranze(3, connessioneAdm);
			aggiornaInterfacciaMenuPrenotati(numeroMenu1, numeroMenu2, numeroMenu3, numeroIntolleranze1, numeroIntolleranze2, numeroIntolleranze3);
		} catch (Exception e) {
			new DatabaseException().showMessage(1, windowMenuPrenotati.getLblError());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowMenuPrenotati.getLblError().setIcon(new ImageIcon(img));
		}
	}
	
	public void switchtoModificaAttivita() {
	    windowModificaAttAdmin.attach(StartApplication.c1.getWindowNotifiche());
		windowModificaAttAdmin.getFrame().setVisible(true);
	}
	
	public void switchtoNotificheAdmin() {
		String notificaIntolleranze = "";
		String notificaPenale = "";
		try {
			windowNotificheAdmin.getFrame().setVisible(true);
			windowNotificheAdmin.getTextArea().setText(" ");
			notificaIntolleranze = nc.prendiNotificaIntolleranze(connessioneAdm);
			if (!notificaIntolleranze.equals("")) {
				windowNotificheAdmin.getTextArea().append(notificaIntolleranze);
			}
			notificaPenale = nc.prendiNotificaPenale(connessioneAdm);
			if (!notificaPenale.equals("")) {
				windowNotificheAdmin.getTextArea().append(notificaPenale);
			}	
		} catch (Exception e) {
			new DatabaseException().showMessage(1, windowNotificheAdmin.getLblError());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowNotificheAdmin.getLblError().setIcon(new ImageIcon(img));
		}
	}
	
	public void switchtoSelectCategories() {
		windowCategorieAdmin.getFrame().setVisible(true);
	}		
}
