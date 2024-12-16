<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <title>Turismo CLM</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>

<body>
    <div class="container shadow p-0">
        <header class="row justify-content-between align-items-center py-2 mx-0 bg-white">
            <div class="col">
            	<a href="Controller?op=inicio" class=text-decoration-none"">
                	<img src="img/logo.png" alt="" class="img-fluid">
                </a>
            </div>
            <div class="col text-danger text-end">
	            <c:choose>
	            	<c:when test="${fav=='1'}">
		            	<a href="Controller?op=opfav" class="text-decoration-none" style="color: #e51b4d;">
		                	<i class="fa fa-heart fa-2x" aria-hidden="true"></i>
		                </a>            	
	            	</c:when>
	            	<c:otherwise>
		            	<a href="Controller?op=opfav" class="text-decoration-none text-secondary">
		                	<i class="fa fa-heart fa-2x" aria-hidden="true"></i>
		                </a>            	
	            	</c:otherwise>
	            </c:choose>
            </div>
        </header>
        <video src="img/video.mp4" controls class="img-fluid w-100"></video>
        <main>
            <section class="mt-3">
                <div class="row px-3">
                    <div class="col-8">
                        <img src="img/molinos.jpg" alt="" class="img-fluid w-100">
                    </div>
                    <div class="col-4 text-white row align-items-center" style="background-color: #e51b4d;">
                        <c:forEach items="${provincias }" var="provincia">
                        	<a href="Controller?op=opprovincia&idprovincia=${provincia.id }&provincia=${provincia.nombre}" class="h4 text-white text-decoration-none">${provincia.nombre }</a>
                        </c:forEach>
                    </div>
                </div>
            </section>
            <section>
                <div class="row justify-content-center px-3">
                	<c:forEach items="${categorias }" var="categoria">
	                    <div class="col-md-6 mt-3 d-flex">
	                        <div class="card text-white border-0 shadow flex-fill">
	                        	<a href="Controller?op=opcategoria&idcategoria=${categoria.id}&categoria=${categoria.nombre}" class="text-white text-decoration-none">
		                            <img class="card-img img-fluid" src="${categoria.imagen }" alt="Title" />
		                            <div class="card-img-overlay text-white">
		                                <h3 class="card-title text-center py-4" style="background-color: #e51b4dbb;">${categoria.nombre }</h3>
		                            </div>
	                            </a>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
            </section>
            <hr>
            <div class="row justify-content-between px-3">
                <div class="col h2">${categoria }</div>
                <div class="col h2 text-end">${provincia }</div>
            </div>
            <section>
                <div class="row justify-content-center">
                	<c:forEach items="${lugares }" var="lugar">
	                    <div class="col-6 col-md-4 col-lg-3 mt-3 d-flex">
	                        <div class="card flex-fill">
	                            <div class="card-body bg-dark text-light">
	                                <h5 class="card-title">${lugar.nombre }</h5>
	                            </div>
	                            <img class="img-fluid" src="${lugar.imagen }" alt="Title" />
	                            <c:choose>
	                            	<c:when test="${lugar.fav==1}">
	                            		<a href="Controller?op=changefav&idlugar=${lugar.id }&lugar=${lugar.nombre }&fav=${lugar.fav }" class="text-decoration-none" style="color: #e51b4d;">
	                            			<i class="fa fa-heart fa-2x p-3 bg-light bg-opacity-50 rounded-pill position-absolute bottom-0 end-0 m-3" aria-hidden="true"></i>
	                            		</a>
	                            	</c:when>
	                            	<c:otherwise>
	                            		<a href="Controller?op=changefav&idlugar=${lugar.id }&lugar=${lugar.nombre }&fav=${lugar.fav }" class="text-decoration-none text-secondary">
	                            			<i class="fa fa-heart fa-2x p-3 bg-light bg-opacity-50 rounded-pill position-absolute bottom-0 end-0 m-3" aria-hidden="true"></i>
	                            		</a>	                            	
	                            	</c:otherwise>
	                            </c:choose>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
            </section>
        </main>
         <footer class="py-2 mt-3" style="background-color: #e51b4d;">
            <h3 class="text-center text-white">&copy; Turismo CLM 
                <i class="fa fa-instagram ms-3" aria-hidden="true"></i>
                <i class="fa fa-facebook mx-3" aria-hidden="true"></i>
                <i class="fa fa-twitter" aria-hidden="true"></i>
           </h3>
        </footer>
<div class="position-fixed top-50 start-50 translate-middle">
    	<div id="tostada" class="toast rounded-pill border-2 border-danger" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
        		<div class="toast-body bg-light text-danger text-center rounded-pill">
            		<h5>${msg}</h5>
        		</div>
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
        
</body>

</html>