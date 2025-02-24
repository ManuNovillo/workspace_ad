<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %> -->

<!doctype html>
<html lang="en">

        <head>
                <title>Playas</title>
                <!-- Required meta tags -->
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

                <!-- Bootstrap CSS v5.2.1 -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        </head>

        <body>
                <div class="container shadow">
                        <header class="pt-2">
                                <div class="row align-items-center">
                                        <div class="col-4">
                                                <img src="img/logo.png" alt="">
                                        </div>
                                        <div class="col-8 text-end">
                                                <c:choose>
                                                    <c:when test="${usuario == null}">
                                                        <button class="btn btn-danger mb-3" data-bs-toggle="modal"
                                                                data-bs-target="#modalLogReg">
                                                                Login
                                                        </button>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="mb-2">
                                                                <p class="m-0 d-inline">Welcome ${usuario.nick}</p>
                                                                <a href="Controller?op=logout" class="btn btn-success">Logout</a>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>
                                                <div class="row">
                                                        <div class="col-lg-4">
                                                                <form action="Controller?op=comunidadSeleccionada" method="post">
                                                                        <select name="comunidadId" id="comunidadSelect" class="w-100"
                                                                                onchange="this.form.submit()">
                                                                                <option disabled selected value="">Elige una comunidad</option>
                                                                                <c:forEach var="comunidad" items="${comunidades}">
                                                                                    <option value="${comunidad.id}">${comunidad.nombre}</option>
                                                                                </c:forEach>
                                                                        </select>
                                                                </form>
                                                        </div>
                                                        <div class="col-lg-4 my-3 my-lg-0">
                                                                <form action="Controller?op=provinciaSeleccionada" method="post">
                                                                        <select name="provinciaId" id="provinciaSelect" class="w-100"
                                                                                onchange="this.form.submit()">
                                                                                <option disabled selected value="">Elige una provincia</option>
                                                                                <c:forEach var="provincia" items="${comunidadSeleccionada.provincias}">
                                                                                    <option value="${provincia.id}">${provincia.nombre}</option>
                                                                                </c:forEach>
                                                                        </select>
                                                                </form>
                                                        </div>
                                                        <div class="col-lg-4">
                                                                <form action="Controller?op=municipioSeleccionado" method="post">
                                                                        <select name="municipioId" id="municipioSelect" class="w-100"
                                                                                onchange="this.form.submit()">
                                                                                <option disabled selected value="">Elige un municipio</option>
                                                                                <c:forEach var="municipio" items="${provinciaSeleccionada.municipios}">
                                                                                    <option value="${municipio.id}">${municipio.nombre}</option>
                                                                                </c:forEach>
                                                                        </select>
                                                                </form>
                                                        </div>
                                                </div>
                                        </div>
                                </div>
                        </header>

                        <main>
                                <div class="row mt-3">
                                        <c:forEach var="playa" items="${municipioSeleccionado.playas}">
                                            <div class="col-lg-6 mb-3">
                                                    <div class="card h-100 pb-5">
                                                            <img class="card-img-top" src="img/playas/${playa.id}_${playa.imagenes[0].id}.jpg"
                                                                 alt="Title" />
                                                            <div class="card-body">
                                                                    <h4 class="card-title">${playa.nombre}</h4>
                                                                    <p class="card-text">${playa.descripcion}</p>
                                                            </div>
                                                            <c:if test="${usuario != null}">
                                                                <div class="position-absolute bottom-0 start-0 ms-2">
                                                                        <a href="#" data-bs-toggle="modal" data-bs-target="#modalReviews" data-bs-idPlaya="${playa.id}"><i
                                                                                    class="fa fa-info-circle fa-3x text-danger" aria-hidden="true"></i></a>
                                                                </div>
                                                                <div class="position-absolute bottom-0 end-0 me-2">
                                                                        <a href="Controller?op=loadDetail&idPlaya=${playa.id}"><i
                                                                                    class="fa fa-star-half-full fa-3x text-warning" aria-hidden="true"></i></a>
                                                                </div>
                                                            </c:if>
                                                    </div>
                                            </div>
                                        </c:forEach>
                                </div>
                        </main>

                        <footer>
                                <h1 class="text-center lh-base">Manuel Novillo &copy;</h1>
                        </footer>
                    <!-- Bootstrap JavaScript Libraries -->
                        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                                integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                        crossorigin="anonymous"></script>

                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                                integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                        crossorigin="anonymous"></script>

                        <script>
										    document.getElementById("comunidadSelect").value = '${comunidadSeleccionada.id}';
										    document.getElementById("provinciaSelect").value = '${provinciaSeleccionada.id}';
										    document.getElementById("municipioSelect").value = '${municipioSeleccionado.id}';
                        </script>

                        <div class="modal fade" id="modalLogReg" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false"
                             role="dialog" aria-labelledby="modalTitleId" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
                                        <div class="modal-content">
                                                <div class="modal-header">
                                                        <h5 class="modal-title" id="modalTitleId">
                                                                Login/Register
                                                        </h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <form action="Controller?op=logreg" method="post">
                                                        <div class="modal-body">
                                                                <label for="name">Nick</label>
                                                                <br>
                                                                <input type="text" name="nick" />
                                                                <br>
                                                                <label for="name">Password</label>
                                                                <br>
                                                                <input type="password" name="pass" />
                                                        </div>
                                                        <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                                        Close
                                                                </button>
                                                                <button type="submit" class="btn btn-primary">Save</button>
                                                        </div>
                                                </form>
                                        </div>
                                </div>
                        </div>
                        <div class="modal fade" id="modalReviews" tabindex="-1" data-bs-keyboard="false" role="dialog"
                             aria-labelledby="modalTitleId" aria-hidden="true">
                                <div class="modal-dialog modal-dialog-scrollable" role="document">
                                        <div class="modal-content">
                                                <div class="modal-header text-center">
                                                        <h5 class="modal-title" id="modalTitleId">
                                                                Calificación de la playa
                                                        </h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">

                                                </div>
                                                <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                                Close
                                                        </button>
                                                        <button type="button" class="btn btn-primary">Save</button>
                                                </div>
                                        </div>
                                </div>
                        </div>
                </div>

                <script type="text/javascript" src="myjs.js"></script>

        </body>

</html>