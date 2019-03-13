<%@ page contentType="text/html;charset=UTF-8" language="java" %>

Product: ${product.type} name:  ${product.name} price: $${product.price}
<form method="POST">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="hidden" name="command" value="to_edit"/>
    <input type="submit" value="Редактировать"/>
</form>
<form method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="hidden" name="command" value="delete"/>
    <input type="submit" value="Удалить"/>
</form>
