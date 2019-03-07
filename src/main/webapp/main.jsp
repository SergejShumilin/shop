<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sport shop</title>
</head>
<body>
Введите данные для добавления товара:<p>
<form method="post">
    Тип: <input type="text" name="type" maxlenght="20" required>
    Имя: <input type="text" name="name" maxlenght="20" required>
    Цена: <input type="number" name="price" min="1" max="500" required>
    <input type=submit value="Сохранить">
</form>

<h4>Распределение по бренду:</h4><p>

    Nike:<p>
    <c:forEach var="product" items="${products}">
         <c:if test="${product.name=='Nike'}">
            <p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
         </c:if>
    </c:forEach>

    Adidas:<p>
    <c:forEach var="product" items="${products}">
          <c:if test="${product.name=='Adidas'}">
            <p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
          </c:if>
    </c:forEach>

    Puma:<p>
    <c:forEach var="product" items="${products}">
           <c:if test="${product.name=='Puma'}">
             <p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
           </c:if>
    </c:forEach>

<h4>Прочие бренды</h4><p>
    <c:forEach var="product" items="${products}">
           <c:if test="${(product.name!='Puma') && (product.name!='Nike') && (product.name!='Adidas')}">
              <p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
           </c:if>
    </c:forEach>





<h4>Распределение по цене:</h4>
<p>
    <c:forEach var="product" items="${products}">
    <c:choose>

    <c:when test="${product.price > 95}">
    Дорогие:
<p>
    </c:when>

    <c:when test="${product.price < 95}">
    Дешевые:
<p>
    </c:when>

    <c:otherwise>
    В самый раз:
<p>
    </c:otherwise>

    </c:choose>

<p>Product: ${product.type} name: ${product.name} price: ${product.price}</p>
</c:forEach>
</body>
</html>
