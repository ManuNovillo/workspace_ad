<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="en">

<head>
    <title>Playa</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>

<body>
    <div class="container">
        <header class="bg-primary text-white text-center">
            <div class="container">
                <h1 class="display-2">${playa.nombre}</h1>
                <h1 class="display-2">
                    <img src="img/ccaa/ccaa_${comunidadSeleccionada.id}.png" width="200" alt="Bandera comunidad">
                    ${municipioSeleccionado.nombre} (${provinciaSeleccionada.nombre})
                    <img src="img/ccaa/ccaa_${comunidadSeleccionada.id}.png" width="200" alt="Bandera comunidad">
                </h1>
                <h3>${playa.descripcion}</h3>
                <hr class="text-black">
                <img src="img/caritas/ic_${playa.media}.png" alt="Carita">
            </div>
        </header>
        <main>
            <div id="carouselId" class="carousel slide my-3" data-bs-ride="carousel">
                <div class="carousel-inner" role="listbox">
                    <c:set var="i" value="1"/>
                    <c:forEach var="imagen" items="${playa.imagenes}">
                        <c:choose>
                            <c:when test="${i==1}">
                                <c:set var="i" value="2"/>
                                <div class="carousel-item active" data-bs-interval="3000">
                                    <img src="img/playas/${playa.id}_${imagen.id}.jpg" class="w-100 d-block" alt="First slide" />
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="carousel-item" data-bs-interval="3000">
                                    <img src="img/playas/${playa.id}_${imagen.id}.jpg" class="w-100 d-block" alt="First slide" />
                                </div>
                            </c:otherwise>
			</c:choose>
                    </c:forEach>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <div class="text-center mb-3">
                    
                <a href="">
                    <img src="img/caritas/ic_1.png" width="150" alt="">
                </a>
                <a href="">
                    <img src="img/caritas/ic_2.png" width="150" alt="">
                </a>
                <a href="">
                    <img src="img/caritas/ic_3.png" width="150" alt="">
                </a>
                <a href="">
                    <img src="img/caritas/ic_4.png" width="150" alt="">
                </a>
                <a href="">
                    <img src="img/caritas/ic_5.png" width="150" alt="">
                </a>
            </div>
        </main>

        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
    </div>
</body>

</html>