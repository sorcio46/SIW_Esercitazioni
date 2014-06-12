<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body bgcolor="#E6E6FA">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>SIW-PROGETTO-ESAME</title>
</head>
<body>
	<f:view>
		<h1><center>PROGETTO ESAME SIW GIUGNO 2014</center></h1>
		
		<h1><center>Benvenuto ${amministratoreController.corrente.mail}${utenteController.corrente.mail}
		<c:if test="${amministratoreController.corrente != null}">
			<h:form><h:commandLink action="#{amministratoreController.logoutAmministratore}" value="LOGOUT"/></h:form>
		</c:if>
		<c:if test="${utenteController.corrente != null}">
			<h:form><h:commandLink action="#{utenteController.logoutUtente}" value="LOGOUT"/></h:form>
		</c:if>
		</center></h1>
		
		<c:if test="${amministratoreController.corrente == null && utenteController.corrente == null}">
			<h1><center>Non sei registrato? Chiedi a un Amministratore!</center></h1>
		</c:if>
		<c:if test="${amministratoreController.corrente == null && utenteController.corrente==null}">
			<h1><center><h:form><h:commandLink action="#{productController.listProducts}" value="Visita il nostro Catalogo Prodotti"/></h:form></center></h1>
		</c:if>

		<c:if test="${amministratoreController.corrente != null}">
			<h1><center><h:form><h:commandLink action="#{productController.listProductsAdmin}" value="Modifica il Catalogo Prodotti"/></h:form></center></h1>
			<h1><center><a href='<c:url value="/faces/newProduct.jsp" />'>Inserisci un prodotto nel catalogo</a></center></h1>
			<h1><center><a href='<c:url value="/faces/evadiOrdine.jsp" />'>Evadi Ordine</a></center></h1>
			<h1><center><a href='<c:url value="/faces/registraUtente.jsp" />'>Registra Utente</a></center></h1>
			<h1><center><a href='<c:url value="/faces/registraFornitore.jsp" />'>Registra un Fornitore</a></center></h1>
		</c:if>
		<c:if test="${utenteController.corrente != null}">
			<h1><center><h:form><h:commandLink action="#{productController.listProductsUser}" value="Visita il Catalogo Prodotti"/></h:form></center></h1>
			<h1><center><a href='<c:url value="/faces/creaOrdine.jsp" />'>Crea un nuovo ordine</a></center></h1>
			<h1><center><a href='<c:url value="/faces/consultaOrdini.jsp" />'>Consulta i tuoi Ordini</a></center></h1>
		</c:if>
		<c:if test="${amministratoreController.corrente == null && utenteController.corrente == null}">
			<h1><center><a href='<c:url value="/faces/loginUtente.jsp" />'>Effettua il login Utente</a></center></h1>
			<h1><center><a href='<c:url value="/faces/loginAmministratore.jsp" />'>Effettua il login Amministratore</a></center></h1>	
		</c:if>
		
		<h2>Operazioni per la diagnostica:</h2> 
		<ul>
			<li><a href='<c:url value="/faces/newProduct.jsp" />'>Inserisci un nuovo prodotto nella base di dati</a></li>
			<li><h:form><h:commandLink action="#{productController.listProducts}" value="Visualizza la base di dati dei prodotti"/></h:form></li>
			<li><a href='<c:url value="/faces/registraAmministratore.jsp" />'>Inserisci un nuovo amministratore nella base di dati</a></li>
		</ul>
		<h2>Realizzato dagli studenti:</h2>
		<ul>
			<li>Brutti Davide</li>
			<li>Germano Lorenzo</li>
		</ul>
		<h2><a href="https://github.com/sorcio46/SIW_Esercitazioni/">Repository del progetto su Github</a></h2> 
	</f:view>
</body>
</html>

