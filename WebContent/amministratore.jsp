<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profilo dell'amministratore</title>
</head>
<body>
<f:view>
<h1>${amministratoreController.amministratore.mail}</h1>
<h2>Dettagli</h2>
<div>Nome: ${amministratoreController.amministratore.nome}</div>
<div>Cognome: ${amministratoreController.amministratore.cognome}</div>
</f:view>
</body>
</html>