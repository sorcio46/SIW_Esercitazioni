<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Riepilogo Riga Ordine</title>
</head>
<body>
<f:view>
<h:form>
<h2>Dettagli</h2>
<div>Prodotto: ${ordineController.prodotto.name}</div>
<div>Quantità: <h:inputText value="#{ordineController.quantita}" 
    		required="false"
    		requiredMessage="La Quantita' e' obbligatoria"
    		converterMessage="La Quantita' deve essere maggiore o uguale a 1" 
    		id="quantita"/> <h:message for="quantita" /> 
</div>
<h:commandLink action="#{ordineController.confermaRigaOrdine}" value="Aggiungi al Carrello">
	<f:param name="quantita" value="#{ordineController.quantita}" />
</h:commandLink>
</h:form>
</f:view>
</body>
</html>