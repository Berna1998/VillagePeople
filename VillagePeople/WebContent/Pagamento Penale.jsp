<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="logic.controller.EliminaPrenotazioneController" %>
<%@ page import="logic.controller.NotificheController" %>
<%@ page import= "java.sql.SQLException"%>
<%@ page import= "java.util.Random"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "logic.model.dao.DataBaseClass" %>
<%@ page import = "logic.model.dao.DataBaseFactory" %>

<!-- dichiarazione e instanziazione di un loginBean !-->
<jsp:useBean id="UtenteBean" scope="request" class="logic.bean.UtenteBean"/>
<jsp:useBean id="AttivitaBean" scope="request" class="logic.bean.AttivitaBean"/>
<!-- mappare gli attributi di un oggetto sui campi della form -->

<%  
   Connection connessione = null;
   String type = "MySql";
   DataBaseFactory dbf = new DataBaseFactory();
   DataBaseClass db = dbf.getConnessione(type);
   connessione = db.openConnection();
	String codiceId = request.getParameter("custIdElimPret");

	if (codiceId!= null){
		request.getSession().setAttribute("custIdPenale", codice);
	}
	
	if (codiceId == null || codiceId.equals("")) {
		codiceId = (String)request.getSession().getAttribute("custIdPenale");
	}

	String codGen = request.getParameter("custCodPenale");

	if (codGen!= null){
		request.getSession().setAttribute("custGenerato", codGen);
	}
	
	if(codGen == null){
		codGen = (String)request.getSession().getAttribute("custGenerato");
	}

	String penale = request.getParameter("custPenale");
	String codAtt = request.getParameter("custCodAtt");
	String prezzoAtt = request.getParameter("custPrezzo");
	
	if (penale!= null){
		request.getSession().setAttribute("custPenCosto", penale);
	}
	if (codAtt!= null){
		request.getSession().setAttribute("custAttPenale", codAtt);
	}
	if (prezzoAtt!= null){
		request.getSession().setAttribute("custPrezPenale", prezzoAtt);
	}
	
	if (penale == null){
		penale = (String)request.getSession().getAttribute("custPenCosto");
	}
	if (codAtt == null){
		codAtt = (String)request.getSession().getAttribute("custAttPenale");
	}
	if (prezzoAtt == null){
		prezzoAtt = (String)request.getSession().getAttribute("custPrezPenale");		
	}
	

	EliminaPrenotazioneController epc = new EliminaPrenotazioneController();
	NotificheController nc = new NotificheController();
	
	if(request.getParameter("eliminaPren") != null){

			boolean risultato = false;
			double budget = epc.cercaBudget(codiceId, connessione);
    		double prezzo = Double.parseDouble(prezzoAtt);   	 
    		double budgetN = budget + prezzo;
			UtenteBean.setBudget(budgetN);
			UtenteBean.setCodiceID(codiceId);
			AttivitaBean.setCodice(Integer.parseInt(codAtt));
			try{
				risultato = epc.eliminaPrenotazione(UtenteBean, AttivitaBean, connessione); 	    
			}catch (SQLException e){
		   			e.printStackTrace();
			} 
		
			String notificaPenale = "DEVE PAGARE UNA PENALE IL CLIENTE: ";
			notificaPenale = notificaPenale.concat(codiceId);
			try {
				nc.comunicaNotificaPenale(notificaPenale, connessione);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connessione.close();

	 		%>
	 		<p style="color: green">Prenotazione Rimossa</p>
	 		<%
		
	}

	if(request.getParameter("indietro") != null){
		%>		
		<jsp:forward page="EliminaPrenotazione.jsp"/>
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
  <body style="background-color: â€#CCCCCCâ"€>
    <nav class="navbar navbar-light" style="background-color: #ffffff;">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">
            <img src="./immagini/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">
            Village People
          </a>
        </div>
    </nav>
    <h1> </h1>
    <form action="Pagamento Penale.jsp" name="formPenale" method="POST">
  
    <div class="container">
      <div class="row">
        <div class="col-sm">
      
        </div>
        <div class="col-sm">
          <div class="card" style="width: 34rem;">
            <img src="./immagini/cancellaprenotazione1.jpg" class="img-fluid" alt="...">
            <div class="card-body">
              <h3 class="card-title" style="text-align:center">Cancellazione Prenotazione</h3>
              <p class="card-text">La cancellazione della prenotazione non è possibile poiché l'attività  si svolge in data odierna. E' possibile procedere comunque con la cancellazione con il pagamento di una penale.
              </p>
              <h1> </h1>
              <h6>Codice Attivita':</h6>
              <label for="codGen"><%=codAtt%></label>
              <h1> </h1>
              <h6>Prezzo Attivita':</h6>
              <label for="codGen"><%=prezzoAtt%></label>
              <h1> </h1>
              <h6>Costo Penale:</h6>
              <label for="codGen"><%=penale%></label>
              <h1> </h1>
              <h6>Codice Utente:</h6>
              <label for="codGen"><%=codiceId%></label>
              <h1> </h1>
              <h6>Il pagamento della penale può essere effettuato alla cassa, stampando il relativo codice, oppure tramite PayPal o carta di credito.</h6>
              
              <h1> </h1>
              <div id="smart-button-container">
                <div><label for="description">Codice Penale: </label><input type="text" name="descriptionInput" id="description" maxlength="127" value="<%=codGen%>" readonly></div>
                  <p id="descriptionError" style="visibility: hidden; color:red; text-align: center;">Inserire codice penale</p>
                <div style="text-align: center"><label for="amount">Importo: </label><input name="amountInput" type="number" id="amount" value="<%=penale%>" readonly><span> EUR</span></div>
                  <p id="priceLabelError" style="visibility: hidden; color:red; text-align: center;">Inserire un prezzo</p>
                <div id="invoiceidDiv" style="text-align: center; display: none;"><label for="invoiceid"> </label><input name="invoiceid" maxlength="127" type="text" id="invoiceid" value="" ></div>
                  <p id="invoiceidError" style="visibility: hidden; color:red; text-align: center;">Please enter an Invoice ID</p>
                <div style="text-align: center; margin-top: 0.625rem;" id="paypal-button-container"></div>
              </div>
              <script src="https://www.paypal.com/sdk/js?client-id=sb&currency=EUR" data-sdk-integration-source="button-factory"></script>
              <script>
              function initPayPalButton() {
                var description = document.querySelector('#smart-button-container #description');
                var amount = document.querySelector('#smart-button-container #amount');
                var descriptionError = document.querySelector('#smart-button-container #descriptionError');
                var priceError = document.querySelector('#smart-button-container #priceLabelError');
                var invoiceid = document.querySelector('#smart-button-container #invoiceid');
                var invoiceidError = document.querySelector('#smart-button-container #invoiceidError');
                var invoiceidDiv = document.querySelector('#smart-button-container #invoiceidDiv');
            
                var elArr = [description, amount];
            
                if (invoiceidDiv.firstChild.innerHTML.length > 1) {
                  invoiceidDiv.style.display = "block";
                }
            
                var purchase_units = [];
                purchase_units[0] = {};
                purchase_units[0].amount = {};
            
                function validate(event) {
                  return event.value.length > 0;
                }
            
                paypal.Buttons({
                  style: {
                    color: 'gold',
                    shape: 'pill',
                    label: 'pay',
                    layout: 'vertical',
                    
                  },
            
                  onInit: function (data, actions) {
                    //actions.disable();
            
                    if(invoiceidDiv.style.display === "block") {
                      elArr.push(invoiceid);
                    }
            
                    elArr.forEach(function (item) {
                      item.addEventListener('keyup', function (event) {
                        var result = elArr.every(validate);
                        if (result) {
                          actions.enable();
                        } else {
                          actions.disable();
                        }
                      });
                    });
                  },
            
                  onClick: function () {
                    if (description.value.length < 1) {
                      descriptionError.style.visibility = "visible";
                    } else {
                      descriptionError.style.visibility = "hidden";
                    }
            
                    if (amount.value.length < 1) {
                      priceError.style.visibility = "visible";
                    } else {
                      priceError.style.visibility = "hidden";
                    }
            
                    if (invoiceid.value.length < 1 && invoiceidDiv.style.display === "block") {
                      invoiceidError.style.visibility = "visible";
                    } else {
                      invoiceidError.style.visibility = "hidden";
                    }
            
                    purchase_units[0].description = description.value;
                    purchase_units[0].amount.value = amount.value;
            
                    if(invoiceid.value !== '') {
                      purchase_units[0].invoice_id = invoiceid.value;
                    }
                  },
            
                  createOrder: function (data, actions) {
                    return actions.order.create({
                      purchase_units: purchase_units,
                    });
                  },
            
                  onApprove: function (data, actions) {
                    return actions.order.capture().then(function (details) {
                      alert('Transaction completed by ' + details.payer.name.given_name + '!');
                    });
                  },
            
                  onError: function (err) {
                    console.log(err);
                  }
                }).render('#paypal-button-container');
              }
              initPayPalButton();
              </script>
            </div>
             <input type="submit" name="eliminaPren" value="Elimina Prenotazione">
            <h1></h1>
             <input type="submit" name="indietro" value="Indietro">
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

