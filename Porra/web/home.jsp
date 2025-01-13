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
			<c:choose>
				<c:when test="${usuario == null}">
				    <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalLogin">Login</button>
				</c:when>
				<c:otherwise>
					<div class="col-md-4">
						
					</div>
				</c:otherwise>
			</c:choose>
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
 <div class="modal fade" id="modalLogin" tabindex="-1" data-bs-keyboard="false" role="dialog"
        aria-labelledby="modalTitleId" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitleId">User Login</h5>
                </div>
                <div class="modal-body">
                    <form action="Controller?op=login" method="post">
                        <div class="mb-3">
                            <label for="" class="form-label">DNI</label>
                            <input type="text" class="form-control" name="dni" id="" aria-describedby="emailHelpId"
                                placeholder="12345678D" />
                            <small><a href="" data-bs-dismiss="modal" data-bs-toggle="modal" data-bs-target="#modalSignin">Registrarse</a></small>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Login</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modalSignin" tabindex="-1" data-bs-keyboard="false" role="dialog"
        aria-labelledby="modalTitleId" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitleId">Sign in</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="Controller?op=signin" method="post">
                        <div class="mb-3">
                            <label for="" class="form-label">DNI</label>
                            <input type="text" class="form-control" name="dni" id="" aria-describedby="emailHelpId"
                                placeholder="12345678D" />
                            <label for="" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="nombre" id="" aria-describedby="emailHelpId"
                                placeholder="perico" />
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Login</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Optional: Place to the bottom of scripts -->
    <script>
        const myModal = new bootstrap.Modal(
            document.getElementById("modalLogin"),
            options,
        );
    </script>
</body>

</html>