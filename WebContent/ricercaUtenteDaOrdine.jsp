<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Utente</title>
</head>
<body>

	<f:view>
		<h:form>
			<div>
				ID Ordine
				<h:inputText value="#{ordineController.id}" 
				required="true"
				requiredMessage="Non hai inserito nessun codice"
				id="id"/> <h:message for="id" />
				<h:commandButton value="Mostra l'Utente" action="#{ordineController.getUtenteDaOrdine}"/>
			</div>
		</h:form>
	</f:view>
</body>
</html>