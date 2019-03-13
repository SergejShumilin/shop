<%@ page contentType="text/html;charset=UTF-8" language="java" %>

Product: ${product.type} name:  ${product.name} price: $${product.price}
<form method="POST" style="display: inline-block">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="hidden" name="command" value="to_edit"/>
    <input type="hidden" name="page" value="${page}">
    <input type="submit" value="Редактировать"/>
</form>
<form method="post" style="display: inline-block">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="hidden" name="command" value="delete"/>
    <input type="hidden" name="page" value="${page}">
    <input type="submit" value="Удалить"/>
</form>
<p>
