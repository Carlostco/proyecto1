<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Inicio de Sesión</h1>
<form action="PersonaCtrl">
	<table>
		<tr>
			<td>USUARIO</td>
			<td><input type="text" name="txtusuario"> </td>
		</tr>
		<tr>
			<td>CONTRASEÑA</td>
			<td><input type="password" name="txtclave"> </td>
		</tr>
		<tr>
			<td><input type="submit" value="ENVIAR"> </td>
		</tr>
		
	</table>
</form>
</body>
</html>