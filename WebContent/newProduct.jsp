<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Nuovo Prodotto</title>
</head>
<body bgcolor="#F5F5F5">
<f:view>
<h1><center><font color="red"> Inserimento Nuovo Prodotto</font></center></h1>
<h:form>
    <div>Nome:<h:inputText value="#{productController.name}" 
                     required="true"
                     requiredMessage="Il Nome e' obbligatorio"
                     id="name"/> <h:message for="name" />
	</div>
    <div>Codice: <h:inputText value="#{productController.code}" 
                     required="true"
                     requiredMessage="Il Codice e' obbligatorio"
                     id="code"/> <h:message for="code" />
	</div>
    <div>Prezzo: <h:inputText value="#{productController.price}" 
                     required="true"
                     requiredMessage="Il Prezzo e' obbligatorio"
                     converterMessage="Il Prezzo deve essere un numero"
                     id="price"/> <h:message for="price" />
	</div>
	<div>Disponibilita: <h:inputText value="#{productController.disponibilita}" 
    				required="false"
    				requiredMessage="La Disponibilita' e' obbligatoria"
    				converterMessage="La Disponibilita' deve essere un numero" 
    				id="disponibilita"/> <h:message for="disponibilita" /> 
                     
	</div>
    <div>Descrizione: <h:inputTextarea value="#{productController.description}" 
    				required="false" 
    				cols="20" 
    				rows="5" />     
	</div>
	<div>Fornitore: <h:inputText value="#{productController.fornitore}" 
    				required="false"
    				requiredMessage="Il fornitore e' obbligatorio"
    				id="fornitore"/> <h:message for="fornitore" /> 
                     
	</div>
	<div>
		<h:commandButton value="Inserisci Prodotto"  action="#{productController.createProduct}"/>
	</div>
	<h:commandLink action="#{productController.listProducts}" value="Lista dei prodotti" />
	<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
</h:form>
</f:view>
</body>
</html>