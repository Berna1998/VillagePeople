
<!doctype html>

 <%@ page import= "logic.controller.InserisciAttivitaAdminController" %>
 <%@ page import= "java.sql.SQLException"%>
 <%@ page import= "java.sql.Connection"%>
 <%@ page import= "logic.model.dao.DataBaseClass" %>
 <%@ page import= "logic.model.dao.DataBaseFactory" %>
<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="AttivitaBean" scope="request" class="logic.bean.AttivitaBean"/>

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="AttivitaBean" property="*"/>

<html lang="en">
<%  Connection connessione = null;
    String type = "MySql";
    DataBaseFactory dbf = new DataBaseFactory();
    DataBaseClass db = dbf.getConnessione(type);
    connessione = db.openConnection();

	String codice=" ";
	
	if (request.getParameter("custIdGestAdm") != null) {
		codice=request.getParameter("custIdGestAdm");
	}else if (codice == null) {
		codice = request.getParameter("custAddAtt");
	}
    
    if (request.getParameter("aggAttivita") != null) {
    	if(request.getParameter("codice").equals("") || request.getParameter("nome").equals("") ||
    			request.getParameter("prezzo").equals("")) {
			 %>
			<p style="color: red">Compila tutti i campi</p>
			<%	    
    	}else if (request.getParameter("tipologia").equals("gruppo")&&request.getParameter("partecipanti").equals("0")){
			 %>
			<p style="color: red">Devi inserire i partecipanti dell'attività di gruppo</p>
			<%	 
    	}else {
    		InserisciAttivitaAdminController iaac = new InserisciAttivitaAdminController();
    		boolean risultato = false;
    		String categoria = request.getParameter("categorie");
    		String giorno = request.getParameter("giorno");
    		String tipologia = request.getParameter("tipologia");
    		if (categoria.equals("sport")){
    			AttivitaBean.setCategoria("Sport");
    		}
    		if (categoria.equals("saluteBenessere")){
    			AttivitaBean.setCategoria("Salute&Benessere");
    		}
    		if (categoria.equals("svagoRelax")){
    			AttivitaBean.setCategoria("Svago&Relax");
    		}
    		if (categoria.equals("bambini")){
    			AttivitaBean.setCategoria("Bambini");
    		}
    		if (giorno.equals("lunedi")){
    			AttivitaBean.setGiorno("Lunedi");
    		}
    		if (giorno.equals("martedi")){
    			AttivitaBean.setGiorno("Martedi");
    		}
    		if (giorno.equals("mercoledi")){
    			AttivitaBean.setGiorno("Mercoledi");
    		}
    		if (giorno.equals("giovedi")){
    			AttivitaBean.setGiorno("Giovedi");
    		}
    		if (giorno.equals("venerdi")){
    			AttivitaBean.setGiorno("Venerdi");
    		}
    		if (giorno.equals("sabato")){
    			AttivitaBean.setGiorno("Sabato");
    		}
    		if (giorno.equals("domenica")){
    			AttivitaBean.setGiorno("Domenica");
    		}
    		if (tipologia.equals("singolo")){
    			AttivitaBean.setTipologia("Singolo");
    		}
    		if (tipologia.equals("gruppo")){
    			AttivitaBean.setTipologia("Gruppo");
    		}

			try {
	    	    risultato = iaac.aggiungiAttivita(AttivitaBean, connessione);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connessione.close();
    	
       	 	if (risultato){  
 				%>
 				<p style="color: green">Attivita aggiunta</p>
 
 				<%	
       	 	}else{

				 %>
 				<p style="color: red">Attivita non aggiunta</p>

				<%	
        	}
    	}
    }
    
	if (request.getParameter("indietro")!=null) {
		%>		
		<jsp:forward page="GestisciAttivitaAdmin.jsp"/>
		<%
	}
%>

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
    <form action="AggiungiAttivita.jsp" name="formAggiungiAtt" method="POST">
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <img src="./immagini/AttivitaSing1.jpg" class="img-fluid" alt="...">
        </div>
        <div class="col-sm">
          <div class="card" style="width: 22rem;">
            <div class="card-body">
              <h5 class="card-title" style="text-align:center">Inserisci una nuova attività</h5>
              <h1> </h1>
    <%
    byte[] travB=codice.getBytes();
	//byte[] bytes=Base64.getEncoder().encode(travB);
	String encoded = new String(travB,"UTF-8");
    %>
              <input type="hidden" id="custAddAtt" name="custAddAtt" value="<%=codice.getBytes()%>">
              <label>Codice:</label>
              <input id="codice" name="codice" type="text" autocomplete="off" size="20" maxlength="20"/>
              <h1> </h1>
              <label>Nome:</label>
              <input id="nome" name="nome" type="text" autocomplete="off" size="20" maxlength="20"/>
              <h1> </h1>
              <label>Orario:</label>
              <input id="orario" name="orario" type="time" autocomplete="off" size="20" maxlength="20"/>
              <h1> </h1>
              <label>Prezzo:</label>
              <input id="prezzo" name="prezzo" type="number" autocomplete="off" size="20" maxlength="20"/>
              <h1> </h1>
              <label for="categorie">Categoria:</label>

              <select name="categorie" id="categorie">
                <option value="sport">Sport</option>
                <option value="svagoRelax">Svago&Relax</option>
                <option value="saluteBenessere">Salute&Benessere</option>
                <option value="bambini">Bambini</option>
              </select>
              <h1> </h1>
              <label for="giorno">Giorno:</label>

              <select name="giorno" id="giorno">
                <option value="lunedi">Lunedi'</option>
                <option value="martedi">Martedi'</option>
                <option value="mercoledi">Mercoledi'</option>
                <option value="giovedi">Giovedi'</option>
                <option value="venerdi">Venerdi'</option>
                <option value="sabato">Sabato</option>
                <option value="domenica">Domenica</option>
              </select>
              <h1> </h1>
              <label for="tipologia">Tipologia:</label>

              <select name="tipologia" id="tipologia">
                <option value="singolo">Singolo</option>
                <option value="gruppo">Gruppo</option>
              </select>
              <h1> </h1>
              <label>Partecipanti:</label>
              <input id="partecipanti" name="partecipanti" type="number" autocomplete="off" size="20" maxlength="20"/>
              <h1> </h1>
              <input type="submit" name="aggAttivita" value="Aggiungi Attivita">
              <h1> </h1>
              <input type="submit" name="indietro" value="Indietro">
            </div>
          </div>
        </div>
        <div class="col-sm">
          <img src="./immagini/AttivitaSing2.jpg" class="img-fluid" alt="...">
        </div>
      </div>
    </div>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

  </body>
</html>

