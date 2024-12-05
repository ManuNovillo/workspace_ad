<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<title>Turismo CLM</title>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="container shadow">
		<header>
			<!-- place navbar here -->
			<div class="row justify-content-between align-items-center">
				<div class="col-2">
					<a href="Controller?op=inicio"> <img src="img/logo.png"
						alt="logo" class="img-fluid"></a>
				</div>
				<div class="col-2 text-end">
					<c:choose>
						<c:when test="${fav == '%'}">
							<a href="Controller?op=fav"><i
								class="fa text-secondary fa-heart fa-2x" aria-hidden="true"></i></a>
						</c:when>
						<c:otherwise>
							<a href="Controller?op=fav"><i
								class="fa text-rosa fa-heart fa-2x" aria-hidden="true"></i></a>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</header>
		<main class="mt-3">
			<video src="videos/video.mp4" controls class="w-100"></video>
			<div class="container mt-3">
				<div class="row">
					<div class="col-8 p-0">
						<img src="img/molinos.jpg" alt="" class="img-fluid w-100 h-100">
					</div>
					<div
						class="col-4 d-flex flex-column justify-content-between m-0 ps-2 bg-rosa text-white ">
						<c:forEach var="provincia" items="${provincias}">
							<h3 class="py-2">
								<a class="text-decoration-none text-white"
									href="Controller?op=provincia&provinciaid=${provincia.id}">${provincia.nombre}
								</a>
							</h3>
						</c:forEach>
					</div>
				</div>
				<section class="mt-3">
					<div class="row">
						<c:forEach var="categoria" items="${categorias}">
							<div class="col-md-6 mb-3">
								<div class="card bg-dark text-white border-0">
									<a class="text-white"
										href="Controller?op=categoria&categoriaid=${categoria.id}">
										<img src="${categoria.imagen}" class="card-img img-fluid"
										alt="${categoria.nombre}">
										<div class="card-img-overlay opacity-75">
											<h5 class="card-title text-center bg-rosa py-3">${categoria.nombre}</h5>
										</div>
									</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</section>
				<section class="my-3">
					<div class="row justify-content-between align-items-center">
						<div class="col">
							<c:choose>
								<c:when test="${nombreCategoria != null}">
									<h2>${nombreCategoria}</h2>
								</c:when>
								<c:otherwise>
									<h2>Todas las categorías</h2>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col text-end">
							<c:choose>
								<c:when test="${nombreProvincia != null}">
									<h2>${nombreProvincia}</h2>
								</c:when>
								<c:otherwise>
									<h2>CLM</h2>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="row justify-content-center mt-2">
						<c:forEach var="lugar" items="${lugares}">
							<div class="col-6 col-md-4 col-xl-3 mb-3">
								<div class="card bg-dark text-white border-0">
									<img src="${lugar.imagen}" class="card-img"
										alt="${lugar.nombre}">
									<div class="card-img-overlay m-0 p-0">
										<h5 class="card-title text-center bg-dark py-3 px-2">${lugar.nombre}</h5>
									</div>
									<c:choose>
										<c:when test="${lugar.fav == 1}">
											<a
												href="Controller?op=lugarfav&lugarid=${lugar.id}&currfav=${lugar.fav}"
												class="position-absolute end-0 bottom-0 m-2 p-2 opacity-75 rounded-circle bg-white">
												<i class="fa fa-heart text-rosa fa-2x" aria-hidden="true"></i>
											</a>
										</c:when>
										<c:otherwise>
											<a
												href="Controller?op=lugarfav&lugarid=${lugar.id}&currfav=${lugar.fav}"
												class="position-absolute end-0 bottom-0 m-2 p-2 opacity-75 rounded-circle bg-white">
												<i class="fa fa-heart text-secondary fa-2x"
												aria-hidden="true"></i>
											</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</c:forEach>
					</div>
				</section>
			</div>
		</main>
		<footer class="py-2 bg-rosa text-center">
			<!-- place footer here -->
			<h2 class="text-white">
				Turismo CLM <i class="fa fa-instagram mx-2" aria-hidden="true"></i>
				<i class="fa mx-2 fa-facebook" aria-hidden="true"></i> <i
					class="fa mx-2 fa-twitter" aria-hidden="true"></i>
			</h2>
		</footer>

		<div class="position-fixed top-50 start-50 translate-middle">
			<div id="tostada" class="toast rounded-pill border-2 border-danger"
				role="alert" aria-live="assertive" aria-atomic="true"
				data-bs-delay="2000">
				<div
					class="toast-body bg-light text-danger text-center rounded-pill">
					<h5>Fav ${lugarActualizado} ${estadoLugarActualizado}</h5>
				</div>
			</div>
		</div>
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

	<c:if test="${lugarActualizado!=null}">
		<script type="text/javascript">
			const tostada = document.getElementById('tostada')
			const toastBootstrap = bootstrap.Toast.getOrCreateInstance(tostada)
			toastBootstrap.show()
		</script>
	</c:if>
</body>

</html>