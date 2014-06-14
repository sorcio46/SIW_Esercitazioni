<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Riepilogo Ordine</title>
</head>
<body>
	<f:view>
		<h:form>
			<c:forEach var="rigaOrdine"
				items="#{ordineController.getRigheOrdine}">
				<tr>
					<td>${rigaOrdine.product.name}</td>
					<td>${rigaOrdine.quantita}</td>
					<td>${rigaOrdine.product.price}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>${ordineController.ordine.totale}</td>
				<td>${ordineController.ordine.dataAperturaOrdine}</td>
				<td>${ordineController.ordine.dataChiusuraOrdine}</td>
			</tr>
		</h:form>
		<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
	</f:view>
</body>
</html>