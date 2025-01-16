<%-- 
    Document   : home
    Created on : 09-ene-2025, 13:49:32
    Author     : diurno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <script language="javascript" type="text/javascript">
						function setSelected(lista, valor) {
                            console.log("AAAA")
								for (i = 0; i < lista.options.length; i++) {
										if (lista.options[i].value == valor) {
												lista.options[i].selected = true;
                            console.log("BBBBBBB")
										}
								}
						}
                    </script>
                <div class="container shadow-lg p-0">
                        <header class="bg-primary text-white py-2">
                                <div class="row align-items-center">
                                        <div class="col-md-8">
                                                <img src="img/logoliga.png" alt="" class="img-fluid">
                                        </div>
                                        <c:choose>
                                            <c:when test="${usuario==null}">
                                                <div class="col-3 me-3 text-end">
                                                        <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalLogin">Login</button>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="col-md-4">
                                                        <div class="row">
                                                                <div class="col-9 text-end">
                                                                        <h3>Welcome ${usuario.nombre}</h3>
                                                                </div>
                                                                <div class="col-3 text-start">
                                                                        <a class="btn btn-danger" href="Controller?op=logout">Logout</a>
                                                                </div>
                                                        </div>
                                                </div>  
                                            </c:otherwise>
                                        </c:choose>


                                </div>
                        </header>
                        <main>
                                <div class="row justify-content-center my-4">
                                        <div class="col-md-6">
                                                <form action="Controller?op=vajornada" method="post" id="partidos">
                                                        <div>
                                                                <select class="form-select form-select-lg" name="jornada" id="jornada"
                                                                        onchange="this.form.submit()">
                                                                        <option disabled selected>Seleccione jornada</option>
                                                                        <c:forEach items="${jornadas}" var="jornada">
                                                                            <option value="${jornada.idjornada}">${jornada.nombre} (${jornada.fechainicio} - ${jornada.fechafin})</option>
                                                                        </c:forEach>
                                                                </select>
                                                        </div>
                                                </form>
                                                <script type="text/javascript">
													setSelected(document.forms.partidos.jornada, '${jornada}')
                                                </script>
                                        </div>
                                </div>
                                <c:choose>
                                    <c:when test="${partidos != null}">
                                        <section>
                                                <c:forEach items="${partidos}" var="partido">
                                                    <div class="row border-secondary border-bottom align-items-center mb-5 mx-5">
                                                            <c:if test="${usuario!=null}">
                                                                <div class="col text-start">
                                                                        <button class="btn btn-danger w-100">
                                                                                <i class="fa fa-info-circle" aria-hidden="true"></i>
                                                                        </button>
                                                                </div>
                                                            </c:if>
                                                            <div class="col text-end">
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
                                                            <c:if test="${usuario!=null}">
                                                                <div class="col text-end">
                                                                        <button class="btn btn-danger w-100" data-bs-toggle="modal" data-bs-target="#modalApuesta" data-bs-local="${partido.local.nombre}" data-bs-partido="${partido.idpartido}" data-bs-visitante="${partido.visitante.nombre}">Apostar</button>
                                                                </div>
                                                            </c:if>
                                                    </div>
                                                </c:forEach>
                                        </section>
                                    </c:when>	
                                    <c:otherwise>
                                        <section>
                                                <section class="px-5 pb-5">
                                                        <img src="img/fotoliga.jpg" alt="" class="img-fluid w-100">
                                                </section>
                                        </section>
                                    </c:otherwise>

                                </c:choose>
                        </main>
                        <footer class="py-2 bg-primary">
                                <h1 class="text-center text-white m-0">&copy; Paco Pulido</h1>
                        </footer>
                </div>
                <!-- Modales -->
                <div class="modal fade" id="modalLogin" tabindex="-1" data-bs-keyboard="false" role="dialog"
                     aria-labelledby="modalTitleId" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
                                <div class="modal-content">
                                        <div class="modal-header">
                                                <h5 class="modal-title" id="modalTitleId">
                                                        User Login
                                                </h5>
                                        </div>
                                        <form action="Controller?op=login" method="post">
                                                <div class="modal-body">
                                                        <div class="mb-3">
                                                                <p><input type="text" class="form-control" name="dni" id="" aria-describedby="emailHelpId"
                                                                          placeholder="dni" /></p>

                                                                <small id="emailHelpId" class="form-text text-muted"><a href="" data-bs-toggle="modal"
                                                                                                                        data-bs-target="#modalRegistro" data-bs-dismiss="modal">Eres nuevo.
                                                                                Registraté.</a></small>
                                                        </div>

                                                </div>
                                                <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Login</button>
                                                </div>
                                        </form>
                                </div>
                        </div>
                </div>
                <!-- *************************************** -->
                <div class="modal fade" id="modalRegistro" tabindex="-1" data-bs-keyboard="false" role="dialog"
                     aria-labelledby="modalTitleId" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-sm" role="document">
                                <div class="modal-content">
                                        <div class="modal-header">
                                                <h5 class="modal-title" id="modalTitleId">
                                                        User Register
                                                </h5>
                                        </div>
                                        <form action="Controller?op=registro" method="post">
                                                <div class="modal-body">
                                                        <div class="mb-3">
                                                                <p><input type="text" class="form-control" name="dni" id="" aria-describedby="emailHelpId"
                                                                          placeholder="dni" /></p>
                                                                <p><input type="text" class="form-control" name="nombre" id=""
                                                                          aria-describedby="emailHelpId" placeholder="nombre" /></p>
                                                        </div>

                                                </div>
                                                <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Register</button>
                                                </div>
                                        </form>
                                </div>
                        </div>
                </div>

                <div class="position-fixed top-50 start-50 translate-middle">
                        <div id="tostada" class="toast rounded-pill border-2 border-danger" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
                                <div class="toast-body bg-light text-danger text-center rounded-pill">
                                        <h5>${msg}</h5>
                                </div>
                        </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                crossorigin="anonymous"></script>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
                        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
                crossorigin="anonymous"></script>
                <c:if test="${msg!=null}">
                    <script type="text/javascript">
						const tostada = document.getElementById('tostada')
						oonst toastBootstrap = bootstrap.Toast.getOrCreateInstance(tostada)
						toastBootstrap.show()
                    </script>
                    
                </c:if>
                <div class="modal fade" id="modalApuesta" tabindex="-1" data-bs-local="${partido.local.nombre}" data-bs-visitante="${partido.local.visitante}" data-bs-keyboard="false" role="dialog"
                     aria-labelledby="modalTitleId" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-md" role="document">
                                <div class="modal-content">
                                        <div class="modal-header">
                                                <h5 class="modal-title" id="modalTitleId">
                                                </h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <form action="Controller?op=apuesta" method="POST">
                                                <div class="modal-body text-center">
                                                        <input type="text" name="goleslocal" class="w-25" placeholder="local"/>
                                                        <input type="text" name="golesvisitante" class="w-25" placeholder="visitante"/>
                                                        <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                                        Close
                                                                </button>
                                                                <button type="submit" class="btn btn-primary">Save</button>
                                                        </div>    
                                                </div></form>

                                </div>
                        </div>
                </div>
                <script src="myjs.js" type="text/javascript"></script>

        </body>
</html>
