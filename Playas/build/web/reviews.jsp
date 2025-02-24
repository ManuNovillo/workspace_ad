<%-- 
    Document   : reviews
    Created on : 22-feb-2025, 15:49:36
    Author     : smurf
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h4>${playa.nombre}</h4>
<table class="table table-striped text-primary w-50 m-auto">
	<tbody>
		<c:forEach var="puntuacion" items="${puntuaciones}">
			<tr>
				<td><img src="img/caritas/ic_${puntuacion.puntos}.png" alt="" width="50"></td>
				<td><p class="m-0">${puntuacion.cuantos}</p></td>
			</tr>
		</c:forEach>
	</tbody>
</table>