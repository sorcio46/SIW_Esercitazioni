<%@ page import="it.uniroma3.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
</head>
<body>
	<h1>Hai inserito il seguente prodotto:</h1>
	<%Product prod=(Product)session.getAttribute("product"); %>
	<div>Nome: <% out.println(prod.getName()); %></div>
	<div>Prezzo: <% out.println(prod.getPrice()); %></div>
	<div>Descrizione: <% out.println(prod.getDescription()); %></div>
	<div>Codice: <% out.println(prod.getCode()); %></div>
</body>
</html>