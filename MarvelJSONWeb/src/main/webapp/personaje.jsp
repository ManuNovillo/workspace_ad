<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="es">
<c:forEach var="personaje" items="${personajes}">
	<c:if test="${param.id == personaje.id}">
		<head>
			<title>${personaje.name}</title>
			<!-- Required meta tags -->
			<meta charset="utf-8" />
			<meta name="viewport"
				content="width=device-width, initial-scale=1, shrink-to-fit=no" />
			
			<!-- Bootstrap CSS v5.2.1 -->
			<link
				href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
				rel="stylesheet"
				integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
				crossorigin="anonymous" />
			<link rel="stylesheet" href="css/style.css" />
		</head>

		<body class="bg-dark fondo-marvel d-flex flex-column min-vh-100">
			<div class="container opacity-90 d-flex flex-column flex-grow-1">
				<header class="text-center bg-black p-4">
					<div class="row justify-content-between align-items-center">
						<div class="col-md-4">
							<img class="img-fluid" src="img/logo.png" alt="" width="300">
						</div>
						<div class="col-md-4">
							<h1 class="text-white">${personaje.name}</h1>
						</div>
						<div class="col-md-4">
							<h2>
								<a class="text-decoration-none text-white" href="home.jsp">Inicio</a>
							</h2>
						</div>
					</div>
				</header>
				<main class="pt-3 bg-dark">
					<div class="row text-white w-100">
						<div class="col-4">
							<img src="${personaje.thumbnail.picture}" alt="" class="img-fluid"
								width="500px">
						</div>
						<div class="col-8">
							<h3>Descripción:</h3>
							<p class="fs-5">${personaje.description}</p>
							<h3>Cómics en los que aparece:</h3>
							<c:forEach var="comic" items="${personaje.comics.items}">
								<p class="fs-5">${comic.name}</p>
							</c:forEach>

						</div>
					</div>
				</main>
				<footer class="bg-black text-center p-3 mt-auto">
					<h2 class="text-white">&copy; Manuel Novillo Romocea</h2>
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
	</c:if>

</c:forEach>
</html>