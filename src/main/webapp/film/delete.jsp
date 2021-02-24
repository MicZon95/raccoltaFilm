<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
			<form method="post" action="ExecuteDeleteFilmServlet">
			
			<div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Titolo:</dt>
				  <dd class="col-sm-9">${filmDaEliminare.titolo}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Genere:</dt>
				  <dd class="col-sm-9">${filmDaEliminare.genere}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data Pubblicazione:</dt>
				  <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${filmDaEliminare.dataPubblicazione}" /></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Durata (min.):</dt>
				  <dd class="col-sm-9">${filmDaEliminare.minutiDurata}</dd>
		    	</dl>
		    	
		    	<!-- info Regista -->
		    	<p>
				  <a class="btn btn-primary btn-sm" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
				    Info Regista
				  </a>
				</p>
				<div class="collapse" id="collapseExample">
				  <div class="card card-body">
				  	<dl class="row">
					  <dt class="col-sm-3 text-right">Nome:</dt>
					  <dd class="col-sm-9">${filmDaEliminare.regista.nome}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Cognome:</dt>
					  <dd class="col-sm-9">${filmDaEliminare.regista.cognome}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Nickname:</dt>
					  <dd class="col-sm-9">${filmDaEliminare.regista.nickName}</dd>
				   	</dl>
				   	<dl class="row">
					  <dt class="col-sm-3 text-right">Sesso:</dt>
					  <dd class="col-sm-9">${filmDaEliminare.regista.sesso}</dd>
				   	</dl>
				    
				  </div>
				</div>
				<!-- end info Regista -->
		    	
		    </div>
		    
		     <input type="text" name="idFilm" id="idFilm" value="${filmDaEliminare.id}" hidden>
				  
				  <div class='card-footer'>
		        <a href="ExecuteListFilmServlet" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
		        <input type="submit" style='width:80px;' class='btn btn-outline-danger' value="Delete">
		        <i class='fa fa-chevron-right'></i>
		    </div>
			
			</form>
		    </div>
<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
</body>
</html>