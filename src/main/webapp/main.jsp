<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sport shop</title>
</head>
<body>
<h4>Распределение по бренду:</h4><p>
    <c:forEach var="product" items="${products}">
    <c:if test="${product.name=='Nike'}">
    Nike:
<p>
    </c:if>
    <c:if test="${product.name=='Adidas'}">
    Adidas:
<p>
    </c:if>
    <c:if test="${product.name=='Puma'}">
    Puma:
<p>
    </c:if>
<p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
</c:forEach>

<h4>Распределение по цене:</h4><p>
    <c:forEach var="product" items="${products}">
    <c:choose>

    <c:when test="${product.price > 95}">
    Дорогие:<p>
    </c:when>

    <c:when test="${product.price < 95}">
    Дешевые:<p>
    </c:when>

    <c:otherwise>
    В самый раз:<p>
    </c:otherwise>

    </c:choose>

<p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
</c:forEach>
</body>
</html>
