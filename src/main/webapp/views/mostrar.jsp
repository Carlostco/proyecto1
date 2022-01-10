<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado</title>
</head>
<body>
<h1>Datos Persona</h1>

<table>
<tr>
	<td>Rut</td>
	<td>Nombre</td>
	<td>Apellido</td>
	<td>Telefono</td>
	<td>Fecha Ingreso</td>
</tr>
<tr>
	<td><c.out value="${per.Rut}"></td>
	<td><c.out value="${per.Nombre}"></td>
	<td><c.out value="${per.Apellido}"></td>
	<td><c.out value="${per.Telefono}"></td>
	<td><c.out value="${per.FechaIngreso}"></td>
</tr>

</table>
</body>
</html>