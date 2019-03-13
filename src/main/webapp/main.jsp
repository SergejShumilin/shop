<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Sport shop</title>
</head>
<body>
<c:set var="page" value="${page}" scope="request"/>

<jsp:include page = "header.jsp"/>
Введите данные для создания товара:<p>
    <form method = "POST">
        Тип: <input type = "text" name = "type" maxlength = "20" required value = "${product.type}" /> <p>
    Имя: <input type = "text" name = "name" maxlength="20" required value = "${product.name}" /> <p>
    Цена: <input type = "number" name = "price" min="1" max="500" required value = "${product.price}" /> <p>
    <c:choose>
    <c:when test = "${product.id > 0}">
    <input type="hidden" name = "id" value = "${product.id}"/>
    <input type="hidden" name = "command" value = "edit"/>
    </c:when>
    <c:otherwise>
    <input type="hidden" name = "command" value = "create"/>
    </c:otherwise>
    </c:choose>
    <input type="hidden" name = "page" value = "${page}"/>
    <input type = "submit" value = "Сохранить" />
    </form>

    Распределение по бренду: <p>
    <c:forEach var = "brand" items = "Nike,Adidas,Puma">
        ${brand}: <p>
    <c:forEach var = "product" items = "${products}">
    <c:if test="${product.name == brand}" >
        <c:set var="product" value="${product}" scope="request"/>
        <c:import url="product.jsp"/>
    </c:if>
    </c:forEach>
    </c:forEach>

    Прочие бренды: <p>
    <c:forEach var = "product" items = "${products}">
    <c:if test="${(product.name != 'Puma') && (product.name != 'Adidas') && (product.name != 'Nike')}" >
        <c:set var="product" value="${product}" scope="request"/>
        <c:import url="product.jsp"/>
    </c:if>
    </c:forEach>

    <c:forEach var = "i" begin = "1" end = "${count}">
<form method = "POST"  style="display: inline-block">
    <input type = "submit" name ="page"  value = "${i}" />
</form>
</c:forEach>
<br>
<jsp:include page = "footer.jsp"/>
</body>
</html>