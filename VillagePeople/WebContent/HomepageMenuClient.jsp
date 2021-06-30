<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ page import="logic.controller.MenuClientController" %>
 <%@ page import= "java.sql.SQLException"%>
 <%@ page import = "java.sql.Connection"%>
 <%@ page import = "logic.model.dao.DataBaseClass" %>
 <%@ page import = "logic.model.dao.DataBaseFactory" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="MenuBean" scope="request" class="logic.bean.MenuBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="MenuBean" property="*"/>

<%  Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();
	String codice = codice = request.getParameter("codiceH");
	
	if (codice!= null){
		request.getSession().setAttribute("custIdMenu", codice);
	}
	
	
	if (codice == null || codice.equals("")){
 		if ((String)request.getSession().getAttribute("custIdMenu")!=null){
			codice = (String)request.getSession().getAttribute("custIdMenu");
		} else if ((String)request.getSession().getAttribute("custIdSelMen")!=null){
			codice = (String)request.getSession().getAttribute("custIdSelMen");
		} 
	}
	
	if (codice.equals("")){
		codice = "Errore";
	}
	
	MenuClientController mcc = new MenuClientController();
	try {
		connessione = db.openConnection();
		mcc.mostraMenu(MenuBean, connessione);
	}catch (SQLException e){
		e.printStackTrace();
	}
	String menu1 = MenuBean.getMenu1();
	String menu2 = MenuBean.getMenu2();
	String menu3 = MenuBean.getMenu3();
	
	connessione.close();
	
	if(request.getParameter("SelezionaMenu") != null){
		%>		
		<jsp:forward page="SelezionaMenu.jsp"/>
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
     <form action="HomepageMenuClient.jsp" name="formHomepageMenuCli" method="POST">
     <input type="hidden" id="custIdMenu" name="custIdMenu" value="<%=codice%>">
    <label for="codice">Codice ID: </label>
    <label for="codice"><%=codice%></label>
    <ul class="nav" style="background-color: #ffffff;";>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageClient.jsp?codiceH=<%=codice%>">Area Personale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./GestisciAttivitaClient.jsp?codiceH=<%=codice%>">Gestisci Attività </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./NotificheClient.jsp?codiceH=<%=codice%>">Notifiche</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./Login.jsp">LogOut</a>
      </li>
    </ul>

    <h1> </h1>

    <h3 style="text-align:center"> Scegliere il Menu </h3>

    <p style="text-align:center">In questa pagina potrai scegliere il menu giornaliero che più si addice alle vostre preferenze.</p> 
    <p style="text-align:center">Una volta scelto il menu, potrai segnalare eventuali intolleranze a cibi che verranno eliminati dal menu stesso.</p> 

    <div class="container">
      <div class="row">
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Menu 1</h3>
              <textarea rows="20" cols="33" name="description" disabled ><%=menu1%></textarea>
              <h1> </h1>
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Menu 2</h3>
              <textarea rows="20" cols="33" name="description" disabled><%=menu2%></textarea>
              <h1> </h1>
            </div>
            <input type="submit" name="SelezionaMenu" value="Seleziona Menu">
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Menu 3</h3>
              <textarea rows="20" cols="33" name="description" disabled><%=menu3%></textarea>
              <h1> </h1>
            </div>
          </div>
        </div>
      </div>
    </div>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>


    