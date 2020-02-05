<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of jugadores</title>
</head>
<body>
<h1>List of jugadores</h1>
<p>Here you can see the list of the jugadores, edit them, remove or update.</p>
<table class="table" border="1px" cellpadding="0" cellspacing="0" >
<thead class="thead-dark">
<tr>
<th scope="col" width="10%">dorsal</th>
<th scope="col" width="15%">nombre</th>
<th scope="col" width="10%">apellidos</th>
<th scope="col" width="10%">posición</th>
<th scope="col" width="10%">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="jugador" items="${jugadores}">
<tr>
	<td>${jugador.dorsal}</td>
	<td>${jugador.nombre}</td>
	<td>${jugador.apellidos}</td>
	<td>${jugador.posicion}</td>
	<td>
	<a href="${pageContext.request.contextPath}/Jugador/edit/${jugador.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/Jugador/delete/${jugador.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a role="button" href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>