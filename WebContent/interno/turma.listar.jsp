<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>turmas do Sistema</title>
</head>
<body>
<h1>Turmas cadastrados</h1>
<p>${param.msg}</p>

<table border="1">
<tr><th>Disciplina</th><th>numero</th></tr>

<c:forEach items="${turmas}" var="turma">
<tr>
<td>${turma.disciplina}</td><td>${turma.numero}</td><td><a href="turma.remover?codigo=${turma.numero}">remover</a></td>
</tr>
</c:forEach>
</table>

<a href="index.jsp">voltar</a>
</body>
</html>