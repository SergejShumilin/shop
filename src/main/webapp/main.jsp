<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sport shop</title>
</head>
<body>
<jsp:include page="header.jsp"/>
Введите данные для добавления товара:
<p>
    <form method="POST">
        Тип: <input type="text" name="type" maxlength="20" required value="${product.type}"/>
<p>
    Имя: <input type="text" name="name" maxlength="20" required value="${product.name}"/>
<p>
    Цена: <input type="number" name="price" min="1" max="500" required value="${product.price}"/>
<p>
    <c:choose>
    <c:when test="${product.id > 0}">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="hidden" name="command" value="edit"/>
    </c:when>
    <c:otherwise>
    <input type="hidden" name="command" value="create"/>
    </c:otherwise>
    </c:choose>
    <input type="submit" value="Сохранить"/>
    </form>

<h4>Распределение по бренду:</h4>
<c:forEach var="brand" items="Nike,Adidas,Puma">
    ${brand}: <p>
    <c:forEach var="product" items="${products}">
        <c:if test="${product.name == brand}">
            <c:set var="product" value = "${product}" scope="request"/>
        <c:import url="product.jsp"/>
        </c:if>
    </c:forEach>
</c:forEach>

<h4>Прочие бренды</h4>
<p>
    <c:forEach var="product" items="${products}">
    <c:if test="${(product.name != 'Puma') && (product.name != 'Adidas') && (product.name != 'Nike')}">
   <c:set var="product" value="${product}" scope="request"/>
        <c:import url="product.jsp"/>
</c:if>
</c:forEach>
<jsp:include page="footer.jsp"/>
</body>
</html>
