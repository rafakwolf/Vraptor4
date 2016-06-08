<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet" />
<title>Listagem de Produtos</title>
</head>
<body>
	<div class="container">
		<h1>Listagem de Produtos do ${usuarioLogado.usuario.nome}</h1>
		<p>
			<a href="<c:url value='/produto/formulario'/>">Adicionar mais
				produtos!</a>
		</p>
		
		<p>
			<a href="<c:url value='/produto/listaXML'/>">Utilize a lista em XML!</a>
		</p>
		<table class="table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Valor</th>
					<th>Quantidade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtoList}" var="produto">
					<tr>
						<td>${produto.nome}</td>
						<td>${produto.valor}</td>
						<td>${produto.quantidade}</td>
						<td><a
							href="<c:url value='/produto/remove?produto.id=${produto.id}'/>">Remover</a></td>
						<td><c:url value='/produto/enviaPedidoDeNovosItens?produto.nome=${produto.nome}' var="url"/>
						<a href="${url}">Pedir mais Itens</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>${mensagem}</p>
	</div>
</body>
</html>