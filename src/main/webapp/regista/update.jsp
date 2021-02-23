<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
	<title>Modifica</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
<jsp:include page="../navbar.jsp" />

	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Modifica Regista</h5> 
		    </div>
		    <div class='card-body'>
		    
		    <div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		 							 ${errorMessage}
		  		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    		<span aria-hidden="true">&times;</span>
		  		</button>
			</div>
		    
		    		<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteUpdateRegistaServlet" >
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Nome <span class="text-danger">*</span></label>
								<input type="text" name="nome" id="nome" class="form-control" value="${registaDaModificare.nome}" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Cognome <span class="text-danger">*</span></label>
								<input type="text" name="cognome" id="cognome" class="form-control" value="${registaDaModificare.cognome}" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Nickname <span class="text-danger">*</span></label>
								<input type="text" class="form-control" name="nickName" id="nickName" value="${registaDaModificare.nickName}" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Nascita <span class="text-danger">*</span></label>
                        		<input class="form-control" id="dataDiNascita" type="date" value="${registaDaModificare.dataDiNascita}"
                            		title="formato : gg/mm/aaaa"  name="dataDiNascita" required>
							</div>
							<div class="form-group col-md-3">
								<label for="sesso">Sesso <span class="text-danger">*</span></label>
							    <select class="form-control" id="sesso" name="sesso" required>
							    	<option value=""> - Selezionare - </option>
							      	<option value="MASCHIO">M</option>
							      	<option value="FEMMINA">F</option>
							    </select>
							</div>
							
						</div>
							
						<input type="text" name="idRegista" id="idRegista" value="${registaDaModificare.id}" hidden>
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
	<script type="text/javascript">
	window.onload = function () {
		caricaSesso()
	}
	
	function caricaSesso() {
		document.getElementById('sesso').value = '${registaDaModificare.sesso}';
	}
	</script>
</body>
</html>