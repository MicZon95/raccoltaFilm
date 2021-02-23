<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
	<title>Inserisci nuovo</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Inserisci nuovo elemento</h5> 
		    </div>
		    <div class='card-body'>

					<form method="post" action="ExecuteUpdateFilmServlet" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Titolo</label>
								<input type="text" name="titolo" id="titolo" class="form-control" value="${filmDaModificare.titolo}" >
							</div>
							
							<div class="form-group col-md-6">
								<label>Genere</label>
								<input type="text" name="genere" id="genere" class="form-control" value="${filmDaModificare.genere}" >
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Data di Pubblicazione</label>
                        		<input class="form-control" id="dataPubblicazione" type="date" name="dataPubblicazione"
                            		value = "<fmt:formatDate type="date" value="${filmDaModificare.dataPubblicazione}" pattern="yyyy-MM-dd" />">
							</div>
							<div class="form-group col-md-6">
								<label>Durata (minuti)</label>
								<input type="number" class="form-control" name="minutiDurata" id="minutiDurata" value="${filmDaModificare.minutiDurata}" >
							</div>
						</div>
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label for="regista.id">Regista</label>
							    <select class="form-control" id="regista.id" name="regista.id">
							    	<option value=""> -- Selezionare una voce -- </option>
							      	<c:forEach items="${registi_list_attribute }" var="registaItem">
							      		<option value="${registaItem.id}">${registaItem.nome } ${registaItem.cognome }</option>
							      	</c:forEach>
							    </select>
							</div>
						</div>
							<input type="text" name="idFilm" id="idFilm" value="${filmDaModificare.id}" hidden>
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
						<a href="ExecuteListFilmServlet" class='btn btn-outline-secondary' style='width:80px'>
		            		<i class='fa fa-chevron-left'></i> Back
		        		</a>
						
					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
<body>

</body>
</html>