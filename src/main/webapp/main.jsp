<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Sport shop</title>
</head>
<body>
<c:forEach var="product" items="${products}">
    <p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
</c:forEach>
</body>
</html>
