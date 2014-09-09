<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar turma</title>
</head>
<body>
<h1>Cadastro de Turmas</h1>
<form action="turma.cad" method="post">
${msgErro.geral}
<table>


<tr><th>Número da Turma</th><td><input type="text" name="camponumero" size="40"/></td><td>${msgErro.camponumero}</td></tr>

<tr><th>Dia</th><td><input type="text" name="campodia" size="40"/></td><td>${msgErro.campodia}</td></tr>

<tr><th>Código da Disciplina:</th><td><input type="text" name="campoCodigoDaDisciplina" size="40"/></td><td>${msgErro.campoCodigoDaDisciplina}</td></tr>

<tr><th>Hora Início</th><td><input type="text" name="campoHoraInicio" size="40"/></td><td>${msgErro.campoHoraInicio}</td></tr>

<tr><th>Minuto Inicio</th><td><input type="text" name="campoMinInicio" size="40"/></td><td>${msgErro.campoMinInicio}</td></tr>

<tr><th>Hora Final</th><td><input type="text" name="campoHoraFim" size="40"/></td><td>${msgErro.campoHoraFim}</td></tr>

<tr><th>Minuto Final</th><td><input type="text" name="campoMinFim" size="40"/></td><td>${msgErro.campoMinFim}</td></tr>
<tr><td><input type="submit" value="Enviar"/></td></tr>
</table>
</body>

</html>