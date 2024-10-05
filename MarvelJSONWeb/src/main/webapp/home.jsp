<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">

<head>
    <title>Marvel</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="css/style.css">
</head>

<body class="bg-dark fondo-marvel ">
	<div class="container opacity-90">

		<header class="text-center bg-black p-4">
			<div class="row justify-content-between align-items-center">
				<div class="col-md-4">
					<img class="img-fluid" src="img/logo.png" alt="" width="300">
				</div>
				<div class="col-md-4">
					<h1 class="text-white">MARVEL STUDIOS CHARACTERS</h1>
				</div>
				<div class="col-md-4">
					<h2
						><a class="text-decoration-none text-white" href="home.jsp">Inicio</a>
					</h2>
				</div>
			</div>
		</header>
		<main class="p-3 bg-dark">
			<div class="row">
				<c:forEach var="personaje" items="${personajes}">
					<div class="col-md-6 col-lg-4 d-flex mb-3">
					<a href="personaje.jsp?id=${personaje.id}" class="text-decoration-none w-100">
						<div class="card border-0 w-100">
							<img class="card-img-top img-fluid" style="height: 400px;"
								src="${personaje.thumbnail.picture}" alt="Title" />
							<div class="card-body bg-black">
								<h4 class="card-title text-white">${personaje.name}</h4>
							</div>
						</div>
					</a>
					</div>
				</c:forEach>
			</div>
		</main>
		<footer class="text-center bg-black p-4">
			<!-- place footer here -->
			<h2 class="text-white">&copy; Manuel Novillo Romocea</h2>
			<a href="#top"><i class="fa fa-arrow-circle-up fa-3x text-danger position-fixed bottom-0 end-0 m-3" aria-hidden="true"></i></a>
		</footer>
	</div>
	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>

</html>