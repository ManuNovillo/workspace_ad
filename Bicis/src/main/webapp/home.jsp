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
			<div class="row align-items-center">
				<div class="col-4">
					<form action="Controller?op=marca&m" method="post">
                        <select class="form-select w-100 mb-3" name="marca" onchange="this.form.submit()">
                            <option selected disabled>Elige marca</option>
                            <option value="%" selected>Todas</option>
                           	<c:forEach var="marca" items="${marcas}">
                           		<option value="${marca.id}">${marca.nombre}</option>
                           	</c:forEach>
                        </select>
                    </form>
				</div>
				<div class="col-4">
					 <form action="Controller?op=order" method="post">
                        <select class="form-select w-100 mb-3" name="order" onchange="this.form.submit()">
                            <option selected>Ordenar por</option>
                            <option value="null">Sin orden</option>
                            <option value="precio asc">Precio Ascendente</option>
                            <option value="precio desc">Precio Descendente</option>
                            <option value="marca">Marca</option>
                        </select>
                    </form>
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