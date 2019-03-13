package com.shop.sport.command;

import com.shop.sport.dao.DAO;
import com.shop.sport.dao.ProductDAO;
import com.shop.sport.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditCommand implements Command {
    private static final Command INSTANCE = new EditCommand();
    private final DAO<Product> dao = ProductDAO.getINSTANCE();

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

        List<Product> products = dao.findAll();
        req.setAttribute("products", products);

        return "main.jsp";
    }
}
