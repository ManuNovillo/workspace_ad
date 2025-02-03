<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">
<head>
    <title>Actores</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img class="img-fluid" src="img/logotmdb.png" alt="logo" width="100">
                </a>
                <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav me-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?op=actores">Person</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?op=movies">Movie</a>
                        </li>
                    </ul>
                    <c:choose>
                        <c:when test="${usuario == null}">
                            <button class="btn btn-outline-success my-2 my-sm-0" data-bs-toggle="modal" data-bs-target="#modalLogin">
                                Login
                            </button>
                        </c:when>
                        <c:otherwise>
                            <p class="text-white d-inline">Welcome ${usuario.nombre}</p>
                            <a href="Controller?op=logout&pagina=person" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </nav>
    </header>

    <main>
        <div class="container">
            <div class="row justify-content-center">
                <c:forEach var="actor" items="${actores}">
                    <div class="col-md-6 col-lg-4 mt-3 d-flex">
                        <div class="card p-0 pb-5">
                            <img class="card-img-top" src="https://image.tmdb.org/t/p/w500${actor.foto}" alt="Title" />
                            <div class="card-body text-center">
                                <c:forEach begin="1" end="${actor.media}">
                                    <span class="fs-2 fw-bold">&#9733</span>
                                </c:forEach>

                                <h3>${actor.nombre}</h3>
                                <span class="rating">
                                    <a href="Controller?op=rating&rating=1">&#9733;</a>
                                    <a href="Controller?op=rating&rating=2">&#9733;</a>
                                    <a href="Controller?op=rating&rating=3">&#9733;</a>
                                    <a href="Controller?op=rating&rating=4">&#9733;</a>
                                    <a href="Controller?op=rating&rating=5">&#9733;</a>
                                </span>
                                <div
                                    class="border-top start-0 position-absolute bottom-0 w-100 border-light-subtle border-1 bg-light py-2">
                                    <button class="btn btn-success text-white">
                                        Filmografía
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
    <footer>
        <h1 class="text-success bg-dark lh-base text-center m-0 mt-2">The MovieDB - Azarquiel 2025</h1>
    </footer>
    <!-- Modal trigger button -->
    <div class="modal fade" id="modalLogin" tabindex="-1" data-bs-keyboard="false" role="dialog"
        aria-labelledby="modalTitleId" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitleId">
                        Iniciar Sesión
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="Controller?op=login&pagina=person" method="post">
                    <div class="modal-body">
                        <input type="text" name="dni" placeholder="DNI">
                        <p class="form-text text-muted mt-2" data-bs-toggle="modal" data-bs-target="#modalSignIn">¿No tienes cuenta? Regístrate</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                            Cancelar
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Iniciar sesión
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalSignIn" tabindex="-1" data-bs-keyboard="false" role="dialog"
        aria-labelledby="modalTitleId" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitleId">
                        Registrarse
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="Controller?op=register&pagina=person" method="post">
                    <div class="modal-body">
                        <input type="text" name="dni" placeholder="DNI">
                        <input type="text" name="nombre" placeholder="Nombre">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                            Cancelar
                        </button>
                        <button type="submit" class="btn btn-primary">
                            Registrarse
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="position-fixed top-50 start-50 translate-middle">
    	<div id="loginResult" class="toast rounded-pill border-2 border-danger" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
            <div class="toast-body bg-light text-danger text-center rounded-pill">
                <h5>${mensaje}</h5>
            </div>
    	</div>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>

    <c:if test="${mensaje!=null}">
        <script type="text/javascript">
            const tostada = document.getElementById('loginResult')
            const toastBootstrap = bootstrap.Toast.getOrCreateInstance(tostada)
            toastBootstrap.show()
        </script>
    </c:if>

</body>

</html>