<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add jugador page</title>
</head>
<body>
<h1>Add jugador page</h1>
<p>Here you can add a new jugador.</p>
<form:form method="POST" commandName="jugador" action="${pageContext.request.contextPath}/Jugador/add.html">
<table>
<tbody>
	<tr>
		<td>Dorsal:</td>
		<td><form:input path="dorsal" /></td>
	</tr>
	<tr>
		<td>Nombre:</td>
		<td><form:input path="nombre" /></td>
	</tr>
	<tr>
		<td>Apellidos:</td>
		<td><form:input path="apellidos" /></td>
	</tr>
	<tr>
		<td>Posición:</td>
		<td><form:input path="posicion" /></td>
	</tr>
	<tr>
		<td>Altura:</td>
		<td><form:input path="altura" /></td>
	</tr>
	<tr>
		<td>Peso:</td>
		<td><form:input path="peso" /></td>
	</tr>
	<tr>
		<td>Edad:</td>
		<td><form:input path="edad" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Add" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a role="button" href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>