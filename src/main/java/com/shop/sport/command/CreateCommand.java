package com.shop.sport.command;

import com.shop.sport.domain.Product;
import javax.servlet.http.HttpServletRequest;

public class CreateCommand extends AbstractCommand{
    private static final Command INSTANCE = new CreateCommand();

    public CreateCommand() {
    }

    public static Command getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest req) {
        String type = req.getParameter("type");
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));

        Product newProduct = Product.builder().name(name).type(type).price(price).build();
        dao.save(newProduct);

        populateProducts(req);
        return "main.jsp";
    }
}
