<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="es">

<head>
<title>Title</title>
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
</head>

<body>
	<div class="container">
		<header class="bg-primary p-3">
			<!-- place navbar here -->
			<img src="img/logo-white.png" class="img-fluid" alt="logo">
		</header>
		<main class="mt-3">
			<div class="row">
				<div class="col-4">
					<div class="dropdown">
						<button class="btn btn-light dropdown-toggle" type="button"
							id="triggerId" data-bs-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Marca</button>
						<div class="dropdown-menu" aria-labelledby="triggerId">
							<c:forEach var="marca" items="${marcas}">
								<a class="dropdown-item" href="#">${marca.nombre}</a>
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="col-4">
					<div class="dropdown">
						<button class="btn btn-light dropdown-toggle" type="button"
							id="triggerId" data-bs-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Ordenar por</button>
						<div class="dropdown-menu" aria-labelledby="triggerId">
							<a class="dropdown-item" href="#">Precio descendiente</a> <a
								class="dropdown-item" href="#">Precio ascendente</a> <a
								class="dropdown-item" href="#">Marca</a>
						</div>
					</div>
				</div>
				<div class="col-4">
					<a href="" class="display-2 text-decoration-none">&#9733;</a>
				</div>
			</div>
			<div class="row">
				<c:forEach var="bici" items="${bicis}">
					<div class="col-md-6 col-lg-4 mb-2">
						<div class="card">
							<img class="card-img-top" src="${bici.foto}" alt="Title" />
							<div class="card-body">
								<h4 class="card-title">${bici.marca.nombre}</h4>
								<p class="card-text">${bici.descripcion}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</main>
		<footer>
			<!-- place footer here -->
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