<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Disciplinas</title>
</head>
<body>
<h1>Cadastro de Disciplinas</h1>
<form action="disciplina.cad" method="post">
${msgErro.geral}
<table>
<tbody>
<tr><th>Nome:</th><td><input type="text" name="camponome" size="80"/></td><td>${msgErro.camponome}</td></tr>
<tr><th>Ementa:</th><td><input type="text" name="campoementa" size="80"/></td><td>${msgErro.campoementa}</td></tr>
<tr><th>Carga Horária:</th><td><input type="text" name="campoch" size="80"/></td><td>${msgErro.campoch}</td></tr>
<tr><th>Código:</th><td><input type="text" name="campocodigo" size="80"/></td><td>${msgErro.campocodigo}</td></tr>
<tr><td><input type="submit" value="Enviar"/></td></tr>
</tbody>
</table>
</form>
</body>
</html>