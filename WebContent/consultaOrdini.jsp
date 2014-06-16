<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I miei Ordini</title>
</head>
<body>
<f:view>
<h1>Catalogo Prodotti</h1>
<h:form>
<table>
	<tr>
		<th>ID</th><th>TOTALE</th>
	</tr>
	<c:forEach var="ordine" items="#{ordineController.orders}">
		<tr>
		<td>${ordine.id}</td>
		<td>${ordine.totale}</td>
		</tr>
	</c:forEach>
</table>
</h:form>
<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
</f:view>
</body>
</html>