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
	<!-- Navigation-->
	<%@ include file="frame_navigation.html"%>

	<!-- Contact Section-->
	<section class="masthead page-section" id="contact">
		<div class="container">


			<!-- Contact Section-->
			<section class="page-section" id="contact">
				<div class="container">
					<!-- Contact Section Heading-->
					<h2
						class="page-section-heading text-center text-uppercase text-secondary mb-0">LOGIN</h2>
					<!-- Icon Divider-->
					<div class="divider-custom">
						<div class="divider-custom-line"></div>
						<div class="divider-custom-icon">
							<i class="fas fa-star"></i>
						</div>
						<div class="divider-custom-line"></div>
					</div>
					<!-- Contact Section Form-->
					<div class="row justify-content-center">
						<div class="col-lg-8 col-xl-7">
							<!-- * * * * * * * * * * * * * * *-->
							<!-- * * SB Forms Contact Form * *-->
							<!-- * * * * * * * * * * * * * * *-->
							<!-- This form is pre-integrated with SB Forms.-->
							<!-- To make this form functional, sign up at-->
							<!-- https://startbootstrap.com/solution/contact-forms-->
							<!-- to get an API token!-->
							<form id="contactForm" method="post" action="Login">
								<!-- Name input-->
								<div class="form-floating mb-3">
									<input class="form-control" id="username" name="username"
										type="text" placeholder="" data-sb-validations="required" />
									<label for="name">Username</label>
									<div class="invalid-feedback" data-sb-feedback="name:required">A
										username is required.</div>
								</div>
								<!-- Email address input-->
								<div class="form-floating mb-3">
									<input class="form-control" id="password" name="password"
										type="password" placeholder="" data-sb-validations="required" />
									<label for="password">Password</label>
									<div class="invalid-feedback" data-sb-feedback="email:required">A
										password is required.</div>

								</div>

								<!-- Submit Button-->
								<button class="btn btn-primary btn-xl" id="submitButton"
									type="submit">Send</button>
							</form>
						</div>
					</div>
				</div>
			</section>

			<%@ include file="/WEB-INF/footer.html"%>

			<%
			if (request.getParameter("errore") != null) {
				//l'alert viene eseguito dopo che la pagina è caricata
			%>
			<script>
				window.onload = function() {
					alert('Credenziali errate');

				};
			</script>
			<%
			}
			%>
		</div>
	</section>


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
