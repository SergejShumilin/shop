package com.shop.sport.command;

import com.shop.sport.dao.DAO;
import com.shop.sport.dao.ProductDAO;
import com.shop.sport.domain.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

abstract class AbstractCommand implements Command {
    final DAO<Product> dao = ProductDAO.getINSTANCE();
    private static  final int PAGE_SIZE = 5;

    void populateProducts(HttpServletRequest req){
        String page = req.getParameter("page");
        int number = 1;
        if (page!=null){
            number = Integer.valueOf(page);
        }

        List<Product> products = dao.findPage(number, PAGE_SIZE);
        req.setAttribute("products", products);

        long pageCount = (dao.size() + PAGE_SIZE - 1) / PAGE_SIZE;
        req.setAttribute("count", pageCount);
        req.setAttribute("page", page);
    }
}
