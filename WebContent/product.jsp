<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<title>Informazioni sul prodotto</title>
</head>
<body>
<f:view>
<h1><center> Informazioni Prodotto </center></h1>
<h1>${productController.product.name}</h1>
<h2>Dettagli</h2>
<div>Codice: ${productController.product.code}</div>
<div>Prezzo: ${productController.product.price}</div>
<div>Descrizione: ${productController.product.description}</div>
<div>Disponibilità: ${productController.product.disponibilita}</div>
<div>Fornitore: ${productController.product.fornitore}</div>
<ul>
	<c:if test="${amministratoreController.corrente != null}">	
		<li><a href='<c:url value="/faces/newProduct.jsp" />'>Inserisci un prodotto nel catalogo</a></li>
	</c:if>
	<li><a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a></li>
	<li><h:form>
		<h:commandLink action="#{productController.listProducts}" value="Visualizza la base di dati dei prodotti"/>
	</h:form></li>
</ul>
</f:view>
</body>
</html>