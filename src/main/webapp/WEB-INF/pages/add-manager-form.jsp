<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add manager page</title>
</head>
<body>
<h1>Add manager page</h1>
<p>Here you can add a new manager.</p>
<form:form method="POST" commandName="manager" action="${pageContext.request.contextPath}/Manager/add.html">
<table>
<tbody>
	<tr>
		<td>Nombre:</td>
		<td><form:input path="Nombre" /></td>
	</tr>
	<tr>
		<td>Apellidos:</td>
		<td><form:input path="Apellidos" /></td>
	</tr>
	<tr>
		<td>Usuario:</td>
		<td><form:input path="Usuario" /></td>
	</tr>
	<tr>
		<td>Contraseña:</td>
		<td><form:input path="Contr" /></td>
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