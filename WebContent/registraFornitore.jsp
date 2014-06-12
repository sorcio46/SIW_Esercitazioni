<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrazione Fornitore</title>
</head>
<body>
<f:view>
		<h1><center>SCHERMATA REGISTRAZIONE FORNITORE</center></h1>
		<h:form>
			<div>Nome: <h:inputText value="#{fornitoreController.nome}"
						required="true"
						requiredMessage="Campo nome obbligatorio"
						id="nome"/>
						<h:message for="nome"/>
			</div>
			<div>Partita IVA: <h:inputText value="#{fornitoreController.partitaIVA}"
						required="true"
						requiredMessage="Campo partita IVA obbligatorio"
						id="partitaIVA"/>
						<h:message for="partitaIVA"/>
			</div>
			<div>Indirizzo: <h:inputText value="#{fornitoreController.indirizzo}"
						required="true"
						requiredMessage="Campo indirizzo obbligatorio"
						id="indirizzo"/>
						<h:message for="indirizzo"/>
			</div>
			<div>
				<h:commandButton value="Submit" action="#{fornitoreController.createFornitore}"/>
			</div>
			<h:commandLink action="#{fornitoreController.listFornitori}" value="Lista dei Fornitori" />
		</h:form>
		<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
	</f:view>

</body>
</html>