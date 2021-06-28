<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 
 <%@ page import="logic.controller.SignUpController" %>
 <%@ page import= "java.sql.Connection"%>
 <%@ page import = "java.sql.Connection"%>
 <%@ page import = "logic.model.dao.DataBaseClass" %>
 <%@ page import = "logic.model.dao.DataBaseFactory" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="SignUpBean" scope="request" class="logic.bean.SignUpBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="SignUpBean" property="*"/>

<%  Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();
	
    if (request.getParameter("signUp") != null) {
    	String nome = SignUpBean.getNome();
    	String cognome = SignUpBean.getCognome();
    	String email = SignUpBean.getEmail();
    	String codiceID = SignUpBean.getCodiceID();
    	String password = SignUpBean.getPassword();    	
    	String confermaPass = SignUpBean.getConfermaPassword();
    	int giorniPerma = SignUpBean.getGiorni();
	    if (nome == null || cognome == null|| email == null || codiceID == null || password == null ||
	    			confermaPass == null || giorniPerma == 0) {
	 			%>
					<p style="color: red">Compila tutti i campi!</p>

				<%	
    	}else if (password.length() < 8) {
 			%>
				<p style="color: red">Password troppo corta</p>

			<%	
		
    	}else if (!password.equals(confermaPass)) {
 			%>
				<p style="color: red">Conferma correttamente la password</p>

			<%
    	} else{
    		SignUpController sc = new SignUpController();
    		boolean responso = false;
    		if (request.getParameter("sport")!=null){
    			SignUpBean.setSport(true);
    		}
    		if (request.getParameter("saluteBenessere")!=null){
    			SignUpBean.setSaluteBenessere(true);
    		}
    		if (request.getParameter("svagoRelax")!=null){
    			SignUpBean.setSvagoRelax(true);
    		}
    		if (request.getParameter("bambini")!=null){
    	  		SignUpBean.setBambini(true);
    		}

  			try {
  				Class.forName("com.mysql.jdbc.Driver");
	       	 	responso = sc.controlloAssociazione(SignUpBean, connessione);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
        	if(responso){  
        		sc.aggiungiContatto(SignUpBean, connessione);
        		sc.verificaCategorie(SignUpBean, connessione);
 			%>
 				<p style="color: green">Registrazione Effettuata</p>
 
 			<%	
       	 	}else{

 			%>
 				<p style="color: red">Registrazione Non Avvenuta, codice gia'  esistente</p>
			<%	
        	}
    	}
    }
    connessione.close();
		if (request.getParameter("Indietro") != null) {
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
    <h1> </h1>
    <form action="SignUp.jsp" name="formSignUp" method="POST">
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Informazioni Personali</h3>
              <p class="card-text">Tutti i dati inseriti verrano utilizzati solo a scopo funzionale. Iscrivendovi al nostro servizio, date l'autorizzazione per l'utilizzo, a scopo puramente applicativo, di questi dati.</p>
              <h4>Nome:</h4>
              <input id="nome" name="nome" type="text" autocomplete="off" size="30" maxlength="200" />
              <h1> </h1>
              <h4>Cognome:</h4>
              <input id="cognome" type="text" maxlength="200" size="30" name="cognome" />
              <h1> </h1>
              <h4>Email:</h4>
              <input id="email" type="text" maxlength="200" size="30" name="email" />
              <h1> </h1>
              <h4>Password:</h4>
              <input id="password" name="password" type="password" size="30" maxlength="200" />
              <h1> </h1>
              <h4>Conferma Password:</h4>
              <input id="confermaPassword" name="confermaPassword" type="password" size="30" maxlength="200" />
              <h1> </h1>
              
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Informazioni Gestionali</h3>
              <p class="card-text">Cosa aspettate? Richiedete subito, presso la nostra Reception, il codice ID associato alla vostra prenotazione. Inseritelo poi nel box sottostante per confermare la registrazione.
              </p>
              <h4>Codice ID</h4>
              <input id="codiceID" name="codiceID" type="text" autocomplete="off" size="20" maxlength="20" />
              <h1> </h1>
              <h4>Giorni di permanenza:</h4>
              <input id="giorni" name="giorni" type="number" autocomplete="off" size="5" maxlength="5" />
              <h1> </h1>
              <h4>Categorie attività  di interesse:</h4>
              <input type="checkbox" id="bambini" name="bambini" value="bambini">
              <label for="bambini"> Bambini</label><br>
              <input type="checkbox" id="saluteBenessere" name="saluteBenessere" value="saluteBenessere">
              <label for="saluteBenessere"> Salute e Benessere</label><br>
              <input type="checkbox" id="sport" name="sport" value="sport">
              <label for="sport"> Sport</label><br>
              <input type="checkbox" id="svagoRelax" name="svagoRelax" value="svagoRelax">
              <label for="svagoRelax"> Svago e Relax</label><br>
              <h1> </h1>
            </div>
            <h1></h1>
            
            <input type="submit" name="signUp" value="SignUp">
          </div>
        </div>
        <div class="col-sm">
          <p style="text-align:right">
            <input type="submit" name="Indietro" value="Indietro">
          </p>
          
          <img src="./immagini/fotoResort2.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>

