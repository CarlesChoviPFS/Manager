<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
${message}<br/>
<a role="button" href="${pageContext.request.contextPath}/Manager/add.html">a�adir nuevo manager</a><br/>
<a role="button" href="${pageContext.request.contextPath}/Jugador/add.html">a�adir nuevo jugador</a><br/>
<a role="button" href="${pageContext.request.contextPath}/Manager/list.html">Lista de managers</a><br/>
<a role="button" href="${pageContext.request.contextPath}/Jugador/list/${id}">Lista de jugadores</a><br/>
<a role="button" href="${pageContext.request.contextPath}/Manager/login.html">Usuario Manager</a><br/>
</p>
</body>
</html>