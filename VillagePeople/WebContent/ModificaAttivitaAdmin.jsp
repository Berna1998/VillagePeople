<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
 <%@ page import="logic.controller.AttivitaController" %>
 <%@ page import="logic.controller.ModificaAttivitaAdminController" %>
 <%@ page import="logic.controller.NotificheController" %>
 <%@ page import= "java.sql.SQLException"%>
 <%@ page import= "java.util.ArrayList"%>
 <%@ page import = "java.sql.Connection"%>
 <%@ page import = "logic.model.dao.DataBaseClass" %>
 <%@ page import = "logic.model.dao.DataBaseFactory" %>

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="AttivitaBean" scope="request" class="logic.bean.AttivitaBean"/>
<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="AttivitaBean" property="*"/>
     <% 
     Connection connessione = null;
     String type = "MySql";
     DataBaseFactory dbf = new DataBaseFactory();
     DataBaseClass db = dbf.getConnessione(type);
     connessione = db.openConnection();
     int i = 0;
     int j = 0;
     double budget = 0.0;
     String codiceId = request.getParameter("custIdGestAdm");
 	 if (codiceId!= null){
		request.getSession().setAttribute("custIdModAttAd", codiceId);
	 }
	
 	 String categoriaCus = " ";
 	 String giorniCus = " ";
 	 
 	 if((String)request.getSession().getAttribute("custCateg") !=null){
 		 categoriaCus = (String)request.getSession().getAttribute("custCateg");
 	 }
 	 
 	 if((String)request.getSession().getAttribute("custGiorno") != null){
 		 giorniCus = (String)request.getSession().getAttribute("custGiorno");
 	 }

     if (codiceId == null) {
    	 codiceId = (String)request.getSession().getAttribute("custIdModAttAd");
     }

     AttivitaController ac = new AttivitaController();
     ModificaAttivitaAdminController maac = new ModificaAttivitaAdminController();
     NotificheController nc = new NotificheController();     
     ArrayList<Object> l = new ArrayList<>();
     int lenList = l.size();
     if (request.getParameter("custList") != null){
         if (lenList == 0){
        	 lenList = Integer.parseInt(request.getParameter("custList"));
         }
     }
     
     if (request.getParameter("cerca") != null){
    	    String categoria = request.getParameter("categorie");
    	    String giorno = request.getParameter("giorno");
    	 	request.getSession().setAttribute("custCateg", categoria);
    	 	request.getSession().setAttribute("custGiorno", giorni);
    	 	request.getSession().setAttribute("custList", l.size());
    	    categoriaCus = (String)request.getSession().getAttribute("custCateg");
    	    giorniCus = (String)request.getSession().getAttribute("custGiorno");
    	 	if (categoria.equals("Salute e Benessere")){
    	 		categoria = "Salute&Benessere";
    	 	}else if (categoria.equals("Svago e Relax")){
    	 		categoria = "Svago&Relax";
    	 	}
    		AttivitaBean.setCategoria(categoria);
    		AttivitaBean.setGiorno(giorno);
    	    try {
    	    	ac.ricercaAttivita(AttivitaBean, l, connessione);
    	    } catch (SQLException e){
    			e.printStackTrace();
    		}
     }
     if (request.getParameter("modifica") != null){
    	 lenList = Integer.parseInt(request.getParameter("custList"));
    	 if (lenList == 0){
           	 %>
        	 <p style="color: red">Devi prima cercare le attivita</p>
        	 <%	 
    	 } else if (request.getParameter("scelta") == null){
        	 %>
        	 <p style="color: red">Seleziona una delle attivita mostrate</p>
        	 <%
    	 }else if (request.getParameter("prezzo").equals("") || request.getParameter("orario").equals("")){
        	 %>
        	 <p style="color: red">Compila tutti i campi!</p>
        	 <%
    	 }else{
     		int m = Integer.parseInt(request.getParameter("scelta"));
    	 	int index = m*4; 	
	 	    int cond = 0;
    		boolean risultato = false;  
    		String categoria = (String)request.getSession().getAttribute("custCateg");
    	 	String giorno = (String)request.getSession().getAttribute("custGiorno");
    		String categoria = request.getParameter("custCateg");
    	 	String giorno = request.getParameter("custGiorno");
    	 	if(categoria.equals("Salute e Benessere")){
    	 		categoria = "Salute&Benessere";
    	 	}else if (categoria.equals("Svago e Relax")){
    	 		categoria = "Svago&Relax";
    	 	}
    	 	
    		AttivitaBean.setCategoria(categoria);
    		AttivitaBean.setGiorno(giorno);
 	     	try{
 	     		ac.ricercaAttivita(AttivitaBean, l, connessione);
	     	}catch (SQLException e){
				e.printStackTrace();
		 	}
 	     	String codiceAtt = l.get(index).toString();
    	 	double prezzo = Double.parseDouble(request.getParameter("prezzo"));   	 
    	 	String orario=request.getParameter("orario");
    	 	AttivitaBean.setPrezzo(prezzo);
    	 	AttivitaBean.setCodice(Integer.parseInt(codiceAtt));
    	 	AttivitaBean.setOrario(orario);
    	 	try{
    	 		risultato = maac.modificaAttivita(AttivitaBean, connessione); 	    
    	 	}catch (SQLException e){
 				e.printStackTrace();
 		 	}   
    		String notificaSport = "MODIFICATA ATTIVITA DI SPORT CHE HAI PRENOTATO";
    		String notificaSvagoRelax = "MODIFICATA ATTIVITA DI SVAGO E RELAX CHE HAI PRENOTATO";
    		String notificaSaluteBenessere = "MODIFICATA ATTIVITA DI SALUTE E BENESSERE CHE HAI PRENOTATO";
    		String notificaBambini = "MODIFICATA ATTIVITA DI BAMBINI CHE HAI PRENOTATO";   	 	
    	 	if (categoria.equals("Sport")) {
    			try {
    				nc.comunicaNotificaModificaAttivita(notificaSport, 1, AttivitaBean.getCodice(), connessione);    				
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}	
    		}
    		else if (categoria.equals("Salute&Benessere")) {
    			try {
    				nc.comunicaNotificaModificaAttivita(notificaSvagoRelax, 2, AttivitaBean.getCodice(), connessione);
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}    			
    		}
    		else if (categoria.equals("Svago&Relax")) {
    			try {
    				nc.comunicaNotificaModificaAttivita(notificaSaluteBenessere, 3, AttivitaBean.getCodice(), connessione);
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}    			
    		}
    		else if (categoria.equals("Bambini")) {
    			try {
    				nc.comunicaNotificaModificaAttivita(notificaBambini, 4, AttivitaBean.getCodice(), connessione);
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}   		
    		}
    	 	connessione.close();
 	
    	 	%>
    	 		<p style="color: green">Attivita Modificata</p>    	 	
    	 	<%
 	     	}
    	 
     }
        
 	if(request.getParameter("Indietro")!=null){
		%>		
		<jsp:forward page="GestisciAttivitaAdmin.jsp"/>
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
    <form action="ModificaAttivitaAdmin.jsp" name="formModificaAttAdmin" method="POST">
 
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <h1> </h1>
          <img src="./immagini/basket.jpg" class="img-fluid" alt="...">
        </div>
        <div class="col-sm">
          <h1> </h1>
          <h5>Seleziona l'attività  da modificare:</h5>
          <label for="categorie">Seleziona categoria attività:</label>

			  <select name="categorie" id="cateogorie"> 
  				<% 
  			     if(request.getParameter("categorie")==null){
    	 				%>
    				 <option value="vuoto>"> </option>
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

          <label for="giorno">Seleziona giorno attività:</label>

  			<select name="giorno" id="giorno">
  			 <% 
     			if(request.getParameter("giorno") == null){
    	 		%>
    				 <option value="vuoto>"> </option>
    			<% 
     			}else{
        	 		%>
   					 <option value="<%=giornoCus%>"><%=giornoCus%></option>
   			        <% 	
     			}
    			 %>  
   				 <option value="Lunedi">Lunedi</option>
    			 <option value="Martedi">Martedi</option>
     			 <option value="Mercoledi">Mercoledi</option>
    			 <option value="Giovedi">Giovedi</option>
    			 <option value="Venerdi">Venerdi</option>
     			 <option value="Sabato">Sabato</option>
    			 <option value="Domenica">Domenica</option>
  			</select>
		  <h1> </h1>
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
			</tr>
			<%
			for (i = 0; i < l.size(); i = i+4){	
			%> 
			<tr>
		    <%
		    	String codAtt = l.get(i).toString();
		    	String nomeAtt = l.get(i+1).toString();
		   	 	String orarioAtt = l.get(i+2).toString();
		    	String prezzoAtt = l.get(i+3).toString();
		    %>
		    	<td><input type="radio" id="scelta" name="scelta" value="<%=j%>"> </td>
				<td style="width: 50%"><strong><%=codAtt%></strong></td>
            	<td style="width: 50%"><strong><%=nomeAtt%></strong></td>
				<td style="width: 50%"><strong><%=orarioAtt%></strong></td>
				<td style="width: 50%"><strong><%=prezzoAtt%></strong></td>
			</tr>		
			<% 
			j++;
			}
			%>
		  </table>
		  <input type="hidden" id="custList" name="custList" value="<%=l.size()%>"> 
          <h1> </h1>
          <h5>Inserire i valori da modificare, e successivamente premere il tasto Modifica.</h5>
          <h4>Orario:</h4>
          <input id="orario" name="orario" type="time" autocomplete="off" size="30" maxlength="30"/>
          <h1> </h1>
          <h4>Prezzo:</h4>
          <input id="prezzo" name="prezzo" type="number" autocomplete="off" size="30" maxlength="30"/>
          <h1> </h1>
		  <input type="submit" name="modifica" value="Modifica">
          <h1> </h1>		  
          <input type="submit" name="Indietro" value="Indietro">

        </div>
        <div class="col-sm">
          <h1> </h1>          
          <img src="./immagini/AttivitaSing1.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
	</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>
