<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../base.css">
<title>Formulário de Login</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		
		<form action="<c:url value='/login/autentica' />" method="post">
			Usuário: <input type="text" name="usuario.nome" class="form-control" />
			Senha: <input type="text" name="usuario.senha" class="form-control" />
			<input type="submit" value="Login"	class="btn btn-primary" />

		</form>
		
		
	</div>
	<c:forEach items="${errors}" var="erro">
		 ${erro.category} - ${erro.message}<br />  
	</c:forEach>
</body>
</html>