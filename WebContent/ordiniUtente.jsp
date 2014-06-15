<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<th><font color="#008800" size="4" face="Arial" >Nome </font></th> 
		<th><font color="#008800" size="4" face="Arial" >Quantita </font></th> 
	</tr>
	<c:forEach var="ordine" items="#{ordineController.ordini}">
		<tr>
		<td>${rigaOrdine.product.name}</td>
		<td>${rigaOrdine.quantita}</td>
		</tr>
	</c:forEach>
</table>
</h:form>
<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
</f:view>
</body>
</html>