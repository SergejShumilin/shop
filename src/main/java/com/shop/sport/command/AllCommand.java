package com.shop.sport.command;

import com.shop.sport.dao.DAO;
import com.shop.sport.dao.ProductDAO;
import com.shop.sport.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AllCommand implements Command {
    private static final Command INSTANCE = new AllCommand();
    private final DAO<Product> dao = ProductDAO.getINSTANCE();

    public AllCommand() {
    }

    public static Command getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<Product> products = dao.findAll();
        req.setAttribute("products", products);
        return "main.jsp";
    }
}
