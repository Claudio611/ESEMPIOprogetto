<%@page import="it.unirc.txw.prototipo.beans.corso_di_laurea.CDL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.unirc.txw.prototipo.beans.studente.Studente"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Università  Bella</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">

	<%
	@SuppressWarnings("unchecked")  //Incluso per togliere il warning della prossima istruzione
	Vector<CDL> cdls= (Vector<CDL>) request.getAttribute("cdls");

	Studente studente=(Studente)request.getAttribute("studente");


	String action="AggiungiStudente";
	String matricola="";
	String disabled="";
	String nome="";
	String data="";
	Integer cdl=-1;

	if (studente!=null){
		action="ModificaStudente";
		matricola=studente.getMatricola()+"";
		disabled="readonly";
		nome=studente.getNome();
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd"); 
	    data=sdf.format(studente.getDataDiNascita());
		
	    cdl=studente.getCdl();
	}
%>







	<!-- Navigation-->
	<%@include file="/WEB-INF/privato/frame_navigation.html"%>

	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">Gestione
				studenti</h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Masthead Subheading-->
			<p class="masthead-subheading font-weight-light mb-5">Da qui puoi
				aggiungere uno studente.</p>

			<div class="container col-6">
				<form id="contactForm" action="<%=action%>">
					<!-- Name input-->
					<div class="form-floating mb-3">
						<input class="form-control" id="matricola" name="matricola"
							data-sb-validations="required" value="<%=matricola%>"
							<%=disabled%> /> <label for="matricola">Matricola</label>
						<div class="invalid-feedback"
							data-sb-feedback="matricola:required">La matricola è
							richiesta</div>
					</div>

					<div class="form-floating mb-3">
						<input class="form-control" id="nome" name="nome" type="text"
							data-sb-validations="required" value="<%=nome%>" /> <label
							for="Nome">Nome</label>
						<div class="invalid-feedback" data-sb-feedback="nome:required">Il
							nome è richiesto</div>
					</div>

					<div class="form-floating mb-3">
						<input class="form-control" id="data" name="data" type="date"
							data-sb-validations="required" value="<%=data%>" /> <label
							for="data">Data di nascita</label>
						<div class="invalid-feedback" data-sb-feedback="data:required">La
							data è richiesta</div>
					</div>

					<div class="form-floating mb-3">
						Corso di laurea: <select class="form-select" name="cdl" id="cdl">
							<option value="null">Nessuno</option>
							<%
									for (CDL c:cdls) {
																	String selected="";
																	if (cdl!=null && c.getId()==cdl)
																		selected="selected";
									%>

							<option value="<%=c.getId()%>" <%=selected%>><%= c.getNome() %></option>
							<% } %>
						</select>
					</div>


					<!-- Submit error message-->
					<!---->
					<!-- This is what your users will see when there is-->
					<!-- an error submitting the form-->
					<div class="d-none" id="submitErrorMessage">
						<div class="text-center text-danger mb-3">Errore nell'invio
							dei dati</div>
					</div>
					<!-- Submit Button-->
					<button class="btn btn-xl btn-secondary" id="submitButton"
						type="submit">INVIA</button>
				</form>
			</div>
		</div>
	</header>

	<%@ include file="/WEB-INF/footer.html"%>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
