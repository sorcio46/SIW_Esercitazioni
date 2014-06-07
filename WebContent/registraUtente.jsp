<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrazione Utente</title>
</head>
<body>
<f:view>
		<h1><center>SCHERMATA REGISTRAZIONE UTENTE</center></h1>
		<h:form>
			<div>Nome: <h:inputText value="#{utenteController.nome}"
						required="true"
						requiredMessage="Campo nome obbligatorio"
						placeholder="Inserire nome"
						id="nome"/>
						<h:message for="nome"/>
			</div>
			<div>Cognome: <h:inputText value="#{utenteController.cognome}"
						required="true"
						requiredMessage="Campo cognome obbligatorio"
						placeholder="Inserire cognome"
						id="cognome"/>
						<h:message for="cognome"/>
			</div>
			<div>Email: <h:inputText value="#{utenteController.mail}"
						required="true"
						requiredMessage="Campo email obbligatorio"
						ph:placeholder name="Inserire email"
						id="mail"/>
						<h:message for="mail"/>
			</div>
			<div>Password: <h:inputSecret value="#{utenteController.password}"
						required="true"
						requiredMessage="Campo password obbligatorio"
						ph: placeholder name="Inserire password"
						id="password"/>
						<h:message for="password"/>
			</div>
			<div>Indirizzo: <h:inputText value="#{utenteController.indirizzo}"
						required="true"
						requiredMessage="Campo indirizzo obbligatorio"
						ph: placeholder name="Inserire indirizzo"
						id="indirizzo"/>
						<h:message for="indirizzo"/>
			</div>
			<div>Data Di Registrazione: <h:inputText value="#{utenteController.dataDiRegistrazione}"
						required="true"
						requiredMessage="Campo data di registrazione obbligatorio"
						ph: placeholder name="Inserire data, formato: yyyy-MM-dd"
						id="dataDiRegistrazione">
						<f:convertDateTime pattern="yyyy-MM-dd"/>
						</h:inputText>
						<h:message for="dataDiRegistrazione"/>
			</div>
			<div>Data Di Nascita: <h:inputText value="#{utenteController.dataDiNascita}"
						required="true"
						requiredMessage="Campo data di nascita obbligatorio"
						ph:placeholder name="Inserire data, formato: yyyy-MM-dd"
						id="dataDiNascita">
						<f:convertDateTime pattern="yyyy-MM-dd"/>
						</h:inputText>
						<h:message for="dataDiNascita"/>
			</div>
			<div>
				<h:commandButton value="Submit" action="#{utenteController.createUtente}"/>
			</div>
			<h:commandLink action="#{utenteController.listUtente}" value="Lista degli Utenti" />
		</h:form>
	</f:view>

</body>
</html>