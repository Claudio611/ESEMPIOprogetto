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
	@SuppressWarnings("unchecked") 
	Vector<Studente> studenti= (Vector<Studente>) request.getAttribute("studenti");
%>

	

	<!-- Navigation-->
	<%@ include file="../frame_navigation.html"%> 
	
	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center">
		<div class="col-2"></div>
		<div class="col-6">
			<a href="RichiediAggiungiStudente"><button class="btn btn-secondary">NUOVO</button></a>
		</div>
		<div class="col-10"></div>
		
		<br>


		<div class="container col-7 d-flex align-items-center flex-column">

			<table class="table table-secondary table-hover ">
				<tr>
					<th>Matricola</th>
					<th>Nome</th>
					<th>Data di Nascita</th>
					<th>Cdl</th>
					<th>Modifica</th>
					<th>Elimina</th>
				</tr>

	<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // creo l'oggetto
    for (Studente s:studenti){
		String dataStr = sdf.format(s.getDataDiNascita()); 
		
		String modificaURL="RichiediModificaStudente?matricola="+s.getMatricola();
		String eliminaURL="EliminaStudente?matricola="+s.getMatricola();
		
		String cDL="Nessuno";
		if (s.getCdl() != null) 
			cDL=s.getCdl()+"";//qui potrei accedere al DB per avere il nome del CDL???
		
		
	%>
		<tr>
		<td style="text-align: center;"><%= s.getMatricola() %></td>
		<td style="text-align: center;"><%= s.getNome() %></td>
		<td style="text-align: center;"><%= dataStr %></td>
		<td style="text-align: center;"><%= cDL %></td>
		<td style="text-align: center;"><a href="<%=modificaURL%>"><button class="btn btn-secondary">MODIFICA</button></a></td>
		<td style="text-align: center;"><a href="<%=eliminaURL%>"><button class="btn btn-secondary">ELIMINA</button></a></td>
		</tr>
	<% } %>
			</table>
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
