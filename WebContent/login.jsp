<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>

<form action="login" method="post" >
${param.msg}
<p>Login: <input type="text" name="campologin" size="40"/></p>
<p>Senha: <input type="password" name="camposenha" size="8" width="8" maxlength="4"/></p>
<p><input type="submit" value="Enviar"/></p>
</form>
</body>
</html>