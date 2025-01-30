<%-- 
    Document   : movie
    Created on : 30-ene-2025, 12:56:30
    Author     : diurno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <title>TMDB</title>
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
                    <form class="d-md-flex my-2 my-lg-0" onchange="this.form.submit()">
                        <input class="form-control me-sm-2 mb-1 mb-md-0" type="text" name="dni" placeholder="dni" />
                        <input class="form-control me-sm-2 mt-1 mt-md-0" type="text" name="nombre"
                            placeholder="nombre" />
                        <button class="btn btn-outline-success btn-dark my-2 my-sm-0" type="submit">
                            Login/Register
                        </button>
                    </form>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="container">
            <div class="row justify-content-center">
		    <c:forEach var="movie" items="${movies}">
<div class="col-lg-6 mt-3 d-flex">
                    <div class="card mb-3"> 
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="${movie.poster}" class="img-fluid h-100 rounded-start" alt="Card title" />
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">${movie.titulo}</h5>
                                    <p class="card-text">${movie.fecha}</p>
                                    <p class="card-text">${movie.trama}</p>
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
        <h1 class="text-success bg-dark lh-base text-center m-0 mt-2">The MovieDB - Azarquiel 2025</h1>
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>

</body>

</html>
