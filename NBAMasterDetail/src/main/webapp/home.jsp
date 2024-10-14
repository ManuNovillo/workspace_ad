<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<title>OpenWeather</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>

<body>
	<div class="container shadow p-0">
		<header class="bg-dark p-2">
			<div class="row justify-content-between align-items-center">
				<div class="col">
					<img src="img/logo1.svg" alt="">
				</div>
				<div class="col text-end">
					<img src="img/logo2.svg" alt="">
				</div>
			</div>
		</header>
		<main>
			<div class="row justify-content-center p-3">
				<c:forEach items="${teams}" var="team">
					<div class="col-4 col-md-3 col-xl-2 my-3 d-flex">
						<div class="card flex-fill">
							<a href="Controller?op=dameplayers&name=${team.name}"
								class="text-dark text-decoration-none"> <img
								class="card-img-top" src="${team.teamLogoUrl}" alt="Title" />
								<div class="card-body">
									<h4 class="card-title">${team.name}</h4>
								</div>
							</a>
						</div>
					</div>

				</c:forEach>
			</div>
			<c:if test="${not empty players}">
				<hr />
				<h2 class="text-center bg-dark text-white">Jugadores de ${name}</h2>
				<hr />
				<div class="row justify-content-center p-3">
					<c:forEach items="${players}" var="player">
						<div class="col-md-6 my-3 d-flex">
							<div class="card flex-fill">
								<div class="row">
									<div class="col-5">
										<img class="card-img-top" src="${player.headShotUrl }"
											alt="Title" />
									</div>
									<div class="col-7">
										<h4 class="card-title">${player.lastName}
											${player.firstName}</h4>
										<h6>Position: ${player.position}</h6>
										<h6>Birth Date: ${player.dateOfBirth}</h6>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</main>
		<footer>
			<h2 class="text-white text-center bg-dark p-2">&copy; Paco
				Pulido</h2>
		</footer>
	</div>

	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>
</html>