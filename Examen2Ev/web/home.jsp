<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <title>Shushi He</title>
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
                <header>
                        <div class="row justify-content-between align-items-center">
                                <div class="col-3 ps-0">
                                        <img class="m-0" src="img/logo.jpg" alt="">
                                </div>
                                <div class="col-3 text-end pe-3">
                                        <a href="#" data-bs-toggle="modal" data-bs-target="#modalCarrito">
                                                <i class="fa fa-shopping-cart fa-3x" aria-hidden="true"></i>
                                        </a>
                                </div>
                        </div>
                </header>
                <main class="pb-5">
                        <div id="carousel" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner" role="listbox">
                                        <div class="carousel-item active">
                                                <img src="img/slides/slide1.jpg" class="w-100 d-block" alt="First slide" />
                                        </div>
                                        <div class="carousel-item">
                                                <img src="img/slides/slide2.jpg" class="w-100 d-block" alt="Second slide" />
                                        </div>
                                        <div class="carousel-item">
                                                <img src="img/slides/slide3.jpg" class="w-100 d-block" alt="Third slide" />
                                        </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Next</span>
                                </button>
                        </div>

                        <div class="row justify-content-center align-items-center">
                                <!-- card de todos los alérgenos -->
                                <div class="col-md-4 col-lg-2 text-center mt-4">
                                        <a href="Controller?op=filtroAlergeno&alergeno=0" class="text-decoration-none text-black">
                                                <div class="border border-1 text-center">
                                                        <img class="py-2" src="img/alergenos/allergen_0.jpg" alt="Title" width="100" />
                                                        <p class="pt-2" class="card-text">TODOS</p>
                                                </div>
                                        </a> 
                                </div>
                                <!-- resto de alérgenos -->
                                <c:forEach var="alergeno" items="${alergenos}">
                                  <div class="col-md-4 col-lg-2 text-center mt-4">
                                          <a href="Controller?op=filtroAlergeno&alergeno=${alergeno.id}" class="text-decoration-none text-black">
                                                  <div class="border border-1 text-center">
                                                          <img class="py-2" src="img/alergenos/${alergeno.foto}" alt="Title" width="100" />
                                                          <p class="pt-2" class="card-text">${alergeno.nombre}</p>
                                                  </div>
                                          </a>

                                  </div>
                                </c:forEach>

                        </div>

                        <h1 class="bg-secondary text-white text-center mt-4">CATEGORÍA: ${nombreCategoria} - ALÉRGENO: ${nombreAlergeno}</h1>

                        <div class="row">
                                <div class="col-5 col-lg-4">
                                        <h3 class="bg-light">
                                                <a class="text-decoration-none text-black" href="Controller?op=filtroCategoria&categoria=0">
                                                        TODAS
                                                </a>
                                        </h3>
                                        <c:forEach var="categoria" items="${categorias}">
                                          <h3 class="bg-light">
                                                  <a class="text-decoration-none text-black" href="Controller?op=filtroCategoria&categoria=${categoria.id}">
                                                          ${categoria.nombre}</a>
                                          </h3>
                                        </c:forEach>
                                </div>
                                <div class="col-5 col-lg-8">
                                        <c:forEach var="plato" items="${platos}">
                                          <div class="card mb-3">
                                                  <div class="row g-0">
                                                          <div class="col-md-4">
                                                                  <img src="img/platos/${plato.foto}" class="img-fluid rounded-start w-100" alt="Card title" />
                                                          </div>
                                                          <div class="col-md-8 border position-relative pb-5">
                                                                  <div class="card-body">
                                                                          <h5 class="card-title">${plato.nombre}</h5>
                                                                          <c:forEach var="alergeno" items="${plato.alergenoList}">
                                                                            <img src="img/alergenos/${alergeno.foto}" alt="" width="40">
                                                                          </c:forEach>
                                                                  </div>
                                                                  <div class="position-absolute bottom-0 start-0 ms-2 mb-3">
                                                                          <h2>${plato.precio} €</h2>
                                                                  </div>
                                                                  <div class="position-absolute bottom-0 end-0 me-2 mb-3">
                                                                          <a href="Controller?op=carrito&plato=${plato.id}">
                                                                                  <i class="fa fa-shopping-cart fa-3x" aria-hidden="true"></i>
                                                                          </a>
                                                                  </div>
                                                          </div>
                                                  </div>
                                          </div>
                                        </c:forEach>
                                </div>

                        </div>
                </main>
                <footer>
                        <h1 class="text-center m-0 lh-base">Manuel Novillo &copy;</h1>
                </footer>

                <div class="position-fixed top-50 start-50 translate-middle">
                        <div id="tostada" class="toast rounded-pill border-2 border-danger" role="alert" 
                             aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
                                <div class="toast-body bg-light text-danger text-center rounded-pill">
                                        <h5>${msg}</h5>
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

                <c:if test="${msg!=null}">
                  <script type="text/javascript">
		    const tostada = document.getElementById('tostada')
		    const toastBootstrap = bootstrap.Toast.getOrCreateInstance(tostada)
		    toastBootstrap.show()
                  </script>
                </c:if>

        </div>

        <div class="modal fade" id="modalCarrito" tabindex="-1" data-bs-keyboard="false" role="dialog"
             aria-labelledby="modalTitleId" aria-hidden="true">
                <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-md" role="document">
                        <div class="modal-content">
                                <div class="modal-header">
                                        <h5 class="modal-title text-center" id="modalTitleId">
                                                Cesta
                                        </h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                        <c:forEach var="plato" items="${platosCarrito}">
                                          <div class="card mb-3">
                                                  <div class="row g-0">
                                                          <div class="col-md-4">
                                                                    <img src="img/platos/${plato.foto}" class="img-fluid rounded-start w-100" alt="Card title" />
                                                          </div>
                                                          <div class="col-md-8 border position-relative pb-5">
                                                                  <div class="card-body">
                                                                          <h5 class="card-title">${plato.nombre}</h5>
                                                                  </div>
                                                                  <div class="position-absolute bottom-0 start-0 ms-2 mb-3">
                                                                          <h2>${plato.precio} €</h2>
                                                                  </div>
                                                          </div>
                                                  </div>
                                          </div>
                                        </c:forEach>
                                </div>
                                <div class="border border-top-1 p-2 text-start">
                                        <form action="Controller?op=submitCarrito" method="post">
                                                <div class="row align-items-center">
                                                        <div class="col-6 text-center">
                                                                <select name="mesa" id="" class="w-100">
                                                                        <c:forEach var="i" begin="1" end="10">
                                                                          <option value="${i}">Mesa ${i}</option>
                                                                        </c:forEach>
                                                                </select>
                                                        </div>
                                                        <div class="col-6 text-center">
                                                                <button class="btn btn-primary text-white w-100" type="submit">Realizar pedido</button>
                                                        </div>
                                                </div>
                                        </form>
                                </div>
                        </div>
                </div>
        </div>



</body>

</html>

