<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ page import="logic.controller.SignUpController" %>
 <%@ page import= "java.sql.Connection"%>
 <%@ page import="logic.model.dao.DataBaseClass" %>
 <%@ page import="logic.model.dao.DataBaseFactory" %>
 
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="SignUpBean" scope="request" class="logic.bean.SignUpBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="SignUpBean" property="*"/>

<%  Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();
	String codice = (String)request.getSession().getAttribute("custIdAdm");
	if (codice!= null){
		request.getSession().setAttribute("custIdAddCli", codice);
	}
	
	if (codice == null){
		codice =(String)request.getSession().getAttribute("custIdAddCli");		
	}
    if (request.getParameter("Aggiungi utente") != null) {
    	if (request.getParameter("codiceID").equals("") || request.getParameter("nome").equals("") ||
    			request.getParameter("cognome").equals("")){
    		 %>
  			<p style="color: red">Compila i campi</p>
 			<%			
    	}else {
    		SignUpController sc = new SignUpController();
    		int n = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");	
				connessione = db.openConnection();
	        	n = sc.controllaCodiceCliente(SignUpBean, connessione);
			} catch (ClassNotFoundException e) {
	 			%>
	 			<p style="color: red">Codice già esistente</p>
				<%	
			}

        	if(n == 0) {  
        		sc.aggiungiNuovoCliente(SignUpBean, connessione);
 			%>
 				<p style="color: green">Aggiunta Effettuata</p>
 
 			<%	
        	connessione.close();
    	}
    }

	if (request.getParameter("Indietro") != null) {
		%>		
		<jsp:forward page="HomepageAdmin.jsp"/>
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
  <body style="background-color: â€#CCCCCCâ">
    <nav class="navbar navbar-light" style="background-color: #ffffff;">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            <img src="./immagini/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
            Village People
          </a>
        </div>
    </nav>
    <h1> </h1>
        <form action="AggiungiNuovoCliente.jsp" name="formAggiungiCliente" method="POST">
<!-- Questo valore hidden ci serve per avere il codice dell'admin anche quando
 ritorniamo nella scheramata di homepage, altrimenti avremmo valore null come Codice ID  -->  
    <div class="container">
      <div class="row">
        <div class="col-sm">
      
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/AggiungiCliente1.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Aggiungi nuovo cliente</h3>
              <p class="card-text">In questa sezione puoi aggiungere un nuovo cliente per permettergli di registrarsi al sistema ed usufruire di tutti i servizi messi a disposizione.
              </p>
              <h1> </h1>
              <h4>Nome:</h4>
              <input id="nome" name="nome" type="text" autocomplete="off" size="30" maxlength="200" />
              <h1> </h1>
              <h4>Cognome:</h4>
              <input id="cognome" type="text" maxlength="200" size="30" name="cognome" />
              <h1> </h1>
              <h4>Codice:</h4>
              <input id="codiceID" name="codiceID" type="number" autocomplete="off" size="30" maxlength="200" />
              <h1> </h1>
               <input type="submit" name="Aggiungi utente" value="Aggiungi utente">
               <input type="submit" name="Indietro" value="Indietro">
            </div>
          </div>
        </div>
        <div class="col-sm">
          
        </div>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</form>
  </body>
</html>


