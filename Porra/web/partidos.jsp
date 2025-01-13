<%-- 
    Document   : partidos
    Created on : 13-ene-2025, 12:44:26
    Author     : diurno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <title>La liga</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="container shadow-lg p-0">
        <header class="bg-primary text-white py-2">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <img src="img/logoliga.png" alt="" class="img-fluid">
                </div>
                <div class="col-3 me-3 text-end">
                    <button class="btn btn-success">Login</button>
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-9 text-end">
                            <h3>Welcome Perico</h3>
                        </div>
                        <div class="col-3 text-start">
                            <a class="btn btn-danger" href="Controller?op=logout">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <main>
            <div class="row justify-content-center my-4">
                <div class="col-md-6">
                    <form action="Controller?op=vajornada" method="post">
                        <div>
                            <select class="form-select form-select-lg" name="jornada" id=""
                                onchange="this.form.submit()">
                                <option disabled selected>Seleccione jornada</option>
                                <option value="1">Jornada 1 (12/12/2019 - 13/12/2019)</option>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
            <section>
			<c:forEach var="partido" items="${partidos}">
                <div class="row border-secondary border-bottom align-items-center mb-5 mx-5">
                    		<div class="col text-start">
				<button class="btn btn-danger w-100">
				    <i class="fa fa-info-circle" aria-hidden="true"></i>
				</button>
			    </div>
			    <div class="col text-end"
				<img src="${partido.local.escudo}" alt="" width="100" class="img-fluid">
			    </div>
			    <div class="col text-end">
				<h3>${partido.local.nombre}</h3>
			    </div>
			    <div class="col text-center">
				<h2>${partido.goleslocal} - ${partido.golesvisitante}</h2>
			    </div>
			    <div class="col text-start">
				<h3>${partido.visitante.nombre}</h3>
			    </div>
			    <div class="col"><img src="${partido.visitante.escudo}" alt="" width="100" class="img-fluid">
			    </div>
			    <div class="col text-end">
				<button class="btn btn-danger w-100">Apostar</button>
			    </div>
                </div>
			</c:forEach>
            </section>
        </main>
        <footer class="py-2 bg-primary">
            <h1 class="text-center text-white m-0">&copy; Paco Pulido</h1>
        </footer>
    </div>

    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>

</body>

</html>
