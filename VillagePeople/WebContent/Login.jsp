<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
 <%@ page import = "logic.controller.LogInController" %>
 <%@ page import = "java.sql.Connection"%>
 <%@ page import = "logic.model.dao.DataBaseClass" %>
 <%@ page import = "logic.model.dao.DataBaseFactory" %>
 <%@ page import = "java.sql.SQLException"%>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="LoginBean" scope="request" class="logic.bean.LoginBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="LoginBean" property="*"/>

<%  Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
	String codice = request.getParameter("codiceID");
	Class.forName("com.mysql.jdbc.Driver");
	connessione = db.openConnection();
	if (request.getParameter("SignUp") != null) {
		%>
    	<jsp:forward page="SignUp.jsp"/>
	<%
	}
	
    if (request.getParameter("login") != null) {
    	codice = request.getParameter("codiceID");
    	String password = request.getParameter("password");
    	if (codice.equals("") || codice == null || password.equals("") || password == null) {
    		%>
        	<p style="color: red">Compila i campi</p>
			<%
    	} else {
    		LogInController lc = new LogInController();
    		int ruolo = 3;
    	
			try {
				Class.forName("com.mysql.jdbc.Driver");
	        	ruolo = lc.ritornaRuolo(LoginBean, connessione);
			} catch (Exception e) {
				e.printStackTrace();
			}
			connessione.close();

        if(ruolo == 0){      	
%>
        	<jsp:forward page="HomepageAdmin.jsp"/>
<%
        } else if (ruolo == 1) {
%>
			<jsp:forward page="HomepageClient.jsp"/>
<%
        } else{
        	
 %>
			<p style="color: red">Dati errati</p>
<%	
        }
    	}
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
  <body >
    <nav class="navbar navbar-light" style="background-color: #ffffff;">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            <img src="./immagini/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
            Village People
          </a>
        </div>
    </nav>
    <h1> </h1>
     <form action="Login.jsp" name="formLogin" method="POST">
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/login1.png" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Login</h3>
              <p class="card-text">Sei già registrato? Effettua l'accesso inserendo i tuoi dati.</p>
              <h4>Codice ID:</h4>
              <input id="codiceID" name="codiceID" type="text" autocomplete="off" size="30" maxlength="200" /> 
              <h1> </h1>
              <h4>Password:</h4>
              <input id="password" type="password" maxlength="10" size="18" name="password" /> 
              <h1> </h1>  
              <input type="submit" name="login" value="Login" style="background-color:blue; border-color:blue; color:white">                   
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <img src="./immagini/login1.png" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">SignUp</h3>
              <p class="card-text">Sei appena arrivato presso il nostro resort e non hai ancora scoperto come usufruire a pieno di tutti i nostri servizi?
                Registrati subito ed immergiti nel nostro mondo, creato su misura per ogni tua esigenza.
              </p>
             <input type="submit" name="SignUp" value="SignUp"  style="background-color:blue; border-color:blue; color:white">
            </div>
          </div>
        </div>
      
        <div class="col-sm">
          <img src="./immagini/fotoResort.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>

