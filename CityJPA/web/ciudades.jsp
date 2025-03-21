<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

    <head>
        <title>Ciudades partrimonio de la humanidad en España</title>
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
            <header>
                <!-- place navbar here -->
                <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#"><img src="img/logo.png"
                                                              alt="Logo"></a>
                        <button class="navbar-toggler d-lg-none" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapsibleNavId"
                                aria-controls="collapsibleNavId" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="collapsibleNavId">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item"><a class="nav-link active fs-4"
                                                        href="#">Ciudades</a></li>
                                <li class="nav-item dropdown"><a
                                        class="nav-link dropdown-toggle active fs-4" href="#"
                                        id="dropdownId" data-bs-toggle="dropdown" aria-haspopup="true"
                                        aria-expanded="false">Rutas</a>
                                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                                        <c:forEach var="ciudad" items="${ciudadesConRutas}">
                                            <a class="dropdown-item" href="Controller?op=damerutas&ciudadId=${ciudad.id}">
                                                ${ciudad.nombre}
                                            </a>
                                        </c:forEach>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <main class="mt-3">
                <div class="container-fluid">
                    <div class="row justify-content-center">
                        <c:forEach var="ciudad" items="${ciudades}">
                            <div class="col-lg-6 mb-3">
                                <div class="card pb-5 h-100">
                                    <a href="${ciudad.link}" class="text-decoration-none"> <img
                                            class="card-img-top" src="${ciudad.imagen}" alt="Title" />
                                    </a>
                                    <div class="card-body position-relative">
                                        <h4 class="card-title">${ciudad.nombre}</h4>
                                        <p class="card-text">${ciudad.descripcion}</p>
                                    </div>
                                    <p>
                                        <img src="${ciudad.mapa}" width="100" alt=""
                                             class="position-absolute end-0 bottom-0">
                                    </p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </main>
            <footer class="p-4 bg-primary">
                <!-- place footer here -->
                <h2 class="text-white text-center">&copy; Manuel Novillo Romocea</h2>
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