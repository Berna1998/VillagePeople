<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ page import="logic.controller.NotificheController" %>
<%@ page import= "java.sql.SQLException"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "logic.model.dao.DataBaseClass" %>
<%@ page import = "logic.model.dao.DataBaseFactory" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="MenuBean" scope="request" class="logic.bean.MenuBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="MenuBean" property="*"/>

<%  
    Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();

	String codice = request.getParameter("custIdAdm");

	if (codice!= null){
		request.getSession().setAttribute("custIdNotAdm", codice);
	}
	
	if (codice == null){
	 	if (request.getParameter("custIdGestAdm") != null){
			codice = request.getParameter("custIdGestAdm");
		} else if (request.getParameter("custIdMenuAdm") != null){
			codice = request.getParameter("custIdMenuAdm");
		} else if ((String)request.getSession().getAttribute("custId") != null){
			codice = (String)request.getSession().getAttribute("custId");
		} else if (request.getParameter("codiceH") != null){
	    	codice = request.getParameter("codiceH");
	    }
	}
	
	if (codice.equals("")){
		codice = "Errore";
	}
	
	NotificheController nc = new NotificheController();
	String notifica = "";
	String notificaIntolleranze = "";
	String notificaPenale = "";
	try {
		notificaIntolleranze = nc.prendiNotificaIntolleranze(connessione);
		if (!notificaIntolleranze.equals("")) {
			notifica = notifica+notificaIntolleranze+"\n";
		}
		notificaPenale = nc.prendiNotificaPenale(connessione);
		if (!notificaPenale.equals("")) {
			notifica = notifica+notificaPenale+"\n";
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	connessione.close();

	if(request.getParameter("menu")!=null){
  		%> 		
    	<jsp:forward page="HomepageMenuAdmin.jsp"/>
		<%		
	}
	if(request.getParameter("profiloPersonale")!=null){
  		%> 		
    	<jsp:forward page="HomepageAdmin.jsp"/>
		<%		
	}
	if(request.getParameter("gestisciAttivita")!=null){
		%>		
		<jsp:forward page="GestisciAttivitaAdmin.jsp"/>
		<%
	}
	if(request.getParameter("logout")!=null){
		%>		
		<jsp:forward page="Login.jsp"/>
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
    <label for="codice">Codice ID: </label>
	<label for="codice"><%=codice%></label>
    <form action="NotificheAdmin.jsp" name="formNotificheAdm" method="POST">
 
    <ul class="nav" style="background-color: #ffffff;";>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageAdmin.jsp?codiceH=<%=codice%>">Area Personale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageMenuAdmin.jsp?codiceH=<%=codice%>">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./GestisciAttivitaAdmin.jsp?codiceH=<%=codice%>">Gestisci Attività </a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Notifiche</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./Login.jsp">LogOut</a>
      </li>
    </ul>

    <h1> </h1>
      <p style="text-align:center">
        <textarea rows="50" cols="180" name="notifica" disabled><%=notifica%></textarea>
      </p>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>
 