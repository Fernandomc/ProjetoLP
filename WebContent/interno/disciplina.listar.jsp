<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Disciplinas do Sistema</title>
</head>
<body>
<h1>Disciplinas cadastrados</h1>
<p>${param.msg}</p>

<table border="1">
<tr><th>Nome da Disciplina</th><th>Código</th></tr>

<c:forEach items="${disciplinas}" var="disciplina">
<tr>
<td>${disciplina.nome}</td><td>${disciplina.codigo}</td><td><a href="disciplina.remover?codigo=${disciplina.codigo}">remover</a></td>
</tr>
</c:forEach>
</table>

<a href="index.jsp">voltar</a>
</body>
</html>