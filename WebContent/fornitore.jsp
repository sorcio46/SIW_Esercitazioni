<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo del Fornitore</title>
</head>
<body>
<f:view>
<h1>${fornitoreController.fornitore.nome}</h1>
<h2>Dettagli</h2>
<div>Nome: ${fornitoreController.fornitore.nome}</div>
<div>Partita IVA: ${fornitoreController.fornitore.partitaIVA}</div>
<div>Indirizzo: ${fornitoreController.fornitore.indirizzo}</div>
<h2><a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a></h2>
</f:view>
</body>
</html>