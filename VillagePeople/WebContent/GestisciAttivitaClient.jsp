<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="logic.controller.MenuController" %>
<%@ page import= "java.sql.SQLException"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="MenuBean" scope="request" class="logic.bean.MenuBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="MenuBean" property="*"/>

<%

	String codice = request.getParameter("custId");

	if(codice != null){
		request.getSession().setAttribute("custIdGest", codice);
	}
	if(codice == null){
 		if ((String)request.getSession().getAttribute("custIdGest") != null){
			codice = (String)request.getSession().getAttribute("custIdGest");
		} else if (request.getParameter("custIdMenu") != null){
			codice = request.getParameter("custIdMenu");
		} else if (request.getParameter("custIdNot") != null){
			codice = request.getParameter("custIdNot");
		} else if(request.getParameter("custIdElimPret") != null){
			 codice = request.getParameter("custIdElimPret");
	    } else if(request.getParameter("custIdPrenAtt") != null){
			 codice = request.getParameter("custIdPrenAtt");
	    } else if(request.getParameter("custIdPrenAttGr") != null){
			 codice = request.getParameter("custIdPrenAttGr");
	    } else if (request.getParameter("codiceH") != null){
	    	codice = request.getParameter("codiceH");
	    }

	}
	
	if(request.getParameter("AggiungiPrenotazione")!=null){
  		%> 		
    	<jsp:forward page="PrenotaAttivitaSingola.jsp"/>
		<%		
	}
	
	if(request.getParameter("EliminaPrenotazione")!=null){
  		%> 		
    	<jsp:forward page="EliminaPrenotazione.jsp"/>
		<%		
	}
	
	if(request.getParameter("AggiungiPrenotazioneGruppo")!=null){
  		%> 		
    	<jsp:forward page="PrenotaAttivitaGruppo.jsp"/>
		<%		
	}
	
	if(codice.equals("")){
		codice = "Errore";
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
    <label for="codice">Codice ID: </label>
	<label for="codice"><%=codice%></label>
    <form action="GestisciAttivitaClient.jsp" name="formGestAttCli" method="POST">
 
    <ul class="nav" style="background-color: #ffffff;";>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageClient.jsp?codiceH=<%=codice%>">Area Personale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageMenuClient.jsp?codiceH=<%=codice%>">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Gestisci Attività </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./NotificheClient.jsp?codiceH=<%=codice%>">Notifiche</a>
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
            <img src="./immagini/attivitaSingola.jpeg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Prenota Attività  singole</h3>
              <p class="card-text">In questa sezione puoi prenotare attività  da svolgere in solitaria.
                Compariranno nell'elenco delle attività  disponibili, solamente quelle che hanno un costo inferiore al budget inserito.
              </p>
              <input type="submit" name="AggiungiPrenotazione" value="Prenota">
              <h1> </h1>
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/attivitaDiGruppo.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Prenota Attività  di gruppo</h3>
              <p class="card-text"> In questa sezione puoi prenotare attività  da svolgere in gruppo. I gruppi variano in base alla tipologia di attività  scelta.
                Compariranno nell'elenco delle attività  disponibili, solamente quelle che hanno un costo inferiore al budget inserito.
              </p>
              <h1> </h1>
              <input type="submit" name="AggiungiPrenotazioneGruppo" value="Prenota">
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/cancellaPrenotazione.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Cancella Prenotazione</h3>
              <p class="card-text">In questa sezione puoi eliminare le prenotazioni effettuate in precedenza. 
              Se la prenotazione che si vuole cancellare è relativa ad un'attività  odierna, verrà  calcolata automaticamente dal sistema un'eventuale penale da pagare.
              </p>
              <h1> </h1>
              <input type="submit" name="EliminaPrenotazione" value="Cancella Prenotazione">
            </div>
          </div>
        </div>
      </div>
    </div>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>

