package com.shop.sport.command;

import com.shop.sport.domain.Product;

import javax.servlet.http.HttpServletRequest;

public class EditCommand extends AbstractCommand {
    private static final Command INSTANCE = new EditCommand();

    public EditCommand() {
    }

    public static Command getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest req) {
        long id = Long.valueOf(req.getParameter("id"));
        String type = req.getParameter("type");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        Product updateProduct = Product.builder().id(id).name(name).type(type).price(price).build();
        dao.update(updateProduct);

        populateProducts(req);

        return "main.jsp";
    }
}
