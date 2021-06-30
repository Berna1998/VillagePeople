<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import= "java.sql.SQLException"%>

<%

	String codice = request.getParameter("custIdAdm");
	
	if(codice != null){
		request.getSession().setAttribute("custIdGestAdm", codice);
	}
	if(codice == null){
	 	if ((String)request.getSession().getAttribute("custAddAtt") != null){
			codice = (String)request.getSession().getAttribute("custAddAtt");
		} else if (request.getParameter("custIdMenuAdm") != null){
			codice = request.getParameter("custIdMenuAdm");
		} else if (request.getParameter("custIdNotAdm") != null){
			codice = request.getParameter("custIdNotAdm");
		} else if (request.getParameter("custIdModAttAd") != null){
			codice = request.getParameter("custIdModAttAd");
		} else if (request.getParameter("custIdElimAttAd") != null){
			codice = request.getParameter("custIdElimAttAd");
		}else if (request.getParameter("custAddAtt") != null){
			codice = request.getParameter("custAddAtt");
		} else if (request.getParameter("codiceH") != null){
	    	codice=request.getParameter("codiceH");
	    }
 	
	}

	
	if(request.getParameter("AggiungiAttivita")!=null){
  		%> 		
    	<jsp:forward page="AggiungiAttivita.jsp"/>
		<%		
	}
	
	if(request.getParameter("ModificaAttivita")!=null){
  		%> 		
    	<jsp:forward page="ModificaAttivitaAdmin.jsp"/>
		<%		
	}
	
	if(request.getParameter("EliminaAttivita")!=null){
  		%> 		
    	<jsp:forward page="EliminaAttivitaAdmin.jsp"/>
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
    <form action="GestisciAttivitaAdmin.jsp" name="formGestisciAttivitaAdm" method="POST">

    <ul class="nav" style="background-color: #ffffff;">
      <li class="nav-item">
        <a class="nav-link" href="./HomepageAdmin.jsp?codiceH=<%=codice%>">Area Personale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageMenuAdmin.jsp?codiceH=<%=codice%>">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Gestisci Attività </a>
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
    <label for="codice">Codice ID: </label>
	<label for="codice"><%=codice%></label>
      <div class="row">
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/attivitaSingola.jpeg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Aggiungi Attività </h3>
              <p class="card-text">In questa sezione puoi aggiungere un'attività.
                Compariranno nell'elenco delle attività  disponibili per i clienti, dipendentemente dalla tipologia di attività inserita.
              </p>
                <input type="submit" name="AggiungiAttivita" value="Aggiungi Attivita">
              <h1> </h1>
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/modifica.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Modifica Attività</h3>
              <p class="card-text"> In questa sezione puoi modificare attività già precedentemente aggiunte. Si possono modificare dati come il numero di partecipanti, l'orario di inizio e il prezzo della stessa.
              </p>
              <h1> </h1>
                <input type="submit" name="ModificaAttivita" value="Modifica Attivita"> 
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/cancellaPrenotazione.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Cancella Attività</h3>
              <p class="card-text">In questa sezione puoi eliminare le attività aggiunte in precedenza. 
              Tutti gli utenti iscritti all'attività  in questione verranno notificati della sua cancellazione .
              </p>
              <h1> </h1>
                <input type="submit" name="EliminaAttivita" value="Elimina Attivita">
            </div>
          </div>
        </div>
      </div>
    </div>
	</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>
    