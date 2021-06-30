package logic.view.controllergrafico;


import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;

import logic.exceptions.DatabaseException;
import logic.exceptions.TableException;
import logic.exceptions.TeamActivityException;
import logic.exceptions.ThreadException;
import logic.exceptions.URLException;
import logic.bean.AttivitaBean;
import logic.bean.IntolleranzeBean;
import logic.bean.LoginBean;
import logic.bean.MenuBean;
import logic.bean.SignUpBean;
import logic.bean.UtenteBean;
import logic.controller.AttivitaController;
import logic.controller.EliminaPrenotazioneController;
import logic.controller.LogInController;
import logic.controller.MenuClientController;
import logic.controller.NotificheController;
import logic.controller.PrenotazioneAttivitaController;
import logic.controller.SignUpController;
import logic.model.dao.DataBaseClass;
import logic.model.dao.DataBaseFactory;
import logic.view.boundary.PrenotazioneAttivitaDiGruppoGUI;
import logic.view.boundary.PrenotazioneAttivitaSingolaGUI;
import logic.view.boundary.EliminaPrenotazioneGUI;
import logic.view.boundary.GestisciAttivitaClientGUI;
import logic.view.boundary.HomepageClientGUI;
import logic.view.boundary.InvioIntolleranzeGUI;
import logic.view.boundary.Login;
import logic.view.boundary.MenuClientGUI;
import logic.view.boundary.NotificheClientGUI;
import logic.view.boundary.PenaleGUI;
import logic.view.boundary.SignUpGUI;
import logic.view.boundary.StartApplication;
import logic.util.AggiornaBudget;
import logic.util.MandaPrenotazioneAttGruppo;
import logic.util.PenalValues;
import logic.util.RetInt;
import logic.util.SendIntolerance;
import logic.util.SendMenu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class ControllerGrafico {
	
	private Login window;
	private HomepageClientGUI windowHomepage;
	private GestisciAttivitaClientGUI windowAttivita;
	private MenuClientGUI windowMenu;
	private LogInController cli = new LogInController();
	private SignUpGUI windowSignUp;
	private SignUpController signupCon = new SignUpController();
	private MenuBean mb = new MenuBean();
	private MenuClientController mcc = new MenuClientController();
	private NotificheClientGUI windowNotifiche = new NotificheClientGUI();
	private InvioIntolleranzeGUI windowIntolleranze = new InvioIntolleranzeGUI();
	private String codiceId;
	private PrenotazioneAttivitaSingolaGUI windowCategorie;
	private AttivitaController ac = new AttivitaController();
	private PrenotazioneAttivitaController pac = new PrenotazioneAttivitaController();
	private EliminaPrenotazioneGUI windowEliminaPrenotazione;
	private PenaleGUI windowPenale = new PenaleGUI();
	private PrenotazioneAttivitaDiGruppoGUI windowAttivitaGruppo = new PrenotazioneAttivitaDiGruppoGUI();
	private NotificheController nc = new NotificheController();
	private EliminaPrenotazioneController epc = new EliminaPrenotazioneController();
	private String bambini = "Bambini";
	private String saluteBenessere = "Salute&Benessere";
	private String sport = "Sport";
	private String svagoRelax = "Svago&Relax";
	private LoginBean lb = new LoginBean();
	private SignUpBean sb = new SignUpBean();
	private IntolleranzeBean ib = new IntolleranzeBean();
	private UtenteBean ub = new UtenteBean();
	private AttivitaBean ab = new AttivitaBean();
	private int countLog = 0;
	private Connection connessione;
	private String type = "MySql";
	private String errore = "/errore.png"; 
	private String spuntaVerde = "/spuntaVerde.png";

	/* GETTER E SETTER */
	public PenaleGUI getWindowPenale() {
		return windowPenale;
	}

	public void setWindowPenale(PenaleGUI windowPenale) {
		this.windowPenale = windowPenale;
	}

	public NotificheClientGUI getWindowNotifiche() {
		return windowNotifiche;
	}

	public void setWindowNotifiche(NotificheClientGUI windowNotifiche) {
		this.windowNotifiche = windowNotifiche;
	}
	
	/* METODI (in ordine alfabetico) */
	
	public void aggiungiNotificaAttivitaGruppo(String categoria, int cod) {
		String notificaSport = "NUOVO PRENOTATO IN ATTIVITA DI SPORT";
		String notificaSvagoRelax = "NUOVO PRENOTATO IN ATTIVITA DI SVAGO E RELAX";
		String notificaSaluteBenessere = "NUOVO PRENOTATO IN ATTIVITA DI SALUTE E BENESSERE";
		String notificaBambini = "NUOVO PRENOTATO IN ATTIVITA DI BAMBINI";
		if (categoria.equals(sport)) {
			try {
				nc.comunicaNotificaAttivitaGruppo(notificaSport, 1, cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(saluteBenessere)) {
			try {
				nc.comunicaNotificaAttivitaGruppo(notificaSvagoRelax, 2, cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(svagoRelax)) {
			try {
				nc.comunicaNotificaAttivitaGruppo(notificaSaluteBenessere, 3, cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(bambini)) {
			try {
				nc.comunicaNotificaAttivitaGruppo(notificaBambini, 4, cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
		
		}
		
	}
	
	public void aggiungiNotificaEliminaAttivita(String categoria, int cod) {
		String notificaSport = "ELIMINATA ATTIVITA DI SPORT CHE HAI PRENOTATO";
		String notificaSvagoRelax = "ELIMINATA ATTIVITA DI SVAGO E RELAX CHE HAI PRENOTATO";
		String notificaSaluteBenessere = "ELIMINATA ATTIVITA DI SALUTE E BENESSERE CHE HAI PRENOTATO";
		String notificaBambini = "ELIMINATA ATTIVITA DI BAMBINI CHE HAI PRENOTATO";
		if (categoria.equals(sport)) {
			try {
				nc.comunicaNotificaEliminaAttivita(notificaSport, 1, cod, connessione);
				ac.eliminaPrenotazioni(cod, connessione); /*Cancelliamo le prenotazioni dopo l'inserimento della notifica così che si possa associare 
                la notifica ai clienti che si sono prenotati alla determinata attività che si sta cancellando */
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(saluteBenessere)) {
			try {
				nc.comunicaNotificaEliminaAttivita(notificaSvagoRelax, 2, cod, connessione);
				ac.eliminaPrenotazioni(cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(svagoRelax)) {
			try {
				nc.comunicaNotificaEliminaAttivita(notificaSaluteBenessere, 3, cod, connessione);
				ac.eliminaPrenotazioni(cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(bambini)) {
			try {
				nc.comunicaNotificaEliminaAttivita(notificaBambini, 4, cod, connessione);
				ac.eliminaPrenotazioni(cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
		
		}
		
	}
	
	/* Tale metodo viene invocato dall'update dell'Observer ogni qualvolta l'Admin aggiunge il menu giornaliero*/
	public void aggiungiNotificaMenu() {
		String notifica1 = "MENU GIORNALIERO DISPONIBILE";
		try {
			nc.comunicaNotificaMenuAdmin(notifica1, connessione);
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
		}
	}
	
	public void aggiungiNotificaModificaAttivita(String categoria, int cod) {
		String notificaSport = "MODIFICATA ATTIVITA DI SPORT CHE HAI PRENOTATO";
		String notificaSvagoRelax = "MODIFICATA ATTIVITA DI SVAGO E RELAX CHE HAI PRENOTATO";
		String notificaSaluteBenessere = "MODIFICATA ATTIVITA DI SALUTE E BENESSERE CHE HAI PRENOTATO";
		String notificaBambini = "MODIFICATA ATTIVITA DI BAMBINI CHE HAI PRENOTATO";
		if (categoria.equals(sport)) {
			try {
				nc.comunicaNotificaModificaAttivita(notificaSport, 1, cod, connessione);
				
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(saluteBenessere)) {
			try {
				nc.comunicaNotificaModificaAttivita(notificaSvagoRelax, 2, cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(svagoRelax)) {
			try {
				nc.comunicaNotificaModificaAttivita(notificaSaluteBenessere, 3, cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(bambini)) {
			try {
				nc.comunicaNotificaModificaAttivita(notificaBambini, 4, cod, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
		
		}
		
	}
	
	public void aggiungiNotificaPostoLibero(String categoria, int codiceAtt) {
		String notificaSport = "UN UTENTE SI E LIBERATO DA UN ATTIVITA DI SPORT DI TUO INTERESSE";
		String notificaSvagoRelax = "UN UTENTE SI E LIBERATO DA UN ATTIVITA  DI SVAGO E RELAX DI TUO INTERESSE";
		String notificaSaluteBenessere = "UN UTENTE SI E  LIBERATO DA UN'ATTIVITA  DI SALUTE E BENESSERE DI TUO INTERESSE";
		String notificaBambini = "UN UTENTE SI E LIBERATO DA UN ATTIVITA DI BAMBINI DI TUO INTERESSE";

		if (categoria.equals(sport)) {
			try {
				nc.comunicaNotificaPostoLibero(notificaSport, 1, codiceAtt, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(saluteBenessere)) {
			try {
				nc.comunicaNotificaPostoLibero(notificaSvagoRelax, 2, codiceAtt, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(svagoRelax)) {
			try {
				nc.comunicaNotificaPostoLibero(notificaSaluteBenessere, 3, codiceAtt, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(bambini)) {
			try {
				nc.comunicaNotificaPostoLibero(notificaBambini, 4, codiceAtt, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1,windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
		}	
	}
	
	
	public void apriConnessione() {
		DataBaseFactory dbf = new DataBaseFactory();
		DataBaseClass db = dbf.getConnessione(type);
		try {
			connessione = db.openConnection();
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, window.getLabelErrore());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
		}	
	}
	
	public void chiamaPayPal() {
		String urlString = "https://www.paypal.com";
		try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (URISyntaxException | IOException e) {
		        new URLException().printMessage(windowPenale.getLblPenale());
		        Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		        windowPenale.getLblPenale().setIcon(new ImageIcon(img));
		}
		
	}
	
	/*Questo metodo ricerca le attività prenotabili in base alle scelte che il cliente ha inserito
	 * Viene invocato da CategorieAttivitaView   */
	public void controllaCategoriaAttivita(String categoria, String giorno) {
		ab.setCategoria(categoria);
		ab.setGiorno(giorno);
			try {
			    ArrayList<Object> l = new ArrayList<>();
			    
				pac.verificaAttivita(ab, l, ub, connessione);
				creaTabella(l, 1);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowCategorie.getErrorLabelPren());
				Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowCategorie.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
		
	}
	
	public void controllaCategoriaAttivitaGruppo(String categoria, String giorno) {
		ab.setCategoria(categoria);
		ab.setGiorno(giorno);
		try {
			ArrayList<Object> l = new ArrayList<>();
			pac.verificaAttivitaGruppo(ab, l, ub, connessione);
			creaTabella(l,3);
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowAttivitaGruppo.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowAttivitaGruppo.getErrorLabelPren().setIcon(new ImageIcon(img));
			
		}
	
		
	}

	/* Il seguente metodo permette di controllare quali checkBox sono state selezionate in fase di Sign Up*/
	public void controllaCheckBox(boolean sport, boolean salutebenessere, boolean svagorelax, boolean bambini){
		if (sport || salutebenessere || svagorelax || bambini) {
			sb.setSport(sport);
			sb.setSaluteBenessere(salutebenessere);
			sb.setSvagoRelax(svagorelax);
			sb.setBambini(bambini);
			try {
				signupCon.verificaCategorie(sb, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(3, windowSignUp.getMsgError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowSignUp.getMsgError().setIcon(new ImageIcon(img));
			}
		}
	}
	
	/*Questo metodo si occupa di controllare se CodiceID e Password inseriti dall'utente non sono vuoti
	 * Inoltre chiama un metodo del Controller che ritorna il ruolo dell'utente loggato: 0 Admin, 1 Client, 3 Errore*/
	public int controllaCodicePassword(String codice, String password){
		lb.setCodiceID(codice);
		lb.setPassword(password);
		int role;
		if (codice.equals("") || password.equals("")) {
			return 3;
		}
		else {
			try {
				role = cli.ritornaRuolo(lb, connessione);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, window.getLabelErrore());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				window.getLabelErrore().setIcon(new ImageIcon(img));
				return 3;
				
			}
			return role;
		}
	}

    /* Il seguente metodo effettua il controllo sui campi inseriti nel momento del Sign Up: se non vengono rispettate alcune condizioni
     * vengono stampate a schermo opportune Jlabel ad evidenziare l'errore commesso; se invece i dati inseriti vanno bene avviene
     * l'invocazione di opportuni metodi del Sign Up Controller per proseguire nella fase di registrazione al sistema. */
	public void controllaDatiRegistrazione(String nome, String cognome, String codice, String email, String password, String confermaPass, int giorni) {
        sb.setNome(nome);
        sb.setCognome(cognome);
        sb.setCodiceID(codice);
        sb.setEmail(email);
        sb.setPassword(password);
        sb.setConfermaPassword(confermaPass);
        sb.setGiorni(giorni);
		if (nome.equals("") || cognome.equals("") || codice.equals("") || email.equals("") || password.equals("") || confermaPass.equals("") || giorni==0) {
			windowSignUp.getMsgError().setText("Inserire correttamente tutti i dati!");
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowSignUp.getMsgError().setIcon(new ImageIcon(img));
			
		}
		else if (!password.equals(confermaPass)) {
			windowSignUp.getMsgError().setText("Password diverse!");
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowSignUp.getMsgError().setIcon(new ImageIcon(img));
			
		}
		else if (password.length()<8){
			windowSignUp.getMsgError().setText("Password troppo corta, minimo caratteri = 8");
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowSignUp.getMsgError().setIcon(new ImageIcon(img));
			
		}
		else {
			if (connessione == null) {
			    apriConnessione();
			}
			boolean responso = false;
			try {				
				responso = signupCon.controlloAssociazione(sb, connessione);

			} catch (SQLException e) {
				
				new DatabaseException().showMessage(1, windowSignUp.getMsgError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowSignUp.getMsgError().setIcon(new ImageIcon(img));
				
			}
			
			try {
     			if (responso) {
					signupCon.aggiungiContatto(sb, connessione);
					windowSignUp.getMsgError().setText("Utente aggiunto");
					Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
					windowSignUp.getMsgError().setIcon(new ImageIcon(img));
				} 
     			else {
					windowSignUp.getMsgError().setText("Hai sbagliato a inserire codice");
					Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
					windowSignUp.getMsgError().setIcon(new ImageIcon(img));
				}
			} catch (SQLException e) {
				new DatabaseException().showMessage(2, windowSignUp.getMsgError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowSignUp.getMsgError().setIcon(new ImageIcon(img));

			}
		}
	}
	
	/* Il seguente metodo viene invocato dalla view della eliminazione delle prenotazioni premendo il tasto "Elimina prenotazioni" 
	 * e controlla se l'utente ha selezionato una riga della tabella. In tal caso controlla se mostrare la view per la gestione 
	 * della penale oppure proseguire nella eliminazione stessa della prenotazione */
	public int controllaEliminazione(int codiceAtt, String giornoAtt, double prezzo) {
		ab.setCodice(codiceAtt);
		ab.setPrezzo(prezzo);
		int notif = 0;
		ExecutorService service = Executors.newFixedThreadPool(2); //creazione di un pool di 2 thread 

		boolean risultato = false;
		try {
			if (windowEliminaPrenotazione.getTable().getSelectedRow() == -1) {
				throw new TableException();
				
			} else {
				    int tipoPenale;
					tipoPenale = ottieniGiorni(giornoAtt);
					if (tipoPenale != 0) {
						 int codicePen = 0;
						 double prezzoPenale;

						  Future<Integer> retInt = service.submit(new RetInt());
						  
						  Future<Double> penalValues = service.submit(new PenalValues(prezzo, tipoPenale));
						  
						
						  codicePen = retInt.get();
						  prezzoPenale = penalValues.get();
						  service.shutdown(); //chiusura dei thread
						  notif = 1;
						  if(codicePen != 0 && prezzoPenale != 0.0) { //controllo se i dati acquisiti dai thread sono effettivamente presi
							 switchtoPenale(prezzoPenale, codiceAtt, prezzo, codicePen);
						  }
						
					} else {
						double budgetN = ub.getBudget() + prezzo;
						ub.setBudget(budgetN);
						risultato = epc.eliminaPrenotazione(ub, ab, connessione);
						epc.aggiornaBudget(ub, connessione);
					}
               
			}
			gestisciAlert2(risultato);
			
		}catch (TableException tb){
			tb.printMessage(2, windowEliminaPrenotazione.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowEliminaPrenotazione.getErrorLabelPren().setIcon(new ImageIcon(img));
			return notif;
		} catch (InterruptedException | ExecutionException e) {
			new ThreadException().solve(service);
			Thread.currentThread().interrupt();
		}  catch (SQLException e) {
			new DatabaseException().showMessage(1, windowEliminaPrenotazione.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowEliminaPrenotazione.getErrorLabelPren().setIcon(new ImageIcon(img));
		}

		return notif;
		
	}
	
	public int controllaEliminazionePenale(double prezzo) {
		try {
			double budgetN = ub.getBudget() + prezzo;
			ub.setBudget(budgetN);
			epc.eliminaPrenotazione(ub, ab, connessione);
			windowPenale.getLblPenale().setText("Prenotazione rimossa correttamente");
			Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowPenale.getLblPenale().setIcon(new ImageIcon(img));
		} catch (SQLException e) {
			new DatabaseException().showMessage(1, windowPenale.getLblPenale());
			Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowPenale.getLblPenale().setIcon(new ImageIcon(img));
		} 
					
		return 1;
}
	
	 /*Il seguente metodo viene invocato premendo il bottone "Prenota" dalla view della prenotazione di attività lato Client e
	  * controlla se sono state selezionate righe dalla tabella. In tal caso invoca un metodo del controller delle attività	 
	  * per prenotare un'attività */
	public void controllaPrenotazione(int codiceAtt, double prezzo) {
		ab.setCodice(codiceAtt);
		ab.setPrezzo(prezzo);
		boolean risultato = false;
		try {
			if (windowCategorie.getTable().getSelectedRow() == -1) {
				throw new TableException();
			}
			else {
				double budgetN = ub.getBudget()- prezzo;
				ub.setBudget(budgetN);
				risultato = pac.aggiungiPrenotazione(ab, ub, connessione);
				pac.aggiornaBudget(ub, connessione);
			 

				if (risultato) {
					windowCategorie.getErrorLabelPren().setText("Attività prenotata correttamente");
					Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
					windowCategorie.getErrorLabelPren().setIcon(new ImageIcon(img));
				}
			}
		} catch (TableException tb){
			tb.printMessage(2, windowCategorie.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowCategorie.getErrorLabelPren().setIcon(new ImageIcon(img));
		
		}catch (SQLException e) {
			new DatabaseException().showMessage(1, windowCategorie.getErrorLabelPren());
			Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowCategorie.getErrorLabelPren().setIcon(new ImageIcon(img));
			
		} 
	}
	
	/* Il seguente metodo viene invocato dalla view per la prenotazione delle attività di gruppo premendo il bottone Prenota
	 * e controlla se una delle righe della tabella è stata selezionata oppure se l'attività selezionata ha già raggiunto il 
	 * numero di partecipanti massimo. In tal caso viene invocato un metodo del controller delle attività per effettuare una
	 * prenotazione */
	public int controllaPrenotazioneGruppo(int codice, double prezzo, int partecipantiAttuali, int partecipantiMax) {
		boolean risultato = false;
		int codiceRet = 0;
		ab.setCodice(codice);
		ExecutorService service = Executors.newFixedThreadPool(2); //creazione di un pool di 2 thread 
		try {
			if (windowAttivitaGruppo.getTable().getSelectedRow() == -1) {
				throw new TeamActivityException(1);
			}
			else if (partecipantiAttuali == partecipantiMax) {
				throw new TeamActivityException(2);
			}
			else {
				 double budgetN = ub.getBudget() - prezzo;
				 ub.setBudget(budgetN);

				 Future<Integer> retBudg = service.submit(new AggiornaBudget(ub, connessione));
				  
				 Future<Boolean> risult = service.submit(new MandaPrenotazioneAttGruppo(ab, ub, connessione));
				 
				 codiceRet = retBudg.get();
				 risultato = risult.get();
				 service.shutdown(); //chiusura dei thread
           
			}
			if (risultato && codiceRet != 0) {
				windowAttivitaGruppo.getErrorLabelPren().setText("Attivita di gruppo prenotata correttamente");
				Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowAttivitaGruppo.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
		}catch(TeamActivityException tae) {
				tae.printMessage(windowAttivitaGruppo.getErrorLabelPren());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowAttivitaGruppo.getErrorLabelPren().setIcon(new ImageIcon(img));
				return 0;
			
		} catch (InterruptedException | ExecutionException e) {	
			double budgetN = ub.getBudget() + prezzo;
			ub.setBudget(budgetN);
			service.submit(new AggiornaBudget(ub, connessione));
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowAttivitaGruppo.getErrorLabelPren().setIcon(new ImageIcon(img));
			windowAttivitaGruppo.getErrorLabelPren().setText("Attivita Già Prenotata");
			new ThreadException().solve(service);
			Thread.currentThread().interrupt();
			
		}
		return 1;
		
	}
	
	
	/* Il seguente metodo controlla che sia stata selezionata una riga della tabella. Vengono distinte tre tipologie diverse 
	 * perché il metodo viene invocato in tre view diverse */
	public int controllaRiga(int riga, int tipo) {
		if (tipo == 1) {
	       riga = windowCategorie.getTable().getSelectedRow();
		   if (riga == -1) {
			  riga = 0;
		   }   
		}else if (tipo == 2) {
		   riga  =windowAttivitaGruppo.getTable().getSelectedRow();
	       if (riga == -1) {
			  riga = 0;
		   }  
		} else if (tipo == 3) {
		    riga = windowEliminaPrenotazione.getTable().getSelectedRow();
			if (riga == -1) {
				riga = 0;
			}
		}
		return riga;
	}
	
	public int controllaScelteMenu(boolean menu1, boolean menu2, boolean menu3) {
		if (!menu1 && !menu2 && !menu3) {
			windowIntolleranze.getErroreIntoll().setText("Scegliere uno tra i menu proposti!");
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowIntolleranze.getErroreIntoll().setIcon(new ImageIcon(img));
			return 0;
		}
		return 1;
	}
	
	/*creaTabella serve a creare dinamicamente la tabella con l'elenco delle attività di un determinato giorno. Tramite la 
	 * setRowCount avviene l'azzeramento delle righe della tabella, in modo da non memorizzare ogni attività cercata */
	public void creaTabella(List<Object> l, int tipo) {
		int lunghezza = l.size();
		int i = 0;
		if (tipo == 1) {
		    windowCategorie.getTabella().setRowCount(0);
		    for (i=0; i<(lunghezza); i=i+4) {
		        windowCategorie.getTabella().addRow(new Object[] {l.get(i), l.get(i+1), l.get(i+2), l.get(i+3)});
		    }
	    }else if (tipo == 2) {
	    	windowEliminaPrenotazione.getTabella().setRowCount(0);
	    	for (i=0; i<lunghezza; i=i+5) {
	    		windowEliminaPrenotazione.getTabella().addRow(new Object[] {l.get(i), l.get(i+1), l.get(i+2), l.get(i+3), l.get(i+4)});
	    	}
	    }else if (tipo == 3) {
	    	windowAttivitaGruppo.getTabella().setRowCount(0);
	    	for (i = 0; i < lunghezza; i = i + 6) {
	    		windowAttivitaGruppo.getTabella().addRow(new Object[] {l.get(i), l.get(i+1), l.get(i+2), l.get(i+3), l.get(i+4),l.get(i+5)});
	    	}
	    }
     }
	
	public void disconnessione(int i) {
        if (i == 1) {	
		    windowHomepage.getFrame().setVisible(false);
		}
		else if (i == 2) {	
		    windowAttivita.getFrame().setVisible(false);
		}
		else if (i == 3) {	
		    windowMenu.getFrame().setVisible(false);
		}
		else if (i == 4) {	
			windowNotifiche.getFrame().setVisible(false);
			
		}
		try {
			cli.logOut(connessione);
		} catch (SQLException e) {
			if(i == 1) {
				new DatabaseException().showMessage(1, windowHomepage.getLblModifica());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowHomepage.getLblModifica().setIcon(new ImageIcon(img));
			} else if (i == 2) {				    
				new DatabaseException().showMessage(1, windowAttivita.getLblError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowAttivita.getLblError().setIcon(new ImageIcon(img));
			}
			else if (i == 3) {	
				new DatabaseException().showMessage(1, windowMenu.getLblMenuError());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowMenu.getLblMenuError().setIcon(new ImageIcon(img));
			}
			else if (i == 4) {	
				new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
			}
		}
		countLog = 0;
		startwithLoginGUI();
	}
	
	public void gestisciAlert(boolean risultato, int intol) {
		if (risultato) {
			if (intol != 0) {
			   windowIntolleranze.getErroreIntoll().setText("Dati e intolleranze inviati correttamente");			
			   Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			   windowIntolleranze.getErroreIntoll().setIcon(new ImageIcon(img));
			} else {
				windowIntolleranze.getErroreIntoll().setText("Dati inviati correttamente");			
				Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowIntolleranze.getErroreIntoll().setIcon(new ImageIcon(img));
			}
	   }
	}
	
	public void gestisciAlert2(boolean risultato) {
		if (risultato) {
			windowEliminaPrenotazione.getErrorLabelPren().setText("Prenotazione eliminata correttamente");
			Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowEliminaPrenotazione.getErrorLabelPren().setIcon(new ImageIcon(img));
		}
	}
	
	/* Tale metodo viene invocato dal tasto "Invia" di InvioIntolleranzeGUI e controlla se uno dei menu sono stati selezionati.
	 * In caso negativo stampa a schermo un messaggio di errore. */
	public int inviaDatiIntolleranze(String codice, boolean menu1, boolean menu2, boolean menu3, String elencoIntolleranze, boolean sceltaInt) {
		ib.setCodiceId(codice);
		ib.setMenu1(menu1);
		ib.setMenu2(menu2);
		ib.setMenu3(menu3);
		ib.setIntolleranze(elencoIntolleranze);
		boolean risultato = false;
		int j = 0;
		int intol = 0;
		ExecutorService service = Executors.newFixedThreadPool(2); //creazione di un pool di 2 thread
			try {
				if (sceltaInt) {
					if (elencoIntolleranze.equals("") ||  elencoIntolleranze.equals(" ")) {
						windowIntolleranze.getErroreIntoll().setText("Devi scrivere l'intolleranze se hai selezionato");
						Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
						windowIntolleranze.getErroreIntoll().setIcon(new ImageIcon(img));
					} else {
						j = 1;

						Future<Boolean> rispostaMen = service.submit(new SendMenu(ib, connessione));
						  
						Future<Integer> rispostaIntol = service.submit(new SendIntolerance(ib, connessione));
					
						risultato = rispostaMen.get();
						intol = rispostaIntol.get();
						
					    service.shutdown(); //chiusura dei thread


					}

				} else {
					risultato = mcc.selezionaDati(ib, connessione); //metodo senza intolleranze
				}
				
			} catch (SQLException e) {
				if (e.getErrorCode() == 1452){
					new DatabaseException().showMessage(4, windowIntolleranze.getErroreIntoll());
					Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
					windowIntolleranze.getErroreIntoll().setIcon(new ImageIcon(img));
				} else {
					new DatabaseException().showMessage(5, windowIntolleranze.getErroreIntoll());
					Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
					windowIntolleranze.getErroreIntoll().setIcon(new ImageIcon(img));
				}
			} catch (InterruptedException | ExecutionException e) {	
				new ThreadException().solve(service);
				Thread.currentThread().interrupt();
			}
		gestisciAlert(risultato, intol);
		return j;
	}
	
	/*In base al ruolo che viene ritornato dal metodo del Controller di Login chiamato, viene scelta una particolare
	 * Homepage da mostrare all'utente loggato, con cui poi continuare la navigazione */
	public void login(String codice, String password) {
		int role;
		apriConnessione();
		role = controllaCodicePassword(codice, password);
		if (role == 3) {
			countLog+=1000;
			window.getLabelErrore().setText("Codice ID o Password errati!");
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			window.getLabelErrore().setIcon(new ImageIcon(img));
			try {
				Thread.sleep(countLog);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				
			}
	
		}
		else if (role == 0) {
		  	window.getFrame().setVisible(false);
			StartApplication.c2.switchtoHomepage(codice, connessione);
		}
		else {
		  	window.getFrame().setVisible(false); 
			switchtoHomepage(codice);
		}
	}
	
	/*Questo metodo passa al Controller tutti i valori che il Client può modificare alla pressione del bottone ModificaDatiPersonali*/
	public void modificaDatiPersonali(String email, String budget) {
		if (email.equals("")||budget.equals("")|| email.equals(" ")||budget.equals(" ")) {
			windowHomepage.getLblModifica().setText("Inserire i dati da modificare in modo corretto");
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowHomepage.getLblModifica().setIcon(new ImageIcon(img));
	
		} else {		
			try {
				cli.setNewInfo(email, budget, connessione);
				ub.setEmail(email);
				double budgetD = Double.parseDouble(budget);
				ub.setBudget(budgetD);
			
			} catch (SQLException e) {
			    new DatabaseException().showMessage(1, windowHomepage.getLblModifica());
			    Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			    windowHomepage.getLblModifica().setIcon(new ImageIcon(img));
			}
			windowHomepage.getLblModifica().setText("Dati modificati in modo corretto");
			Image img = new ImageIcon(this.getClass().getResource(spuntaVerde)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowHomepage.getLblModifica().setIcon(new ImageIcon(img));
		}
	}
	
	public void modificaInterfacciaUtente(HomepageClientGUI windowHomepage, List<Object> l) {
		windowHomepage.getTextNome().setText(String.valueOf(l.get(1)));
		windowHomepage.getTextCognome().setText(String.valueOf(l.get(2)));
		windowHomepage.getTextCodice().setText(String.valueOf(l.get(0)));
		windowHomepage.getTextEmail().setText(String.valueOf(l.get(3)));
		windowHomepage.getTextBudget().setText(String.valueOf(l.get(4)));
	}
	
	public int ottieniGiorni(String giornoAtt) {
		String giorno = "";
		String giornoDopo = "";
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		if (day == Calendar.MONDAY) {
			giorno = "Lunedi";
			giornoDopo = "Martedi";
		} else if (day == Calendar.TUESDAY) {
			giorno = "Martedi";
			giornoDopo = "Mercoledi";
		} else if (day == Calendar.WEDNESDAY) {
			giorno = "Mercoledi";
			giornoDopo = "Giovedi";
		} else if (day == Calendar.THURSDAY) {
			giorno = "Giovedi";
			giornoDopo = "Venerdi";
		} else if (day == Calendar.FRIDAY) {
			giorno = "Venerdi";
			giornoDopo = "Sabato";
		} else if (day == Calendar.SATURDAY) {
			giorno = "Sabato";
			giornoDopo = "Domenica";
		} else if (day == Calendar.SUNDAY) {
			giorno = "Domenica";
			giornoDopo = "Lunedi";
		}
		if (giornoAtt.equals(giorno)) {
			return 1;
		}
		else if (giornoAtt.equals(giornoDopo)) {
			return 2;
		}
		else {
			return 0;
		}
	}

	
	/* Il seguente metodo viene invocato dalla view per l'eliminazione della prenotazione di un'attività e permette di cercare
	 * l'elenco delle prenotazioni del cliente invocando un metodo del controller di eliminazione delle prenotazioni */ 
	public void ricercaPrenotazioni(String categoria) {
		ArrayList<Object> l = new ArrayList<>();
		if (categoria.equals(sport)) {
			try {
				epc.ricercaPrenotazioni(codiceId, l, 1, connessione);
				creaTabella(l, 2);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowEliminaPrenotazione.getErrorLabelPren());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowEliminaPrenotazione.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(saluteBenessere)) {
			try {
				epc.ricercaPrenotazioni(codiceId, l, 2, connessione);
				creaTabella(l, 2);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowEliminaPrenotazione.getErrorLabelPren());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowEliminaPrenotazione.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(svagoRelax)) {
			try {
				epc.ricercaPrenotazioni(codiceId, l, 3, connessione);
				creaTabella(l, 2);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowEliminaPrenotazione.getErrorLabelPren());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowEliminaPrenotazione.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
			
		}
		else if (categoria.equals(bambini)) {
			try {
				epc.ricercaPrenotazioni(codiceId, l, 4, connessione);
				creaTabella(l, 2);
			} catch (SQLException e) {
				new DatabaseException().showMessage(1, windowEliminaPrenotazione.getErrorLabelPren());
				Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				windowEliminaPrenotazione.getErrorLabelPren().setIcon(new ImageIcon(img));
			}
		
		}
	
	}
	
	/* L'utilità di questo metodo è far si che il cliente possa selezionare un solo menu */
	public void selezionaCheckBox(int menuSelezionato) {
		if (menuSelezionato == 1) {
            windowIntolleranze.getChckbxMenu2().setSelected(false);
            windowIntolleranze.getChckbxMenu3().setSelected(false);
		} else if (menuSelezionato == 2) {
            windowIntolleranze.getChckbxMenu1().setSelected(false);
            windowIntolleranze.getChckbxMenu3().setSelected(false);
		} else if (menuSelezionato == 3) {
            windowIntolleranze.getChckbxMenu1().setSelected(false);
            windowIntolleranze.getChckbxMenu2().setSelected(false);
		}
		
	}
	
	public void selezionaRadioButton(boolean scelta) {
			windowIntolleranze.getTxtIntol().setEditable(scelta);
			if (!scelta) {
				windowIntolleranze.getTxtIntol().setText("");
			}
	}
	
	/*Questo metodo apre la GUI di login*/
	public void startwithLoginGUI() {
			window = new Login();
			window.getFrame().setVisible(true);
	}

	

	/* Il seguente metodo viene invocato per effettuare il primo accesso alla Homepage lato Client*/
	public void switchtoHomepage(String codice) {
		try {
			windowHomepage = new HomepageClientGUI();  
			windowHomepage.getFrame().setVisible(true);
			this.codiceId = codice;
			ArrayList<Object> listaDati = new ArrayList<>();
			cli.setInfoCliente(codice, ub, connessione);
			cli.getInformazioni(listaDati, ub);
			modificaInterfacciaUtente(windowHomepage, listaDati);
		} catch (Exception e) {
			new DatabaseException().showMessage(1, windowHomepage.getLblModifica());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowHomepage.getLblModifica().setIcon(new ImageIcon(img));
		}
	}
	
	/* Il seguente metodo permette di passare da qualsiasi pagina dell'account dell'Admin alla pagina di Homepage del Client */
	public void switchtoHomepage() {
		try {
			windowHomepage = new HomepageClientGUI();
			windowHomepage.getFrame().setVisible(true);
			ArrayList<Object> listaDati = new ArrayList<>();
			cli.getInformazioni(listaDati, ub);
			modificaInterfacciaUtente(windowHomepage, listaDati);
		} catch (Exception e) {
			new DatabaseException().showMessage(1, windowHomepage.getLblModifica());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowHomepage.getLblModifica().setIcon(new ImageIcon(img));
			
		}
	}
	
	/* Il seguente metodo permette il passaggio da qualsiasi view dell'account del Client alla view per la gestione del Menu 
	 * del Client*/
	public void switchtoMenu() {
		try {
			windowMenu = new MenuClientGUI();
			windowMenu.getFrame().setVisible(true);
			mcc.mostraMenu(mb, connessione);
			windowMenu.getTxtCodiceId().setText(codiceId);
			windowMenu.getTextArea().setText(mb.getMenu1());
			windowMenu.getTextArea1().setText(mb.getMenu2());
			windowMenu.getTextArea2().setText(mb.getMenu3());
		} catch (Exception e) {
			new DatabaseException().showMessage(1, windowMenu.getLblMenuError());
			Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			windowMenu.getLblMenuError().setIcon(new ImageIcon(img));
		}
	}
	
	/* Tale metodo permette (lato cliente) il passaggio da qualsiasi pagina alla pagina delle notifiche */
	public void switchtoNotifiche() {
		    String notificaModificaAttivita = "";
		    String notificaEliminaAttivita = "";
		    String notificaAttivitaGruppo = "";
		    String notificaMenu = "";
		    String notificaPostoLibero = "";
			windowNotifiche.getFrame().setVisible(true);
			windowNotifiche.getTxtCodiceId().setText(codiceId);
			windowNotifiche.getTextArea().setText("");
			try {
				notificaMenu = nc.prendiNotificaMenu(connessione);
				if (notificaMenu != null ) {
					   windowNotifiche.getTextArea().append(notificaMenu+"\n");
				}
				notificaModificaAttivita = nc.prendiNotificaModificaAttivita(codiceId, connessione);
			    if (!notificaModificaAttivita.equals("")) {
				       windowNotifiche.getTextArea().append(notificaModificaAttivita);
			    }
			    notificaEliminaAttivita = nc.prendiNotificaEliminaAttivita(codiceId, connessione);
			    if (!notificaEliminaAttivita.equals("")) {
				       windowNotifiche.getTextArea().append(notificaEliminaAttivita);
			    }
			    notificaAttivitaGruppo = nc.prendiNotificaAttivitaGruppo(codiceId, connessione);
			    if (!notificaAttivitaGruppo.equals("")) {
				       windowNotifiche.getTextArea().append(notificaAttivitaGruppo);
			    }
			    notificaPostoLibero = nc.prendiNotificaPostoLibero(codiceId, connessione);
			    if (!notificaPostoLibero.equals("")) {
				       windowNotifiche.getTextArea().append(notificaPostoLibero);
			    }
			
	        } catch (Exception e) {
	        	new DatabaseException().showMessage(1, windowNotifiche.getLblMsgNotifiche());
	        	Image img = new ImageIcon(this.getClass().getResource(errore)).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	        	windowNotifiche.getLblMsgNotifiche().setIcon(new ImageIcon(img));
	        }
	}
	
	/* Tale metodo permette il passaggio dalla view del Login iniziale alla view del Sign Up*/
	public void switchtoSignUp() {
		windowSignUp = new SignUpGUI();
		windowSignUp.getFrame().setVisible(true);

	}
	
	/* Il seguente metodo viene invocato dalla view della gestione del Menu del Client tramite il bottone "Seleziona Menu" e
	 *  permette il passaggio dalla view della gestione del Menu dell'account del Client alla view per la scelta del menu e l'indicazione
	 *  delle eventuali intolleranze*/
	public void switchtointolerance() {
		windowIntolleranze.attach(StartApplication.c2.getWindowNotificheAdmin());			
		windowIntolleranze.getFrame().setVisible(true);
		windowIntolleranze.getTxtCodiceId().setText(codiceId);

	}

	
	/* Il seguente metodo permette il passaggio da qualsiasi view dell'account del Client alla view per la gestione delle attività 
	 * del Client*/
	public void switchtoGestisciAttivitaClient() {
		windowAttivita = new GestisciAttivitaClientGUI();
		windowAttivita.getFrame().setVisible(true);
		windowAttivita.getTxtCodiceId().setText(codiceId);

	}
	
	/* Il seguente metodo viene invocato premendo il bottone "Prenota" dalla view della gestione delle attività lato Client e
	 * permette il passaggio alla view per prenotare un'attività basandosi sul numero che gli viene passato in argomento. Se
	 * il numero è 1 si ha il passaggio alla view per prenotare un'attività singola, altrimenti si ha il passaggio alla view
	 * per prenotare un'attività di gruppo*/
	public void switchToPrenotation(int numero) {
		if (numero == 1) {
			windowCategorie = new PrenotazioneAttivitaSingolaGUI();
			windowCategorie.getFrame().setVisible(true);
			windowCategorie.getTxtCodiceId().setText(codiceId);
		}
		else {
			windowAttivitaGruppo.attach(getWindowNotifiche());
			windowAttivitaGruppo.getFrame().setVisible(true);
			windowAttivitaGruppo.getTxtCodiceId().setText(codiceId);
		}
		
		
	}
	
	/* Il seguente metodo viene invocato premendo il bottone "Cancella" dalla view della gestione delle attività lato Client e
	 * permette il passaggio alla view per eliminare una prenotazione */
	public void switchtoEliminaPrenotazione() {
		windowEliminaPrenotazione = new EliminaPrenotazioneGUI();
		windowEliminaPrenotazione.attach(getWindowNotifiche());
		windowEliminaPrenotazione.getFrame().setVisible(true);

	}

	/* Il seguente metodo viene invocato dalla view dell'eliminazione della prenotazione premendo il bottone Elimina prenotazioni
	 *  (quando si verificano determinate condizioni)*/
	public void switchtoPenale(double penale, int codiceAtt, double prezzo, int codicePen) {
		    String penal2 = String.format("%.2f", penale);
			windowPenale.attach(StartApplication.c2.getWindowNotificheAdmin());
			windowPenale.getFrame().setVisible(true);
			windowPenale.getTextPanePenale().setText(penal2);
			windowPenale.getTextPaneCodiceAtt().setText(String.valueOf(codiceAtt));
		    windowPenale.getTxtPcodiceUtente().setText(codiceId);
		    windowPenale.getTextPaneCodicePenale().setText(String.valueOf(codicePen));
		    windowPenale.getTxtPanePrezzo().setText(String.valueOf(prezzo));

	}

}