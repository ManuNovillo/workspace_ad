<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<c:forEach var="i" begin="1" end="${ruta.media}">
			<p class="d-inline">&#9733;</p>
			<c:set var="i" value="i+1"></c:set>
		</c:forEach>
	</div>
</body>
</html>