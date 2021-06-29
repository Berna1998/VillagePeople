<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

       
<%@ page import="logic.controller.MenuAdminController" %>
<%@ page import= "java.sql.SQLException"%>
<%@ page import= "java.sql.Connection"%>
<%@ page import="logic.model.dao.DataBaseClass" %>
<%@ page import="logic.model.dao.DataBaseFactory" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="MenuBean" scope="request" class="logic.bean.MenuBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="MenuBean" property="*"/>

<%

	String codice=request.getParameter("custIdMenPret");
	if(codice!=null){
		request.getSession().setAttribute("custIdElenInt2", codice);

	}
    StringBuilder totale2= new StringBuilder();
	MenuAdminController mac = new MenuAdminController();
	Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();
	try { 
		totale2 = mac.prendiElenco(2, connessione);
	} catch (SQLException e){
		e.printStackTrace();
	}
	connessione.close();

	if(request.getParameter("Indietro") != null){
		%>		
		<jsp:forward page="MenuPrenotati.jsp"/>
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
    <form action="ElencoIntolleranze2.jsp" name="formElencInt2" method="POST">
 
    <div class="container">
      <div class="row">
        <div class="col-sm">
      
        </div>
        <div class="col-sm">
          <div class="card" style="width: 40rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Intolleranze menu 2</h3>
              <h1><label for="intolleranze"><%=totale2%></label></h1>
              
              <input type="submit" name="Indietro" value="Indietro">
            </div>
          </div>
        </div>
        <div class="col-sm">
          
        </div>
      </div>
    </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>

