<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="es">

<head>
<title>Alltriks</title>
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
	<div class="container shadow p-0">
		<header>
			<nav class="navbar navbar-expand-sm navbar-light bg-info">
				<div class="container">
					<img src="img/logo-white.png" alt="">
				</div>
			</nav>
		</header>
		<main>
			<div class="row justify-content-center align-items-center py-3">
				<div class="col-md-3 d-flex">
					<form action="Controller?op=vamarca" method="post">
						<select class="form-select" name="marca"
							onchange="this.form.submit()">
							<option selected disabled>Elija Marca</option>
							<option value="%">Todas</option>
							<c:forEach items="${marcas}" var="marca">
								<option value="${marca.id}">${marca.nombre}</option>
							</c:forEach>
						</select>
					</form>
				</div>
				<div class="col-md-3">
					<form action="Controller?op=vaorder" method="post">
						<select class="form-select" name="order"
							onchange="this.form.submit()">
							<option selected disabled>Ordenar por</option>
							<option value="null">Nada</option>
							<option value="precio asc">Precio Ascendente</option>
							<option value="precio desc">Precio Descendente</option>
							<option value="marca">Marca</option>
						</select>
					</form>
				</div>
				<div class="col-md-1">
					<a href="Controller?op=vafav" class="text-decoration-none"> <span
						class="text-warning fs-1">&#9733;</span>
					</a>
				</div>
			</div>
			<div class="container">
				<div class="row justify-content-center">
					<c:forEach items="${bicis}" var="bici">
						<div class="col-md-6 col-xl-4 my-3 d-flex">
							<div class="card flex-fill position-relative pb-5">
								<div class="row">
									<div>
										<img class="card-img-top" src="${bici.foto}" alt="Title" />
									</div>
									<div>
										<div class="card-body">
											<h4 class="card-title">${bici.nombreMarca}</h4>
											<p>${bici.descripcion}</p>
											<p>${bici.precio}</p>
											<c:choose>
												<c:when test="${fav == '1'}">
													<span class="text-secondary fs-1 position-absolute bottom-0 left-0 ms-2 mb-4">&#9733;</span>
												</c:when>
												<c:otherwise>
													<span class="text-warning fs-1 position-absolute bottom-0 left-0 ms-2 mb-4">&#9733;</span>
												</c:otherwise>
											</c:choose>
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</main>
		<footer>
			<div class="bg-info text-center text-white py-2">
				<h3>&copy; S2DAM</h3>
			</div>
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