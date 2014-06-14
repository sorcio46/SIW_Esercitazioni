<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Evadi Ordini</title>
</head>
<body>
<h1><center><font color="red" size="5" face="Verdana" >Benvenuto ${amministratoreController.corrente.nome} ${amministratoreController.corrente.cognome}</font></center></h1>
       <c:forEach var="ordini" items="#{ordineController.ordiniChiusi}">
		<tr>
		<td>
		<h:commandLink action="#{ordineController.findProduct}" value="#{product.name}">
		<f:param name="id" value="#{product.id}" />
		</h:commandLink>
		</td>
		<td>${product.price}</td>
		<td>${product.disponibilita}</td>
		<td>${product.fornitore}</td>
		<td>
		<h:commandLink action="#{ordineController.aggiungiRigaOrdine}" value="Aggiungi al Carrello">
			<f:param name="pid" value="#{product.id}" />
		</h:commandLink>
		</td>
		</tr>
	</c:forEach>
</body>
</html>