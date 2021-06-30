<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 
 <%@ page import ="logic.controller.LogInController" %>
 <%@ page import ="logic.bean.UtenteBean" %>
 <%@ page import = "java.util.ArrayList" %>
 <%@ page import = "java.sql.SQLException"%>
 <%@ page import = "java.sql.Connection"%>
 <%@ page import = "logic.model.dao.DataBaseClass" %>
 <%@ page import = "logic.model.dao.DataBaseFactory" %>
 
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="UtenteBean" scope="request" class="logic.bean.UtenteBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="UtenteBean" property="*"/>

<%  Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();
	String codice = request.getParameter("codiceID");
	if (codice!= null){
		request.getSession().setAttribute("custIdAdm", codice);
	}
	
	
	//utile nel processamento della pagina, pochè senza questo controllo si perderebbe il valore del codice
	if(codice == null || codice.equals("")){
		if((String)request.getSession().getAttribute("custIdAdm") != null){
			codice = (String)request.getSession().getAttribute("custIdAdm");
		} else if ((String)request.getSession().getAttribute("custIdAddCli") != null){
			codice = (String)request.getSession().getAttribute("custIdAddCli");
		} else if (request.getParameter("codiceH") != null){
	    	codice = request.getParameter("codiceH");
	    }
	}
	
	if (codice.equals("")){
		codice = "Errore";
	}
	LogInController lc = new LogInController();
	ArrayList<Object> listaDati = new ArrayList<>();
	try {
		lc.setInfoAdmin(codice,UtenteBean, connessione);
		lc.getInformazioniAdmin(listaDati,UtenteBean);
	}catch (SQLException e){
		e.printStackTrace();
	}
  	String nome = String.valueOf(listaDati.get(1));
  	String cognome = String.valueOf(listaDati.get(2));
  	String email = String.valueOf(listaDati.get(3));
  	String numeroUtenti = String.valueOf(listaDati.get(4));
  	connessione.close();


  	if (request.getParameter("AggiungiCliente") != null){
  		%>
  		
    	<jsp:forward page="AggiungiNuovoCliente.jsp"/>
		<%
  	}
  	

%>

<!doctype html>
<html lang="en">
  <head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="./main.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <title>Village People</title>
  </head>
  <body>
    <nav class="navbar navbar-light" style="background-color: #ffffff;">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            <img src="./immagini/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
            Village People
          </a>
        </div>
    </nav>
    <form action="HomepageAdmin.jsp" name="formHomepageAd" method="POST">
   
    <ul class="nav" style="background-color: #ffffff;";>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Area Personale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageMenuAdmin.jsp?codiceH=<%=codice%>" >Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./GestisciAttivitaAdmin.jsp?codiceH=<%=codice%>">Gestisci Attività </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./NotificheAdmin.jsp?codiceH=<%=codice%>">Notifiche</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./Login.jsp">LogOut</a>
      </li>
    </ul>

    <h1> </h1>

    <div class="container">
      <div class="row">
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/login_omino.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Dati Personali</h3>
              <p class="card-text">In questa sezione puoi modificare eventuali dati personali errati.</p>
              <h4>Nome:</h4>
              <input id="nome" name="nome" type="text" value="<%=nome%>" autocomplete="off" size="30" maxlength="30" readonly />
              <h1> </h1>
              <h4>Cognome:</h4>
              <input id="cognome" type="text" value="<%=cognome%>" maxlength="30" size="30" name="cognome" readonly />
              <h1> </h1>
              <h4>CodiceID:</h4>
              <input id="codiceID" type="number" value="<%=codice%>" maxlength="30" size="30" name="codiceID" readonly />
              <h1> </h1>
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/budget.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Dati Funzionali</h3>
              <p class="card-text"> Inserisci qui sotto la tua e-mail e il tuo budget, per fare in modo di riuscire a prenotare attività  con costi non superiori al valore inserito.
              </p>
              <h4>Indirizzo e-mail:</h4>
              <input id="mail" name="mail" type="text" value="<%=email%>" autocomplete="off" size="30" maxlength="30" readonly/>
              <h1> </h1>
              <h4>Numero Utenti:</h4>
              <input id="numutenti" type="number" value="<%=numeroUtenti%>" maxlength="30" size="30" name="numutenti" readonly />
              <h1> </h1>
              <h8>Clicca il bottone sottostanze per aggiungere un nuovo cliente al sistema e permettergli di effettuare il SignUp</h8>
              <h1> </h1>
               <input type="submit" name="AggiungiCliente" value="Aggiungi Cliente">
            </div>
          </div>
        </div>
        <div class="col-sm">
          <img src="./immagini/fotoResort3.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
	</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>

