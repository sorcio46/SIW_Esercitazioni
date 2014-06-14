<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<f:view>
<h:form>
<h2>Dettagli</h2>
<div>Prodotto: ${ordineController.prodotto.name}</div>
<div>Quantità: ${ordineController.quantita}</div>
<h2>
	<h:commandLink action="#{ordineController.aggiungiAltraRigaOrdine}" value="Aggiungi un altro prodotto al tuo ordine"/>
</h2>
<h2>
	<h:commandLink action="#{ordineController.chiudiOrdine}" value="Termina il tuo ordine adesso"/>
</h2>
<h2>
	<a href='<c:url value="/faces/index.jsp" />'>Torna alla pagina Home</a>
</h2>
</h:form>
</f:view>
</body>
</html>