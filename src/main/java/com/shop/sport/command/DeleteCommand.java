package com.shop.sport.command;

import com.shop.sport.dao.DAO;
import com.shop.sport.dao.ProductDAO;
import com.shop.sport.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteCommand implements Command{
    private static final Command INSTANCE = new DeleteCommand();
    private final DAO<Product> dao = ProductDAO.getINSTANCE();

    public DeleteCommand() {
    }

    public static Command getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest req) {
        long id = Long.valueOf(req.getParameter("id"));
        dao.delete(id);

        List<Product> products = dao.findAll();
        req.setAttribute("products", products);

        return "main.jsp";
    }
}
