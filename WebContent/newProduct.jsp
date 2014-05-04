<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>New Product</title>
</head>
<body>
	<form action="product" method="get">
	
	<div>Name: <input type="text" name="name" 
		value="<% if(request.getParameter("name")!=null){out.print(request.getParameter("name"));}%>" 
		<%if(request.getAttribute("nameErr")!=null){out.print(request.getAttribute("nameErr"));} %>/></div>
	<div>Code: <input type="text" name="code"
		value="<% out.print(request.getParameter("code"));%>" 
		<%if(request.getAttribute("codeErr")!=null){out.print(request.getAttribute("codeErr"));} %>/></div>
	<div>Price: <input type="text" name="price"
		value="<% out.print(request.getParameter("price"));%>" 
		<%if(request.getAttribute("priceErr")!=null){out.print(request.getAttribute("priceErr"));} %>/></div> 
	<div>Description: <input type="text" name="description"
		value="<% out.print(request.getParameter("description"));%>" /></div> 
	
	<div><input type="submit" name="sumbit" value="invia" /></div>
	</form>
</body>
</html>
