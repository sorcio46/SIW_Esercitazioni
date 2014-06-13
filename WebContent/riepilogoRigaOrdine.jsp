<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Riepilogo Riga Ordine</title>
</head>
<body>
<f:view>
<h2>Dettagli</h2>
<div>Prodotto: ${ordineController.rigaordine.prodotto.name}</div>
<div>Quantita: ${ordineController.rigaordine.quantita}</div>
<ul>
	<li><a href='<c:url value="/faces/creaOrdine.jsp" />'>Torna alla schermata della creazione Ordine</a></li>
</ul>
</f:view>
</body>
</html>