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
		<div>
			<h1><font size="5" color="red" >I miei Ordini </font></h1>
		</div>
			<div>
				<h:commandButton action="#{ordineController.creaOrdine}" value="Crea un nuovo ordine" />
			</div>
			<div>
				<div align="center">
					<h3>Ordini Aperti</h3>
				</div>
				<table class="table">
					<tr>
						<th>Id ordine</th>
						<th>Data Apertura Ordine</th>
						<th>Azioni Disponibili</th>
					</tr>
					<c:forEach var="ordine" items="#{ordineController.ordini}">
						<c:if test="${ordine.isEvaso =='false'}">
							<tr>
								<td>${ordine.id}</td>
								<td>${ordine.dataAperturaOrdine}</td>
								<td><h:commandButton action="#{ordineController.chiudiOrdine}"
										value="Chiudi">
										<f:param name="id" value="#{ordine.id}" />
									</h:commandButton></td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<div align="center">
					<h3>Ordini Chiusi</h3>
				</div>
				<table class="table">
					<tr>
						<th>Id Ordine</th>
						<th>Data Apertura Ordine</th>
						<th>Data Chiusura Ordine</th>
					</tr>
					<c:forEach var="ordine" items="#{ordineController.ordini}">
						<c:if test="${ordine.isChiuso =='true'}">
							<tr>
								<td>${ordine.id}</td>
								<td>${ordine.dataAperturaOrdine}</td>
								<td>${ordine.dataChiusuraOrdine}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
				<div align="center">
					<h3>Ordini Evasi</h3>
				</div>
				<table class="table">
					<tr>
						<th>Id Ordine</th>
						<th>Data Apertura Ordine</th>
						<th>Data Chiusura Ordine</th>
						<th>Data Evasione Ordine</th>
					</tr>
					<c:forEach var="ordine" items="#{ordineController.ordini}">
						<c:if test="${ordine.isEvaso=='true'}">
							<tr>
								<td>${ordine.id}</td>
								<td>${order.creationDate}</td>
								<td>${order.closeDate}</td>
								<td>${order.evasionDate}</td>
							</tr>
						</c:if>
					</c:forEach>
				</table>
			</div>
	</f:view>
</body>
</html>