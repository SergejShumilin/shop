package com.shop.sport;

import com.shop.sport.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = new Product(1, "Nike", "sniekers", 95);
        req.setAttribute("product", product);

        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }
}
