package com.shop.sport.command;

import javax.servlet.http.HttpServletRequest;

public class ToEditCommand extends AbstractCommand {
    private static final Command INSTANCE = new ToEditCommand();

    public ToEditCommand() {
    }

    public static Command getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public String execute(HttpServletRequest req) {
        long id = Long.valueOf(req.getParameter("id"));
        dao.get(id).ifPresent(product -> req.setAttribute("product", product));

       populateProducts(req);
        return "main.jsp";
    }
}
