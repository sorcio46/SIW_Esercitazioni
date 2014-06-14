<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Evadi Ordini</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>
				<center>
					<font color="red" size="5" face="Verdana">Benvenuto
						${amministratoreController.corrente.nome}
						${amministratoreController.corrente.cognome}</font>
				</center>
			</h1>
			<h2>
				<center>
					<font color="blue" size="4" face="Arial">Ordini Chiusi </font>
				</center>
			</h2>
			<div>
			<table class="table">
	        <tr><th>Nome</th><th>Quantita</th><th>Data Apertura Ordine</th><th>Data Chiusura Ordine</th><th>Totale</th><th>Azioni disponibili</th></tr>      
			<c:forEach var="ordine"
				items="#{ordineController.ordiniChiusi}">
				<tr>
					<td>${ordine.prodotto.name}</td>
					<td>${ordine.quantita}</td>
					<td>${ordine.dataAperturaOrdine}</td>
					<td>${ordine.dataChiusuraOrdine}</td>
					<td>${ordine.totale}</td>
					<td><h:commandLink action="#{ordineController.evadiOrdine}"
							value="Evadi l'Ordine">
							<f:param name="id" value="#{ordine.id}" />
						</h:commandLink></td>
				</tr>
			</c:forEach>
			</table>
			</div>
		</h:form>
		<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
	</f:view>
</body>
</html>