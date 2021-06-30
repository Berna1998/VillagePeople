<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ page import="logic.controller.MenuClientController" %>
 <%@ page import="logic.controller.NotificheController" %>
 <%@ page import= "java.sql.SQLException"%>
 <%@ page import= "java.util.concurrent.ExecutionException" %>
 <%@ page import= "java.util.concurrent.ExecutorService" %>
 <%@ page import= "java.util.concurrent.Executors" %>
 <%@ page import= "java.util.concurrent.Future" %>
 <%@ page import= "logic.util.SendIntolerance" %> 
 <%@ page import= "logic.util.SendMenu" %> 
 <%@ page import = "java.sql.Connection"%>
 <%@ page import = "logic.model.dao.DataBaseClass" %>
 <%@ page import = "logic.model.dao.DataBaseFactory" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="IntolleranzeBean" scope="request" class="logic.bean.IntolleranzeBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="IntolleranzeBean" property="*"/>

<%
    Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();
	String codice = request.getParameter("custIdMenu");
	if (codice!= null){
		request.getSession().setAttribute("custIdSelMen", codice);
	}
    MenuClientController mcc = new MenuClientController();
    NotificheController nc = new NotificheController();
	if (codice == null){
		codice = (String)request.getSession().getAttribute("custIdSelMen");
	}
    if (request.getParameter("Invia") != null) {

    	boolean responso = false;
    	int intol = 0;
    	if (request.getParameter("menu") == null) {
 			%>
				<p style="color: red">Seleziona un Menu</p>

			<%	    	
    	} else {
    		if (request.getParameter("menu").equals("menu1")){
    			IntolleranzeBean.setMenu1(true);
    			IntolleranzeBean.setCodiceId(codice);
    		}
    		if (request.getParameter("menu").equals("menu2")){
    			IntolleranzeBean.setMenu2(true);
    			IntolleranzeBean.setCodiceId(codice);
    		}
    		if (request.getParameter("menu").equals("menu3")){
    			IntolleranzeBean.setMenu3(true);
    			IntolleranzeBean.setCodiceId(codice);
    		}
    		if (request.getParameter("scelInto") != null){
    			if (request.getParameter("intolleranze") == null || request.getParameter("intolleranze") == " " || request.getParameter("intolleranze") == "") {
	 				%>
						<p style="color: red">Devi scrivere l'intolleranza prima di inviare</p>
					<%	
    			}else{
					ExecutorService service = Executors.newFixedThreadPool(2); //creazione di un pool di 2 thread 

					Future<Boolean> rispostaMen = service.submit(new SendMenu(IntolleranzeBean, connessione));
				  
					Future<Integer> rispostaIntol = service.submit(new SendIntolerance(IntolleranzeBean, connessione));
				
					try {
						responso = rispostaMen.get();
						intol = rispostaIntol.get();
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} catch (ExecutionException e) {
					
						e.printStackTrace();
					}
					service.shutdown(); //chiusura dei thread			
			
					String notificaMenu = "HA AGGIUNTO LE INTOLLERANZE IL CLIENTE: ";
					notificaMenu = notificaMenu.concat(codice);
					try {
						nc.comunicaNotificaIntolleranze(notificaMenu, connessione);
					} catch (SQLException e) {
						e.printStackTrace();
					}
							
    			}
    		}else {
    			
				try {			
	       	 		responso = mcc.selezionaDati(IntolleranzeBean, connessione);
				} catch (SQLException e){
	 				%>
						<p style="color: red">Menu già prenotato, per cambiarlo chiedere alla reception</p>
					<%	
				
				}
    		}
            connessione.close();
        	if (responso) { 
        		if (intol == 0){
         			%>
     				<p style="color: green">Menu inviato</p>
     
     			   <%	
        		} else{
         			%>
     				<p style="color: green">Menu e intolleranze inviati</p>
     
     			   <%
        		}

        	} else{

 			%>
 				<p style="color: red">Menu non inviato</p>
			<%	
        	}
    	}
    }

	if (request.getParameter("Indietro") != null){
		%>		
		<jsp:forward page="HomepageMenuClient.jsp"/>
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
    <form action="SelezionaMenu.jsp" name="formSelezionaMenu" method="POST">
 
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <h1> </h1>
          <img src="./immagini/cibo1.jpg" class="img-fluid" alt="...">
        </div>
        <div class="col-sm">
          <h1> </h1>
          <h5>Selezionare il menu preferito:</h5>
          <label for="menu">Seleziona menu:</label>
		  <h1></h1>
          <label for="menu1">Menu 1</label>
          <input type="radio" id="menu1" name="menu" value="menu1">
          <h1></h1>
          <label for="menu2">Menu 2</label>
          <input type="radio" id="menu2" name="menu" value="menu2">
		  <h1></h1>
          <label for="menu3">Menu 3</label>
          <input type="radio" id="menu3" name="menu" value="menu3">
		  <h1></h1>
		  <label for="menu3">Selezionare se si vogliono aggiungere intolleranze sul menu scelto </label>
          <input type="radio" id="scelInto" name="scelInto" value="sceltaInto">
          <h1></h1>
          <h5>Inserire eventuali intolleranze qui:</h5>
		  <h1></h1>
          <textarea rows="10" cols="48" name="intolleranze" id="intolleranze"></textarea>
          <h1> </h1>
          <input type="submit" name="Invia" value="Invia">
          <h1> </h1>
          <input type="submit" name="Indietro" value="Indietro">

        </div>
        <div class="col-sm">
          <h1> </h1>          
          <img src="./immagini/cibo2.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
	</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>