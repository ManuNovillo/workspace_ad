<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="es">
<head>
<title>${lugar.titre}</title>
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
	<header>
		<!-- place navbar here -->
	</header>
	<main>
		<div id="carouselId" class="carousel slide" data-bs-ride="carousel">
			<ol class="carousel-indicators list-unstyled">
				<c:set var="i" value="0" />
				<c:forEach var="photo" items="${lugar.photos}">
				<c:choose>
					<c:when test="${i==0}">
						 <li
                        data-bs-target="#carouselId"
                        data-bs-slide-to="0"
                        class="active"
                        aria-current="true"
                        aria-label="First slide"
                    ></li>
					</c:when>
					<c:otherwise>
						<li data-bs-target="#carouselId" data-bs-slide-to="${i}"
						aria-label="slide"></li>
					</c:otherwise>
				</c:choose>
					<c:set var="i" value="${i+1}" />
				</c:forEach>
			</ol>
			<div class="carousel-inner" role="listbox">
				<c:set var="c" value="0" />
				<c:forEach var="photo" items="${lugar.photos}">
					<c:choose>
						<c:when test="${c==0}">
							<div class="carousel-item active">
								<img src="${photo.link_large}" class="w-100 d-block"
									alt="Second slide" />
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img src="${photo.link_large}" class="w-100 d-block"
									alt="Second slide" />
							</div>
						</c:otherwise>
					</c:choose>
					<c:set var="c" value="${c+1}" />
				</c:forEach>


			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselId" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselId" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

	</main>
	<footer>
		<!-- place footer here -->
	</footer>
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
