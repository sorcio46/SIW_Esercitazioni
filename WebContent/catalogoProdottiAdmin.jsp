<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Catalogo Prodotti</title>
</head>
<body bgcolor="#F0FFFF">
<f:view>
<h1><center><font color="blue" size="8" face="Verdana" >CATALOGO PRODOTTI</font></center></h1>
<h2><center><font color="red" size="5" face="Verdana" >Benvenuto ${amministratoreController.corrente.nome} ${amministratoreController.corrente.cognome}</font></center></h2>
<h:form>
<table>
	<tr>
		<th><font color="#008800" size="4" face="Arial" >Nome </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Prezzo </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Disponibilit� </font></th>
		<th><font color="#008800" size="4" face="Arial" >Fornitore </font></th>  
		<th><font color="#008800" size="4" face="Arial" >Azioni Disponibili</font></th>
	</tr>
	<c:forEach var="product" items="#{productController.products}">
		<tr>
		<td>
		<h:commandLink action="#{productController.findProduct}" value="#{product.name}"><f:param name="id" value="#{product.id}" />
		</h:commandLink>
		</td>
		<td>${product.price}</td>
		<td>${product.disponibilita}</td>
		<td>${product.fornitore}</td>
		<td>
		<h:commandLink action="#{productController.deleteProduct}" value="CANCELLA"><f:param name="id" value="#{product.id}" />
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