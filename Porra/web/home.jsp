<%-- 
    Document   : home
    Created on : 09-ene-2025, 13:49:33
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
				<c:forEach var="jornada" items="${jornadas}">
					<option value="${jornada.idjornada}">
						${jornada.nombre} ${jornada.fechainicio} - ${jornada.fechafin}
					</option>
				</c:forEach>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
            <section>
                <section class="px-5 pb-5">
                    <img src="img/fotoliga.jpg" alt="" class="img-fluid w-100">
                </section>
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