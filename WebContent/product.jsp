<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Informazioni sul prodotto</title>
</head>
<body>
<f:view>
<h1>${productController.product.name}</h1>
<h2>Dettagli</h2>
<div>Codice: ${productController.product.code}</div>
<div>Prezzo: ${productController.product.price}</div>
<div>Descrizione: ${productController.product.description}</div>
<div>Disponibilità: ${productController.product.disponibilita}</div>
</f:view>
</body>
</html>