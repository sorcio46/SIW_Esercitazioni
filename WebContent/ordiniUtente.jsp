<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ordini utente</title>
</head>
<body>
<f:view>
<h1><center><font color="blue" size="8" face="Verdana" >Consulta i tuoi Ordini</font></center></h1>
<h2><center><font color="red" size="5" face="Verdana" >Benvenuto ${utenteController.corrente.nome} ${utenteController.corrente.cognome}</font></center></h2>
<h:form>
<table>
	<tr>
		<th><font color="#008800" size="4" face="Arial" >ID Ordine </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Ultima Data Utile </font></th>
		<th><font color="#008800" size="4" face="Arial" >Totale </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Utente </font></th>  
	</tr>
	<c:forEach var="ordine" items="#{ordineController.ordini}">
		<tr>
		<c:if test="${ordine.utente.id == utenteController.corrente.id}">
		<td>
		<h:commandLink action="#{ordineController.findOrdine}" value="#{ordine.id}"><f:param name="id" value="#{ordine.id}" />
		</h:commandLink>
		</td>
		
		<c:if test="${ordine.dataEvasioneOrdine == null}">
			<td>Data Chiusura : ${ordine.dataChiusuraOrdine}</td>
		</c:if>
		
		<c:if test="${ordine.dataEvasioneOrdine != null}">
			<td>Data Evasione: ${ordine.dataEvasioneOrdine}</td>
		</c:if>
		
		<td>${ordine.totale}</td>
		<td>${ordine.utente.mail}</td>
		</c:if>
		</tr>
	</c:forEach>
</table>
</h:form>
	<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
</f:view>
</body>
</html>