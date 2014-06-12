<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registra Amministratore</title>
</head>
<body>
	<f:view>
		<h1><center>SCHERMATA REGISTRAZIONE AMMINISTRATORE</center></h1>
		<h:form>
			<div>Nome: <h:inputText value="#{amministratoreController.nome}"
						required="true"
						requiredMessage="Campo nome obbligatorio"
						id="nome"/>
						<h:message for="nome"/>
			</div>
			<div>Cognome: <h:inputText value="#{amministratoreController.cognome}"
						required="true"
						requiredMessage="Campo cognome obbligatorio"
						id="cognome"/>
						<h:message for="cognome"/>
			</div>
			<div>Email: <h:inputText value="#{amministratoreController.mail}"
						required="true"
						requiredMessage="Campo email obbligatorio"
						id="mail"/>
						<h:message for="mail"/>
			</div>
			<div>Password: <h:inputSecret value="#{amministratoreController.password}"
						required="true"
						requiredMessage="Campo password obbligatorio"
						id="password"/>
						<h:message for="password"/>
			</div>
			<div>
				<h:commandButton value="Submit" action="#{amministratoreController.createAmministratore}"/>
			</div>
			<h:commandLink action="#{amministratoreController.listAmministratori}" value="Lista degli Amministratori" />
		</h:form>
		<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
	</f:view>
</body>
</html>