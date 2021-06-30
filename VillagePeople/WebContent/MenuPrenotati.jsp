<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="logic.controller.MenuAdminController" %>
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
	String codice = (String)request.getSession().getAttribute("custIdMenuAdm");

	if (codice!= null){
		request.getSession().setAttribute("custIdMenPret", codice);
	}
	
	if (codice == null||codice.equals("")){
		if((String)request.getSession().getAttribute("custIdElenInt1") != null){				
			codice = (String)request.getSession().getAttribute("custIdElenInt1");
	 	} else if ((String)request.getSession().getAttribute("custIdElenInt2") != null){
			codice = (String)request.getSession().getAttribute("custIdElenInt2");
	 	} else if ((String)request.getSession().getAttribute("custIdElenInt3") != null){
			codice = (String)request.getSession().getAttribute("custIdElenInt3")
	 	}
	}
	int numPret1 = 0;
	int numPret2 = 0;
	int numPret3 = 0;
	int intSegn1 = 0;
	int intSegn2 = 0;
	int intSegn3 = 0;
	MenuAdminController mac = new MenuAdminController();
	try {
		numPret1 = mac.contaMenu(1, connessione);
		numPret2 = mac.contaMenu(2, connessione);
		numPret3 = mac.contaMenu(3, connessione);
		intSegn1 = mac.contaIntolleranze(1, connessione);
		intSegn2 = mac.contaIntolleranze(2, connessione);
		intSegn3 = mac.contaIntolleranze(3, connessione);
	}catch (SQLException e){
		e.printStackTrace();
	}
	
	connessione.close();

	
	if(request.getParameter("VediIntolleranze1") != null){
  		%> 		
    	<jsp:forward page="ElencoIntolleranze1.jsp"/>
		<%		
	}
	if(request.getParameter("VediIntolleranze2") != null){
  		%> 		
    	<jsp:forward page="ElencoIntolleranze2.jsp"/>
		<%		
	}
	if(request.getParameter("VediIntolleranze3") != null){
		%>		
		<jsp:forward page="ElencoIntolleranze3.jsp"/>
		<%
	}
	if(request.getParameter("indietro") != null){
		%>		
		<jsp:forward page="HomepageMenuAdmin.jsp"/>
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
    <form action="MenuPrenotati.jsp" name="formMenuPrenotati" method="POST">
 
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <img src="./immagini/cibo1.jpg" class="img-fluid" alt="...">
        </div>
        <div class="col-sm">
          <div class="card" style="width: 26rem;">
            <div class="card-body">
              <h5 class="card-title" style="text-align:center">Elenco menu prenotati dai clienti</h5>
              <h1> </h1>
              <label>Menu 1 prenotati:</label>
              <label for="menu1Pret"><%=numPret1%></label>
              <h1> </h1>
              <label>Intolleranze segnalate:</label>
              <label for="intol1"><%=intSegn1%></label>
              <h1> </h1>
                <input type="submit" name="VediIntolleranze1" value="Vedi Intolleranze">
              <h1> </h1>
              <h1> </h1>
              <label>Menu 2 prenotati:</label>
              <label for="menu2Pret"><%=numPret2%></label>
              <h1> </h1>
              <label>Intolleranze segnalate:</label>
              <label for="intol2"><%=intSegn2%></label>
              <h1> </h1>
                <input type="submit" name="VediIntolleranze2" value="Vedi Intolleranze">
              <h1> </h1>
              <label>Menu 3 prenotati:</label>
              <label for="menu3Pret"><%=numPret3%></label>
              <h1> </h1>
              <label>Intolleranze segnalate:</label>
              <label for="intol3"><%=intSegn3%></label>
              <h1> </h1>
                <input type="submit" name="VediIntolleranze3" value="Vedi Intolleranze">
              <h1> </h1>
              <input type="submit" name="indietro" value="Indietro">
            </div>
          </div>
        </div>
        <div class="col-sm">
          <img src="./immagini/cibo2.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
	</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>
