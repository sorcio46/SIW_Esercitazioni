<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crea un Nuovo Ordine</title>
</head>
<body>
<f:view>
<h1><center><font color="blue" size="8" face="Verdana" >Crea il tuo Ordine</font></center></h1>
<h2><center><font color="red" size="5" face="Verdana" >Benvenuto ${utenteController.corrente.nome} ${utenteController.corrente.cognome}</font></center></h2>
<h:form>
<table>
	<tr>
		<th><font color="#008800" size="4" face="Arial" >Nome </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Prezzo </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Disponibilità </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Fornitore </font></th>
		<th><font color="#008800" size="4" face="Arial" >Quantita' </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Azioni Disponibili</font></th>
	</tr>
	<c:forEach var="product" items="#{productController.products}">
		<tr>
		<td>
		<h:commandLink action="#{productController.findProduct}" value="#{product.name}">
		<f:param name="id" value="#{product.id}" />
		</h:commandLink>
		</td>
		<td>${product.price}</td>
		<td>${product.disponibilita}</td>
		<td>${product.fornitore}</td>
		<td>
		<div><h:inputText value="#{ordineController.quantita}" 
    				required="false"
    				requiredMessage="La Quantita' e' obbligatoria"
    				converterMessage="La Quantita' deve essere maggiore o uguale a 1" 
    				id="quantita"/> <h:message for="quantita" /> 
		</div>
		</td>
		<td>
		<h:commandLink action="#{ordineController.aggiungiRigaOrdine}" value="Aggiungi al Carrello">
		<f:param name="pid" value="#{product.id}" />
		</h:commandLink>
		</td>
		</tr>
	</c:forEach>
</table>
</h:form>
<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
</f:view>
</body>
</html>