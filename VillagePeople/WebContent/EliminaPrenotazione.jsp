<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


 <%@ page import="logic.controller.EliminaPrenotazioneController" %>
 <%@ page import="logic.controller.NotificheController" %>
 <%@ page import= "java.sql.SQLException"%>
 <%@ page import= "java.util.ArrayList"%>
 <%@ page import= "java.util.Calendar"%>
 <%@ page import= "java.util.concurrent.ExecutionException" %>
 <%@ page import= "java.util.concurrent.ExecutorService" %>
 <%@ page import= "java.util.concurrent.Executors" %>
 <%@ page import= "java.util.concurrent.Future" %>
 <%@ page import= "logic.util.RetInt" %> 
 <%@ page import= "logic.util.PenalValues" %> 
 <%@ page import= "java.sql.Connection"%>
 <%@ page import="logic.model.dao.DataBaseClass" %>
 <%@ page import="logic.model.dao.DataBaseFactory" %>
 <%@ page import="java.math.BigDecimal" %>
 <%@ page import="java.math.RoundingMode" %>
 


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
     double prezzo = 0.0;
     double penale = 0.0;
     String codiceAtt = "";
     String codiceId = (String)request.getSession().getAttribute("custIdGest");
     
 	 if (codiceId!= null){
		request.getSession().setAttribute("custIdElimPret", codiceId);
	 }
 	 
     if(codiceId == null || codiceId.equals("")){
  	 	if ((String)request.getSession().getAttribute("custIdElimPret") !=null) {
	 		 codiceId = (String)request.getSession().getAttribute("custIdElimPret");
		} else if ((String)request.getSession().getAttribute("custIdPenale") != null) {
    	 codiceId = (String)request.getSession().getAttribute("custIdPenale");
     	}
     }
     
	 String categoriaCus = " ";
	 if((String)request.getSession().getAttribute("custCateg") !=null){
		 categoriaCus = (String)request.getSession().getAttribute("custCateg");
	 }
	 
	 String giornoCus = request.getParameter("giorno");
    
     EliminaPrenotazioneController epc = new EliminaPrenotazioneController();
     NotificheController nc = new NotificheController();     
     ArrayList<Object> l = new ArrayList<>();
     int lenList = l.size();
     if (request.getParameter("custList") != null) {
         if (lenList == 0) {
        	 lenList = Integer.parseInt(request.getParameter("custList"));
         }
     }
     
     if(request.getParameter("cerca") != null){
 	    	String categoria = request.getParameter("categorie");
 	    	request.getSession().setAttribute("custCateg", categoria);
 	    	categoriaCus = (String)request.getSession().getAttribute("custCateg");
    	    int catN = 0;
    	    if (categoria.equals("Sport")) {
    	    	catN = 1;
    	    }else if (categoria.equals("Salute e Benessere")){
    	    	catN = 2;
    	    }else if (categoria.equals("Svago e Relax")){
    	    	catN = 3;
    	    }else {
    	    	catN = 4;
    	    }
    	    UtenteBean.setCodiceID(codiceId);
    	    try {
    	   		epc.ricercaPrenotazioni(UtenteBean, l, catN, connessione);
    	    }catch (SQLException e){
    			e.printStackTrace();
    		}
    	    connessione.close();
     }
     
     if (request.getParameter("elimina") != null){
    	 lenList = Integer.parseInt(request.getParameter("custList"));
    	 if(lenList == 0){
           	 %>
        	 <p style="color: red">Devi prima cercare le attivita</p>
        	 <%	 
    	 }else if (request.getParameter("scelta") == null){
        	 %>
        	 <p style="color: red">Seleziona una delle attivita mostrate</p>
        	 <%
    	 }else{
 	   		 String categoria=(String)request.getSession().getAttribute("custCateg");
 	    	 int catN = 0;
 	    	 if(categoria.equals("Sport")){
 	    		catN = 1;
 	   	  	 }else if(categoria.equals("Salute e Benessere")){
 	    		catN = 2;
 	    	 }else if(categoria.equals("Svago e Relax")){
 	    		catN = 3;
 	    	 }else{
 	    		catN = 4;
 	   			 }
 	    	 UtenteBean.setCodiceID(codiceId);
 	    	 try {
 	   			epc.ricercaPrenotazioni( UtenteBean, l, catN, connessione);
 	    	 }catch (SQLException e){
 				e.printStackTrace();
 			 }
			 boolean risultato = false;
    		 int m = Integer.parseInt(request.getParameter("scelta"));
    		 int index = m*5;
	    	 budget = epc.cercaBudget(codiceId, connessione);
    		 prezzo = Double.parseDouble(l.get(index+3).toString());   	 
    		 double budgetN = budget+prezzo;
    		 codiceAtt = l.get(index).toString();
    		 String giornoAtt = l.get(index+5).toString();
    		 String giorno = "";
    		 String giornoDopo = "";
    		 int tipoPenale = 0;
    		 double penal2 = 0.0;
    		 Calendar calendar = Calendar.getInstance();
    		 int day = calendar.get(Calendar.DAY_OF_WEEK);

    		 if (day == Calendar.MONDAY) {
    				giorno = "Lunedi";
    				giornoDopo = "Martedi";
    		 } else if (day == Calendar.TUESDAY) {
    				giorno = "Martedi";
    				giornoDopo = "Mercoledi";
    		 } else if (day == Calendar.WEDNESDAY) {
    				giorno = "Mercoledi";
    				giornoDopo = "Giovedi";
    		 } else if (day == Calendar.THURSDAY) {
    				giorno = "Giovedi";
    				giornoDopo = "Venerdi";
    		 } else if (day == Calendar.FRIDAY) {
    				giorno = "Venerdi";
    				giornoDopo = "Sabato";
    		 } else if (day == Calendar.SATURDAY) {
    				giorno = "Sabato";
    				giornoDopo = "Domenica";
    		 } else if (day == Calendar.SUNDAY) {
    				giorno = "Domenica";
    				giornoDopo = "Lunedi";
    		 }
    		 if (giornoAtt.equals(giorno)) {
    				tipoPenale = 1;
    		 }
    		 else if (giornoAtt.equals(giornoDopo)) {
    				tipoPenale = 2;
    		 }	
			 if (tipoPenale != 0) {
				 int codicePenale = 0;
				 
				 
				 ExecutorService service = Executors.newFixedThreadPool(2); //creazione di un pool di 2 thread 

				  Future<Integer> retInt = service.submit(new RetInt());
				  
				  Future<Double> penalValues = service.submit(new PenalValues(prezzo, tipoPenale));
				  
				try {
					codicePenale = retInt.get();
					penale = penalValues.get();
					BigDecimal p = new BigDecimal(penale).setScale(2, RoundingMode.HALF_UP);
					penal2 = p.doubleValue();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				} catch (ExecutionException e) {
					
					e.printStackTrace();
				}
				service.shutdown(); //chiusura dei thread
				
	  			%>
	    		<jsp:forward page="Pagamento Penale.jsp"> 
	    	 	<jsp:param name="custPenale" value="<%=penal2%>"/>
	    	 	<jsp:param name="custPrezzo" value="<%=prezzo%>"/>
	    	 	<jsp:param name="custCodAtt" value="<%=codiceAtt%>"/>
	    	 	<jsp:param name="custCodPenale" value="<%=codicePenale%>"/>
	    		</jsp:forward>				
				<%	
			 }else {
				UtenteBean.setBudget(budgetN);
    			UtenteBean.setCodiceID(codiceId);
    			AttivitaBean.setCodice(Integer.parseInt(codiceAtt));
    			try{
					risultato = epc.eliminaPrenotazione(UtenteBean, AttivitaBean, connessione); 	    
    			}catch (SQLException e){
 		   			e.printStackTrace();
 				} 
    			String notificaSport = "UN UTENTE SI E LIBERATO DA UN ATTIVITA DI SPORT DI TUO INTERESSE";
    			String notificaSvagoRelax = "UN UTENTE SI E LIBERATO DA UN ATTIVITA  DI SVAGO E RELAX DI TUO INTERESSE";
    			String notificaSaluteBenessere = "UN UTENTE SI E  LIBERATO DA UN'ATTIVITA  DI SALUTE E BENESSERE DI TUO INTERESSE";
    			String notificaBambini = "UN UTENTE SI E LIBERATO DA UN ATTIVITA DI BAMBINI DI TUO INTERESSE";
    		
    			if (categoria.equals("Sport")) {
    				try {
    					nc.comunicaNotificaPostoLibero(notificaSport, 1, AttivitaBean.getCodice(), connessione);
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}   			
    			}
    			else if (categoria.equals("Salute&Benessere")) {
    				try {
    					nc.comunicaNotificaPostoLibero(notificaSvagoRelax, 2, AttivitaBean.getCodice(), connessione);
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}   			
    			}
    			else if (categoria.equals("Svago&Relax")) {
    				try {
    					nc.comunicaNotificaPostoLibero(notificaSaluteBenessere, 3, AttivitaBean.getCodice(), connessione);
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}   			
    			}
    			else if (categoria.equals("Bambini")) {
    				try {
    					nc.comunicaNotificaPostoLibero(notificaBambini, 4, AttivitaBean.getCodice(), connessione);
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}  		
    			}
    			
    			connessione.close();

    	 		%>
    	 		<p style="color: green">Prenotazione Rimossa</p>
    	 		<%
     			}
    	 }
     }
     
 	if (request.getParameter("Indietro") != null){
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
   <form action="EliminaPrenotazione.jsp" name="formEliminaPrenotazione" method="POST">

    <div class="container">
      <div class="row">
        <div class="col-sm">
          <h1> </h1>
          <img src="./immagini/villaggioT.jpg" class="img-fluid" alt="...">
          <h1> </h1>
          <img src="./immagini/gruppo2.jpg" class="img-fluid" alt="...">
        </div>
        <div class="col-sm">
          <h1> </h1>
          <h5>Seleziona la prenotazione da cancellare:</h5>
          <label for="categorie">Seleziona categoria attività:</label>

  			<select name="categorie" id="cateogorie">
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
    			 <option value="Salute e Benessere">Salute e Benessere</option>
     			 <option value="Svago e Relax">Svago e Relax</option>
    			 <option value="Bambini">Bambini</option>
  			</select>
          <h1></h1>

          <input type="submit" name="cerca" value="Visualizza Prenotazioni">

          <h1></h1>
          		<table style="width:300px" border="1">
          		<caption> </caption>
		<tr>
		    <th scope="col" style="width: 50%"><strong>Seleziona</strong></th>
			<th scope="col" style="width: 50%"><strong>Codice</strong></th>
            <th scope="col" style="width: 50%"><strong>Nome</strong></th>
			<th scope="col" style="width: 50%"><strong>Orario</strong></th>
			<th scope="col" style="width: 50%"><strong>Prezzo</strong></th>
			<th scope="col"style="width: 50%"><strong>Giorno</strong></th>
		</tr>
		<%
		for(i = 0; i < l.size(); i = i + 5){	
		%> 
		<tr>
		    <%
		    	String codAtt = l.get(i).toString();
		    	String nomeAtt = l.get(i+1).toString();
		   	 	String orarioAtt = l.get(i+2).toString();
		    	String prezzoAtt = l.get(i+3).toString();
		    	String giorno = l.get(i+4).toString();
		    %>
		    <td><input type="radio" id="scelta" name="scelta" value="<%=j%>"> </td>
			<td style="width: 50%"><strong><%=codAtt%></strong></td>
            <td style="width: 50%"><strong><%=nomeAtt%></strong></td>
			<td style="width: 50%"><strong><%=orarioAtt%></strong></td>
			<td style="width: 50%"><strong><%=prezzoAtt%></strong></td>
			<td style="width: 50%"><strong><%=giorno%></strong></td>
		</tr>		
		<%
		j++;
		}
		%>
	</table>
	<input type="hidden" id="custList" name="custList" value="<%=l.size()%>"> 
          <h1></h1>
          <input type="submit" name="elimina" value="Elimina Prenotazione">
          <h1></h1>
          <input type="submit" name="Indietro" value="Indietro">
          <h1> </h1>

        </div>
        <div class="col-sm">
          <h1> </h1>          
          <img src="./immagini/attivitaDiGruppo.jpg" class="img-fluid" alt="...">
          <h1> </h1>
          <img src="./immagini/gruppo1.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>

