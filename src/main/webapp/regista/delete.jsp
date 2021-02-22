<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
	<title>Visualizza elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		    
		    <div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		 							 ${errorMessage}
		  		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    		<span aria-hidden="true">&times;</span>
		  		</button>
			</div>
			<form method="post" action="ExecuteDeleteRegistaServlet">
		
		    <div class='card-body'>
				  	<dl class="row">
					  <dt class="col-sm-3 text-right">Nome:</dt>
					  <dd class="col-sm-9">${registaDaVisualizzare.nome}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Cognome:</dt>
					  <dd class="col-sm-9">${registaDaVisualizzare.cognome}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Nickname:</dt>
					  <dd class="col-sm-9">${registaDaVisualizzare.nickName}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Sesso:</dt>
					  <dd class="col-sm-9">${registaDaVisualizzare.sesso}</dd>
				   	</dl>
				    
				  </div>
				  <input type="text" name="idRegista" id="idRegista" value="${registaDaVisualizzare.id}" hidden>
				  
				  <div class='card-footer'>
		        <a href="ExecuteListRegistaServlet" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
		        <input type="submit" style='width:80px;' class='btn btn-outline-danger' value="Delete">
		        <i class='fa fa-chevron-right'></i>
		    </div>
		    </form>
		    </div>
		    </main>
</body>
</html>