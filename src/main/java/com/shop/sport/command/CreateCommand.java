package com.shop.sport.command;

import com.shop.sport.dao.DAO;
import com.shop.sport.dao.ProductDAO;
import com.shop.sport.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateCommand implements Command{
    private static final Command INSTANCE = new CreateCommand();
    private final DAO<Product> dao = ProductDAO.getINSTANCE();

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

        List<Product> products = dao.findAll();
        req.setAttribute("products", products);
        return "main.jsp";
    }
}
