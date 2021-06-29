<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ page import="logic.controller.AttivitaController" %>
 <%@ page import="logic.controller.EliminaAttivitaController" %>
 <%@ page import="logic.controller.NotificheController" %>
 <%@ page import= "java.sql.SQLException"%>
 <%@ page import= "java.util.ArrayList"%>
 <%@ page import= "java.sql.Connection"%>
 <%@ page import="logic.model.dao.DataBaseClass" %>
 <%@ page import="logic.model.dao.DataBaseFactory" %>

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
		request.getSession().setAttribute("custIdElimAttAd", codiceId);
	 }
	
 	 String categoriaCus = " ";
 	 String giorniCus = " ";
 	 
 	 if((String)request.getSession().getAttribute("custCateg") !=null){
 		 categoriaCus = (String)request.getSession().getAttribute("custCateg");
 	 }
 	 
 	 if((String)request.getSession().getAttribute("custGiorno") != null){
 		 giorniCus = (String)request.getSession().getAttribute("custGiorno");
 	 }

     if (codiceId == null){
    	 codiceId = (String)request.getSession().getAttribute("custIdElimAttAd");
     }

     AttivitaController ac = new AttivitaController();
     EliminaAttivitaController eac = new EliminaAttivitaController();
     NotificheController nc = new NotificheController();
     ArrayList<Object> l = new ArrayList<>();
     int lenList = l.size();
     if (request.getSession().getAttribute("custList") != null) {
         if(lenList == 0){
        	 lenList = Integer.valueOf((request.getSession().getAttribute("custList")).toString());
         }
     }
     if (request.getParameter("cerca") != null) {
    	    String categoria = request.getParameter("categorie");
    	    String giorno = request.getParameter("giorno");
    	 	request.getSession().setAttribute("custCateg", categoria);
    	 	request.getSession().setAttribute("custGiorno", giorno);
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
     if (request.getParameter("elimina") != null){
    	 lenList = Integer.valueOf((request.getSession().getAttribute("custList")).toString());
    	 if (lenList == 0){
           	 %>
        	 <p style="color: red">Devi prima cercare le attivita'</p>
        	 <%	 
    	 } else if (request.getParameter("scelta") == null){
        	 %>
        	 <p style="color: red">Seleziona una delle attivita' mostrate</p>
        	 <%
    	 } else {
    		boolean risultato = false;
    		int m = Integer.parseInt(request.getParameter("scelta"));
    	 	int index = m*4;
    		String categoria = (String)request.getSession().getAttribute("custCateg");
    	 	String giorno = (String)request.getSession().getAttribute("custGiorno");
    	 	if (categoria.equals("Salute e Benessere")){
    	 		categoria = "Salute&Benessere";
    	 	} else if (categoria.equals("Svago e Relax")){
    	 		categoria = "Svago&Relax";
    	 	}
    		AttivitaBean.setCategoria(categoria);
    		AttivitaBean.setGiorno(giorno);
 	     	try {
 	     		connessione = db.openConnection();
 	     		ac.ricercaAttivita(AttivitaBean, l, connessione);
	     	} catch (SQLException e){
				e.printStackTrace();
		 	}    	     	 
    	 	double prezzo = Double.parseDouble(l.get(index+3).toString());   	 
    	 	String codiceAtt = l.get(index).toString();
    	 	AttivitaBean.setPrezzo(prezzo);
    	 	AttivitaBean.setCodice(Integer.parseInt(codiceAtt));
    	 	try{
    	 		risultato = eac.eliminaAttivita(AttivitaBean, connessione); 	    
    	 	}catch (SQLException e){
 				e.printStackTrace();
 		 	}  
    		String notificaSport = "ELIMINATA ATTIVITA DI SPORT CHE HAI PRENOTATO";
    		String notificaSvagoRelax = "ELIMINATA ATTIVITA DI SVAGO E RELAX CHE HAI PRENOTATO";
    		String notificaSaluteBenessere = "ELIMINATA ATTIVITA DI SALUTE E BENESSERE CHE HAI PRENOTATO";
    		String notificaBambini = "ELIMINATA ATTIVITA DI BAMBINI CHE HAI PRENOTATO";
    	 	if (categoria.equals("Sport")){
    			try {
    				nc.comunicaNotificaEliminaAttivita(notificaSport, 1, AttivitaBean.getCodice(), connessione);
    				ac.eliminaPrenotazioni(AttivitaBean.getCodice(), connessione);
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
	 		}else if (categoria.equals("Salute&Benessere")){
				try {
					nc.comunicaNotificaEliminaAttivita(notificaSaluteBenessere, 2, AttivitaBean.getCodice(), connessione);
					ac.eliminaPrenotazioni(AttivitaBean.getCodice(), connessione);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
	 		}else if (categoria.equals("Svago&Relax")){
				try {
					nc.comunicaNotificaEliminaAttivita(notificaSvagoRelax, 3, AttivitaBean.getCodice(), connessione);
					ac.eliminaPrenotazioni(AttivitaBean.getCodice(), connessione);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	 		}else if (categoria.equals("Bambini")){
				try {
					nc.comunicaNotificaEliminaAttivita(notificaBambini, 4, AttivitaBean.getCodice(), connessione);
					ac.eliminaPrenotazioni(AttivitaBean.getCodice(), connessione);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	 		}
    	 	connessione.close();
    	 	
    	 	%>
    	 		<p style="color: green">Attivita' Eliminata</p>    	 	
    	 	<%
     		
    	 }
     }
        
 	if(request.getParameter("Indietro") != null){
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
   <form action="EliminaAttivitaAdmin.jsp" name="formEliminaAttAdmin" method="POST">

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
          <h5>Seleziona l'attivita'  da eliminare:</h5>
          <label for="categorie">Seleziona categoria attivita':</label>

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
    				 <option value=" "> </option>
    			<% 
     			}else{
        	 		%>
   					 <option value="<%=giorniCus%>"><%=giorniCus%></option>
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
			for(i=0;i<l.size();i=i+4){	
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

		<h1></h1>
          <input type="submit" name="elimina" value="Elimina">
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