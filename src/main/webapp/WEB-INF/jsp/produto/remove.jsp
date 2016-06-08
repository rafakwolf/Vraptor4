<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produto Removido</title>
</head>
<body>
	<div class="container">
		<h1>Produto removido com sucesso!</h1>
		<p>
			<a href="<c:url value='/produto/lista'/>">Lista de produtos!</a>
		</p>
	</div>
</body>
</html>