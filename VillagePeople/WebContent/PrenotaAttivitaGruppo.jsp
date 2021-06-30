<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


 <%@ page import="logic.controller.PrenotazioneAttivitaController" %>
 <%@ page import="logic.controller.NotificheController" %>
 <%@ page import= "java.sql.SQLException"%>
 <%@ page import= "java.util.ArrayList"%>
  <%@ page import= "java.util.concurrent.ExecutionException" %>
 <%@ page import= "java.util.concurrent.ExecutorService" %>
 <%@ page import= "java.util.concurrent.Executors" %>
 <%@ page import= "java.util.concurrent.Future" %>
 <%@ page import= "logic.util.AggiornaBudget" %> 
 <%@ page import= "logic.util.MandaPrenotazioneAttGruppo" %> 
 <%@ page import = "java.sql.Connection"%>
 <%@ page import = "logic.model.dao.DataBaseClass" %>
 <%@ page import = "logic.model.dao.DataBaseFactory" %>
 
 

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="AttivitaBean" scope="request" class="logic.bean.AttivitaBean"/>
<jsp:useBean id="UtenteBean" scope="request" class="logic.bean.UtenteBean"/>
<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="AttivitaBean" property="*"/>
     <% 
     Connection connessione = null;
     String type = "MySql";
     DataBaseFactory dbf = new DataBaseFactory();
     DataBaseClass db = dbf.getConnessione(type);
     connessione = db.openConnection();
     int i = 0;
     int n = 0;
     int j = 0;
     double budget = 0.0;
     String codiceId = (String)request.getSession().getAttribute("custIdGest");
 	 if (codiceId!= null){
		request.getSession().setAttribute("custIdPrenAttGr", codiceId);
	 }
	
 	 String categoriaCus = " ";
 	 String giornoCus = " ";
 	 
 	 if((String)request.getSession().getAttribute("custCateg") !=null){
 		 categoriaCus = (String)request.getSession().getAttribute("custCateg");
 	 }
 	 
 	 if((String)request.getSession().getAttribute("custGiorno") != null){
 		 giornoCus = (String)request.getSession().getAttribute("custGiorno");
 	 }

     if (codiceId == null){
    	 codiceId = (String)request.getSession().getAttribute("custIdPrenAttGr");
     }
    
     PrenotazioneAttivitaController pac = new PrenotazioneAttivitaController();
     NotificheController nc = new NotificheController();
     ArrayList<Object> l = new ArrayList<>();
     int lenList = l.size();
     if (request.getParameter("custList") != null) {
         if (lenList == 0) {
        	 lenList=Integer.parseInt(request.getParameter("custList"));
         }
     }
     if (request.getParameter("cerca") != null){
    	    budget = pac.cercaBudget(codiceId, connessione);
    	    UtenteBean.setBudget(budget);
    	    String categoria = request.getParameter("categorie");
    	    String giorno = request.getParameter("giorno");
    	 	request.getSession().setAttribute("custCateg", categoria);
    	 	request.getSession().setAttribute("custGiorno", giorno);
    	    categoriaCus = (String)request.getSession().getAttribute("custCateg");
    	    giornoCus = (String)request.getSession().getAttribute("custGiorno");
    	 	if(categoria.equals("Salute e Benessere")){
    	 		categoria = "Salute&Benessere";
    	 	}else if(categoria.equals("Svago e Relax")){
    	 		categoria = "Svago&Relax";
    	 	}
    	 	if(giorno.equals("Lunedì")){
    	 		giorno = "Lunedi";
    	 	}
    		AttivitaBean.setCategoria(categoria);
    		AttivitaBean.setGiorno(giorno);
    	    try {
    	    	pac.verificaAttivitaGruppo(AttivitaBean, l, UtenteBean, connessione);
    	    }catch (SQLException e){
    			e.printStackTrace();
    		}
    	    connessione.close();
     }
     if (request.getParameter("prenota") != null){
    	 lenList = Integer.parseInt(request.getParameter("custList"));
    	 if (lenList == 0){
           	 %>
        	 <p style="color: red">Devi prima cercare le attivita</p>
        	 <%	 
    	 }else if (request.getParameter("scelta")==null){
        	 %>
        	 <p style="color: red">Seleziona una delle attivita mostrate</p>
        	 <%
    	 }else {
    		boolean responso = false;
    		int m = Integer.parseInt(request.getParameter("scelta"));
    		String categoria = (String)request.getSession().getAttribute("custCateg");
    	 	String giorno = (String)request.getSession().getAttribute("custGiorno");
    	 	int index = m*6;
 	     	budget = pac.cercaBudget(codiceId, connessione);
 	     	UtenteBean.setBudget(budget);
    		String categoria = request.getParameter("custCateg");
    	 	String giorno = request.getParameter("custGiorno");
    	 	if (categoria.equals("Salute e Benessere")){
    	 		categoria = "Salute&Benessere";
    	 	} else if (categoria.equals("Svago e Relax")){
    	 		categoria = "Svago&Relax";
    	 	}

    		AttivitaBean.setCategoria(categoria);
    		AttivitaBean.setGiorno(giorno);
 	     	try {
 	     		pac.verificaAttivitaGruppo(AttivitaBean, l, UtenteBean, connessione);
	     	} catch (SQLException e){
				e.printStackTrace();
		 	}    	     	 
 	     	int partecipantiAtt = Integer.parseInt(l.get(index+4).toString());   
 	     	int partecipantiMax = Integer.parseInt(l.get(index+5).toString());  
 	     	if (partecipantiAtt == partecipantiMax){
 	        	 %>
 	        	 <p style="color: red">L'attivita è al completo</p>
 	        	 <%
 	     	}else {
    	 		double prezzo = Double.parseDouble(l.get(index+3).toString());   	 
    	 		double budgetN=budget-prezzo;
    	 		int c = 0;
    	 		int codiceRet = 0;
    	 		boolean risultato = false;
    	 		String codiceAtt = l.get(index).toString();
    	 		UtenteBean.setBudget(budgetN);
    	 		UtenteBean.setCodiceID(codiceId);
    	 		AttivitaBean.setCodice(Integer.parseInt(codiceAtt));
 				 
   				ExecutorService service = Executors.newFixedThreadPool(2); //creazione di un pool di 2 thread 

   				Future<Integer> retBudg = service.submit(new AggiornaBudget(UtenteBean, connessione));
   				  
   				Future<Boolean> risult = service.submit(new MandaPrenotazioneAttGruppo(AttivitaBean, UtenteBean, connessione));
   				 
   				try {
   						codiceRet = retBudg.get();
   						risultato=risult.get();
   				} catch (InterruptedException | ExecutionException e) {
   					    budgetN=budget;
   					    UtenteBean.setBudget(budgetN);
   					    service.submit(new AggiornaBudget(UtenteBean, connessione));
   	 		   	 		%>
   	 	    	 		<p style="color: red">Attivita già Prenotata</p>
   	 	    	 		<%
   						e.printStackTrace();
   				}
   				service.shutdown(); //chiusura dei thread
   				 if (risultato && codiceRet!=0) {
   	    			String notificaSport = "NUOVO PRENOTATO IN ATTIVITA DI SPORT";
   	    			String notificaSvagoRelax = "NUOVO PRENOTATO IN ATTIVITA DI SVAGO E RELAX";
   	    			String notificaSaluteBenessere = "NUOVO PRENOTATO IN ATTIVITA DI SALUTE E BENESSERE";
   	    			String notificaBambini = "NUOVO PRENOTATO IN ATTIVITA DI BAMBINI";
   	    	 		if(categoria.equals("Sport")){
   	    				try {
   	    					nc.comunicaNotificaAttivitaGruppo(notificaSport, 1, AttivitaBean.getCodice(), connessione);
   	    				} catch (SQLException e) {
   	    					e.printStackTrace();
   	    				}
   	    	 		}else if(categoria.equals("Salute&Benessere")){
   	    				try {
   	    					nc.comunicaNotificaAttivitaGruppo(notificaSvagoRelax, 2, AttivitaBean.getCodice(), connessione);
   	    				} catch (SQLException e) {
   	    					e.printStackTrace();
   	    				}
   	    	 		}else if(categoria.equals("Svago&Relax")){
   	    				try {
   	    					nc.comunicaNotificaAttivitaGruppo(notificaSaluteBenessere, 3, AttivitaBean.getCodice(), connessione);
   	    				} catch (SQLException e) {
   	    					e.printStackTrace();
   	    				}
   	    	 		}else if(categoria.equals("Bambini")){
   	    				try {
   	    					nc.comunicaNotificaAttivitaGruppo(notificaBambini, 4, AttivitaBean.getCodice(), connessione);
   	    				} catch (SQLException e) {
   	    					e.printStackTrace();
   	    				}
   	    	 		}
   	    	 		connessione.close();
   					
   		    	 	%>
   		    	 	<p style="color: green">Attivita Prenotata</p>
   		    	 	<%	

   				 }
    	 	  }
    	 	}
     }
        
 	if(request.getParameter("Indietro") != null){
		%>		
		<jsp:forward page="GestisciAttivitaClient.jsp"/>
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
    <form action="PrenotaAttivitaGruppo.jsp" name="formPrenotaAttGruppo" method="POST">
 
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <h1> </h1>
          <img src="./immagini/calcetto.jpg" class="img-fluid" alt="...">
        </div>
        <div class="col-sm">
          <h1> </h1>
          <h5>Seleziona l'attività  da prenotare:</h5>
          <label for="categorie">Seleziona categoria attività:</label>
          <select name="categorie" id="categorie">
                <% 
  			     if(request.getParameter("categorie")==null){
    	 				%>
    				 <option value=" "> </option>
    	 				<% 
     			 }else{
         	 		%>
    				 <option value="<%=categoriaCus%>"><%=categoriaCus%></option>
    			        <% 	
      			}
     			 %>  	
            <option value="Sport">Sport</option>
            <option value="Svago e Relax">Svago&Relax</option>
            <option value="Salute e Benessere">Salute&Benessere</option>
            <option value="Bambini">Bambini</option>
          </select>
          <h1></h1>

          <label for="giorno">Seleziona giorno attività:</label>
          <select name="giorno" id="giorno">
             			 <% 
     			if(request.getParameter("giorno")==null){
    	 		%>
    				 <option value=" "> </option>
    			<% 
     			}else{
        	 		%>
   					 <option value="<%=giornoCus%>"><%=giornoCus%></option>
   			        <% 	
     			}
    			 %>  
            <option value="Lunedì">Lunedi</option>
            <option value="Martedi">Martedi</option>
            <option value="Mercoledi">Mercoledi</option>
            <option value="Giovedi">Giovedi</option>
            <option value="Venerdi">Venerdi</option>
            <option value="Sabato">Sabato</option>
            <option value="Domenica">Domenica</option>
          </select>

          <input type="submit" name="cerca" value="Cerca">

          <h1></h1>
          <table style="width:300px" border="1">
          <caption> </caption>
			<tr>
		    	<th scope="col" style="width: 50%"><strong>Seleziona</strong></th>
				<th scope="col" style="width: 50%"><strong>Codice</strong></th>
            	<th scope="col" style="width: 50%"><strong>Nome</strong></th>
				<th scope="col" style="width: 50%"><strong>Orario</strong></th>
				<th scope="col" style="width: 50%"><strong>Prezzo</strong></th>
				<th scope="col" style="width: 50%"><strong>Partecipanti Attuali</strong></th>
				<th scope="col" style="width: 50%"><strong>Partecipanti Massimi</strong></th>
			</tr>
			<%
			for(i = 0; i < l.size(); i = i + 6){	
			%> 
			<tr>
		    	<%
		    	String codAtt = l.get(i).toString();
		    	String nomeAtt = l.get(i+1).toString();
		   	 	String orarioAtt = l.get(i+2).toString();
		    	String prezzoAtt = l.get(i+3).toString();
		    	String numPartAtt = l.get(i+4).toString();
		    	String numPartMax = l.get(i+5).toString();
		    	%>
		    	<td><input type="radio" id="scelta" name="scelta" value="<%=j%>"> </td>
				<td style="width: 50%"><strong><%=codAtt%></strong></td>
            	<td style="width: 50%"><strong><%=nomeAtt%></strong></td>
				<td style="width: 50%"><strong><%=orarioAtt%></strong></td>
				<td style="width: 50%"><strong><%=prezzoAtt%></strong></td>
				<td style="width: 50%"><strong><%=numPartAtt%></strong></td>
				<td style="width: 50%"><strong><%=numPartMax%></strong></td>
			</tr>		
			<%
			j++;
			}
			%>
		</table>
		<input type="hidden" id="custList" name="custList" value="<%=l.size()%>"> 
		<h1> </h1>
        <input type="submit" name="prenota" value="Prenota"> 
        <h1> </h1>
        <input type="submit" name="Indietro" value="Indietro">
        <h1> </h1>
        <h8><strong>Le attività mostrate nella tabella rientrano nei limiti del budget dichiarato</strong></h8>

        </div>
        <div class="col-sm">
          <h1> </h1>          
          <img src="./immagini/basket.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>
