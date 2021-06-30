<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<%@ page import="logic.controller.MenuAdminController" %>
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
		request.getSession().setAttribute("custIdMenuAdm", codice);
	}
	
	if(codice == null||codice.equals("")){
		if((String)request.getSession().getAttribute("custIdMenuAdm") != null){
			codice = (String)request.getSession().getAttribute("custIdMenuAdm");
		} else if (request.getParameter("custIdGestAdm") != null){
			codice = request.getParameter("custIdGestAdm");
		} else if (request.getParameter("custIdNotAdm") != null){
			codice = request.getParameter("custIdNotAdm");
		} else if (request.getParameter("custIdMenPret") != null){
			codice = request.getParameter("custIdMenPret");
		} else if (request.getParameter("codiceH") != null){
	    	codice=request.getParameter("codiceH");
	    }

	}
	
	if (codice.equals("")){
		codice = "Errore";
	}
	
	MenuAdminController mac = new MenuAdminController();
	NotificheController nc = new NotificheController();
	try {
		mac.mostraMenu(MenuBean, connessione);
	}catch (SQLException e){
		e.printStackTrace();
	}
	String menu1 = MenuBean.getMenu1();
	String menu2 = MenuBean.getMenu2();
	String menu3 = MenuBean.getMenu3();
	
	if(request.getParameter("ConfermaModifiche") != null){
		if (request.getParameter("menu1").equals("")||request.getParameter("menu2").equals("")||request.getParameter("menu3").equals("")){
		 	%>
			<p style="color: red">Scrivi tutti i menu</p>
			<%	
		} else {
			MenuBean.setMenu1(request.getParameter("menu1"));
			MenuBean.setMenu2(request.getParameter("menu2"));
			MenuBean.setMenu3(request.getParameter("menu3"));
			boolean responso = false;
			try{
				responso = mac.comunicaMenu(MenuBean, connessione);
			}catch(SQLException e){
				e.printStackTrace();
			}	
		
			String notificaMenu = "MENU GIORNALIERO DISPONIBILE";
			try {
				nc.comunicaNotificaMenuAdmin(notificaMenu, connessione);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 connessione.close();
			if(responso){
				 %>
				<p style="color: green">Menu comunicato correttamente</p>
				<%	
			}else{
			 	%>
				<p style="color: red">Menu non comunicato</p>
				<%	
			}
		}
	}
	
	if (request.getParameter("MenuPrenotati") != null){
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
  <body>
    <nav class="navbar navbar-light" style="background-color: #ffffff;">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            <img src="./immagini/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
            Village People
          </a>
        </div>
    </nav>
    <form action="HomepageMenuAdmin.jsp" name="formHomepageMenuAdm" method="POST">
 
    <label for="codice">Codice ID: </label>
    <label for="codice"><%=codice%></label>
    <ul class="nav" style="background-color: #ffffff;";>
      <li class="nav-item">
        <a class="nav-link" href="./HomepageAdmin.jsp?codiceH=<%=codice%>">Area Personale</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Menu</a>
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

    <h3 style="text-align:center"> Modifica Menu </h3>

    <p style="text-align:center">In questa pagina potrai inserire i nuovi menu giornalieri disponibile presso il ristorante.</p> 
    <p style="text-align:center">Potrai inoltre visulizzare il totale dei menu scelti e le eventuali intolleranze segnalate.</p> 

    <div class="container">
      <div class="row">
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Menu 1</h3>
              <textarea rows="20" cols="33" name="menu1" id="menu1" ><%=menu1%></textarea>
              <h1> </h1>
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Menu 2</h3>
              <textarea rows="20" cols="33" name="menu2" id="menu2" ><%=menu2%></textarea>
              <h1> </h1>
            </div>
                <input type="submit" name="ConfermaModifiche" value="Conferma Modifiche">
            <h1></h1>
                <input type="submit" name="MenuPrenotati" value="Menu Prenotati">
          </div>
        </div>
        <div class="col-sm">
          <div class="card" style="width: 18rem;">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Menu 3</h3>
              <textarea rows="20" cols="33" name="menu3" id="menu3" ><%=menu3%></textarea>
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

    