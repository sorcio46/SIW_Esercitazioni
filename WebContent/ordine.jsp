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
		<h1>Dettagli dell'Ordine fatto dall utente ${utenteController.corrente.mail}</h1>
		<h:form>
		<table>
		<tr>
			<th><font color="#008800" size="4" face="Arial" >Nome Prodotto</font></th> 
			<th><font color="#008800" size="4" face="Arial" >Quantita Prodotto</font></th> 
			<th><font color="#008800" size="4" face="Arial" >Prezzo Unitario</font></th> 
		</tr>
			<c:forEach var="rigaOrdine" items="#{ordineController.ordineCorrente.righeOrdine}">
				<tr>
					<td>${rigaOrdine.prodotto.name}</td>
					<td>${rigaOrdine.quantita}</td>
					<td>${rigaOrdine.prodotto.price}</td>
				</tr>
			</c:forEach>
		</table>
		</h:form>
		<h2>Prezzo totale dell'Ordine: ${ordineController.ordineCorrente.totale} euro</h2>
		<h2>Data apertura Ordine: ${ordineController.ordineCorrente.dataAperturaOrdine}</h2>
		<h2>Data chiusura Ordine: ${ordineController.ordineCorrente.dataChiusuraOrdine}</h2>
		<h2>Data evasione Ordine: ${ordineController.ordineCorrente.dataEvasioneOrdine}</h2>
		<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
	</f:view>
</body>
</html>